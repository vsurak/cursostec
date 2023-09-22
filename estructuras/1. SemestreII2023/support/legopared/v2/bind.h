#include <string>

#ifndef _BIND_
#define _BIND_ 0

using namespace std;

class Bind : class Operation
{
private:
public:
    Bind(string[] * operands)
    {
        super("bind", operands);
    }

    void process()
    {
    }
}

#endif
