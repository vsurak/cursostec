#include <ctime>
#include <iostream>

using namespace std;


class Noticia {
    private:
        string titulo;
        string reportero;
        time_t fecha;
    public:
        // aqui los getters y setters , si no usaron bien el public/private -5
        virtual void getInfo() = 0;  // debe haber un metodo virtual, -5

}

class Media { // si esta estructura no existe como class o struct, -10
    private:
        int order;   // si este order no está -2
        string title;
        string reportero;
        string mediaType;
        string url;
    public:
        // getters y setters
}

class NoticiaDigital : public Noticia {  // aqui debe venir la herencia, si no -5
    private:
        vector<Media> media;  // lista de media de la noticia digital  si no se hizo -5
    public:
        NoticiaDigital(string titulo, string reportero, time_t fecha, vector<media> contenido) 
        {
            this->titulo = titulo;
            this->reportero = reportero;
            this->fecha = fecha;
            // etc
        }
        void getInfo() {
            cout << "Llamando a getinfo de NoticiaDigital" << endl; // no importa lo que impriman aquí 
            // tiene que ser notorio que estoy ejecutando e método en la clase hija , si no -10 
        }
}

// luego siguen las clases NoticiaPaper y NoticiaRadio, muy similar a NoticiaDigital, pero que impriman algo diferente
// aplica los mismos penalties de puntos

// finalmente un main para probar

void main() {
    // se crean un vector de Noticia , de la clase padre
    vector<Noticia> noticias;

    // se llena con clases hijas
    noticias.push_back(new NoticiaDigital("","","","")); // se crea cada objeto de algun tipo y se mete en el vector
    noticias.push_back(new NoticiaPaper("","",'')); 
    // y asi sucevimente , meten al vector noticias hijas, si intentar meter una padre no debería dejarlos por el virtual
    // pero si si lo hacen, -10

    for(Noticia not : noticias) { // las recorro como Noticia, 10 pts
        not.getInfo(); // aqui debe imprimir lo de la clase hija, 10 pts
    }
}