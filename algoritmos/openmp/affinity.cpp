#include <omp.h>
#include <cstdio>
#include <sched.h>
#include <iostream>
#include <list>
#include <time.h> 

using namespace std;

int main(){
	
    int numbers [10] = { 87, 34, 25, 10, 66, 16, 2, 77, 40, 12071 };
    #pragma omp parallel num_threads(2) 
    #pragma omp parallel for
    for(int i=0; i<10; i++) {
        int id = omp_get_thread_num();
        int coreid = sched_getcpu();
        printf("Valor: %d in thread %d in core %d %s", numbers[i], id, coreid, "\n");
    }



    list<int> morenumbers;
    srand (time(NULL));

    const int SIZE = 100000;
    for (int i=0; i<SIZE; i++) 
    {
        morenumbers.push_back(rand() % 999999 + 1);
    } 

    omp_set_num_threads(5);
    const char* line = "El número %d es %s calculado en el thread %d socket %d \n";

    #pragma omp parallel for
    //for (list<int>::iterator number = morenumbers.begin(); number != morenumbers.end(); number++) {
    for (int position=0; position<SIZE; position++) {
        int id = omp_get_thread_num();
        int coreid = sched_getcpu();

        list<int>::iterator number = morenumbers.begin();
        advance(number, position);

        if (*number%2==0) {
            printf(line, *number, "par", id, coreid);
        } else {
            printf(line, *number, "impar", id, coreid);
        }       
    }
}