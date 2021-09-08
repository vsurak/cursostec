#include <iostream>
#include "lib/listasimple.h"
#include "lib/nodo.h"

using namespace std;

int main() {
    listasimple milista;

    milista.add(23);
    milista.add(10);
    milista.add(2);

    cout << milista.isEmpty() << " " << milista.getSize() << endl;

    nodo* recorrido = milista.start;
    while (recorrido!=nullptr) {
        cout << recorrido->data << endl;
        recorrido = recorrido->next;
    }

}