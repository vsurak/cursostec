/*
    comentario de bloque
    author: rodrigo nunez
    date: 08/09/2023
    description: intro a C en el curso de estructuras
*/

// lo primero que hacemos son los includes , es decir las librerias que van
// a utilizar en el programa
// por standard se trata que primero se pongan las librerias del sistema, que uno las nota
// porque se incluyen usando < >
// y seguido las librerias o archivos propios, eso se hace con " "
#include <iostream>
#include <string>

// en el caso de C++ existen tambien los namespaces, esto son agrupaciones de librerias
// uno puede crear las suyas y puede utilizar las existentes del sistema operativo

using namespace std;

// el punto de inicio del hilo principal de un program en C, es el main
// el main debe tener un retorno de codigo de ejecución que es un número entero

/*
sintaxis de las funciones en C

<datatype de retorno> <nombre de la funcion>([parametros])
{

} // el scope o ambito, un scope o ambito es el espacio en el segmento de codigo
que tiene cobertura en ese momento, o existencia en memoria en ese momento,
los scopes pueden ser anidados, es decir, dentro de un scope pueden haber otros scopes
todas las instrucciones pertenecen a un scope y podrían estar creando scopes nuevos
*/
int main()
{
    printf("%s", "hola mundo\n"); // esto es nativo de C
    printf("quiero un %s el %s %i de agosto\n", "helado", "miercoles", 9);

    // como imprimo texto en c++
    // utiliza operadores de entrada y salida standard => std
    std::cout << "hola estructuras de datos" << endl;

    cout << "este print no usa el namespace porque arriba pusimos el using" << endl;
}