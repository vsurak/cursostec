#ifndef _NODO_ // si no está definido un simbolo que se llama _NODO_
#define _NODO_ 1

struct nodo
{
    int data;
    nodo *next = nullptr;
};

#endif