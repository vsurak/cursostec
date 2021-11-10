#ifndef _GRAFO_
#define _GRAFO_ 1
#include <vector>
#include "NodoGrafo.h"
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

        void addArc(INodo pOrigen, INodo pDestino) {
            this->addArc(pOrigen.getId(), pDestino.getId(), 0);
        }

        void addArc(INodo pOrigen, INodo pDestino, int pPeso) {
            this->addArc(pOrigen.getId(), pDestino.getId(), pPeso);
        }

        void addArc(int pOrigen, int pDestino) {
            this->addArc(pOrigen, pDestino, 0);
        }

        void addArc(int pOrigen, int pDestino, int pPeso) {
            NodoGrafo referencias[2]; // [origen, destino] como NodoGrafo
            int currentRef = 0;

            // sería ideal tener un hashtable por ID para no tener que hacer este recorrido tan lento
            for (vector<NodoGrafo>::iterator nodoActual = this->listaNodos.begin() ; nodoActual != this->listaNodos.end(); ++nodoActual) {
                NodoGrafo actual = ((NodoGrafo)*nodoActual);
                if (actual.getInfo().getId()==pOrigen) {
                    referencias[0] = actual;
                    currentRef++;
                }
                if (actual.getInfo().getId()==pDestino) {
                    referencias[1] = actual;
                    currentRef++;
                }
                if (currentRef==2) {
                    break;
                }
            }

            this->addArc(referencias[0], referencias[1], pPeso);
        }

        vector<INodo> deepPath(INodo pOrigen) {  //recorrido en profundidad
            vector<INodo> result;

            return result;
        } 

        vector<INodo> path(INodo pOrigen, INodo pDestino) { // debe retornar un camino, el primero que encuentre estre el nodo oriegn y destino
            // en caso de que no haya camino, result se retorna vacío
            vector<INodo> result;

            return result;
        }

};

#endif