import { Package } from './packageInfo';

export interface ITransportService {
    sendPackage(packageToSend: Package): void;
}
