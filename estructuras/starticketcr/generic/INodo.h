
class INodo {
    public:
        INodo(IData *pData) {
            data = pData;
        } 

    private:
        INodo* left;
        INodo* right;
        int heigth;
        int loadfactor;
        int deep;
        bool visited;
        INodo* parent;

        IData *data;
}


class camara : public IData {
    int compareTo(IData *pToCompare) {
        
        if (pToCompare->id == this->id) {

        }
    }
}

template <class T>
class tree {

    IData* search(IData *pToSearch) {
        INodo* search = root;
        
        if (search->data->compareTo(pToSearch)==0) ya esta insertado, si te da -1 va por la izquierda 1 por la derecha
    }
}