# Serverless TypeScript Project

This project is a serverless application built with TypeScript, utilizing AWS services. It demonstrates how to create AWS Lambda functions with middleware and a repository layer.

## Project Structure

```
svlesstemplate
├── src
│   ├── handlers
│   │   ├── exampleHandlerOne.ts
│   │   └── exampleHandlerTwo.ts
│   ├── middleware
│   │   └── exampleMiddleware.ts
│   ├── repository
│   │   └── exampleRepository.ts
│   └── utils
│       └── logger.ts
├── .env
├── serverless.yml
├── package.json
├── tsconfig.json
└── README.md
```

## Prerequisites

- Node.js (v14.x or later)
- AWS CLI configured with your credentials
- Serverless Framework installed globally (`npm install -g serverless`)

## Setup Instructions

1. **Clone the repository** (if applicable):
   ```bash
   git clone <repository-url>
   cd svlesstemplate
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Configure environment variables**:
   Create a `.env` file in the root directory and add your AWS credentials and any other necessary configuration settings.

4. **Compile TypeScript**:
   Ensure TypeScript is compiled before running or deploying:
   ```bash
   npm run build
   ```

## Local Execution

To test the Lambda functions locally, you can use the Serverless Framework's offline plugin. First, install the plugin:

```bash
npm install serverless-offline --save-dev
```

Then, add the following to your `serverless.yml` under `plugins`:

```yaml
plugins:
  - serverless-offline
```

Now you can run the application locally:

```bash
serverless offline
```

## Deployment to AWS

To deploy the application to AWS, run the following command:

```bash
serverless deploy
```

This command will package your application and deploy it to AWS, creating the necessary resources.

## Modifying the Application

- **Handlers**: Modify `src/handlers/exampleHandlerOne.ts` and `src/handlers/exampleHandlerTwo.ts` to change the behavior of your Lambda functions.
- **Middleware**: Update `src/middleware/exampleMiddleware.ts` to add or modify request processing logic.
- **Repository**: Change `src/repository/exampleRepository.ts` to adjust data operations.
- **Logging**: Use the `log` function from `src/utils/logger.ts` for logging throughout your application.

