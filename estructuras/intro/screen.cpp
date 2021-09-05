#include <iostream>
#include "common.cpp"

#ifndef _SCREEN_

#define _SCREEN_ 1
using namespace std;


void pintarTexto(string pMensaje, position pPos) {
    if ((pPos.X<ANCHO_PANTALLA) && (pPos.Y<ALTO_PANTALLA)) {
        cout << "si pinto el mensaje en pantalla --> " << pMensaje << endl;
    } else {
        cout << "posicion esta fuera de la pantalla" << endl;
    }   
}

#else
#endif