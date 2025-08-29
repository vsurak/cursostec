import { ISubscriber } from './ISubscriber';

export class CalendarManager implements ISubscriber {
    update(data: any): void {
        // Implement update logic here
        console.log('CalendarManager received update:', data);
    }
}