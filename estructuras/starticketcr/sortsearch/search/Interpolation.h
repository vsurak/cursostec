# ifndef INTERPOLATION
# define INTERPOLATION 1
# include "ISearch.h"
# include <math.h>

# define NOT_FOUND -1

class Interpolation : public ISearch
{
    private:
        string name;
        int comparisons;

    public:        
        Interpolation(){
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
            comparisons ++;
            if (pNumberList->getSize() == 0) {
                return NOT_FOUND;
            }
            comparisons ++;
            if (pNumberList->getSize() == 1) {
                comparisons ++;
                if (*pNumberList->find(0) != pKey)
                    return NOT_FOUND;
                return 0;
            }
            int hi = pNumberList->getSize() - 1;
            int low = 0;
            int minVal, maxVal, itemFound, index;
            double position;
 
            while (true) {
                minVal = *pNumberList->find(low);
                maxVal = *pNumberList->find(hi);
                comparisons ++;
                if (pKey < minVal || pKey > maxVal) {
                    return NOT_FOUND;
                }
                position = (pKey - minVal);
                position /= (maxVal - minVal);
                index = std::round(position * (hi - low) + low);
                itemFound = *pNumberList->find(index);
                comparisons += 2;
                if (itemFound < pKey){
                    low = ++index;
                }
                else if(itemFound > pKey){
                    hi = --index;
                }
                else{
                    break;
                }
                /*
                if (itemFound == pKey) {
                    break;
                    
                }else if (itemFound < pKey) {
                    low = ++index;
                } else {
                    hi = --index;
                }
                */
                comparisons ++; 
                if (hi == low) {
                    return NOT_FOUND;
                }
            }
            return index;
        }
};
# endif