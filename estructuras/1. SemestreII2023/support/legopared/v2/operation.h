#include <string>

#ifndef _OPERATION_
#define _OPERATION_ 0

using namespace std;

public
class Operation
{
private:
    string tipo;
    vector<string> *operandos;

public:
    Operation(string pType, string[] * operandos)
    {
        tipo = pType;

        // cargo operandos
    }

    virtual process() = 0;
}

#endif
