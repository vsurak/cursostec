#define CANTIDAD_MAXIMA_SUMAR  100

struct celda {
    int fila;
    int columna;
    int value;
};

struct sumas {
    int fila;
    int columna;
    celda celdasASumar[CANTIDAD_MAXIMA_SUMAR];
    int cantidadCeldasSuma=0;
    int resultado=0;
};

void procesarSpreadSheet(sumas celdas[], int pCantidadSumas) {

}


int main() {
    celda celdas[3];
    celdas[0].fila = 3;
    celdas[0].columna = 2;
    celdas[0].value = 45;

    celdas[1].fila = 4;
    celdas[1].columna = 2;
    celdas[1].value = 10;

    celdas[2].fila = 5;
    celdas[2].columna = 2;
    celdas[2].value = 239;

    sumas celdasdesuma[1];

    celdasdesuma[0].fila = 6;
    celdasdesuma[0].columna = 4;
    celdasdesuma[0].celdasASumar[0] = celdas[0];
    celdasdesuma[0].celdasASumar[1] = celdas[1];
    celdasdesuma[0].celdasASumar[2] = celdas[2];
    celdasdesuma[0].cantidadCeldasSuma = 3;
}

