#include <string>
#include <iostream>

#include "../search/ISearch.h"
#include "../sort/ISort.h"
#include "../../dobleenlazada/List.h"


using namespace std;

int main() {
    cout << "probando sorting y search de los diversos algoritmos con polimorfismo" << endl;
    List<ISort> *algoritmosDeSort = new List<ISort>();
    List<ISearch> *algoritmosDeSearch = new List<ISearch>();
    List<int> *listNumbers = new List<int>();

    int numbers[] = {35, 20, 10, 22, 9};
    listNumbers->add(&numbers[0]);
    listNumbers->add(&numbers[1]);
    listNumbers->add(&numbers[2]);
    listNumbers->add(&numbers[3]);
    listNumbers->add(&numbers[4]);

    // cargar las listas con sus algoritmos
    
    // seleccionar un algoritmo de sort aleatorio y lo ejecuto
    int selectedSort = rand() % 3;
    ISort *sortAlg = algoritmosDeSort->find(selectedSort);
    listNumbers = sortAlg->sort(listNumbers);

    // imprimo la lista ordenada
    int *value = 0;
    
    listNumbers->resetSearch();
    value = listNumbers->next();
    while (value!=NULL) {
        cout << *value << endl;
        value = listNumbers->next();
    } 

    // selecciono un algoritmo de search aleatorio y lo ejecuto
    int selectedSearch = rand() % 2;
    ISearch *searchAlg = algoritmosDeSearch->find(selectedSearch);
   
    cout << searchAlg->search(listNumbers, 22) << endl;
    cout << searchAlg->search(listNumbers, 200) << endl;
}