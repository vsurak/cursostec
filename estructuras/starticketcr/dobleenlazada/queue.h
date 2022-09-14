#ifndef QUEUE 

#define QUEUE 1

template <class T>
class Queue {
    public:
        virtual void enqueue(T* pValue);
        virtual T* dequeue() = 0;
};

#endif;