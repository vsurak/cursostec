#ifndef _GRAFO_
#define _GRAFO_ 1
#include <vector>
#include "NodoGrafo.h"
#include "Persona.h"
#include "INodo.h"

using namespace std;

class Grafo {
    private:
        vector<NodoGrafo> listaNodos;
        bool esDirigido = true;

    public:
        Grafo(bool pDirigido) {
            this->esDirigido =  pDirigido;
        }

        int getSize() {
            return this->listaNodos.size();
        }

        void addNode(INodo pNodo) {
            this->listaNodos.push_back(NodoGrafo(pNodo));
        }

        void addArc(NodoGrafo pOrigen, NodoGrafo pDestino) {
            this->addArc(pOrigen, pDestino, 0);
        }

        void addArc(NodoGrafo pOrigen, NodoGrafo pDestino, int pPeso) {
            Arco newArc(&pOrigen, &pDestino, pPeso);
            pOrigen.addArc(newArc);

            if (!this->esDirigido) {
                Arco reverseArc(&pDestino, &pOrigen , pPeso);
                pDestino.addArc(reverseArc);
            }
        }
};

#endif