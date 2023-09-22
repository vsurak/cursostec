#include <iostream>

#ifndef _FACILITY_
#define _FACILITY_ 0

class Facility
{
private:
    Queue<camion> *camionesLlegando;
    int tiempoDescargaMin;
    int tiempoDescargaMax;
    int tiempoPorCamion;
    int cantidadCamionesPorHora;
    clock_t start;
    clock_t end;

public:
    // esto va a ser un thread
    void ingresarCamiones()
    {
    }
}

#endif