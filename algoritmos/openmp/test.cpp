#include <omp.h>
#include <cstdio>

int main(){
	#pragma omp parallel
    {
        int a = 10 + 5;
        printf("Hola mundo\n");
        printf("Result %d \n", a);
    }
	


    #pragma omp parallel num_threads(3) 
    
    #pragma omp parallel
	printf("Ahora esto saldrá 3 veces\n");
    
    
    omp_set_num_threads(4);
    #pragma omp parallel 
    {
        printf("Ahora esto saldrá 4 veces\n");
        printf("Junto con esta instruccion\n");
    }
	
    
    int numbers [5] = { 16, 2, 77, 40, 12071 };
    omp_set_num_threads(2);
    #pragma omp parallel for  // a partir de aqui se le indica a openmp que puede hacer split de los elementos que recorre el for
    for(int i=0; i<5; i++) { // va a crear una copia privada del valor i, es decir que cada hilo va a observar un valor de i independiente, siendo asi que el i++ no los afecta
        int id = omp_get_thread_num();
        printf("Valor: %d in thread %d %s", numbers[i], id, "\n");
    }

    
    omp_set_num_threads(2);
	int index=0;
	#pragma omp parallel private(index)
	{
        index=10;
		int np = omp_get_num_threads();
        int id = omp_get_thread_num();
        
        #pragma omp parallel for
        for(int i=0; i<5; i++) {
            printf("Valor: %d in thread %d with index %d %s", numbers[i], id, index++, "\n");
        }
	}  // la ejecución se detiene al finalizar un section de parallel y no continua hasta que se termine el último hilo ===> depth

    #pragma omp critical 
    {
        // quiere decir que solo un hilo puede entrar a la vez a este bloque de código
    }

    #pragma omp barrier 
    // aqui los hilos van a esperar hasta que llegue último
}