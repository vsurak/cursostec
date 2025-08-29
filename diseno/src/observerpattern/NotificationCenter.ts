import { Publisher } from './Publisher';

// esta es la clase que se subscribe al listener del sistema operativo, aqui llega la notificacion
export class NotificationCenter {
    private publisher: Publisher;

    constructor(publisher: Publisher) {
        this.publisher = publisher;
    }

    public OnMessage(message: any): void {
        // se queda esperando al publisher
        Promise.resolve(message).then(msg => {
            this.publisher.notify(msg);
        });
    }
}