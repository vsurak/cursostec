#include<iostream>
#include<sstream>
#include "../../dobleenlazada/Node.h"
#include "../../dobleenlazada/List.h"
#include<string>
#include "ISort.h"

using namespace std;

class InsertionSort : public ISort {
    private:
        int interchanges = 0;
        int compares = 0; 
    
    public:
        List<int>* sort(List<int>* pNumberList) {
            //metodo que ordena con el insertion sort
            Node<int> *front = pNumberList->getFirst();
            Node<int> *back = NULL;
            
            while(front != NULL) {
                //se guarda el siguiente para la siguiente iteracion
                back = front->getNext();
                //mientras que esten dos desordenados, y aun no se haya llegado al final:

                while((back != NULL) && (back->getPrevious() != NULL) && (*back->getData() < *back->getPrevious()->getData())) {
                    //incrementamos contador de comparaciones
                    compares++;

                    //darle la vuelta a los nodos change1 y change2
                    Node<int>* change1 = back;
                    Node<int>* change2 = back->getPrevious();
                    
                    int valor = *change1->getData();
                    change1->setData(change2->getData());
                    change2->setData(new int(valor));
                    //incrementamos contador de intercambios
                    interchanges++;

                    //vamos al nodo previo
                    back = back->getPrevious();
                }
                if((back != NULL) && (back->getPrevious() != NULL)) {
                    //incrementamos contador de comparaciones
                    compares++;
                } 
            
                front = front->getNext();
            }
            return pNumberList;
        }

        string getName() {
            return "InsertionSort";
        }

        int getComparisions() {
            //metodo que retorna contador de comparaciones
            return compares;
        }

        int getInterchanges() {
            //metodo que retorna contador de intercambios
            return interchanges;
        }
};