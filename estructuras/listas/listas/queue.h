#ifndef _QUEUE_
#define _QUEUE_ 0

#include "lista.h"

struct queue
{
    struct listadoble stackList;

    bool isEmpty()
    {
        return stackList.isEmpty();
    };

    void enqueue(void *pElement)
    {
        stackList.addToEnd(pElement);
    };

    void *dequeue()
    {
        return stackList.removeFirst();
    }
};

#endif