
#ifndef STACK 

#define STACK 1

//template <class T>  -- esta esa una classe y por dentro use T como una clase plantilla
template <typename T> //esta clase es una plantilla, al ser esta clase una plantilla, entonces otras clases la pueden agregar como un template
class Stack {
    public:
        virtual void push(T* pValue) = 0;
        virtual T* pop() = 0;
        virtual bool isEmpty() = 0;
};

#endif
