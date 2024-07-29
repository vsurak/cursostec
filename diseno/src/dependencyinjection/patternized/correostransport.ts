import { ITransportService } from './itransportservice';
import { Package } from './packageInfo';

export class CorreosTransport implements ITransportService {
    private static instance: CorreosTransport;

    private constructor() {
        // Private constructor to enforce singleton pattern
    }

    public static getInstance(): CorreosTransport {
        if (!CorreosTransport.instance) {
            CorreosTransport.instance = new CorreosTransport();
        }
        return CorreosTransport.instance;
    }

    sendPackage(packageToSend: Package): void {
        // Implementation for sending package via Correos
    }
}
