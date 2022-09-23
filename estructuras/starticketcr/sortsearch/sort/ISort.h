#ifndef ISORT

#include "../../dobleenlazada/List.h"
#include <string>
#include <iostream>

#define ISORT 1

using namespace std;

class ISort {
    public:
        // sort retorna la lista de enteros ya ordenada
        virtual List<int>* sort(List<int>* pNumberList) = 0;
        virtual string getName() = 0;
        virtual int getComparisions() = 0;
        virtual int getInterchanges() = 0;
};

#endif