/*
    comentario de bloque
    author: rodrigo nunez
    date: 08/16/2023
    description: solucion version 1.0 de https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true
*/

#include <iostream>
#include <string>

#define ALICE 0
#define BOB 1
#define CANTIDAD_CALIFICACIONES 4

using namespace std;

int main()
{

    int result[2] = {0, 0};
    int calificaciones[2][CANTIDAD_CALIFICACIONES] = {
        {95, 66, 15, 34},
        {76, 56, 8, 95}};

    for (int indiceCalificaciones = 0; indiceCalificaciones < CANTIDAD_CALIFICACIONES; indiceCalificaciones++)
    {
        if (calificaciones[ALICE][indiceCalificaciones] != calificaciones[BOB][indiceCalificaciones])
        {
            result[calificaciones[ALICE][indiceCalificaciones] < calificaciones[BOB][indiceCalificaciones]]++;
        }
    }

    cout << "Alice ganó " << result[ALICE] << " y Bob ganó " << result[BOB] << endl;
}