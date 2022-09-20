#include "List.h"
#include <string>
#include <iostream>
#include "../eventos/event.h"

using namespace std;

int main() {
    // 3. Despues del cambio esto debería comportarse exactamente igual que el caso de lista simple
    // 4. Crear esta implementación de lista doblemente enlazada corresponde al quiz #4 y #5
    // 5. Entregar a mas tardar el viernes a las 7am, enviandolo al asistente kevinqj.2002@gmail.com 
    // 6. subject: estructuras - quiz #4#5
    // 7. el quiz se hará en parejas asignado por el profesor

    List<Event>* listA = new List<Event>();
    List<string>* listB = new List<string>();

    Event *unEvento = new Event("Concierto Coldplay", "ITCR", "ASODEC");
    Event *otroEvento = new Event("Charla de Bill Gates", "ITCR", "ASODEC");
    Event *otroEvento2 = new Event("Evento del final", "ITCR", "ASODEC");


    listA->insert(0, otroEvento2);
    listA->insert(0, otroEvento);
    listA->add(unEvento);

    listB->insert(0, new string("Un mensaje de prueba1"));
    listB->insert(1, new string("segundo mensaje de prueba"));
    listB->add(new string("tercer mensaje de prueba"));
    listB->add(new string("cuarto mensaje de prueba"));
    listB->add(new string("quinto mensaje de prueba"));

    listB->remove(0);
    listB->remove(3);
    listB->remove(1);

    for(int i=0; i<listA->getSize(); i++) {
        Event *currentEvent = listA->find(i);
        cout << currentEvent->getTitle() << endl;
    }

    cout << "==================================" << endl;
    for(int i=0; i<listB->getSize(); i++) {
        string *currentmsg = listB->find(i);
        cout << *currentmsg << endl;
    }


    // el polimorfismo es una herramienta o técnica de la programación de objetos que nos permite
    // encapsular comportamientos de una clase en otra, es decir, que puedo hacer que una classe
    // se comporte como otra en el momento en que se necesite.
    // Para ello se requiere "firmar un contrato" que establece cuales son los comportamientos
    // que yo quiero que las demás clases tengan, eso se hace por medio de 
    // de herencia o implementacion de interfaces
    // en el caso de C++, las interfaces no existen en un concepto puro, si no que se trabajan
    // como herencia de clases abstractas
    // esto es posible porque C++ es de los pocos lenguajes que permiten herencia múltiple
    // puedo heredar de más de una clase a la vez, ejemplo:
    // supongo que tengo la clase A que es concreta, y tiene el método sumar, (esto es el comportamiento que queremos acordar que se va a compartir)
    // supongo que tengo la clase B que es un abstract, es decir, que posee métodos virtuales sin implementación
    // tiene el método restar que es virtual, ese es el comportamiento que quiero replicar
    // si tengo la clase C, que hereda(implementa), de A y de B
    // class C : public A, public B {
    //    
    // }
    // la clase C hereda el método sumar, es concreto, si lo desea le puede hacer override 
    // dentro del override podría llamar al sumar padre tambien, pero lo importante del polimorfismo
    // es que forzosamente la clase C tiene si o si un método sumar
    // de la misma forma, la clase C al heredar de B, está obligada a implementar el método virtual restar
    // lo importante en polimorfismo es que enotnces la clase C, va a tener el método restar si o si
    //
    // C miVariable; ó C *miVariable = new C();
    // A otraVariable = miVariable; // esto es lo polimorfo, ahora aunque en la memoria esta todo lo que ocupa la clase C, puedo apuntarlo con un puntero de clase A
    

    cout << "Pruebas de polimorfismo con la nueva herencia de List => Stack y Queue" << endl;

    List<string> *ingredientes = new List<string>();

    ingredientes->add(new string("arroz"));
    ingredientes->add(new string("zanahora"));
    ingredientes->add(new string("cebolla"));

    //L-> arroz, zanahora, cebolla

    ingredientes->insert(1,new string("culantro"));

    //L-> arroz, culantro, zanahora, cebolla

    for(int i=0; i<ingredientes->getSize(); i++) {
        string *currentmsg = ingredientes->find(i);
        cout << *currentmsg << endl;
    }

    ingredientes->enqueue(new string("carne molida"));
    ingredientes->enqueue(new string("aceite"));
    //L-> arroz, culantro, zanahora, cebolla, carne molida, aceite


    for(int i=0; i<3; i++) {
        string *currentmsg = ingredientes->pop();
        cout << *currentmsg << endl;
        ingredientes->enqueue(currentmsg);
    }

    //L->  cebolla, carne molida, aceite, arroz, culantro, zanahora

    ingredientes->push(new string("sal"));
    //L->  sal, cebolla, carne molida, aceite, arroz, culantro, zanahora

    for(int i=0; i<ingredientes->getSize(); i++) {
        string *currentmsg = ingredientes->find(i);
        cout << *currentmsg << endl;
    }
 
    cout << "====ahora si, polimorfeando....=====" << endl;

    Queue<string> *colaAnimales = new List<string>(); 
    //colaAnimales->add(new string("gato")); // da error

    colaAnimales->enqueue(new string("gato"));
    colaAnimales->enqueue(new string("perro"));
    colaAnimales->enqueue(new string("conejo"));
    colaAnimales->enqueue(new string("leon"));

    //C ->  gato, perro, conejo, leon

    cout << *(colaAnimales->dequeue()) << endl;

    List<string> *listaNombres = new List<string>();
    
    Queue<string> *colaA = listaNombres;
    Stack<string> *miPila = listaNombres;

    miPila->push(colaAnimales->dequeue()); // perro
    miPila->push(colaAnimales->dequeue()); // conejo
    miPila->push(colaAnimales->dequeue()); // leon

    // Pila -> leon, conejo, perro
    // Lista -> leon, conejo, perro

    colaA->enqueue(new string("basurero"));
    colaA->enqueue(new string("arbol"));
    colaA->enqueue(new string("casa"));

    // Pila -> leon, conejo, perro, basurero, arbol, casa

    for(;!miPila->isEmpty(); ) {
        string *currentmsg = miPila->pop();
        cout << *currentmsg << endl;
    }
}