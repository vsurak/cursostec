import { Sequelize, Model, DataTypes } from 'sequelize';
import sequelize from './connector'


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
