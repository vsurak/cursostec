import * as express from 'express';
import { Logger } from '../common'
import { FeriaController } from '../controllers'

const app = express();
const log = new Logger();

app.post("/getfilteredclients", (req, res,next) => {
    FeriaController.getInstance().getFilteredClients(req.body.filter)
    .then((data:any)=>{
        res.json(data);
    })
    .catch((err:any)=>{
        log.error(err);
        return "{msg: \"error\"}";
    });

});

app.get("/getactionssp", (req, res,next) => {
    FeriaController.getInstance().getActionsPerMonth_withSP()
    .then((data:any)=>{
        res.json(data.recordset);
    })
    .catch((err:any)=>{
        log.error(err);
        return "{msg: \"error\"}";
    });

});

app.get("/getCountByEventTypeId",(req, res,next) => {
    FeriaController.getInstance().getCountByEventTypeId()
    .then((data:any)=>{
        res.json(data);
    })
    .catch((err:any)=>{
        log.error(err);
        return "{msg: \"error\"}";
    });

});

app.get("/geteventspermonth", (req, res,next) => {
    FeriaController.getInstance().getEventCountByMonth()
    .then((data:any)=>{
        res.json(data);
    })
    .catch((err:any)=>{
        log.error(err);
        return "{msg: \"error\"}";
    });

});

export { app as feriarouter };