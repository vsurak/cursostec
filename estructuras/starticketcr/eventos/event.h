#include <iostream>
#include <string>
#include <ctime>
#include "url.h"

using namespace std;

class Event {
    private: 
        tm eventTime;
        string title;
        string location;
        string organizer;
        Url urls[];

    public:
};