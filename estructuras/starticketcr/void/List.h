#include "Node.h"

#ifndef LISTCONVOID 

#define LISTCONVOID 1

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

        void add(void *data) {
            Node *newNode = new Node(data);

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

        void* find(int pPosition) {
            void* result = NULL;
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

        // es que si el position es mayor a la cantidad, entonces inserto al final
        void insert(int pPosition, void *pData) {
            
            if (pPosition<getSize() && first!=NULL) {
                Node *newNodo = new Node(pData);
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
                add(pData);
            }
        }
};

#endif