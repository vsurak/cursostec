#ifndef _BODEGA_
#define _BODEGA_ 0

#include <iostream>
#include "listadoble.h"
#include "stack.h"
#include "paletas.h"

using namespace std;

struct bodega {
    
    struct stack columnas;


    void retirarProducto(int restar){
        int cant = columnas.isEmpty();

        cout<<cant<<endl; 
        if (columnas.isEmpty()!=0){
             struct paleta* paleta1 = (struct paleta*) columnas.pop();

            while (restar!=0 & paleta1->cantproducto!=0){
                paleta1->cantproducto=paleta1->cantproducto-1;
                restar--;
            }
            cout<<"Resto 25"<<endl;
            if (restar<0){
                retirarProducto(restar);
            }
        }
        else{
            cout<<"Imposible"<<endl;
        }
    }
};

#endif