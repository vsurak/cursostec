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

        int getSize() {
            return quantity;
        }

        bool isEmpty() {
            return !quantity;
        }

        Event* find(int pPosition) {
            Event* result = NULL;
            Node* search = this->first;

            if (pPosition<getSize()) {
                while(pPosition>0) {
                    search = search->getNext();
                    pPosition--;
                }
                result = search->getData();
            }

            return result;
        }

        Event* find(string pTitle) {
            Event* result = NULL;
            Node* search = this->first;

            while(search!=NULL && search->getData()->getTitle()!=pTitle) {
                search = search->getNext();
            }

            if (search!=NULL) {
                result = search->getData();
            }

            return result;
        }

        // es que si el position es mayor a la cantidad, entonces inserto al final
        void insert(int pPosition, Event *pEvent) {
            
            if (pPosition<getSize() && first!=NULL) {
                Node *newNodo = new Node(pEvent);
                Node *searchPosition = this->first;
                Node *searchBehind = NULL;

                while(pPosition>0) {
                    pPosition--;
                    searchBehind = searchPosition;
                    searchPosition = searchPosition->getNext();
                }
                
                newNodo->setNext(searchPosition);
                if (searchBehind!=NULL) {
                    searchBehind->setNext(newNodo);
                } else {
                    this->first = newNodo;
                }
                
                quantity++;
            } else {
                add(pEvent);
            }
        }

        void print() {
            Node *search = first;

            while (search!=NULL) {
                cout << search->getData()->getTitle() << endl;
                search = search->getNext();
            }
        }
};

#endif