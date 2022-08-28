#include <iostream>
#include "../eventos/event.h"
#include "List.h"

using namespace std;

int main() {
    List *miLista = new List();

    Event *unEvento = new Event("Concierto Coldplay", "ITCR", "ASODEC");
    Event *otroEvento = new Event("Charla de Bill Gates", "ITCR", "ASODEC");
    Event *otroEvento2 = new Event("Evento del final", "ITCR", "ASODEC");

    miLista->insert(0, otroEvento);
    miLista->insert(2, otroEvento2);
    miLista->add(unEvento);

    for(int i=0; i<miLista->getSize(); i++) {
        void *data = miLista->find(i);
        Event* currentEvent = (Event*)data;
        cout << currentEvent->getTitle() << endl;
    }
}