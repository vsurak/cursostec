#include "../generic/List.h"

#ifndef STACK

#define STACK 1

template <class T>
class Stack {
    private:
        List<T>* stackList;


    public:
        Stack() {
            stackList = new List<T>();
        }

        void push(T* pData) {

        }

        T* pop() {
            T* result = NULL;

            return result;
        }

        T* top() {
            T* result = NULL;

            return result;
        }

        bool isEmpty() {
            
        }
}


#endif