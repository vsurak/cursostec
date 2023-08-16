/*
    comentario de bloque
    author: rodrigo nunez
    date: 08/16/2023
    description: solucion version 1.0 de https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true
*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
    int a[] = {45, 66, 15};
    int b[] = {73, 57, 45};

    int result[2] = {0, 0};

    for (int indiceCalificaciones = 0; indiceCalificaciones < 3; indiceCalificaciones++)
    {
        if (a[indiceCalificaciones] > b[indiceCalificaciones])
        {
            result[0]++;
        }
        else
        {
            if (a[indiceCalificaciones] < b[indiceCalificaciones])
            {
                result[1]++;
            }
        }
    }

    cout << "Alice ganó " << result[0] << " y Bob ganó " << result[1] << endl;
}