# include "ISearch.h"
# include <math.h>

# define NOT_FOUND -1

class Interpolation : public ISearch
{
    public:        
        int search(List<int>* pNumberList, int pKey ) {
            if (pNumberList->getSize() == 0) {
                return NOT_FOUND;
            }
            int hi = pNumberList->getSize() - 1;
            int low = 0;
            int minVal, maxVal;
            double position;
            int index, itemFound;
            if (pKey > *pNumberList->find(hi) || pKey < *pNumberList->find(low)) {
                return NOT_FOUND;
            }
            while (true) {
                minVal = *pNumberList->find(low);
                maxVal = *pNumberList->find(hi);
                position = (pKey - minVal);
                position /= (maxVal - minVal); // 3/33 = 1/11
                index = std::round(position * (hi - low) + low);
                itemFound = *pNumberList->find(index);
                
                // [min     item     max]
                if (itemFound == pKey) {
                    break;
                } else if (itemFound > pKey) {  // [index i2 index]
                    low = index;
                } else { // [min  i2  index]
                    hi = index;
                }
                if (hi != low) {
                    return NOT_FOUND;
                }
            }
            return index;
        }
};