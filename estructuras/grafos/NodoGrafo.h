#ifndef _NODOGRAFO_
#define _NODOGRAFO_ 1
#include "Arco.h"
#include <vector>

using namespace std;

template <class T>
class NodoGrafo {
    private:
        T dato;
        vector<Arco> listaArcos;

    public:

        T getInfo() {
            return dato;
        }
};

#endif