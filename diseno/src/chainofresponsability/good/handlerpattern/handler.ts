
class Handler {
    protected nextHandler: Handler | null = null;

    setNext(handler: Handler) {
        this.nextHandler = handler;
        return handler;
    }

    handle(request: any): void {
        if (this.nextHandler) {
            this.nextHandler.handle(request);
        }
    }
}

export default Handler;