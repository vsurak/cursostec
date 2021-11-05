#ifndef _GRAFO_
#define _GRAFO_ 1
#include <vector>
#include "NodoGrafo.h"
#include "Persona.h"
#include "INodo.h"

using namespace std;

class grafo {
    private:
        vector<NodoGrafo> listaNodos;

    public:
        int getSize() {
            return this->listaNodos.size();
        }
};

#endif