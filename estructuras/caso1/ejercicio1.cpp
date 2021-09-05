#include <iostream>
#include <string>

using namespace std;

#define TAMANO_ARREGLO_PALABRAS 50
#define TAMANO_ARREGLO_DE_FRASES 100
#define MAXIMUM_LENGTH_OF_WORD 40
#define MAXIMO_DE_PALABRAS_TOTAL 1000

struct splitdata {
    string palabras[TAMANO_ARREGLO_PALABRAS];
    int cantidadPalabras;
    string fraseOriginal;
    int cantidadIndicesDePalabras=0;
    int indicesEnPalabras[MAXIMO_DE_PALABRAS_TOTAL];
};


struct persona {
    string nombre;
    string apellido
    int edad;
};


struct indicesporpalabra {
    string palabra="";
    int cantidadIndicesDeFrases=0;
    int indicesDeFrases[TAMANO_ARREGLO_DE_FRASES];
    bool visitada = false;
};


splitdata split(string pTextoToParse, string pSeparator) {
    splitdata result;
    result.cantidadPalabras = 0;
    result.fraseOriginal = pTextoToParse;

    while (pTextoToParse != "") {
        std::size_t found = pTextoToParse.find(pSeparator);
        
        if (found>MAXIMUM_LENGTH_OF_WORD) { // eso es cierto cuando ya no se encuentra el separador en el texto
            result.palabras[result.cantidadPalabras++] = pTextoToParse;
            break;
        }
        
        result.palabras[result.cantidadPalabras++] = pTextoToParse.substr (0,found); 
        pTextoToParse = pTextoToParse.substr(found+1, pTextoToParse.length()-(found+1));
    }

    return result;
}


int analizarFrases(splitdata pFrasesProcesadas[], int pCantidadFrases, indicesporpalabra pPalabrasProcesadas[]) {
    int cantidadPalabrasTotal = 0;
    for(int indiceFrases=0; indiceFrases<pCantidadFrases; indiceFrases++) {
        for(int indicePalabraPorFrase=0; indicePalabraPorFrase<pFrasesProcesadas[indiceFrases].cantidadPalabras; indicePalabraPorFrase++) {
            for(int indicePalabrasProcesadas=0; indicePalabrasProcesadas<=cantidadPalabrasTotal; indicePalabrasProcesadas++) {
                if (pPalabrasProcesadas[indicePalabrasProcesadas].palabra==pFrasesProcesadas[indiceFrases].palabras[indicePalabraPorFrase] ||
                    pPalabrasProcesadas[indicePalabrasProcesadas].palabra=="") {
                    if (pPalabrasProcesadas[indicePalabrasProcesadas].palabra=="") {
                        cantidadPalabrasTotal++;
                    }
                    pPalabrasProcesadas[indicePalabrasProcesadas].palabra = pFrasesProcesadas[indiceFrases].palabras[indicePalabraPorFrase];
                    pPalabrasProcesadas[indicePalabrasProcesadas].indicesDeFrases[pPalabrasProcesadas[indicePalabrasProcesadas].cantidadIndicesDeFrases++] = indiceFrases;
                    pFrasesProcesadas[indiceFrases].indicesEnPalabras[pFrasesProcesadas[indiceFrases].cantidadIndicesDePalabras++] = indicePalabrasProcesadas;                    
                    break;
                }
            }
        }
    }
    return cantidadPalabrasTotal;
}


void sacarFrasesConParejas(splitdata pFrasesProcesadas[], int pCantidadFrases, indicesporpalabra pPalabrasProcesadas[], int pTotalPalabrasProcesadas) {
    for(int indicePalabrasProcesadas = 0; indicePalabrasProcesadas<pTotalPalabrasProcesadas-1; indicePalabrasProcesadas++) {
        if (pPalabrasProcesadas[indicePalabrasProcesadas].cantidadIndicesDeFrases>1 && pPalabrasProcesadas[indicePalabrasProcesadas].visitada==false) {
            pPalabrasProcesadas[indicePalabrasProcesadas].visitada = true;
            // armando parejas de frases
            for (int primerElementoPareja=0; primerElementoPareja<pPalabrasProcesadas[indicePalabrasProcesadas].cantidadIndicesDeFrases-1; primerElementoPareja++) {
                for (int segundoElementoPareja=primerElementoPareja+1; segundoElementoPareja<pPalabrasProcesadas[indicePalabrasProcesadas].cantidadIndicesDeFrases; segundoElementoPareja++) {
                    int frase1 = pPalabrasProcesadas[indicePalabrasProcesadas].indicesDeFrases[primerElementoPareja];
                    int frase2 = pPalabrasProcesadas[indicePalabrasProcesadas].indicesDeFrases[segundoElementoPareja];
                    for(int indiceBuscarHaciaAdelante=indicePalabrasProcesadas+1; indiceBuscarHaciaAdelante<pTotalPalabrasProcesadas; indiceBuscarHaciaAdelante++) {
                        int cantidadCoincidencias = 0;
                        int frasePrimerCoincidencia = 0;
                        
                        for (int indiceComparando=0; indiceComparando<pPalabrasProcesadas[indiceBuscarHaciaAdelante].cantidadIndicesDeFrases; indiceComparando++) {
                            if  (pPalabrasProcesadas[indiceBuscarHaciaAdelante].indicesDeFrases[indiceComparando] == frase1 ||
                                pPalabrasProcesadas[indiceBuscarHaciaAdelante].indicesDeFrases[indiceComparando] == frase2) {
                                    cantidadCoincidencias++;
                                    if (cantidadCoincidencias==2) {
                                        int fraseActual = pPalabrasProcesadas[indiceBuscarHaciaAdelante].indicesDeFrases[indiceComparando];
                                        cout << pFrasesProcesadas[frasePrimerCoincidencia].fraseOriginal << " ==== " << pFrasesProcesadas[fraseActual].fraseOriginal ;
                                        cout << " == palabras => " << pPalabrasProcesadas[indicePalabrasProcesadas].palabra << " , " << pPalabrasProcesadas[indiceBuscarHaciaAdelante].palabra << endl;
                                        break;
                                    }
                                    frasePrimerCoincidencia = pPalabrasProcesadas[indiceBuscarHaciaAdelante].indicesDeFrases[indiceComparando];
                            }
                        }
                    }       
                }
            }
        }
    }
}

int main() {

    string frases[] = {"test arbol casa", "arbol ayer temprano", "arbol casa verde ayer temprano", "ayer hola test casa"};

    int cantidadDeFrases = 4;
    splitdata frasesProcesadas[cantidadDeFrases];

    for(int indiceFrase=0; indiceFrase<cantidadDeFrases; indiceFrase++) {
        frasesProcesadas[indiceFrase] = split(frases[indiceFrase], " ");
    }

    indicesporpalabra palabrasProcesadas[MAXIMO_DE_PALABRAS_TOTAL];

    int totalCantidadPalabras = analizarFrases(frasesProcesadas, cantidadDeFrases, palabrasProcesadas);

    sacarFrasesConParejas(frasesProcesadas, cantidadDeFrases, palabrasProcesadas, totalCantidadPalabras); 
}