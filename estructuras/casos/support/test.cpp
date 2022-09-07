#include "Flight.h"
#include "../../starticketcr/generic/List.h"


// debe llenar una lista de pCantidad vuelos aleatorios cuya hora y minutos de partida esten entre pStartHour y pEndHour
// tomando en cuenta las restricciones de los minutos de salida segun el ejercicio 3 del caso #3
void fillFlights(int pCantidad, int pStartHour, int pEndHour) {

} 


int main() {
    Flight vuelo(4,35);
    cout << vuelo.flightTimeString() << "y el entero es: " << vuelo.getIntTimeValue() << endl;

    Flight otroVuelo(14,20);
    cout << otroVuelo.flightTimeString() << "y el entero es: " << otroVuelo.getIntTimeValue() << endl;
}