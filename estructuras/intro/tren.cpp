#include <iostream>
#include <string>
#include <stdlib.h> 

using namespace std;

#define VAGONES 5
#define ASIENTOS_POR_VAGON 10
#define VENDIDO 1
#define DISPONIBLE 0
#define PORCENTAJE_ASIENTOS_VENDIDOS 0.30
#define TOP 10
#define TOTAL_ASIENTOS VAGONES*ASIENTOS_POR_VAGON

void disponibles(short pTren[]) {
    short primeros[TOP];
    short ultimos[TOP];

    int contadorPrimeros = 0;
    int contadorUltimos = 0;

    for(int indexAsientos=0; indexAsientos<TOTAL_ASIENTOS; indexAsientos++) {
        if (contadorPrimeros<TOP && pTren[indexAsientos]==DISPONIBLE) {
            primeros[contadorPrimeros++] = indexAsientos;
        }
        if (contadorUltimos<TOP && pTren[TOTAL_ASIENTOS-indexAsientos-1]==DISPONIBLE) {
            ultimos[contadorUltimos++] = TOTAL_ASIENTOS-indexAsientos-1;
        }

        if (contadorUltimos==TOP && contadorPrimeros==TOP) {
            break;
        }
    }

    cout << "Top " << TOP << " " << "primeros" << contadorPrimeros << endl;
    cout << "=======================================" << endl;
    for(int index=0; index<contadorPrimeros; index++) {
        cout << "Vagon " << primeros[index] / ASIENTOS_POR_VAGON + 1 << " asiento " << primeros[index] % ASIENTOS_POR_VAGON << endl;
    }

    cout << "Top " << TOP << " " << "ultimos" << endl;
    cout << "=======================================" << endl;
    for(int index=0; index<contadorUltimos; index++) {
        cout << "Vagon " << ultimos[index] / ASIENTOS_POR_VAGON + 1 << " asiento " << ultimos[index] % ASIENTOS_POR_VAGON << endl;
    }
}

int main() {

    //int tren[VAGONES*ASIENTOS_POR_VAGON]; // esta está muy cara, porque son ints
    short tren[VAGONES*ASIENTOS_POR_VAGON];

    int cantidadVendidos = VAGONES*ASIENTOS_POR_VAGON*PORCENTAJE_ASIENTOS_VENDIDOS;
    cout << "cantidad de asientos vendidos " << cantidadVendidos << endl;
    
    for(int vendidos=0; vendidos<cantidadVendidos; vendidos++) {
        tren[rand() %  (VAGONES*ASIENTOS_POR_VAGON)]=VENDIDO;       
    }

    disponibles(tren);
}