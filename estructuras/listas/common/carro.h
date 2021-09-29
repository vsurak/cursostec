#ifndef _CARRO_
#define _CARRO_ 0

using namespace std;

class Carro {
    private:
        color: string;
        puertas: int;
        combustible: string;
        traccion: string;
    public:
        void encender();
        void apagar();
        void frenar();
        int acelerar(); // retorna la velocidad actual
};

#endif