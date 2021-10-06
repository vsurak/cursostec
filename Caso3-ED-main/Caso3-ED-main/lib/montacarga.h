#ifndef _MONTACARGA_
#define  _MONTACARGA_ 0 

#include <iostream>
#include "pedidos.h"

using namespace std;

struct montacarga {
    int montacargas = 0;
    int tiempo = 0;
    struct pedidos* cola = nullptr;
};

#endif