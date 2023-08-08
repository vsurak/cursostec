import { Sequelize, Model, DataTypes } from 'sequelize';
import IGEvenTypes from './ig_eventtypes'

const sequelize = new Sequelize('iglogs', 'sa', '123456', {
    host: '192.168.1.12',
    dialect: 'mssql'
});

const IGEvents  = sequelize.define('IGEvents',
{
    eventid: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
      allowNull: false,
    },
    eventtypeid: {
      type: DataTypes.TINYINT,
      allowNull: false,
      references: {
        model: IGEvenTypes,
        key: 'eventtypeid',
      },
    },
    posttime: {
      type: DataTypes.DATE,
      allowNull: false,
    },
    postid: {
      type: DataTypes.INTEGER,
      allowNull: false,
    },
    userid: {
      type: DataTypes.INTEGER,
      allowNull: false,
    }    
  },
  {
    tableName: 'ig_events',
    modelName: 'IGEvents',
    timestamps: false,
  }
);

export default IGEvents;
