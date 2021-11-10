#include <iostream>
#include "grafo.h"
#include "Persona.h"

using namespace std;

int main() {

    // Ejercicio #1: 
    Grafo grafo1(true);

    Persona ana;
    ana.setNombre("Ana");

    Persona juan;
    juan.setNombre("Juan");

    grafo1.addNode(ana);
    grafo1.addNode(juan);

    grafo1.addArc(ana, juan);

    // caso #5 
    // Implementar el grafo denominado ciudades #1 en un nuevo grafo

    // Implementar el algoritmo de deepPath que retorna el vector de INodo
    // Hacer un for que recorra el vector resultado y castee cada INodo a Ciudad e imprima el recorrido con el 
    // nombre de la ciudad 
    // una modificación muy útil esn los algoritmos de recorrido ya sea en anchura y profundidad, es que el nodo
    // tenga un puntero al nodo que lo marcó antes de meterlo en la pila o la cola, es decir, quién lo metió en la pila o la cola

    // Implementar el metodo path 
    // Calcular los siguientes P(Berna, Lisboa), P(Lisboa, Milan)
    // Hacer un for que recorra el vector resultado y castee cada INodo a Ciudad e imprima el recorrido con el 
    // nombre de la ciudad 

    cout << "termino bien" << endl;
}