import { ISubscriber } from './ISubscriber';

export class Publisher {
    private subscribers: List<ISubscriber> = new List<ISubscriber>();

    subscribe(subscriber: ISubscriber): void {
        if (!this.subscribers.includes(subscriber)) {
            this.subscribers.push(subscriber);
        }
    }

    unsubscribe(subscriber: ISubscriber): void {
        this.subscribers = this.subscribers.filter(s => s !== subscriber);
    }

    notify(data: any): void {
        // secuencial 
        this.subscribers.forEach(subscriber => subscriber.update(data));

        // o en paralelo, si fuera paralelo tenemos que tirar un thread o un promise por cada llamada
        // Promise.all(
        //     this.subscribers.map(subscriber => Promise.resolve().then(() => subscriber.update(data)))
        // );
    }
}