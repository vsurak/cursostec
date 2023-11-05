#ifndef _GRAPHDISCOVER_
#define _GRAPHDISCOVER_ 1

#include <iostream>
#include "INodo.h"
#include "grafo.h"

using namespace std;

struct Path
{
    INodo *origen = nullptr;
    INodo *destino = nullptr;
    int peso;

    vector<Inodo *> path;
};

struct DistancePath
{
    INodo *keyNode = nullptr;
    INodo *LastNodo = nullptr;
    bool procesado = false;
    int peso = 999999999;
}

class GraphDiscover
{
public:
    vector<Path *> *getPathsByWarshall(INodo *pOrigen, INodo *pDestino, Grafo *pGrafo)
    {
        // el método usa el algoritmo de Warshall implementado con listas de adyacencia, el cual calcula todos los caminos posibles de todos los vertices en pGrafo
        // retorna todos los Path posibles de pOrigen ha pDestino
        // paths en Path es la lista de INodos que componen un posible camino y el peso es para ese respectivo camino
    }

    Path *getShorterPath(INodo *pOrigen, INodo *pDestino, Grafo *pGrafo)
    {
        vector<DistancePath *> *pendingNodesV = new vector<DistancePath *>();
        vector<DistancePath *> *processedNodesF = new vector<DistancePath *>();
        DistancePath *currentMin;

        // el método usa el algoritmo de Dijkstra implementado con listas de adyacencia,
        // el cuál retorna el camino más corto de pOrigen a pDestino en el struct Path
        // currentMin has the current minimal peso Arc from pOrigin to all nodes from pendingNodesV
        // pendingNodesV will have all the nodes for the Dijkstra algorithm and acting as V array
        // proccessedNodesF will have all the proccesed nodes F, acting as the D array too
    }

private:
};

#endif