import { Publisher } from './Publisher';
import { TicketDisplayer } from './TicketDisplayer';

function main() {
    const publisher = new Publisher();
    const ticketDisplayer = new TicketDisplayer();
    const calendarManager = new CalendarManager();

    publisher.subscribe(ticketDisplayer);
    publisher.subscribe(calendarManager);

}

main();