import Handler from "../handlerpattern/handler";

class ValidateAmountsHandler extends Handler {

    setNext(handler: Handler) {
        this.nextHandler = handler;
        return handler;
    }

    handle(request: any): void {
        this.validateAmounts(request);
        super.handle(request);
    }

    private validateAmounts(request: any): void {
        console.log("Validating amounts.");
        // Add validation logic here
    }
}

export default ValidateAmountsHandler;