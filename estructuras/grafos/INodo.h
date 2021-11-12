#ifndef _INODO_
#define _INODO_ 1

class INodo {
    public:
        int getId() {
            return id;
        }

        void setId(int pId) {
            this->id = pId;
        }
        
    protected:
        int id;
};

#endif