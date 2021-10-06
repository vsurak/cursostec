#ifndef _TREENODO_
#define _TREENODO_ 0


class treenodo {

    private:
        treenodo* left = nullptr;
        treenodo* right =  nullptr;
        void* data;

    public:
        treenodo(void* pData) {
            data = pData;
            left = nullptr;
            right = nullptr;
        }

        void* getData() {
            return data;
        }
};

#endif