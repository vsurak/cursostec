const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('solutiondesigns', 'bases2', '123456', {
    host: 'localhost',
    dialect: 'mssql',
    loogging: false
});

const Owner = sequelize.define('Owner',
{
    ownerid: { 
        type: DataTypes.BIGINT, primaryKey: true, autoIncrement: true 
    },
    firstname: {
        type: DataTypes.STRING,
        allowNull: false
    },
    lastname: {
        type: DataTypes.STRING,
        allowNull: false
    },
    email: {
        type: DataTypes.STRING,
        allowNull: false
    },
    password: {
        type: DataTypes.BLOB,
        allowNull: false
    },
    enabled: {
        type: DataTypes.BOOLEAN,
        allowNull: false
    },
    creationdate: {
        type: DataTypes.STRING,
        allowNull: false
    }
}, {
  sequelize, 
  modelName: 'Owner',
  timestamps: false,
  tableName: 'sd_owners'
});

export {Owner};