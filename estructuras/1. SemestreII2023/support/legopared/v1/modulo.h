#include <string>
#include "pieza.h"

#ifndef _MODULO_
#define _MODULO_ 0

using namespace std;

public
class Modulo
{
private:
    string nombre;
    int alto;
    int ancho;
    vector<pieza> *piezas;

public:
    Modulo(string pNombre, int pAlto, int pAncho)
    {
        piezas = new vector<piezas>();
        alto = pAlto;
        ancho = pAncho;
        nombre = pNombre;
    }

    string getNombre()
    {
        return pNombre;
    }

    vector<pieza> *getPiezas()
    {
        return piezas;
    }
}

#endif