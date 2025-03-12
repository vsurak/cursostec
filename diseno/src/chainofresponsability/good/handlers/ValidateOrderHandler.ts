import Handler from "../handlerpattern/handler";

class ValidateOrderHandler  extends Handler {

    setNext(handler: Handler){
        this.nextHandler = handler;
        return handler;
    }

    handle(request: any): void {
        this.validateOrder(request);
        super.handle(request);
    }

    private validateOrder(request: any): void {
        console.log("Validating order.");
        // Add validation logic here
    }
}

export default ValidateOrderHandler;