#include <iostream>
#include <chrono>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <vector>

class Chocolatte {
public:
    template <size_t N, size_t M>
    Chocolatte(int (&pCostosAncho)[N], int (&pCostosAlto)[M])
        : ancho(N), alto(M),
          costosAncho(pCostosAncho, pCostosAncho + N),
          costosAlto(pCostosAlto, pCostosAlto + M) {}

    // retornar la cantidad de cortes, debe encontrar la cantidad minima que se debe hacer
    int cuts() {

        auto start = std::chrono::high_resolution_clock::now();
        int totalCuts = 0;


        // put your algorithm here
        // put your prompt here
        // Inputs: parámetros del algoritmo, tipo de dato y el nombre
        // Steps: 
        // 1. saque los puntos x, y bla bla bla
        // 2. otra cosa
        // 3. Returne lista de circulos concentricos 


        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();

        std::cout << "[Calculate cuts] "
                  << "Time: " << duration << " ns, "
                  << "Cuts: " << totalCuts;

        return totalCuts;
    }

private:
    int alto;
    int ancho;
    std::vector<int> costosAncho;
    std::vector<int> costosAlto;
};

int main() {
    std::srand(static_cast<unsigned int>(std::time(nullptr)));

    int costosAncho[500];
    for (int &costo : costosAncho) {
        costo = 2 + std::rand() % 5; // valores de 2 a 6
    }

    int costosAlto[300];
    for (int &costo : costosAlto) {
        costo = 7 + std::rand() % 5; // valores de 7 a 11
    }

    Chocolatte chocCalculator(costosAncho, costosAlto);
    chocCalculator.cuts();

    return 0;
}
