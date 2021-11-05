#ifndef _GRAFO_
#define _GRAFO_ 1
#include <vector>
#include "NodoGrafo.h"

using namespace std;

template <class T>
class grafo {
    private:
        vector<NodoGrafo<T>> listaNodos;

    public:
        int getSize() {
            return this->listaNodos.getSize();
        }
};

#endif