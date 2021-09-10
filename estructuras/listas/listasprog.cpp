#include <iostream>
#include "lib/listasimple.h"
#include "lib/nodo.h"

using namespace std;

int main() {
    listasimple milista;


    milista.add(23);
    milista.add(10);
    milista.add(2);

    milista.addAtBeginning(100);
    milista.addAtBeginning(120);

    milista.insert(20,0);
    milista.insert(10,0);
    milista.insert(5,0);

    int posicioninsertada = milista.insert(65, 10);
    cout << posicioninsertada << endl;

    posicioninsertada = milista.insert(15, 4);
    cout << posicioninsertada << endl;

    posicioninsertada = milista.insert(17, 9);
    cout << posicioninsertada << endl;


    nodo* recorrido = milista.start;
    while (recorrido!=nullptr) {
        cout << recorrido->data << endl;
        recorrido = recorrido->next;
    }

    cout << milista.isEmpty() << " " << milista.getSize() << endl;

}