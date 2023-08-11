const { Sequelize } = require('sequelize');

Sequelize.DATE.prototype._stringify = function _stringify(date:any, options:any) {
    return this._applyTimezone(date, options).format('YYYY-MM-DD HH:mm:ss.SSS');
};

const sequelize = new Sequelize('iglogs', 'sa', '123456', {
    host: '10.0.130.129',
    dialect: 'mssql'
});

export default sequelize;
  