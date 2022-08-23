#include "../eventos/event.h"

#ifndef NODE 

#define NODE 1

class Node {
    private:
        Event *event;
        Node *next;
    
    public:
        Node() {
            event = NULL;
            next = NULL;
        }

        Node(Event *pEvent) {
            this->event = pEvent;
            next = NULL;
        }

        Event* getData() {
            return event;
        }

        Node* getNext() {
            return next;
        }

        void setNext(Node *pValue) {
            this->next = pValue;
        }
};

#endif