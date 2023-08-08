import * as express from 'express';
import { Logger } from '../common';
import {kindnessrouter} from './kindness';
import {articlesrouter} from './articlesrouter';
import { feriarouter } from './feriarouter';

class Routes {

    public express: express.Application;
    public logger: Logger;

    constructor() {
        this.express = express();
        this.logger = new Logger();

        this.middleware();
        this.routes();
    }

    // Configure Express middleware.
    private middleware(): void {
    }

    private routes(): void {
        this.express.use('/kind', kindnessrouter);
        this.express.use('/articles', articlesrouter);
        this.express.use('/feria', feriarouter);
        this.logger.info("Kindness route loaded");
        this.logger.info("articles route loaded");
        this.logger.info("feria route loaded");
    }
}

export default new Routes().express;

