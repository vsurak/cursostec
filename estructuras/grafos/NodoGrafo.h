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
        NodoGrafo(INodo pDato) {
            this->dato = pDato;
        }

        void setInfo(INodo pDato) {
           this->dato = pDato; 
        }

        INodo getInfo() {
            return dato;
        }

        void addArc(Arco pArco) {
            this->listaArcos.push_back(pArco);
        }
};

#endif