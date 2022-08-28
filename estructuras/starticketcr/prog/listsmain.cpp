#include <iostream>
#include "../eventos/event.h"
#include "../listas/List.h"
#include "../listas/ListConVoid.h"

using namespace std;

int main() {
    List *miLista = new List();

    cout << "cantidad de elemementos: " << miLista->getSize() << endl;

    Event *unEvento = new Event("Concierto Coldplay", "ITCR", "ASODEC");
    Event *otroEvento = new Event("Charla de Bill Gates", "ITCR", "ASODEC");
    Event *otroEvento2 = new Event("Evento del final", "ITCR", "ASODEC");

    miLista->add(unEvento);
    miLista->add(otroEvento);
    miLista->add(otroEvento2);

    cout << "cantidad de elemementos: " << miLista->getSize() << endl;

    Event *result = miLista->find(2);
    cout << result->getTitle() << endl;

    result = miLista->find(0);
    cout << result->getTitle() << endl;

    result = miLista->find("Charla de Bill Gates");
    cout << result->getTitle() << endl;

    // este es null porque no existe
    //result = miLista->find("charla de Bill Gates");
    //cout << result->getTitle() << endl;

    cout << "=================================" << endl;
    List *otraLista = new List();
    otraLista->insert(30, otroEvento2);
    otraLista->insert(0, unEvento);
    otraLista->insert(1, otroEvento);

    otraLista->print();

    cout << "=================================" << endl;
    
    otraLista->insert(4, unEvento);
    otraLista->insert(1, otroEvento);
    otraLista->insert(2, unEvento);
    otraLista->insert(5, otroEvento);
    otraLista->insert(6, unEvento);
    otraLista->insert(7, otroEvento);
    otraLista->print();



}