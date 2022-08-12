/*
* Vamos a empezar a programar algunos TADs
* 
*/

#include <iostream>

using namespace std;

// funciones <valor de retorno, si no retorna nada es void> nombredelafuncion([parameters]) {
//}

// los macros nos sirven mucho para definir constantes
#define ANCHO_PANTALLA 1200
#define ALTO_PANTALLA 790

struct position {
   int X;
   int Y;
}; 

// nombres de los parámetros los inicio con p minúscula
int sumar(int pNumber1, int pNumber2) {
   int valor;
   return pNumber1 + pNumber2;
}

template <class T>
T sumarGenerico(T pNumber1, T pNumber2) {
   return pNumber1+pNumber2;
}

// sobrecarga de operadores, que las funciones o metodos
// pueden llamarse igual pero se distinguen segun el tipo de dato y orden de los parámetros
int sumarSobrecarga(int pNumber1, int pNumber2) {
   return pNumber1+pNumber2;
}

float sumarSobrecarga(float pNumber1, double pNumber2) {
   return pNumber1+pNumber2;
}

float sumarSobrecarga(int pNumber1, double pNumber2) {
   return pNumber1+pNumber2;
}

float sumarSobrecarga(float pNumber1, int pNumber2) {
   return pNumber1+pNumber2;
}


position centrar(int pAncho, int pAlto) {
   position resultado;
   resultado.X = ANCHO_PANTALLA / 2 - pAncho / 2;
   resultado.Y = ALTO_PANTALLA / 2 - pAlto / 2;
   return resultado;
}


//Por el momento imprimimos una string
int main()
{
   string mensaje = "Saludando a estructuras de datos";
   cout << mensaje << std::endl;

   
   int otroarreglo[3];
   int miarreglo[] = {8, 4, 2, 8, 1};


   otroarreglo[0] = 10;
   otroarreglo[1] = 20;
   otroarreglo[2] = 30;

   cout << otroarreglo[1] << " " << miarreglo[3] << endl;

   position p = centrar(60, 20);
   cout << "X: " << p.X << " " << "Y: " << p.Y << endl;

   int a = 30;
   short b = a;

   printf("usando un numero que si cabe: transformo %d en %d, probando %s \n", a, b, "hey clase de estructuras" );

   a = 70000;
   b = a;

   printf("usando un numero que no cabe: %d \n", b );

   unsigned short test1 = 65535; 
   printf("usando un ushort al limite: %d \n", test1);

   test1++;
   printf("usando un ushort al limite: %d \n", test1);

   test1++;
   printf("usando un ushort al limite: %d \n", test1);

   test1 = 20000;
   printf("primero evaluo despues ejecuto: %d \n", test1++);
   cout << test1 << endl;

   test1 = 20000;
   printf("primero ejecuto despues evaluo: %d \n", ++test1);

   // printf hace un print con format

   printf("hola a %s hoy el %d del mes %d del anyo %d \n", "todos", 10, 8, 2022);

   test1 = test1 + 1;
   test1++;

   test1 = 30000;
   test1 = test1 + 5000;
   cout << test1 << endl;

   test1 = 30000;
   test1 += 5000; 
   cout << test1 << endl;

   test1 = 30000;
   test1 = test1 * 2;
   cout << test1 << endl;

   test1 = 30000;
   test1 *= 2;
   cout << test1 << endl;


   // orden de ejecucion:
   // 1. initialization
   // 2. conditions
   // 3. body
   // 4. post body
   // las 4 secciones son opcionales
   //for(<initialization>; <conditions>; <post body>) {
   //   <body>
   //};

   for(int i = 0; i<100; i++) {
      // hago algo
   }

   int i = 0;
   for(; i<100; i++) {
      // hago algo
   }

   i = 0;
   for(; i<100;) {
      // hago algo
      i++;
   }

   //for(;;) {
   //   cout << "hola" << endl;
   //}

   for(int i=0, x=10; i<10; i++, printf("hola %d", i));

   sumarGenerico(10, 5);

   sumarGenerico(1.0, 3.5);

   sumarSobrecarga(5, 7.8);
   return 0;
}