import { ISubscriber } from './ISubscriber';

export class TicketDisplayer implements ISubscriber {
    update(data: any): void {
        // Display the ticket information
        console.log('Voy a llamar al UI para que muestre la ficha y la ventanilla');
    }
}