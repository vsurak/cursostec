#ifndef _LISTASIMPLE_
#define _LISTASIMPLE_

#include <stdlib.h>
#include "nodo.h"


struct listasimple {
    int size = 0;
    nodo* start = nullptr;
    nodo* end = nullptr;

    bool isEmpty() {
        return size == 0 ;
    }

    int getSize() {
        return size;
    }

    void add(int pValue) {
        nodo* newvalue = (nodo*)malloc(sizeof(struct nodo));
        newvalue->data = pValue;
        
        if (size == 0) {
            start = newvalue;
            end = newvalue;  // end = start;
        } else {
            // agregar al final de la lista
            end->next = newvalue; // esto es equivalente a  (*end).next = &newvalue;            
            end = newvalue;            
        }

        size++;
    }
};


#endif