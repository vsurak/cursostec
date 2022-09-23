#include<iostream>
#include<sstream>
#include "../../dobleenlazada/Node.h"
#include "../../dobleenlazada/List.h"
#include<string>
#include "ISort.h"

using namespace std;

class InsertionSort : public ISort {
    
    public:
        List<int>* sort(List<int>* pNumberList) {
            //metodo que ordena con el insertion sort
            Node<int> *front = pNumberList->getFirst();
            Node<int> *back = NULL;
            
            while(front != NULL) {
                //se guarda el siguiente para la siguiente iteracion
                back = front->getNext();
                //se cambia el valor del nodo cuando hay nodos consecutivos desordenados
                while((back != NULL) && (back->getPrevious() != NULL) && (*back->getData() < *back->getPrevious()->getData())) {
                    //darle la vuelta a los nodos change1 y change2
                    Node<int>* change1 = back;
                    Node<int>* change2 = back->getPrevious();
                    
                    int valor = *change1->getData();
                    change1->setData(change2->getData());
                    change2->setData(new int(valor));

                    //vamos al nodo previo
                    back = back->getPrevious();
                }
                front = front->getNext();
            }
            return pNumberList;
        }
 
    
};