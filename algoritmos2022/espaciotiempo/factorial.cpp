#include <iostream>

using namespace std;

#define MAX_FILL 100
long factoriales[MAX_FILL];

void fill() {
    int factorial = 2;
    factoriales[0] = 0;
    factoriales[1] = 1;
    for(int i=2; i<MAX_FILL; i++) {
        factoriales[i]=factoriales[i-1]*factorial;
        factorial++;
    }
}

int factorial(int value) { // mem 2 int, 8 bytes, sacrifico es cpu
    int result = 1;
    int iteraciones = 0;

    while (value>1) {
        iteraciones++;
        result*=value;
        value--;
    }

    cout << "Iteraciones de factorial: " << iteraciones << endl;
    return result;
}

int factorialMem(int value) { // MAX_FILL * 4 bytes, 400000 bytes
    int result = 1;
    int count = 1;
    int iteraciones = 0;

    while (count<=value) {
        if (value<MAX_FILL && factoriales[value]) {
            return factoriales[value];
        }        
        result*=count;
        count++;
        iteraciones++;
    }
    cout << "Iteraciones de factorialMEM: " << iteraciones << endl;
    return result;
}

int main() {
    cout << "llenando..." << endl;
    fill();
    
    cout << "correr el lento..." << endl;
    factorial(90);

    cout << "correr el rapido..." << endl;
    factorialMem(90);

    cout << factoriales[90] << endl;
}

// docker run -it --rm -v C:\dev\cursostec\alg2019\algoritmos2022:/home --name migcc /bin/bash