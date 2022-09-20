#include "Node.h"
#include "../eventos/event.h"
#include "stack.h"
#include "queue.h"

#ifndef LIST 

#define LIST 1

// 2. ajustar a que esta lista sea doblemente enlazada, cambia el add, find, insert y el remove
template <typename T> 
class List : public Stack<T>, public Queue<T> {
    private:
        Node<T> *first;
        Node<T> *last;
        Node<T> *searchPosition;
        int size;

    public:
        List() {
            first = NULL;
            last = NULL;
            size = 0;
        }

        void add(T *pData) {
            Node<T> *newNode = new Node<T>(pData);

            if (size>0) {
                this->last->setNext(newNode);
                newNode->setPrev(this->last);  // esta linea se agrega para quiz #4 #5
            } else {
                this->first = newNode;
            }
            this->last = newNode;

            size++;
        }

        Node<T>* getFirst() {
            return this->first;
        }

        int getSize() {
            return size;
        }

        bool isEmpty() {
            return !size;
        }

        T* find(int pPosition) {
            T* result = NULL;
            searchPosition = this->first; // esta linea se agrega para quiz #4 #5, se quito searchBehind

            if (pPosition<getSize()) {
                while(pPosition>0) {
                    searchPosition = searchPosition->getNext();
                    pPosition--;
                }
                result = searchPosition->getData();
            }

            return result;
        }

        // si el position es mayor a la cantidad, entonces inserto al final
        void insert(int pPosition, T *pData) {
            
            if (pPosition<getSize() && first!=NULL) {
                Node<T> *newNodo = new Node<T>(pData);

                T* result = find(pPosition); 
                // esta linea se quita para quiz #4 #5, ya no hace falta, aqui iba searchBehind
                
                newNodo->setNext(searchPosition);
                if (searchPosition->getPrev()!=NULL) {  // apariciones de searchBehind ahora serian getPrev de searchPosition, quiz #4 #5
                    searchPosition->getPrev()->setNext(newNodo); // esas lineas se arreglaan con el prev #4 #5
                    newNodo->setPrev(searchPosition->getPrev());
                    searchPosition->setPrev(newNodo);  
                } else {
                    this->first->setPrev(newNodo); // quiz #4 #5
                    this->first = newNodo;
                }
                
                size++;
            } else {
                add(pData);
            }
        }

        T* remove(int pPosition) {
            T* result = NULL;
            if (first!=NULL && pPosition<getSize()) {
                searchPosition = first;

                if (pPosition!=0) {
                    T* data = find(pPosition);

                    searchPosition->getPrev()->setNext(searchPosition->getNext()); // quiz #4 #5, se quita searchBehind

                    if (searchPosition==last) {
                        last = searchPosition->getPrev();  // quiz #4 #5
                    } else {
                        searchPosition->getNext()->setPrev(searchPosition->getPrev()); // quiz #4 #5
                    }
                    searchPosition->setNext(NULL);
                    searchPosition->setPrev(NULL);

                    result = searchPosition->getData();
                } else {
                    first = first->getNext();
                    searchPosition->setNext(NULL);

                    if (first!=NULL) { // quiz #4 #5, hay que limpiar el anterior del que esta despues del primero
                        first->setPrev(NULL); 
                    } else {
                        last = NULL;
                    }
                    result = searchPosition->getData();
                }
                size--;
            }
            return result;
        };

        void push(T* pValue) {
            insert(0, pValue);
        }

        T* pop() {
            return remove(0);
        }

        void enqueue(T* pValue) {
            add(pValue);
        }

        T* dequeue() {
            return remove(0);
        }

};

#endif