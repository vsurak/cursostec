#include "ISearch.h"

class BinarySearch: public ISearch{
    private:
        int compare;

    public:
        BinarySearch(){
        }

        int search(List<int>* pNumberList, int pKey ){
            compare = 0;
            int low = 0;
            int high = pNumberList->getSize();
            while (low <= high) {
                int mid = low + (high - low) / 2;

                compare++;
                if (*pNumberList->find(mid) == pKey){
                    return mid;
                }
                compare++;
                if (*pNumberList->find(mid) < pKey){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }

            }

            return -1;
        }
};