// estructura recomendada de un programa en C/C++
// inicialmente vamos a tener los includes , que son librerias o archivos creados por nosotros como programadores
// que hay que incluir para que nuestro programa funcione
#include <iostream>
#include <string>
// validación de reentrancia y redeclaraciones #ifdef y ifndef #endif , tiene sentido cuando hay más de un archivo
// definiciones de constantes #define 

#define IVA 0
#define RENTA_ESCALA_1 1
#define RENTA_ESCALA_2 2


// declaración de namesspaces a utilizar
using namespace std;

// funciones, métodos, structs

struct persona {
    string nombre;
    short edad;
    string codigocarrera;
};

struct region {
    int id;
    int color;
    int adyacentes[2];
};

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

    // arreglos
    char letras[10];
    int valores[5];
    bool flags[7];

    int nuevoValor = 9 + valores[4];

    // multidimensionales
    int ratecubo[10][8];

    float impuestos[3] = {0.16, 0.25, 0.30};
    string marcas[] = {"TOYOTA", "NISSAN", "HIUNDAY", "BMW"};

    cout << impuestos[2] << " y la marca 1 " << marcas[1] << endl; 

    float montosubtotal = 4000.00;

    float total = montosubtotal * impuestos[IVA];

    persona ana;

    ana.nombre = "Ana maria";
    ana.edad = 18;
    ana.codigocarrera = "IC";

    persona p1;

    p1.nombre = "Juan Pablo";
    p1.edad = 20;
    p1.codigocarrera = "MI";

    cout << ana.nombre << " " << p1.nombre << endl;

    region lasregiones[] = {
                                {1, 0, {3,2}}, 
                                {2, 0, {1,3}}
                            };

    int matrixrelaciones[][13] = {
        {0,1,1,0,0,0,0,0,0,0,0,0},
        {1,0,1,0,0,0,0,0,0,0,0,0}
    };
/*
    bool cumple = true;
    for (int i=0; i<12; i++) {
        if (lasregiones[i].color==0) {
            for(recorrer los adyacentes de [i] para saber que colores tienen asignados para asignarle un color)
            if hay repetido then cumple = false break;
        } else {
            recorro los adyacentes para ver si tienen un color diferente y decir que esta ok, y si algun adyacente no tiene colores
            aun entonces le asigno un color diferente al [i]
        }
    }

    // recorrido para validar si efectivamente cumple el teorema o no
*/
}