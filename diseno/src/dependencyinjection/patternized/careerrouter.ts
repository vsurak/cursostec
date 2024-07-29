import { Package } from './transportservicehandler';
import { ITransportService } from './itransportservice';

export class CareerRouter {
    private static instance: CareerRouter;
    
    private constructor() {
        // Private constructor to prevent instantiation
    }
    
    public static getInstance(): CareerRouter {
        if (!CareerRouter.instance) {
            CareerRouter.instance = new CareerRouter();
        }
        return CareerRouter.instance;
    }
    
    sendPackage(transportservice: ITransportService,  packageToSend: Package) {
        // aqui puede haber más logica relacionada al routing de envio de paquetes

        // hago el envío con la dependencia que me inyectaron en lugar yo de tenerla implementada o importarlas todas las existentes
        // o tener que preguntar case by case
        transportservice.sendPackage(packageToSend);
        // aqui puede seguir habiendo logica
    }


    // que bondades y principios de diseño se alcanzaron con esta implementación?
}
