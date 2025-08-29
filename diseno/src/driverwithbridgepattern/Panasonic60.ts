import { CameraModelDriver } from './CameraModelDriver';

export class Panasonic60 implements CameraModelDriver {

    takePicture(args: any) {
        console.log('Panasonic60: Taking picture with args:', args);
    }

    powerOn(): void {
        console.log('Panasonic60: Powering on.');
    }

    powerOff(): void {
        console.log('Panasonic60: Powering off.');
    }

    zoomIn(): void {
        console.log('Panasonic60: Zooming in.');
    }

    zoomOut(): void {
        console.log('Panasonic60: Zooming out.');
    }

    capture(): void {
        console.log('Panasonic60: Capturing photo.');
    }
}