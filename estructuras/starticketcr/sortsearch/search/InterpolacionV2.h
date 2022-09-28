# ifndef INTERPOLATIONV2
# define INTERPOLATIONV2 1
# include "ISearch.h"
# include <math.h>

# define NOT_FOUND -1

class Interpolationv2 : public ISearch
{
    private:
        string name;
        int comparisons;

    public:
        Interpolationv2(){
            name = "Interpolation";
        }

        int getComparisions(){
            return comparisons;
        } 

        string getName(){
            return name;
        }

        int search(List<int>* pNumberList, int pKey ) {
            comparisons = 0;

            ++comparisons;
            if (pNumberList->isEmpty()) {
                return NOT_FOUND;
            }

            int hi = pNumberList->getSize() - 1;
            int low = 0;
            int index, itemFound, minVal, maxVal;
            double position;
            
            minVal = *pNumberList->find(low);
            maxVal = *pNumberList->find(hi);
            for(++comparisons; pKey < maxVal && pKey > minVal; ++comparisons) {
                position = double(pKey - minVal) / double(maxVal - minVal);
                index = std::round(position * (hi - low) + low);
                itemFound = *pNumberList->find(index);
                
                ++comparisons;
                if (itemFound == pKey) {
                    return index;
                }

                ++comparisons;
                if (pKey < itemFound) {
                    hi = --index;
                    maxVal = *pNumberList->find(hi); 
                } else {// pKey > itemFound
                    low = ++index;
                    minVal = *pNumberList->find(low);
                }

                /* ++comparisons;          // Ver Justif.1
                if (hi == low) {
                    return NOT_FOUND;
                } */
            }
            
            ++comparisons;
            if (pKey == minVal) {
                return low;
            }
            ++comparisons;
            if (pKey == maxVal) {
                return hi;
            }
            /* else if (pkey > maxVal || pkey < minVal) {   // Ver Justif.2
                return NOT_FOUND;
            } */
            return NOT_FOUND;
        }
};
# endif

/*
Justificacion 1
if (hi == low) es redundante en este diseño debido a
while (pKey > maxVal && pKey < minVal)
Dado un escenario en que hi sea igual a low, los maxVal
y minVal se actualizan antes de terminar el ciclo. En dicho
caso si (pKey > maxVal), entonces (pKey > minVal). Asi, el ciclo
se cierra y pasa a realizar las comparaciones finales. De forma similar,
si (pKey == maxVal), entonces (pKey == minVal).


Justificacion 2
Revisar si (pkey > maxVal || pkey < minVal) resulta redundante
ya que si
    a) De entrada no cumplio la condicion de while(pKey in range)
    b) Itero dentro de while, pero luego se cumplio (pKey not in range)

entonces sabemos que pKey no esta dentro del rango pero puede ser igual
a los extremos. Si al revisar los extremos, este no es igual, resulta
obvio que esta fuera del rango y no se puede hallar
*/