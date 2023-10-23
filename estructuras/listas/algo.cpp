main
{
    queue *fila_exterior;
    queue *pedidos;

    threads thread(filaexterior, pedidos);
}

class threads
{
    queue *fila_exterior;
    queue *pedidos;

    thread(parameters)
    {
    }

    cargarCajeros()
    { // thread
    }

    cargarClientes()
    { // thread
    }
}

//////////////

class CajeroManager
{
private:
    queue *fila_exterior;
    vector<Cajero *> cajeros;
    ChefManager *chefs;
    int current = 0;

public:
public
    CajeroManager()
    {
        // se dispara el hilo aqui el de procesar clientes
        chefs = new ChefManager();
    }

public
    void addCliente(String pName, int numero, string item)
    {
        Cliente *c = new Cliente();
        fila_exterior->enqueue(c);
    }

    void procesarClientes()
    {
        while (true)
        {
            if (!fila_exterior.isEmpty() && cajeros->at(current)->noTieneAsignado())
            {
                cajeros->at(current).setCliente(fila_exterior->dequeue());
                ++current = current % cajeros - getSize();
                Pedido p = new Pedido();
                chefs.addPedido(p);
            }
            // sleeep
        }
    }
}

class ChefManager
{
private:
    queue *pedidos;

public:
public
    ChefManager()
    {
        // disparo el hilo que atiende las ordenes
    }

public
    void addPedido(Pedido *pedido)
    {
        pedidos->enqueue(pedido);
    }

    void procesarPedidos()
    {
        while (true)
        {
            if (!pedidos.isEmpty())
            {
            }
            // sleeep
        }
    }
}
