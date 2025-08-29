import { OsCameraDriver } from './OsCameraDriver';
import { AndroidLolipop } from './AndroidLolipop';
import { CameraModelDriver } from './CameraModelDriver';
import { Apple18 } from './Apple18';
import { Panasonic60 } from './Panasonic60';

export class ClientCamera {
    private cameraDriver: OsCameraDriver;

    constructor() {
    }

    takePicture(args: any): void {
        OsCameraDriver ocd = new Apple18(); // hay que irlo averiguar al operativo
        CameraModelDriver cmd = new Panasonic60(); // hay que irlo averiguar al operativo
        // dependency injection
        ocd.takePicture(args, cmd);
    }
}