#ifndef NODECONVOID 

#define NODECONVOID 1

class Node {
    private:
        void *data;
        Node *next;
    
    public:
        Node() {
            data = NULL;
            next = NULL;
        }

        Node(void *data) {
            this->data = data;
            next = NULL;
        }

        void* getData() {
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