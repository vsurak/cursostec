## actividades fuera de clase

1. estudiar de "Guía de Curso - Algoritmos y Estructuras de Datos - 10-06-2018.pdf" los puntos 5.4 y 5.5 y del libro "Estructuras de datos - Joyanes y Zahonero.pdf" los capítulos 9 y 10. los cuales serán evaluados el miércoles 20.

2. preliminar #1 del caso #2

## actividades en clase

este ejercicio es evaluado.

1. dado un arreglo de enteros tal cual como [45, 12, 6, 8, 23, 9, 15...], cómo podría obtener el arreglo ordenado usando pilas.

void ordenar(int[] \*values) {

}

int main() {
int values[6] = {67, 13, 12, 1, 9, 133};
ordenar(values)
}

mandar el código por mensaje directo a discord.

2. dada una expresión matemática que solo soporta +, -, _, / y números enteros positivos, donde todos los términos y operadores están separados por un espacio, cómo podría resolver la expresión fácilmente haciendo uso de pilas?
   ej. _ 34 _ + 45 10 2 = 3740 , + / 400 10 _ 3 4 = 52

- 34 \* + 45 10 2
- 34 \* 55 2
- 34 110
  3740

notacion matematica
prefija, no requiere priorizacion

- - 20 13 8

infija
(20+13)\*8

postfija
8 13 20 + \*

- / 400 10 \* 3 4 = 52
- / 400 10 12
- 40 12
  52
