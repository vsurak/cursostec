#include "Node.h"
#include "../eventos/event.h"

#ifndef LIST 

#define LIST 1

template <class T>
class List {
    private:
        Node<T> *first;
        Node<T> *last;
        int quantity;
        bool empty;

    public:
        List() {
            first = NULL;
            last = NULL;
            quantity = 0;
            empty = true;
        }

        void add(T *pData) {
            Node<T> *newNode = new Node<T>(pData);

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

        Node<T>* getFirst() {
            return this->first;
        }

        int getSize() {
            return quantity;
        }

        bool isEmpty() {
            return !quantity;
        }

        T* find(int pPosition) {
            T* result = NULL;
            Node<T>* search = this->first;

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
        void insert(int pPosition, T *pEvent) {
            
            if (pPosition<getSize() && first!=NULL) {
                Node<T> *newNodo = new Node<T>(pEvent);
                Node<T> *searchPosition = this->first;
                Node<T> *searchBehind = NULL;

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

};

#endif