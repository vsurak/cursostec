#include <iostream>
#include "common.cpp"
#include "screen.cpp"

using namespace std;

#define CONVERTION_BASE_CHAR_VALUE 64


int main() {
    position pos;
    pos.X = 300;
    pos.Y = 200;
    pintarTexto("buenos dias", pos);

    char laA = 'A';
    char laM = 'M';

    int binariolaA = laA;
    int binariolaM = laM;

    cout << laA << " " << binariolaA <<  endl;
    cout << laM << " " << binariolaM <<  endl;

}