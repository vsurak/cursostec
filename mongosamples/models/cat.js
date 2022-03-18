var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/siembras');
var Cat = mongoose.model('siembras', {
    tipoplanta: String,
    ubicacion: [String],
    semillas: Number,
    pesosemilla: String,
    sol: String,
    horasdesol: Number,
    riego: Number,
    medidariego: String,
    recurrencia: Number,
    unidadrecurrencia: String,
    logs: [
        {
            fechayhora: Date,
            tipoevento: String,
            description: String,
            photo: String,
            resultado: String
        }
    ]
});
