#include <iostream>
#include <string>

using namespace std;

#define SIZE 10000

// la funcion va a retornar la posición donde se encuentra el elemento
// haciendo un barrido secuencial, si no lo encuentra retorna -1
int buscar(int *pItems, int pKey)
{
    int result = -1;

    for (int indiceBusqueda = 0; indiceBusqueda < SIZE; indiceBusqueda++)
    {
        if (pItems[indiceBusqueda] == pKey)
        {
            result = indiceBusqueda;
            break;
        }
    }

    return result;
}

// haciendo un barrido secuencial, si no lo encuentra retorna -1
int buscarConLRU(int *pItems, int pKey)
{
    int result = -1;

    for (int indiceBusqueda = 0; indiceBusqueda < SIZE; indiceBusqueda++)
    {
        if (pItems[indiceBusqueda] == pKey)
        {
            result = indiceBusqueda;

            // corrimientos del LRU
            for (; indiceBusqueda > 0; indiceBusqueda--)
            {
                pItems[indiceBusqueda] = pItems[indiceBusqueda - 1];
            }
            pItems[0] = pKey;

            break;
        }
    }

    return result;
}

int main()
{
    int datos[SIZE];
    int pruebas[6] = {9630, 1005, 9999, 5000, 7300, 1000};
    for (int indiceArray = 0; indiceArray < SIZE; indiceArray++)
    {
        datos[indiceArray] = 1000 + indiceArray;
    }

    int testIndex = 0;
    int cantidadIteracionesDePruebas = 0;

    for (; cantidadIteracionesDePruebas < 60; cantidadIteracionesDePruebas++)
    {
        testIndex++;
        cout << "test #" << cantidadIteracionesDePruebas
             << " buscando " << pruebas[testIndex % 6] << " encontrado en "
             << buscar(datos, pruebas[testIndex % 6]) << endl;
    }
}
