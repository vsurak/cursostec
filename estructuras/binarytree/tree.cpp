#include <iostream>
//#include "treenodo.h"
#include "binarytree.h"

using namespace std;

int main() {
    string mensaje = "hola";

    /* usando treenode.h con un generic hecho con void* 

    treenodo nuevoNodo(&mensaje);

    void* dato = nuevoNodo.getData();
    string elmensaje = *((string*)dato); // hace la programación genérica más incomoda, es mejor usar plantillas
    */

    int values[] = {9, 5, 8, 3, 19, 5, 30, 40};
    binarytree<int> mitree;

    for(int i=0; i<8; i++) {
        mitree.add(values[i]);
    }

    cout << mitree.getSize() << " " << mitree.getHeight() << " "<< mitree.getRoot()->getData() << endl;

}