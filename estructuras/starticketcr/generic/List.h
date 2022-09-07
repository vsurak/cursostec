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
        Node<T> *searchPosition = NULL;
        Node<T> *searchBehind = NULL;

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
            } else {
                this->first = newNode;
            }
            this->last = newNode;

            empty = false;
            quantity++;
        };

        void addAtBegining(T *pData) {
            Node<T> *newNode = new Node<T>(pData);

            if (this->first!=NULL) {
                newNode->setNext(this->first);
            } else {
                this->last = newNode;
            }
            this->first = newNode;

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
            searchPosition = this->first;
            searchBehind = NULL;

            if (pPosition<getSize()) {
                while(pPosition>0) {
                    searchBehind = searchPosition;
                    searchPosition = searchPosition->getNext();
                    pPosition--;
                }
                result = searchPosition->getData();
            }

            return result;
        }

        // es que si el position es mayor a la cantidad, entonces inserto al final
        void insert(int pPosition, T *pData) {
            
            if (pPosition<getSize() && first!=NULL) {
                Node<T> *newNodo = new Node<T>(pData);

                T* result = find(pPosition);
                
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

        T* remove(int pPosition) {
            T* result = NULL;
            if (first!=NULL && pPosition<getSize()) {
                Node<T> *search = first;
                if (pPosition!=0) {
                    result = find(pPosition);

                    searchBehind->setNext(searchPosition->getNext());

                    if (searchPosition==last) {
                        last = searchBehind;
                    }
                    searchPosition->setNext(NULL);
                } else {
                    first = first->getNext();
                    search->setNext(NULL);
                    result = search->getData();
                }
                quantity--;
            }
            return result;
        };
};

#endif