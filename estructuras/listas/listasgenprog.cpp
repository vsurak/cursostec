#include "listas/lista.h"
#include "common/casa.h"
#include "common/libro.h"

int main () {
    listadoble listacasas;
    listadoble listalibros;


    casa c1 = {100, 4, "verde"};
    casa c2 = {200, 5, "blanca"};
    casa c3 = {250, 3, "blanca"};

    listacasas.addToBegining(&c1);
    listacasas.addToBegining(&c2);
    listacasas.addToBegining(&c3);

    for(nodo* cursor = listacasas.start; cursor!=nullptr; cursor=cursor->next) {
        struct casa casaactual = *((struct casa*)(cursor->data));
        cout << casaactual.cantidadHabitaciones << " " << casaactual.color << endl;
    }


    libro l1 = {"estructuras", 2000, "algun publisher"};
    libro l2 = {"c++", 2010, "oreally"};
    libro l3 = {"arboles de costa rica", 1998, "ucr"};
    libro l4 = {"recetas de maiz", 2020, "tia florita"};

    listalibros.addToEnd(&l1);
    listalibros.addToEnd(&l2);
    listalibros.addToEnd(&l3);
    listalibros.addToEnd(&l4);

    for(nodo* cursor = listalibros.start; cursor!=nullptr; cursor=cursor->next) {
        void* genpointer = cursor->data;
        struct libro* pointertolibro = (struct libro*)genpointer;
        struct libro datoactual = *pointertolibro;
        //struct libro libroactual = *((struct libro*)(cursor->data));
        cout << libroactual.title << endl;
    }

}