import { Apple18 } from './apple18';
import { SamsungX95 } from './samsungx95';
import { Panasonic60 } from './panasonic60';

class AndroidPlus {
    private appleDevice: Apple18;
    private samsungDevice: SamsungX95;
    private panasonicDevice: Panasonic60;

    constructor() {
        this.appleDevice = new Apple18();
        this.samsungDevice = new SamsungX95();
        this.panasonicDevice = new Panasonic60();
    }

    // Example method to demonstrate usage
    initializeDevices() {
        this.appleDevice.init();
        this.samsungDevice.init();
        this.panasonicDevice.init();
    }
}

// Example of class initialization
const androidPlus = new AndroidPlus();
androidPlus.initializeDevices();