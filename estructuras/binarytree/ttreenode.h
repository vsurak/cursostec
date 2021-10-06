#ifndef _TTREENODO_
#define _TTREENODO_ 0

template <class T>
class treenodo {

    private:
        treenodo* left = nullptr;
        treenodo* right =  nullptr;
        treenodo* father = nullptr;
        T data;

    public:
        treenodo(T pData) {
            data = pData;
            left = nullptr;
            right = nullptr;
            father = nullptr;
        }

        T getData() {
            return data;
        }

        void setData(T pValue) {
            this->data = pValue;
            //data = pValue;
        }
};

#endif