#ifndef BUBBLE

#include "../../sortsearch/sort/ISort.h"

#define BUBBLE 1

class Bubble : public ISort{
    private:
        int interchanges = 0;
        int compares = 0;

    public:
        // retorne la posición en la lista donde se encuentra el número indicado en pKey
        List<int>* sort(List<int>* pNumberList){
            int i,j,pass=0;
            int* temp=NULL;
            for(i=0; i<pNumberList->getSize(); i++){
                for(j=i+1; j<pNumberList->getSize(); j++){
                    compare++;
                    if (*pNumberList->find(j)<*pNumberList->find(i)){
                        temp=pNumberList->find(i);

                        interchanges+=2;
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
};

#endif