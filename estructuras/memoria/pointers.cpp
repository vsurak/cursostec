#include <iostream>

using namespace std;

int main()
{
    unsigned char letras[10] = {'A', 'A', 'J', 'A', 'Y', 'Y', 'Y', 'V', 'T', 'Q'};

    unsigned char *primerpuntero;

    primerpuntero = &letras[0];

    char x = *primerpuntero;
    cout << "el char que saque: " << x << endl;

    primerpuntero++;
    x = *primerpuntero;
    cout << "el char que saque: " << x << endl;

    ++primerpuntero;
    x = *primerpuntero;
    cout << "el char que saque: " << x << endl;

    cout << "regreso al inicio del array" << endl;
    // me vuelvo a ubicar al inicio
    primerpuntero = &letras[0];
    primerpuntero += 4;
    x = *primerpuntero;
    cout << "el char que saque: " << x << endl;

    cout << "direccion: " << &primerpuntero << endl;
    cout << letras[0] << " " << letras[2] << endl;

    // C y C++ ellos usan la aritmética de direcciones dependiendo del tipo de dato del puntero
    // el arreglo anterior lo accedi con un puntero a char, y el arreglo es de chars, es decir que cada
    // posicion del arreglo contiene un unsigned char, es decir 1 byte
    // pero que pasa si mi puntero es más grande que eso por ejemplo

    unsigned int *segundopuntero = (unsigned int *)&letras[0];
    // 1094797898
    // 01000001 01000001 01001010 01001010
    // 01000001 01001010 01000001 01000001
    unsigned int valor = *segundopuntero;
    cout << "valor :" << valor << endl;

    // el arreglo que tiene YYYV que se va cargar en el int como VYYY
    // 1448696153

    segundopuntero++;
    valor = *segundopuntero;
    cout << "valor :" << valor << endl;

    void *loquesea = &letras[0];

    char caracter = *(char *)loquesea;

    int valor2 = *(int *)loquesea;

    cout << "casteando punteros void a un tipo de dato " << endl;
    cout << "caracter: " << caracter << " valor2: " << valor2 << endl;

    // declarar un puntero
    // <tipodedato>* <nombredelavariable>;
    // int* algo;

    // acceder
    // interpreta el * como "a lo que apunta"
    // int x = algo; // error algo es puntero y x es int
    // int x = *algo; // asigne a x "a lo que apunta algo"

    return 0;
}