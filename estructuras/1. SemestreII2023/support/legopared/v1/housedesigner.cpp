#include <string>
#include "pieza.h"
#include "modulo.h"

#ifndef _DESIGNER_
#define _DESIGNER_ 0

#define CANTIDAD_DE_STEPS = 10

using namespace std;

public
class HouseDesigner
{
private:
    vector<pieza> *inventario;
    vector<string[]>[CANTIDAD_DE_STEPS] steps;
    vector<modulo *> *modulos;

public:
    HouseDesigner()
    {
        inventario = new vector<pieza>();
        modulos = new vector<modulo>();

        inventario->push_back({"Pieza A", 300});
        inventario->push_back({"Pieza B", 300});
        inventario->push_back({"Pieza C", 400});
        inventario->push_back({"Pieza D", 300});
        inventario->push_back({"Pieza E", 200});
        inventario->push_back({"Pieza F", 1000});

        for (int i = 0; i < CANTIDAD_DE_STEPS; i++)
        {
            steps[i] = vector<string>();
        }

        Modulo *newModule = new Modulo("pared", 1, 2);
        newModule->getPiezas()->push_back({"Pieza C", 10});
        newModule->getPiezas()->push_back({"Pieza D", 15});
        newModule->getPiezas()->push_back({"Pieza A", 100});

        modulos->push_back(newModule);

        newModule = new Modulo("techo", 4, 0);
        newModule->getPiezas()->push_back({"Pieza R", 20});
        newModule->getPiezas()->push_back({"Pieza C", 45});

        modulos->push_back(newModule);
        /// sigo cargando
    }

    void loadConstruction()
    {
        steps[0]->push_back([ "unir", "pared", "pared", "unir", "pared", "pared" ]);
        steps[0]->push_back([ "bind", "cuarto de pedro", "unir", "unir", "pared", "pared", "unir", "pared", "pared", "unir", "pared", "paredconpuerta", "pared", "pared" ]);
    }

    void build()
    {
        // recorriendo todos los steps
        // los va evaluar en postfijo usando la definición de operaciones
        for (int stepIndex = 0; i < CANTIDAD_DE_STEPS; stepIndex++)
        {
            for (int vectorIndex = 0; vectorIndex < steps[0]->size(); vectorIndex++)
            {
                string[] operation = steps[0]->at(vectorIndex);

                if (operation[0] == "unir")
                {
                    unir(operation);
                }
                if (operation[0] == "bind")
                {
                    bind(operation);
                }
                //... aqui van a seguir las demas operaciones
            }
        }
    }

    void unir(string[] pOperands)
    {
        //
    }

    void build(string[] pOperands)
    {
        //
    }
}

#endif