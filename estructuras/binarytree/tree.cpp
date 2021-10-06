#include <iostream>
//#include "treenodo.h"
#include "ttreenode.h"

using namespace std;

int main() {
    string mensaje = "hola";

    /* usando treenode.h con un generic hecho con void* 

    treenodo nuevoNodo(&mensaje);

    void* dato = nuevoNodo.getData();
    string elmensaje = *((string*)dato); // hace la programación genérica más incomoda, es mejor usar plantillas
    */

    treenodo<string> minodo(mensaje);
    treenodo<int> otronodo(49);

    cout << minodo.getData() << " " << otronodo.getData() << endl;
}