#ifndef _WEBAPP_
#define _WEBAPP_ 1

#include <iostream>
#include "INodo.h"

using namespace std;

class WebApp : public INodo {
    public:
        WebApp(int pId, string pNombre) {
            this->setId(pId);
            this->setNombre(pNombre);
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