import { ITransportService } from './itransportservice';
import { Package } from './packageInfo';
import { UUID } from 'angular2-uuid';

export class ShippingPackage {
    id: number;
    consecutive: number;
    guid: string;
    description: string;
    weight: number;
    type: string;
    total: number
}



export class UPSTransport implements ITransportService {
    private static instance: UPSTransport;

    private constructor() {
        // Private constructor to enforce singleton pattern
    }

    public static getInstance(): UPSTransport {
        if (!UPSTransport.instance) {
            UPSTransport.instance = new UPSTransport();
        }
        return UPSTransport.instance;
    }

    sendPackage(packageToSend: Package): void {
        // una gran ventaja es que para hacer el envio por ejemplo en UPS, puede ser muy diferente a enviar el paquete por uber
        // o por cualquier otro medio, pero lo bueno es que esta clase solo se preocupa por UPS, todo lo demás lo desconoce
        
        // podria ser que UPS requiera enviar un objeto por un rest diferente Package

        let total = 0;
        let description = "";
        for (const item of packageToSend.costList()) {
            total += item.amount;
            description += item.description+". ";
        }

        const shippingPackage = new ShippingPackage();
        shippingPackage.id =  Number.parseInt(packageToSend.id);
        shippingPackage.consecutive = 100000 + Math.floor(Math.random() * 100000000);
        shippingPackage.guid = new UUID().toString();
        shippingPackage.description = description;
        shippingPackage.weight = packageToSend.weight;
        shippingPackage.type = packageToSend.type;
        shippingPackage.total = total;

        // send the shippingPackage to UPS interface , api, email, database, process, notification service, etc
    }
}
