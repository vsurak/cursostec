#ifndef BUBBLE

#include "ISort.h"
#include "iostream"


#define BUBBLE 1

using namespace std;

class Bubble : public ISort{
    private:
        int interchanges = 0;
        int compares = 0;
        string name;

    public:
        // retorne la posición en la lista donde se encuentra el número indicado en pKey
        List<int>* sort(List<int>* pNumberList){
            int i,j,pass=0;
            int* temp=NULL;
            for(i=0; i<pNumberList->getSize(); i++){
                for(j=i+1; j<pNumberList->getSize(); j++){
                    compares++;     // se incrementa el cont de las comparaciones

                    if (*pNumberList->find(j)<*pNumberList->find(i)){
                        temp=pNumberList->find(i);

                        interchanges++; // se incrementa en cont de los intercambios

                        pNumberList->insert(i,pNumberList->find(j));
                        pNumberList->remove(i+1);
                        pNumberList->insert(j,temp);
                        pNumberList->remove(j+1);
                    }
                }
                pass++;
            }
            return pNumberList; 
        }

        string getName(){      
            name = typeid(Bubble).name();  // se obtiene el nombre de la clase
            name.erase(0,1);               // se elimina el primer caracter, ya que este genera un numero
            return name;
        }

        int getInterchanges(){
            return interchanges;
        }

        int getComparisions(){
            return compares;
        }
};

#endif

