#ifndef _PERSONA_
#define _PERSONA_ 1

#include <iostream>
#include "INodo.h"

using namespace std;

class Persona : public INodo {
    public:
        Persona() {
            this->setId(rand()*99999999999);
        }

        string getNombre() {
            return this->nombre;
        }

        void setNombre(string pNombre) {
            this->nombre = pNombre;
        }

    private:
        string nombre;
};

#endif