#include "../generic/List.h"

#ifndef QUEUE

#define QUEUE 1

template <class T>
class Queue {
    private:
        List<T>* queueList;
    
    public:
        Queue() {
            queueList = NULL;
            queueList = new List<T>();
        }

        // agregar al final
        void enqueue(T* pValue) {
            queueList->add(pValue);
        }

        T* dequeue() {
            T* result = NULL;
            if (!queueList->isEmpty()) {
                result = queueList->remove(0);          
            }
            return result;            
        }

        T* front() {
            T* result = NULL;
            if (!queueList->isEmpty()) {
                result = queueList->find(0);
            }
            return result;
        }

        bool isEmpty() {
            return queueList->isEmpty();
        }
};

#endif
