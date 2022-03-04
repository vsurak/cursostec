import { Logger } from '../common'


export class articles_data {
    private log: Logger;

    public constructor()
    {
        // via singleton, accediendo a un solo pool tengo una conexiona la base de datos
    }

    public getAllArticles() : Promise<any>
    {
        // llamadas a SP, driver de base de datos, ORM
        return null;
    }

}