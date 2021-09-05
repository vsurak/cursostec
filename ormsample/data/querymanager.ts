import {Owner} from '../model/owner'

const { Sequelize, Op } = require('sequelize');

const sequelize = new Sequelize('solutiondesigns', 'bases2', '123456', {
    host: 'localhost',
    dialect: 'mssql'
});

class Querymanager {
    constructor() {
        //this.testConnection();
    }

    public async addOwner(pOwner : any) {
        const user = await Owner.create(pOwner);
    }

    public getAllUsers() {
        return Owner.findAll();
    }

    public getSomeUsers(lowerLimit: number) {
        return Owner.findAll({
            attributes: ['firstname', 'email'],
            where: {
                ownerid: {
                    [Op.gt] : lowerLimit
                }
            }
        });
    }    

    private async testConnection() {
        try {
            await sequelize.authenticate();
            console.log('Connection has been established successfully.');
        } catch (error) {
            console.error('Unable to connect to the database:', error);
        }
    }
}

export { Querymanager }