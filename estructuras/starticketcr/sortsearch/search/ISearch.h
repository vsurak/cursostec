#ifndef ISEARCH 

#include "../../dobleenlazada/List.h"

#define ISEARCH 1

class ISearch {
    public:
        // retorne la posición en la lista donde se encuentra el número indicado en pKey
        virtual int search(List<int>* pNumberList, int pKey ) = 0;
};

#endif