#include <string>

#ifndef _UNION_
#define _UNION_ 0

using namespace std;

class Union : class Operation
{
private:
public:
    Union(string[] * operands)
    {
        super(pType, operands);
    }

    void process()
    {
    }
}

#endif
