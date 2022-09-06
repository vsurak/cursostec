#include "../eventos/event.h"

#ifndef NODE 

#define NODE 1

class Node {
    private:
        Event *event;
        Node *siguiente;
    
    public:
        Node() {
            event = NULL;
            siguiente = NULL;
        }

        Node(Event *pEvent) {
            this->event = pEvent;
            siguiente = NULL;
        }

        Event* getData() {
            return event;
        }

        Node* getNext() {
            return siguiente;
        }

        void setNext(Node *pValue) {
            this->siguiente = pValue;
        }
};

#endif