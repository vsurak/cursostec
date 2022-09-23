
#include "ISort.h"

#ifndef SELECTION

#define SELECTION 1
class SelectionSort : public ISort {
    /* La ordenación por selección procede de la siguiente forma: buscar el mínimo elemento de la lista,
       intercambiarlo con el primero, buscar el siguiente mínimo en el resto de la lista, finalmente 
       intercambiarlo con el segundo. En general lo que hace es buscar el mínimo elemento entre una posición i 
       y el final de la lista, luego intercambiar el mínimo con el elemento de la posición i.
    */
    public:
        List<int>* sort(List<int> *pNumberList) {
            int menor;
            
            int position; 
            int positionXchg; // posición donde vamos a intercambiar elementos.

            for (int index = 0; index < pNumberList->getSize(); index++){ // recorremos la lista
                position = index; // La posición inicial para la revisión es la posición del índice.
                positionXchg = position; // La posición de intercambio empieza siendo la posición inicial, por si
                // se diera el caso donde la posición inicial ya es el menor de lo que queda de la lista.
                menor = *pNumberList->find(index); // El menor es el número en la posición inicial.
                for (int element = position + 1; element < pNumberList->getSize(); element++){
                    // recorremos la lista a partir del siguiente elemento.
                    int numCheck = *pNumberList->find(element); // Obtenemos el dato del nodo en la posición a revisar.
                    if (menor > numCheck){ // revisamos si es menor que el menor actual.
                        menor = numCheck; // Lo cambiamos y almacenamos la posicíon para el intercambio.
                        positionXchg = element;
                    }
                }
                if (position != positionXchg){ // Si las posiciones no son iguales. Si son iguales, no debe hacer intercambio.
                    int *number = pNumberList->find(position); // obtiene elemento en position
                    pNumberList->insert(positionXchg, number); // lo inserta en positionXchg
                    number = pNumberList->find(positionXchg + 1);
                    // Ahora todos los nodos se corrieron una posición después de positionXchg
                    // Obtenemos el elemento de positionXchg + 1;
                    
                    pNumberList->remove(positionXchg + 1); // Eliminamos el nodo en positionXchg + 1 para insertarlo en position.
                    pNumberList->remove(position); // Borramos el nodo de la posición original.
                    pNumberList->insert(position, number); // insertamos el número que orignalmente estaba en positionXchg en position.
                }
            }
            return pNumberList;
        }


};

#endif