#ifndef _LISTADOBLE_
#define _LISTADOBLE_ 0

#include <stdlib.h>
#include "nododoble.h"

#define POSITION_BEGINNING 0
#define POSITION_END 99999999

struct listasimple {
    int size = 0;
    nododoble* start = nullptr;
    nododoble* end = nullptr;

    bool isEmpty() {
        return size == 0 ;
    }

    int getSize() {
        return size;
    }

    void add(struct comida pValue) {
        insert(pValue, POSITION_END);
    }

    void addAtBeginning(struct comida pValue) {
        insert(pValue, POSITION_BEGINNING);
    }

    int insert(struct comida* pValue, int pPosition) {
        int result = 0;

        nododoble* newNodo = (nododoble*)malloc(sizeof(struct nododoble));
        newnodo->data = *pValue;

        if (size==0) {
            start = newNodo;
            end = newNodo;
            newNodo->next = start;
            newNodo->previous = end;
        } else {
            if (pPosition==0) {
                newNodo->next =  start;
                newNodo->previous = end;
                start->previous = newNodo;
                end->next = newNodo;
                start = newNodo;    
            } else {
                int currentPosition = 0;
                nododoble* cursor = start;

                while (cursor!=end && currentPosition<pPosition) {
                    cursor = cursor->next;
                    currentPosition++;
                }

                newNodo->next = cursor->next;
                newNodo->previous = cursor;
                cursor->next = newNodo;
                if (cursor==end) {
                    end = newNodo;
                    start->previous = newNodo;
                }

            }
        }

        size++;
        return result;
    }

};


#endif