#ifndef _NODODOBLE_
#define _NODODOBLE_ 1

#include <iostream>

struct comida {
    int number;
    string dishname;
    float prize;
}

struct nododoble {
    struct comida data;
    struct nododoble* next = nullptr;
    struct nododoble* previous = nullptr;
}

#endif