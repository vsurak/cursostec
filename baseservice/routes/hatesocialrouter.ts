import * as express from 'express';
import { HateController } from '../controllers'

const app = express();


app.put("/rellenar", (req, res,next) => {
    HateController.getInstance().fillHatePosts();
    res.json({ message: "Ok"});
});

export { app as hatesocialrouter };