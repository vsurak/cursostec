template <class T> 
class IData {
    public:
        // 0 igual -1 menor 1 mayor
        virtual int compareTo(IData *pToCompare)=0;
}