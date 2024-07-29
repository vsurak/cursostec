import { ITransportService } from './itransportservice';
import { Package } from './packageInfo';


export class UberTransport implements ITransportService {
    private static instance: UberTransport;

    private constructor() {
        // Private constructor to enforce singleton pattern
    }

    public static getInstance(): UberTransport {
        if (!UberTransport.instance) {
            UberTransport.instance = new UberTransport();
        }
        return UberTransport.instance;
    }

    sendPackage(packageToSend: Package): void {
        // Implementation for sending package via Uber
    }
}
