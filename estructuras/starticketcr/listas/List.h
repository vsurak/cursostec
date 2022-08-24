#include "Node.h"
#include "../eventos/event.h"

#ifndef LIST 

#define LIST 1

class List {
    private:
        Node *first;
        Node *last;
        int quantity;
        bool empty;

    public:
        List() {
            first = NULL;
            last = NULL;
            quantity = 0;
            empty = true;
        }

        void add(Event *pEvent) {
            Node *newNode = new Node(pEvent);

            if (quantity>0) {
                this->last->setNext(newNode);
                this->last = newNode;
            } else {
                this->first = newNode;
                this->last = newNode;
            }

            empty = false;
            quantity++;
        }

        Node* getFirst() {
            return this->first;
        }

        int getQuantity() {
            return quantity;
        }

};

#endif