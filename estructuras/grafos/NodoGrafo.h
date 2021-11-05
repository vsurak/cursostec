#ifndef _NODOGRAFO_
#define _NODOGRAFO_ 1
#include "Arco.h"
#include <vector>
#include "INodo.h"

using namespace std;

class NodoGrafo {
    private:
        INodo dato;
        vector<Arco> listaArcos;

    public:

        INodo getInfo() {
            return dato;
        }
};

#endif