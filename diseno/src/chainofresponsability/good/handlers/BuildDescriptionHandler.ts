import Handler from "../handlerpattern/handler";

class BuildDescriptionHandler extends Handler {

    setNext(handler: Handler) {
        this.nextHandler = handler;
        return handler;
    }

    handle(request: any): void {
        console.log("Building description.");
        this.buildDescription(request);
        // Add description building logic here
        super.handle(request);
    }

    private buildDescription(request: any): void {
        console.log("Building description for the request:", request);
    }
}

export default BuildDescriptionHandler;