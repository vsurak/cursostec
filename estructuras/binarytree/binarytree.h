#ifndef _BINARYTREE_
#define _BINARYTREE_ 0

#include "ttreenode.h"

template <class T>
class binarytree {

    private:
        treenodo<T>* root = nullptr;
        int size = 0;
        int height = 0;

    public:
        int getSize() {
            return size;
        }

        int getHeight() {
            return height;
        }

        treenodo<T>* getRoot() {
            return root;
        }


        void add(T pValue) {
            int currentHeight = 0;
            treenodo<T>* newNodo = (treenodo<T>*) malloc(sizeof(treenodo<T>));
            //treenodo<T> newNodo = new treenodo<T>(pValue);
            newNodo->setData(pValue);

            size++;
            if (root!=nullptr) {
                treenodo<T>* seeker = root;
                bool insertionPointFound = false;
    
                while (!insertionPointFound) {

                    if ((int)newNodo->getData()<(int)seeker->getData()) { // el valor del dato a insertar es <= al nodo actual en seeker
                        // voy por la izquierda
                        if (seeker->left==nullptr) {
                            insertionPointFound = true;

                            seeker->left = newNodo;
                            newNodo->father = seeker;

                        } else {
                            seeker = seeker->left;
                        }
                    } else if ((int)newNodo->getData()>(int)seeker->getData()) {
                        // debo bajar por la derecha
                        if (seeker->right==nullptr) {
                            insertionPointFound = true;
                            seeker->right = newNodo;
                            newNodo->father =  seeker;

                        } else {
                            seeker = seeker->right;
                        }
                    } else {
                        insertionPointFound = true;
                        size--;
                    }

                    currentHeight++;
                    this->height = currentHeight>this->height? currentHeight : this->height;
                }
            } else {
                root = newNodo;
            }
        }

};

#endif