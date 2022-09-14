#include <iostream>
#include <string>
#include <ctime>

using namespace std;

// Quiz #6
// 1. Utilizando esta classe agregue los atributos del vuelo: aerolinea, numero de vuelo, cantidad de pasajeros
// 2. Complete el constructor de la clase, de tal forma que se pueda modificar el flightTime para una hora y minutos específicos
// 3. Implementar alguna forma de convertir el time a un número entero de tal forma que entre menor la hora menor el número, eso en getIntTimeValue()
// 4. En el test.cpp, implementar la función fillFlights()
// fecha de entrega: jueves 8 de setiembre antes de las 10pm
// entrega al asistente al correo: kevinqj.2002@gmail.com
// subject: estructuras de datos - quiz #6
// adjuntan el archivo test.cpp y Flight.h

class Flight {

    private: 
        string aerolinea; // quiz #6, preg 1
        string numerovuelo; // quiz #6, preg 1
        int pasajeros; // quiz #6, preg 1

        time_t flightTime;
        struct tm* flightTimeInfo;

    public: 
        Flight(int pHour, int pMinutes) {  // quiz #6, , preg 2
            time(&flightTime);
            flightTimeInfo = localtime(&flightTime); // creo una hora actual artificial

            flightTimeInfo->tm_hour = pHour;  // modifico la hora y los minutos
            flightTimeInfo->tm_min = pMinutes;

            flightTime = mktime(flightTimeInfo);  // creo un nuevo time con esa hora y le caigo encima
        }

        char* getFlightTimeString() {
            char* result = ctime(&flightTime);
            return result;
        }

        int getIntTimeValue() { // quiz #6, preg 3, aqui puede que hayan agarrado las horas, multiplicarlo por un factor, digamos 100, 1000 y luego sumar los minutos
            // yo lo voy hacer por timediff para que quede documentado 
            int result = 0;
            time_t now;
            struct tm firstDayYear;

            // saco la fecha actual y queda en now
            time(&now);
            firstDayYear = *localtime(&now); // saco el struct y le pongo que es el 1ero de enero, en 0:0:0
            firstDayYear.tm_hour = 0; firstDayYear.tm_min = 0; firstDayYear.tm_sec = 0;
            firstDayYear.tm_mon = 1;  firstDayYear.tm_mday = 1;

            result = (int)difftime(mktime(&firstDayYear), flightTime); //saco la cantidad de segundos del inicio de año a la hora del vuelo

            return result;
        }
};
