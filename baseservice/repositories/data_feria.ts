import { Logger } from '../common'

const sql = require('mssql')

const sqlConfig = {
    user: "sa",
    password: "123456",
    database: "ferianueva",
    server: "localhost",
    pool: {
      max: 1,
      min: 1,
      idleTimeoutMillis: 30000
    },
    options: {
      encrypt: true, 
      trustServerCertificate: true 
    }
}

export class data_feria {
    private log: Logger;

    public constructor()
    {
        this.log = new Logger();

        // via singleton, accediendo a un solo pool tengo una conexiona la base de datos
    }

    public getClientsByFilter(filter: string) : Promise<any>
    {
        return sql.connect(sqlConfig).then((pool:any) => {
            return pool.request()
                .input("searchcriteria", sql.VarChar(40), filter)
                .execute("getFilteredClients")
        })
    }

}
