#ifndef ISEARCH 
#include <string>
#include <iostream>
#include "../../dobleenlazada/List.h"

#define ISEARCH 1

using namespace std;

class ISearch {
    public:
        // retorne la posición en la lista donde se encuentra el número indicado en pKey
        virtual int search(List<int>* pNumberList, int pKey ) = 0;
        virtual string getName() = 0;
        virtual int getComparisions() = 0;

};

#endif