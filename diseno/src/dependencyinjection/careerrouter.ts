import { Package } from './transportservicehandler';


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
    
    sendPackage(packageToSend: Package) {
        // Choose the career to properly manage 
        switch (packageToSend.career) {
            case 'DHL':
                this.sendPackageDHL(packageToSend);
                break;
            case 'Correos':
                this.sendPackageCorreos(packageToSend);
                break;
            case 'Uber':
                this.sendPackageUber(packageToSend);
                break;
            case 'UPS':
                this.sendPackageUPS(packageToSend);
                break;
            default:
                packageToSend.career = 'Invalid career';
        }


        console.log(packageToSend);
    }

    private sendPackageDHL(packageToSend: Package) {
        console.log('Sending package with DHL');
    }

    private sendPackageCorreos(packageToSend: Package) {
        console.log('Sending package with Correos');
    }

    private sendPackageUber(packageToSend: Package) {
        console.log('Sending package with Uber');
    }

    private sendPackageUPS(packageToSend: Package) {
        console.log('Sending package with UPS');
    }

    
}
