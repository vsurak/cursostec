import { Sequelize, Model, DataTypes } from 'sequelize';

const sequelize = new Sequelize('iglogs', 'sa', '123456', {
    host: '192.168.1.12',
    dialect: 'mssql'
});

const IGEvenTypes = sequelize.define('IGEvenTypes', 
{
    eventtypeid: {
      type: DataTypes.TINYINT,
      primaryKey: true,
      allowNull: false,
    },
    event: {
      type: DataTypes.STRING(20),
      allowNull: false,
    }
  },
  {
    tableName: 'ig_eventtypes',
    modelName: 'IGEvenTypes',
    timestamps: false,
  }
);

export default IGEvenTypes;
