
class Tunel {
    public:
        AVLTree tunel;
        int maxDistance;
        int totalMinerales;
}

class Door { 
    
    public: 
        int id;
        bool isMainDoor;
        Tunel tunel;

        Door() {
            if (rand()%100<=66) {
                tunel = new AVLTree();
                generateTunels();
            }
        }

        void generateTunels() {

        }
}

template <class T>
class Node {
    Node* prev;
    Node* cardinals[4];
    T *door;

    Nodo(T *value) {
        door = value;
        cardinals[0] = NULL;
        cardinals[1] = NULL;
        cardinals[2] = NULL;
        cardinals[3] = NULL;
    }
}


class DoorManager {

    public:
        Node<Door> *mainEntrance = NULL;
        Queue<Node<Door>> controlQueue;


        void generateDoors(int pTotalDoors) {
            Door *main = new Door();
            main.isMainDoor = true;

            Node<Door> *start = new Node<Door>(main);
            mainEntrance = main;

            controlQueue.enqueue(main);

            while (!controlQueue.isEmpty() && pTotalDoors>0) {
                Node<Door> *currentDoor = controlQueue.dequeue();

                int cantidad = rand()%4 + 1;
                

                for(;cantidad>0 && pTotalDoors>0; cantidad--) {
                    pTotalDoors--;
                    Door *newDoor = new Door();
                    Node<Door> *newNode = new Node<Door>(newDoor);
                    currentDoor[cantidad-1] = newNode;

                    controlQueue.enqueue(newNode);
                }   
            }
        }
}



