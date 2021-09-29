#ifndef _CARRO_
#define _CARRO_ 0

#include <iostream>

using namespace std;

class Carro {
    private:
        string color;
        int puertas;
        string combustible;
        string traccion;

        int retornarNivelDeAceite();

    public:
        int marchaActual;

        void encender();
        void apagar();
        void frenar();
        int acelerar(); // retorna la velocidad actual
};

#endif