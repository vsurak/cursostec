export const exampleMiddleware = async (event: any, context: any, next: Function) => {
    // Perform any necessary validation or logging here
    console.log("Middleware processing request:", event);

    // Call the next middleware or handler
    await next();
};