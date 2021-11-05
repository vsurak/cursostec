#include <iostream>
#include "grafo.h"

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

    cout << "termino bien" << endl;
}