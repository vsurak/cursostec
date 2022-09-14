
#ifndef STACK 

#define STACK 1

template <class T>
class Stack {
    public:
        virtual void push(T* pValue);
        virtual T* pop() = 0;
};

#endif