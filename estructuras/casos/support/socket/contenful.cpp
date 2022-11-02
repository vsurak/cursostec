#include <stdio.h>
#include <curl/curl.h>
#include <iostream>
#include <string>
#include "json.hpp"

using namespace std;
using json = nlohmann::json;

#define CHUNK_SIZE 2048

typedef struct {
    unsigned char *buffer;
    size_t len;
    size_t buflen;
} get_request;

    CURL *curl;
    CURLcode res;


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
}

void publishEntry(string pEntryId) {
    struct curl_slist *headers = NULL;
    curl_global_init(CURL_GLOBAL_ALL);
    curl = curl_easy_init();
    get_request req = {.buffer = NULL, .len = 0, .buflen = 0};

    headers = curl_slist_append(headers, "Authorization: Bearer CFPAT-C3IxS--BahDuak8g39hA9uhJgNJhXtiBUMYBzI78zvg");
    headers = curl_slist_append(headers, "X-Contentful-Version: 1");

    /* set our custom set of headers */
    curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);        
    /* First set the URL that is about to receive our POST. This URL can
        just as well be an https:// URL if that is what should receive the
        data. */
    string url = "https://api.contentful.com/spaces/9yr18gr54ppj/environments/master/entries/"+pEntryId+"/published";
    cout << "the url is " << url << endl;
    curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
    curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "PUT");
    

    /* Perform the request, res will get the return code */
    res = curl_easy_perform(curl);
    /* Check for errors */
    if(res != CURLE_OK) {
        fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
    } else {
        cout << res << endl;
        //curl_easy_cleanup(curl);
    }
}

int main(void)
{

/*
    char *body = '{ \
       \"fields\": { \
         \"nickname\": \"rtest01\", \
         \"postdate\": \"09/09/2022\", \
         \"password\" : \"123456789\", \
         \"hasoffer\" : 0, \
         \"hasdemand\": 1, \
         \"offer\": \"\", \
         \"demand\":\"prueba de demanda de mercado\" \
       } \
     }';
     
*/
    /* In windows, this will init the winsock stuff */
    curl_global_init(CURL_GLOBAL_ALL);

    /* get a curl handle */
    curl = curl_easy_init();

    if(curl) {

        struct curl_slist *headers = NULL;
        get_request req = {.buffer = NULL, .len = 0, .buflen = 0};

        headers = curl_slist_append(headers, "Authorization: Bearer CFPAT-C3IxS--BahDuak8g39hA9uhJgNJhXtiBUMYBzI78zvg");
        headers = curl_slist_append(headers, "Content-Type: application/vnd.contentful.management.v1+json");
        headers = curl_slist_append(headers, "X-Contentful-Content-Type: nombres");
    
        /* set our custom set of headers */
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);        
        /* First set the URL that is about to receive our POST. This URL can
            just as well be an https:// URL if that is what should receive the
            data. */
        curl_easy_setopt(curl, CURLOPT_URL, "https://api.contentful.com/spaces/9yr18gr54ppj/environments/master/entries");
        curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "POST");
        
        auto jsontext = R"(
            {
                "fields" : {
                    "name" : {
                        "en-US" : "Maria"
                    }
                }
            }
        )";

        string body = "{\"name\" : \"ana\"}";
        char* payload = curl_easy_escape(curl, body.c_str(), 0);
        /* Now specify the POST data */
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, jsontext );

        req.buffer = (unsigned char*)malloc(CHUNK_SIZE);
        req.buflen = CHUNK_SIZE;

        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, write_callback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void *)&req);

        /* Perform the request, res will get the return code */
        res = curl_easy_perform(curl);
        /* Check for errors */
        if(res != CURLE_OK) {
            //fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
        } else {
            printf("Total received bytes: %zu\n", req.len);
            printf("Received data:/n%s\n", req.buffer);
            json responseData = json::parse(req.buffer);
            string entryId(responseData["sys"]["id"].get<string>());

            free(req.buffer); 

            curl_easy_cleanup(curl);
            curl_global_cleanup();

            publishEntry(entryId);
        }
            
        /* always cleanup */
        curl_easy_cleanup(curl);
    }

    curl_global_cleanup();
    return 0;  
}
