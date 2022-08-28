#include <iostream>

#ifndef NODE 

#define NODE 1

using namespace std;

template <class T>
class Node {
    private:
        T *data;
        Node *next;
    
    public:
        Node() {
            data = NULL;
            next = NULL;
        }

        Node(T *pData) {
            this->data = pData;
            next = NULL;
        }

        T* getData() {
            return data;
        }

        Node* getNext() {
            return next;
        }

        void setNext(Node *pValue) {
            this->next = pValue;
        }
};

#endif