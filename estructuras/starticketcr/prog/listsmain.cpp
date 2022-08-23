#include <iostream>
#include "../eventos/event.h"
#include "../listas/List.h"

using namespace std;

int main() {
    List *miLista = new List();

    cout << "cantidad de elemementos: " << miLista->getQuantity() << endl;

    Event *unEvento = new Event("Concierto Coldplay", "ITCR", "ASODEC");
    Event *otroEvento = new Event("Charla de Bill Gates", "ITCR", "ASODEC");

    miLista->add(unEvento);
    miLista->add(otroEvento);

    cout << "cantidad de elemementos: " << miLista->getQuantity() << endl;
}