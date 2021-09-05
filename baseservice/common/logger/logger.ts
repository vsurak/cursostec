export class Logger {

    public info(logText: string): void {
        console.log({"date" : new Date(), "level": "info", "message":logText});
    }

    public debug(logText: string): void {
        console.log({"date" : new Date(), "level": "debug", "message":logText});
    }

    public error(logText: string): void {
        console.log({"date" : new Date(), "level": "error", "message":logText});
    }
}