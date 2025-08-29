import { CameraModelDriver } from './CameraModelDriver';

export abstract class OsCameraDriver {
    abstract takePicture(args: any, cameraModel: CameraModelDriver): void;
}