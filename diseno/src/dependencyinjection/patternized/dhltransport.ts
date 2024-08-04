import { ITransportService } from './itransportservice';
import { Package } from './packageInfo';

export class DHLTransport implements ITransportService {
    private static instance: DHLTransport;

    private constructor() {
        // Private constructor to enforce singleton pattern
    }

    public static getInstance(): DHLTransport {
        if (!DHLTransport.instance) {
            DHLTransport.instance = new DHLTransport();
        }
        return DHLTransport.instance;
    }

    sendPackage(packageToSend: Package): void {
    // Implementation for sending package via DHL
    }
}
