#ifndef _PERSONA_
#define _PERSONA_ 1

#include <iostream>

using namespace std;

class Persona {
   public:
      string getNombre() {
          return this->nombre;
      }

      void setNombre(string pNombre) {
          this->nombre = pNombre;
      }
   
   private:
      string nombre;
};

#endif