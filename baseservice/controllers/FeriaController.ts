import { Logger } from '../common'
import { data_items } from '../repositories/data_items'


export class FeriaController {
    private static instance: FeriaController;
    private log: Logger;

    private constructor()
    {
        this.log = new Logger();
        try
        {
        } catch (e)
        {
            this.log.error(e);
        }
    }

    public static getInstance() : FeriaController
    {
        if (!this.instance)
        {
            this.instance = new FeriaController();
        }
        return this.instance;
    }

    public saveNewEvent(pEvent: any) : Promise<any>
    {
        const data_access = new data_items();
        return data_access.saveIGEvent(pEvent);
    }

    public getTop20Events() : Promise<any>
    {
        const data_access = new data_items();
        return data_access.getTop20Events();
    }

    public getFilteredClients(filter: string) : Promise<any> 
    {
        const data_access = new data_items();
        return data_access.getClientsByFilter(filter);
    }

    public getActionsPerMonth_withSP() : Promise<any> 
    {
        const data_access = new data_items();
        return data_access.getActionsPerMonth_withSP();
    }

    public getCountByEventTypeId() : Promise<any>
    {
        const data_access = new data_items();
        return data_access.getCountByEventTypeId();
    }

    public getEventCountByMonth() : Promise<any> 
    {
        const data_access = new data_items();
        return data_access.getEventCountByMonth();
    }
}