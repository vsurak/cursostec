// estructura recomendada de un programa en C/C++
// inicialmente vamos a tener los includes , que son librerias o archivos creados por nosotros como programadores
// que hay que incluir para que nuestro programa funcione
#include <iostream>

// validación de reentrancia y redeclaraciones #ifdef y ifndef #endif , tiene sentido cuando hay más de un archivo
// definiciones de constantes #define 

// declaración de namesspaces a utilizar
using namespace std;

// funciones, métodos, structs 

// se pone al final el main que es el punto de entrada del programa
int main()  // el int que retonar main es el código de terminación, es cero si termino sin errores y otro número si algo falló
{
    int y = 5;
    cout << "hola clase de estructuras" << endl;
    if (1) {
        int x = 10;
        cout << y << endl;
    } else {
        //cout << x endl; x está en otro contexto o otro scope
        cout << y << endl;
    }
}