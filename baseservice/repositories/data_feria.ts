import { Logger } from '../common'
import IGEvenTypes from './ig_eventtypes'
import IGEvents from './ig_events'

const sql = require('mssql')

const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('iglogs', 'sa', '123456', {
    host: '192.168.1.12',
    dialect: 'mssql'
});

const sqlConfig = {
    user: "sa",
    password: "123456",
    database: "iglogs",
    server: "192.168.1.12",
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
        });
    }

    public getActionsPerMonth_withSP() : Promise<any>
    {
        return sql.connect(sqlConfig).then((pool:any) => {
            return pool.request()
                .execute("getActionsByMonth")
        });
    }

    // npm install sequelize
    // npm install --save tedious


    public getCountByEventTypeId() : Promise<any> {
        try {
            const results = IGEvents.findAll({
                attributes: [
                    [sequelize.fn('DATENAME', sequelize.literal('MONTH'), sequelize.col('posttime')), 'mes'],
                    'eventtypeid',
                    [sequelize.fn('COUNT', sequelize.col('eventid')), 'cantidad'],
                ],
                group: [sequelize.fn('DATENAME', sequelize.literal('MONTH'), sequelize.col('posttime')), 'eventtypeid'],
                order: [
                    [sequelize.fn('DATENAME', sequelize.literal('MONTH'), sequelize.col('posttime')), 'ASC'],
                    ['eventtypeid', 'ASC'],
                ],
            });        
            return results;
        } catch (error) {
            console.error('Error:', error);
        }
    };
     
    public getEventCountByMonth() : Promise<any> {
        try {
            IGEvents.belongsTo(IGEvenTypes, { foreignKey: 'eventtypeid' });
            const results = IGEvents.findAll({
            attributes: [
                [sequelize.fn('DATENAME', sequelize.literal('month'), sequelize.col('posttime')), 'mes'],
                sequelize.col('event'),
                [sequelize.fn('COUNT', sequelize.col('eventid')), 'cantidad'],
            ],
            include: {model: IGEvenTypes, attributes: ['event']},
            group: [sequelize.fn('DATENAME', sequelize.literal('month'), sequelize.col('posttime')), sequelize.fn('DATEPART', sequelize.literal('mm'), sequelize.col('posttime')) ,'event', sequelize.literal('IGEvenType.eventtypeid')],
            order: [
                [sequelize.fn('DATEPART', sequelize.literal('mm'), sequelize.col('posttime')), 'ASC'],
                [sequelize.literal('cantidad'), 'DESC'],
            ],
            });
        
            return results;
        } catch (error) {
            console.error('Error:', error);
        }
    };
}
