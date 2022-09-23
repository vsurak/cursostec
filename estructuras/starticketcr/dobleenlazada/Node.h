#include <iostream>

#ifndef NODE 

#define NODE 1

using namespace std;

template <class T>
class Node {
    private:
        T *data;
        Node *next;
        Node *previous;    //modificacion, agrego link hacia atras 
    
    public:
        Node() {
            data = NULL;
            next = NULL;
            previous = NULL;   //modif, creo previous y la hago null
        }

        Node(T *pData) {
            this->data = pData;
            next = NULL;
            previous = NULL;  //modif, la pongo en null
        }

        T* getData() {
            return data;
        }

        void setData(T *pData) {
            this->data = pData;
        }

        Node* getNext() {
            return next;
        }

        Node* getPrevious() {    //modif, creo este metodo que retorna
            return previous;     //el previo
        }

        void setNext(Node *pValue) {
            this->next = pValue;
        }

        void setPrevious(Node *pValue) {   //modif, creo este metodo que
            this->previous = pValue;       //pone valor al previo    
        }

        Node* getPrev() {    //modif, creo este metodo que retorna
            return previous;     //el previo
        }

        void setPrev(Node *pValue) {   //modif, creo este metodo que
            this->previous = pValue;       //pone valor al previo    
        }
};

#endif