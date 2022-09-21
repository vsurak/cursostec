#ifndef ISORT

#include "../../dobleenlazada/List.h"

#define ISORT 1

class ISort {
    public:
        // sort retorna la lista de enteros ya ordenada
        virtual List<int>* sort(List<int>* pNumberList) = 0;
};

#endif