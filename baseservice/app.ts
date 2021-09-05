import * as express from 'express';
import * as bodyParser from 'body-parser';
import Routes from './routes/routes'

class App {

    public express: express.Application;
    private saludos:string[];

    constructor() {
        this.express = express();
        this.middleware();
        this.routes();
    }

    // Configure Express middleware.
    private middleware(): void {
        this.express.use(bodyParser.json());
        this.express.use(bodyParser.urlencoded({ extended: false }));
    }

    private routes(): void {
        this.express.use('/api', Routes);

        this.express.use('*', (req,res) => {
            res.send("Request invalido");
        });
    }
}

export default new App().express;