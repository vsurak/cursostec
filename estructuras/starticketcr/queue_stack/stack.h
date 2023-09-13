#include "../generic/List.h"

#ifndef STACK

#define STACK 1

template <class T>
class Stack
{
private:
    List<T> *stackList;

public:
    Stack()
    {
        stackList = new List<T>();
    }

    void push(T *pData)
    {
        // insert en posicion 0
    }

    T *pop()
    {
        T *result = NULL;
        // remove de la posicion 0
        return result;
    }

    T *top()
    {
        T *result = NULL;
        // get del primer elemento
        return result;
    }

    bool isEmpty()
    {
        // retornar el isempty de la lista
    }
}

#endif