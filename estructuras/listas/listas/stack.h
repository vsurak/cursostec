#ifndef _STACK_
#define _STACK_ 0

#include "lista.h"

struct stack
{
    struct listadoble stackList;

    bool isEmpty()
    {
        return stackList.isEmpty();
    };

    void push(void *pElement)
    {
        stackList.addToBegining(pElement);
    };

    void *pop()
    {
        return stackList.removeFirst();
    }
};

#endif