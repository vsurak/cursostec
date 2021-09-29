#include <iostream>
#include "listas/stack.h"
#include "listas/queue.h"
#include "common/container.h"

using namespace std;

struct stack pilaGeneral;

struct container release(int pContainerId) {
    struct container result;
    struct stack auxStack;

    while (!pilaGeneral.isEmpty()) {
        void* top = pilaGeneral.pop();
        struct container* topContainer = (struct container*)top;

        cout << "saque de la pila el container " << topContainer->containerid << endl;;
        if (topContainer->containerid==pContainerId) {
            cout << "ya encontré al container " << topContainer->containerid << endl;;
            result = *topContainer;
            break;
        } else {
            auxStack.push(top);
            cout << "guardo en auxiliar " << ((struct container*)top)->containerid << endl;;
        }
    }

    // result tiene la respuesta, es decir el encontrado o el default, containerid = -1
    // podria ser que auxStack tenga elementos, entonces hay que volverlos a apilar

    while (!auxStack.isEmpty()) {
        void* top = auxStack.pop();
        cout << "re apilando a " << ((struct container*)top)->containerid << endl;;
        pilaGeneral.push(top);
    }

    return result;
}

int main() {
    struct container c1 = {45, "abc"};
    struct container c2 = {70, "maerks"};
    struct container c3 = {23, "crawler"};
    struct container c4 = {113, "amazon"};


    pilaGeneral.push(&c1);
    pilaGeneral.push(&c2);
    pilaGeneral.push(&c3);
    pilaGeneral.push(&c4);

    struct container buscado = release(145);

    cout << buscado.containerid << " " << buscado.brand << endl;

    buscado = release(23);
    cout << buscado.containerid << " " << buscado.brand << endl;    
    buscado = release(45);
    cout << buscado.containerid << " " << buscado.brand << endl;    
    
    cout << "==============" << endl;
    buscado = release(145);
    cout << buscado.containerid << " " << buscado.brand << endl;

    cout << "=================================COLAS=================" << endl;
    cout << "=================================COLAS=================" << endl;

    struct queue micola;
    micola.enqueue(&c1);
    micola.enqueue(&c2);
    micola.enqueue(&c3);
    micola.enqueue(&c4);

    while (!micola.isEmpty()) {
        struct container currentElement = (*(struct container*)micola.dequeue());
        cout << "containerid " << currentElement.containerid << endl;
    }

}