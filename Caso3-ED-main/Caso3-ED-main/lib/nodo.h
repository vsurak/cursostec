#ifndef _NODOGENERICO_
#define _NODOGENERICO_ 1

// void es un apuntador genérico a cualquier cosa 
// cuando ya necesite acceder a los datos de alguna forma requiero
// hacer casting al tipo de dato que yo se que está apuntando
struct nodo {
    void* data = nullptr;
    struct nodo* next = nullptr;
    struct nodo* previous = nullptr;
};


#endif