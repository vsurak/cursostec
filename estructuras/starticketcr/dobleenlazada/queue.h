#ifndef QUEUE

#define QUEUE 1

template <typename T>
class Queue
{
public:
    virtual void enqueue(T *pValue) = 0;
    virtual void enqueue(T *pValue, int pPriority) = 0;
    virtual T *dequeue() = 0;
    virtual bool isEmpty() = 0;
};

#endif