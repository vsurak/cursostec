#include "ISearch.h"

class BinarySearch: public ISearch{
    private:
        string name = "BinarySearch";
        int comparations;
    public:
        BinarySearch(){
            
        }
        int search(List<int>* pNumberList, int pKey ){
            this->comparations = 0;
            int low = 0;
            int top = pNumberList->getSize()-1;
            int mid;
            while (top - low > 1) {
                int mid = (top + low) / 2;                
                this->comparations++;
                if (*pNumberList->find(mid) < pKey) {
                    low = mid + 1;                    
                }
                else {
                    top = mid;
                    this->comparations++;
                }
            }
            this->comparations += 2;
            //cout << "Comparaciones: " << this->getComparisions() << endl;
            
            if (*pNumberList->find(low) == pKey) {
                return low;
            }
            else if (*pNumberList->find(top) == pKey) {
                return top;
            }
            else {
                return -1;
            }
        }
        string getName(){
            return name;
        }
        int getComparisions(){
            return this->comparations;
        }

};