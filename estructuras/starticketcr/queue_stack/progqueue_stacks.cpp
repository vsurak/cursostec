#include <iostream>
#include "queue.h"

using namespace std;

int main() {
    Queue<string>* colaNombres = new Queue<string>();
    Queue<int>* numbersqueue = new Queue<int>();

    colaNombres->enqueue(new string("el primer mensaje que meto"));
    colaNombres->enqueue(new string("el segundo mensaje que meto"));
    colaNombres->enqueue(new string("el tercero mensaje que meto"));

    int valores[] = {30, 76, 88, 34, 12, 24};
    
    numbersqueue->enqueue(&valores[0]);
    numbersqueue->enqueue(&valores[1]);
    numbersqueue->enqueue(&valores[2]);
    numbersqueue->enqueue(&valores[3]);
    numbersqueue->enqueue(&valores[4]);
    numbersqueue->enqueue(&valores[5]);


    while (!colaNombres->isEmpty()) {
        cout << *colaNombres->dequeue() << endl;
    }

    while (!numbersqueue->isEmpty()) {
        cout << *numbersqueue->dequeue() << endl;
    }

    // hacemos una prueba del stack
    // push de varios elementos
    // hace un top
    // hacer varios pop imprimiendo lo que saco del pop

}