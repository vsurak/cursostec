/*
    comentario de bloque
    author: rodrigo nunez
    date: 08/23/2023
    description: ejercicio de semana 5
*/

#include <iostream>
#include <string>
#include <bits/stdc++.h>

#define MAX_WORDS 30

using namespace std;

string getCircularRepeat(string pTest)
{
    string words[MAX_WORDS];
    string word;

    //<ObjectType> <nombreVariable>([parametros del constructor]);
    stringstream parser(pTest);

    fill_n(words, MAX_WORDS, "$$");

    int cantidadPalabras = 0;
    while (getline(parser, word, ' '))
    {
        words[cantidadPalabras++] = word;
    }
    // al salir de este loop, en word_position va a quedar la cantidad de palabras que sacó

    // ubicarme en una palabra e ir a buscar si esa palabra aparece más adelante
    for (int indexPalabraActual = 0; i < cantidadPalabras - 1; indexPalabraActual++)
    {
        for (int indexPalabraEvaluar = indexPalabraActual + 1; i < cantidadPalabras; indexPalabraEvaluar++)
        {
            if (words[indexPalabraActual] == words[indexPalabraEvaluar])
            {
                // encontré coincidencia y debo testear si el espacio entre ellas coincide con repetición
                // si no hay espacio entre ellas no hay repetición
                bool seRepite = true;
                int testIndex = 1;
                for (int indexEvaluarRepeticion = indexPalabraActual + 1; indexEvaluarRepeticion < indexPalabraEvaluar; indexEvaluarRepeticion++)
                {
                    if (words[indexEvaluarRepeticion] != words[indexPalabraEvaluar + testIndex])
                    {
                        seRepite = false;
                        break;
                    }
                }
                // ya encontró pero no hemos tomado en cuenta si es circular y también se puede caer porque se acaba el arregl
            }
        }
    }
    return "";
}

int main()
{
    string test1 = "en, quiero comer bien, comer bi";
    string test2 = "hola mundo mundo adios";
    string test3 = "hola mundo";

    string result = getCircularRepeat(test1);
    cout << "resultado => " << result << endl;

    result = getCircularRepeat(test2);
    cout << "resultado => " << result << endl;
}