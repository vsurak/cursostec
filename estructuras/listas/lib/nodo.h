#ifndef _NODO_
#define _NODO_ 1

struct jugador {
    int numero;
    string nombre;
}

struct nodo {
    jugador data;
    nodo* next = nullptr;
};

#endif