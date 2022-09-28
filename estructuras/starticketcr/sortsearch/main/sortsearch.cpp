#include <string>
#include <iostream>

#include "../search/ISearch.h"
#include "../sort/ISort.h"
#include "../../dobleenlazada/List.h"
#include "../search/BinarySearch.h"
#include "../search/Interpolation.h"
#include "../search/InterpolacionV2.h"
#include "../sort/BubbleSort.h"
#include "../sort/InsertionSort.h"
#include "../sort/SelectionSort.h"


using namespace std;

int main() {
    cout << "probando sorting y search de los diversos algoritmos con polimorfismo" << endl;
    List<ISort> *algoritmosDeSort = new List<ISort>();
    List<ISearch> *algoritmosDeSearch = new List<ISearch>();
    List<int> *listNumbers = new List<int>();

    List<int>* numberLists[3];
    numberLists[0] = new List<int>();
    numberLists[1] = new List<int>();
    numberLists[2] = new List<int>();

    int numbers[3][1000];

    for(int i=0; i<1000; i++) {
        numbers[0][i] = 5000-i;//rand();
        numbers[1][i] = numbers[0][i];
        numbers[2][i] = numbers[0][i];

        numberLists[0]->add(&numbers[0][i]);
        numberLists[1]->add(&numbers[1][i]);
        numberLists[2]->add(&numbers[2][i]);
    }

    int pKey = numbers[0][503];

    //int numbers[] = {56, 44, 33, 30, 28, 25, 10}; //10,25,28,30,33,44,56
    // listNumbers->add(&numbers[0]);
    // listNumbers->add(&numbers[1]);
    // listNumbers->add(&numbers[2]);
    // listNumbers->add(&numbers[3]);
    // listNumbers->add(&numbers[4]);
    // listNumbers->add(&numbers[5]);
    // listNumbers->add(&numbers[6]);

    // cargar las listas con sus algoritmos
    algoritmosDeSort->add(new Bubble());
    algoritmosDeSort->add(new InsertionSort());
    algoritmosDeSort->add(new SelectionSort());

    algoritmosDeSearch->add(new BinarySearch());
    algoritmosDeSearch->add(new Interpolation());
    algoritmosDeSearch->add(new Interpolationv2());
    
    // seleccionar un algoritmo de sort aleatorio y lo ejecuto
    //int selectedSort = rand() % 3;
    //ISort *sortAlg = algoritmosDeSort->find(i);
    //listNumbers = sortAlg->sort(listNumbers);

    ISort *sortAlg;

    for(int i=0; i<3; i++) {
        sortAlg = algoritmosDeSort->find(i);
        sortAlg->sort(numberLists[i]);
        cout << "Algoritmo " << sortAlg->getName() << " comparaciones " << sortAlg->getComparisions() << " Intercambios " << sortAlg->getInterchanges() << endl;
    }
    
    

    // // imprimo la lista ordenada
    // int *value = 0;
    
    // listNumbers->resetSearch();
    // value = listNumbers->next();
    // while (value!=NULL) {
    //     cout << *value << endl;
    //     value = listNumbers->next();
    // } 

    // selecciono un algoritmo de search aleatorio y lo ejecuto
    //int selectedSearch = 0;//rand() % 2;
    ISearch *searchAlg = algoritmosDeSearch->find(0);
    cout << searchAlg->search(numberLists[0], pKey) << endl;
    cout << "Algoritmo " << searchAlg->getName() << " comparaciones " << searchAlg->getComparisions() << endl;

    searchAlg = algoritmosDeSearch->find(1);    
    cout << searchAlg->search(numberLists[0], pKey) << endl;
    cout << "Algoritmo " << searchAlg->getName() << " comparaciones " << searchAlg->getComparisions() << endl;

    searchAlg = algoritmosDeSearch->find(2);    
    cout << searchAlg->search(numberLists[0], pKey) << endl;
    cout << "Algoritmo " << searchAlg->getName() << " comparaciones " << searchAlg->getComparisions() << endl;

    // cout << searchAlg->search(listNumbers, 56) << endl;
    // cout << searchAlg->search(listNumbers, 25) << endl;
    // cout << searchAlg->search(listNumbers, 300) << endl;


}