#include <iostream>
#include <string>

using namespace std;

// dado un monto en colones determinar la cantidad de cada denominacion necesaria para dicho monto
void calcularDenominaciones(int pMonto) {
    int cantidad = 0;

    // billetes de 50000
    cantidad = pMonto / 50000;
    if (cantidad>0) {
        cout << "Billetes de 50000 : " << cantidad << endl;
    }
    pMonto%=50000;

    // billetes de 20000
    cantidad = pMonto / 20000;
    if (cantidad>0) {
        cout << "Billetes de 20000 : " << cantidad << endl;
    }
    pMonto%=20000;

    // billetes de 10000
    cantidad = pMonto / 10000;
    if (cantidad>0) {
        cout << "Billetes de 10000 : " << cantidad << endl;
    }
    pMonto%=10000;

    // billetes de 5000
    cantidad = pMonto / 5000;
    if (cantidad>0) {
        cout << "Billetes de 5000 : " << cantidad << endl;
    }
    pMonto%=5000;

    // billetes de 2000
    cantidad = pMonto / 2000;
    if (cantidad>0) {
        cout << "Billetes de 2000 : " << cantidad << endl;
    }
    pMonto%=2000;

    // billetes de 1000
    cantidad = pMonto / 1000;
    if (cantidad>0) {
        cout << "Billetes de 1000 : " << cantidad << endl;
    }
    pMonto%=1000;

    // monedas de 500
    cantidad = pMonto / 500;
    if (cantidad>0) {
        cout << "monedas de 500 : " << cantidad << endl;
    }
    pMonto%=500;

    // monedas de 100
    cantidad = pMonto / 100;
    if (cantidad>0) {
        cout << "monedas de 100 : " << cantidad << endl;
    }
    pMonto%=100;

    // monedas de 50
    cantidad = pMonto / 50;
    if (cantidad>0) {
        cout << "monedas de 50 : " << cantidad << endl;
    }
    pMonto%=50;

    // monedas de 20
    cantidad = pMonto / 20;
    if (cantidad>0) {
        cout << "monedas de 20 : " << cantidad << endl;
    }
    pMonto%=20;

    // monedas de 10
    cantidad = pMonto / 10;
    if (cantidad>0) {
        cout << "monedas de 10 : " << cantidad << endl;
    }
    pMonto%=10;

    // monedas de 5
    cantidad = pMonto / 5;
    if (cantidad>0) {
        cout << "monedas de 5 : " << cantidad << endl;
    }
    pMonto%=5;

    // monedas de 1
    if (pMonto>0) {
        cout << "monedas de 1 : " << pMonto << endl;
    }
}


int main() 
{
    calcularDenominaciones(7383999);
    cout << "--------------------------" <<endl;
    calcularDenominaciones(324001);
}