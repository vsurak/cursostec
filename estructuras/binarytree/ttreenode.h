#ifndef _TTREENODO_
#define _TTREENODO_ 0

template <class T>
class treenodo {

    private:
        T data;

    public:
        treenodo* left = nullptr;
        treenodo* right =  nullptr;
        treenodo* father = nullptr;

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