import App from './app';
import * as  http from 'http'
import { Logger } from './common'

const port = 5000;
const logger = new Logger();

App.set('port', port);
const server = http.createServer(App);
server.listen(port);

server.on('listening', () => {
    const addr = server.address();
    const bind = (typeof addr === 'string') ? `pipe ${addr}` : `port ${addr.port}`;
    logger.info(`Listening on ${bind}`)
 });

module.exports = App;

// docker run -it -p 5000:5000 --name nodeserver -v C:\dev\cursostec\baseservice:/home/baseservice node /bin/bash