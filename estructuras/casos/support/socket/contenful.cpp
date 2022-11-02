#include <iostream>
#include <string>
#include <stdio.h>
#include <curl/curl.h>
#include "json.hpp"

using namespace std;
using json = nlohmann::json;

#define CHUNK_SIZE 2048

string createRegistroJsonTemplate = R"(
                    {
                        "fields" : {
                            "nickname" : {
                                "en-US" : ""
                            },
                            "postdate" : {
                                "en-US" : ""
                            },
                            "password" : {
                                "en-US" : ""
                            },
                            "offer" : {
                                "en-US" : ""
                            },
                            "demand" : {
                                "en-US" : ""
                            }
                        }
                    }
                )";


typedef struct {
    unsigned char *buffer;
    size_t len;
    size_t buflen;
} get_request;

class Registered {
    private:
        string nickname;
        string offer;
        string demand;
        string postdate;

    public:
        Registered(string pNickname, string pOffer, string pDemand, string pPostdate) {
            this->nickname = pNickname;
            this->offer = pOffer;
            this->demand = pDemand;
            this->postdate = pPostdate;
        }

        string getNickname() {
            return this->nickname;
        }

        string getOffer() {
            return this->offer;
        }

        string getDemand() {
            return this->demand;
        }

        string getPostdate() {
            return this->postdate;
        }
};

// static method to act as callback for curl
size_t write_callback(char *ptr, size_t size, size_t nmemb, void *userdata)
{
    size_t realsize = size * nmemb; 
    get_request *req = (get_request *) userdata;

    printf("receive chunk of %zu bytes\n", realsize);

    while (req->buflen < req->len + realsize + 1)
    {
        req->buffer = (unsigned char*)realloc(req->buffer, req->buflen + CHUNK_SIZE);
        req->buflen += CHUNK_SIZE;
    }
    memcpy(&req->buffer[req->len], ptr, realsize);
    req->len += realsize;
    req->buffer[req->len] = 0;

    return realsize;
};

class Contenful {
    private:
        CURL *curl;
        CURLcode res;


        void publishEntry(string pEntryId) {
            // init structs and objects
            struct curl_slist *headers = NULL;

            curl_global_init(CURL_GLOBAL_ALL);
            curl = curl_easy_init();
            
            // add contenful headers to curl object, this token is fixed
            // asumming the update of the version 1 only
            headers = curl_slist_append(headers, "Authorization: Bearer CFPAT-C3IxS--BahDuak8g39hA9uhJgNJhXtiBUMYBzI78zvg");
            headers = curl_slist_append(headers, "X-Contentful-Version: 1");
            curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);        

            // build the URL with the proper entryid
            string url = "https://api.contentful.com/spaces/9yr18gr54ppj/environments/master/entries/"+pEntryId+"/published";
            curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
            curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "PUT");
            
            /* Perform the request, res will get the return code */
            res = curl_easy_perform(curl);
            
            /* Check for errors */
            if(res != CURLE_OK) {
                fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
            }

            // clean the curl objects
            curl_easy_cleanup(curl);
            curl_global_cleanup();
        };

        string createEntry(string pNickname, string pOffer, string pDemand, string pPostdate, string pPassword) {
            string entryId;

            /* In windows, this will init the winsock stuff */
            curl_global_init(CURL_GLOBAL_ALL);

            /* get a curl handle */
            curl = curl_easy_init();

            if(curl) {
                // init the structs
                struct curl_slist *headers = NULL;
                get_request req = {.buffer = NULL, .len = 0, .buflen = 0};

                // prepare the payload for the post request
                json requestJson = json::parse(createRegistroJsonTemplate);
                requestJson["fields"]["nickname"]["en-US"] = pNickname;
                requestJson["fields"]["postdate"]["en-US"] = pPostdate;
                requestJson["fields"]["password"]["en-US"] = pPassword;
                requestJson["fields"]["offer"]["en-US"] = pOffer;
                requestJson["fields"]["demand"]["en-US"] = pDemand;

                string jsontext = to_string(requestJson);

                // set the headers, the token and content type is fixed
                headers = curl_slist_append(headers, "Authorization: Bearer CFPAT-C3IxS--BahDuak8g39hA9uhJgNJhXtiBUMYBzI78zvg");
                headers = curl_slist_append(headers, "Content-Type: application/vnd.contentful.management.v1+json");
                headers = curl_slist_append(headers, "X-Contentful-Content-Type: registros");
            
                /* set our custom set of headers */
                curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);        

                // set the url, space and environment is fixed
                curl_easy_setopt(curl, CURLOPT_URL, "https://api.contentful.com/spaces/9yr18gr54ppj/environments/master/entries");
                curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "POST");
                
                /* Now specify the POST data */
                curl_easy_setopt(curl, CURLOPT_POSTFIELDS, jsontext.c_str() );

                // prepare the callback function to catch the result json
                req.buffer = (unsigned char*)malloc(CHUNK_SIZE);
                req.buflen = CHUNK_SIZE;

                curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_callback);
                curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void *)&req);

                /* Perform the request, res will get the return code */
                res = curl_easy_perform(curl);

                /* Check for errors */
                if(res != CURLE_OK) {
                    fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));

                    // clean and free the curl object
                    curl_easy_cleanup(curl);
                    curl_global_cleanup();

                } else {
                    //printf("Total received bytes: %zu\n", req.len);
                    //printf("Received data:/n%s\n", req.buffer);
                    json responseData = json::parse(req.buffer);
                    entryId = responseData["sys"]["id"].get<string>();

                    free(req.buffer); 

                    curl_easy_cleanup(curl);
                    curl_global_cleanup();
                }
            }
            
            return entryId;
        };

    public: 
        vector<Registered*> getRecords() {

            vector<Registered*> result;
            get_request req = {.buffer = NULL, .len = 0, .buflen = 0};


            curl_global_init(CURL_GLOBAL_ALL);
            curl = curl_easy_init();
            
            // build the URL with the proper entryid
            string url = "https://cdn.contentful.com/spaces/9yr18gr54ppj/environments/master/entries?select=fields&access_token=nekO8xKQJ6Ftx9d4JaIcCf3dBuNQbJMJRHRG_Ekd79s&content_type=registros";
            curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
            curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "GET");

            // prepare the callback function to catch the result json
            req.buffer = (unsigned char*)malloc(CHUNK_SIZE);
            req.buflen = CHUNK_SIZE;

            curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_callback);
            curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void *)&req);

            /* Perform the request, res will get the return code */
            res = curl_easy_perform(curl);
            
            /* Check for errors */
            if(res == CURLE_OK) {
                json responseData = json::parse(req.buffer);
                for(auto& item : responseData["items"]) {
                    Registered *newItem = new Registered(item["fields"]["nickname"].get<string>(),
                                                item["fields"]["offer"].get<string>(),
                                                item["fields"]["demand"].get<string>(),
                                                item["fields"]["postdate"].get<string>()
                                               ); 
                    
                    result.push_back(newItem);
                }

                free(req.buffer);
            } else {
                fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
            }

            // clean the curl objects
            curl_easy_cleanup(curl);
            curl_global_cleanup();

            return result;
        };

        void registerUser(string pNickname, string pOffer, string pDemand, string pPassword, int pDay, int pMonth, int pYear) {

            string postDate(((pMonth /10) > 0 ?  to_string(pMonth) : "0"+to_string(pMonth))+"/"+((pDay /10) > 0 ?  to_string(pDay) : "0"+to_string(pDay))+"/"+to_string(pYear));
            string entryId = createEntry(pNickname, pOffer, pDemand, postDate, pPassword);
            publishEntry(entryId);
        }
};


int main(void)
{
    Contenful regs;

    regs.registerUser("metal_year_2000", "", "requiero de 5 ingenieros en computación con 8 años de experiencia, conocimientos en python.", "holapassword", 28, 10, 2022);
    regs.registerUser("rock_odin_gold", "soy programador python con experiencia", "", "holapassword", 23, 1, 2019);
    vector<Registered*> allrecords = regs.getRecords();
    cout << allrecords.at(1)->getNickname() << endl;
    return 0;  
}
