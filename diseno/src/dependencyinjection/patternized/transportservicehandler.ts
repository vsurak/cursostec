import { Request, Response } from 'express';
import { CareerRouter } from './careerrouter';
import { Package } from './packageInfo';
import { ITransportService } from './itransportservice';
import { DHLTransport } from './dhltransport';
import { UberTransport } from './ubertransport';
import { CorreosTransport } from './correostransport';
import { UPSTransport } from './upstransport';

const transportServices: { [key: string]: ITransportService } = {};

transportServices['DHL'] = DHLTransport.getInstance();
transportServices['Uber'] = UberTransport.getInstance();
transportServices['Correos'] = CorreosTransport.getInstance();
transportServices['UPS'] = UPSTransport.getInstance();


export function sendPackage(req: Request, res: Response): void {
    try {
        const { id, weight, type, costList, career } = req.body.packageInfo;

        // Validate the required fields
        if (!id || !weight || !type || !costList || !costList.length) {
            res.status(400).json({ error: 'Missing required fields' });
            return;
        }

        // Create the package object
        const packageInfo = new Package(id, weight, type, career, costList);

        // perform some logic for example, process the payment of the shiping cost
        // get storage conditions from storage service

        // send the package order to the router making agnostic the transport service
        CareerRouter.getInstance().sendPackage(transportServices[packageInfo.career], packageInfo);

        res.status(200).json({ message: 'Package sent successfully' });
    } catch (error) {
        res.status(500).json({ error: 'Internal server error' });
    }
}
