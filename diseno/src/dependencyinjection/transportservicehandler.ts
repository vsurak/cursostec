import { Request, Response } from 'express';
import { CareerRouter } from './careerrouter';

export class Package {
    private _id: string;
    private _weight: number;
    private _type: string;
    private _career: string;
    private _costList: any;

    constructor(id: string, weight: number, type: string, career: string, costList: any) {
        this._id = id;
        this._weight = weight;
        this._type = type;
        this._career = career;
        this._costList = costList;
    }

    get id(): string {
        return this._id;
    }

    set id(value: string) {
        this._id = value;
    }

    get weight(): number {
        return this._weight;
    }

    set weight(value: number) {
        this._weight = value;
    }

    get type(): string {
        return this._type;
    }

    set type(value: string) {
        this._type = value;
    }

    get career(): string {
        return this._career;
    }

    set career(value: string) {
        this._career = value;
    }
}

export function sendPackage(req: Request, res: Response): void {
    try {
        const { id, weight, type, costList, career } = req.body.packageInfo;

        // Validate the required fields
        if (!id || !weight || !type || !costList || !costList.length) {
            res.status(400).json({ error: 'Missing required fields' });
            return;
        }

        // Create the package object
        const packaInfo = new Package(id, weight, type, career, costList);

        // perform some logic for example, process the payment of the shiping cost
        // get storage conditions from storage service

        // send the package order to the transport provider
        CareerRouter.getInstance().sendPackage(packaInfo);

        res.status(200).json({ message: 'Package sent successfully' });
    } catch (error) {
        res.status(500).json({ error: 'Internal server error' });
    }
}