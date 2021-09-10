#ifndef _LISTASIMPLE_
#define _LISTASIMPLE_

#include <stdlib.h>
#include "nodo.h"

#define POSITION_BEGINNING 0
#define POSITION_END 99999999

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

/*
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

    void addAtBeginning(int pValue) {
        nodo* newvalue = (nodo*)malloc(sizeof(struct nodo));
        newvalue->data = pValue;
        
        if (size == 0) {
            start = newvalue;
            end = newvalue;  // end = start;
        } else {
            newvalue->next = start;
            start = newvalue;
        }

        size++;
    }

*/

    void add(int pValue) {
        insert(pValue, POSITION_END);
    }

    void addAtBeginning(int pValue) {
        insert(pValue, POSITION_BEGINNING);
    }

    int insert(int pValue, int pPosition) {
        nodo* newvalue = (nodo*)malloc(sizeof(struct nodo));
        newvalue->data = pValue;
        int result = 0;

        if (size==0) {
            start = newvalue;
            end = newvalue;  
        } else if (pPosition==0) {
            newvalue->next = start;
            start = newvalue;
        } else {
            int actualPosition = 1;
            nodo* pointerToPosition = nullptr;
            nodo* pointerBehind = nullptr;

            if (pPosition>=size) {
                pointerBehind = end;
                end = newvalue;
                actualPosition = size;
            } else {
                pointerToPosition = start->next;
                pointerBehind = start;
            }

            while (actualPosition<pPosition && pointerToPosition!=nullptr) {
                pointerBehind = pointerToPosition;
                pointerToPosition = pointerToPosition->next;
                actualPosition++;
            }

            pointerBehind->next = newvalue;
            newvalue->next = pointerToPosition;
            result = actualPosition;
        }

        size++;
        return result;
    }

};


#endif