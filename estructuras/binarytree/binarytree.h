#ifndef _BINARYTREE_
#define _BINARYTREE_ 0

#include "ttreenode.h"

template <class T>
class binarytree {

    private:
        treenodo<T>* root = nullptr;
        int size;
        int height;

    public:

        int getSize() {
            return size;
        }

        int getHeight() {
            return height;
        }

        void add(T pValue) {
            treenodo<T>* newNodo = malloc(sizeof(treenodo<T>));
            //treenodo<T> newNodo = new treenodo<T>(pValue);
            newNodo->setData(pValue);

            if (root!=nullptr) {
                
            } else {
                root = newNodo;
            }
        }

};

#endif