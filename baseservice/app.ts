import * as express from 'express';
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
        this.express.use(express.json()); // Used to parse JSON bodies
        this.express.use(express.urlencoded()); // Parse URL-encoded bodies using query-string library
    }

    private routes(): void {
        this.express.use('/api', Routes);

        this.express.use('*', (req,res) => {
            res.send("Request invalido");
        });
    }
}

export default new App().express;