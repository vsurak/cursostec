#ifndef _INODO_
#define _INODO_ 1

class INodo {
    public:
        int getId() {
            return Id;
        };

        void setId(int pId) {
            this->Id = pId;
        };
   
   protected:
      int Id;
};

#endif