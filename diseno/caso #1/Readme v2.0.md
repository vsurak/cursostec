# Dua streamliner design 


**Author**: rodrigo nunez 

The current process of preparing the DUA is highly manual, time-consuming, and error-prone for importers and exporters. Information required to complete the document is typically scattered across multiple files such as Excel sheets, Word documents, PDFs, and scanned invoices. These documents often follow different structures and formats, making data extraction complex and heavily dependent on human interpretation. As a result, customs specialists spend significant time consolidating, validating, and transcribing information into the official template.

To address this challenge, the proposed solution is an automated system that requires only a folder path containing all relevant documents. The system will intelligently read multiple formats, extract both structured and unstructured data—including OCR from scanned images—and apply AI-driven semantic interpretation tailored to customs terminology. It will then automatically map the extracted information to the official DUA template defined by the Ministerio de Hacienda, validate basic consistency rules, and flag ambiguous or low-confidence fields for review.

The expected result is a fully pre-filled Word DUA document with visual confidence indicators that guide expert validation. This approach does not eliminate the customs specialist’s role but transforms it into a strategic review function, significantly reducing manual operational workload. Ultimately, the system aims to increase efficiency, reduce errors, accelerate processing times, and improve compliance accuracy in international trade operations.


# 1. Frontend design

## 1.1 Technology stack 

- Application type: server side rendering web app
- Web framework: reactjs version 19.2
- NodeJs version 21
- TypeScript 5.9.3
- Unit testing: Jest 30.2.0
- Zod 4.3.6 to data validation 
- Prettier 3.8.1
- eslint 10.0.2 
- Integration testing: Playwright version 1.58.2
- Cloud service: Azure cloud services
- Hosted by Azure App Service
- Code respositories by Azure DevOps
- Automated code tasks by Husky 9.1.7
- CI CD by Azure DevOps Pipelines
- Environments: development, stage and production
- Environment deployments Azure DevOps Environments
- Observability by Azure Application Insights SDK
- State management with redux 5.0.1

## 1.3 Component design strategy
- Use atomic design for basic and complex component design
- Centralize CSS styles in just one file per component type
- Class names patterns for CSS: ComponentName-StyleName
- Use only "em" positional units to support responsiveness in the design
- Components supports react-i18next 16.5.8
- There're not accesible requirements

[Atomic design folder](/src/components)

## 1.4 Security 
- Multi-Factor Authentication (MFA) through **Azure Entra ID**.
- Mobile authenticator application only.
- Single Sign on Azure Entra ID
- Authentication is handled by Azure Entra ID.
- Roles: Manager, Customs Agent
- Permissions by Role:
  - **Manager**
    - Permission Code: `MANAGE_USERS`  
      - Description: Manage user crud
    - Permission Code: `VIEW_REPORTS`  
      - Description: Access operational and performance reports.
    - Permission Code: `EDIT_TEMPLATES`  
      - Description: Change or update DUA templates available
  - **Customs Agent**
    - Permission Code: `LOAD_FILES`  
      - Description: Set and upload a folder with data files. 
    - Permission Code: `GENERATE_DUA`  
      - Description: Starts the AI process of generating a DUA 
    - Permission Code: `DOWNLOAD_DUA`  
      - Description: Downloads the DUA generated
- Azure Key Vault is used to store Environment variables, API keys, Sensitive configuration data
- Server Name: `customsidentityserver`

## 1.5 Layered design:

* The frontend performs **SSR (Server-Side Rendering)**.
* If there is no authenticated session, the **Authentication Layer** is invoked.
* If authentication is successful, the visual resource is accessed and rendered within the **Components Layer**.
* Components follow **Atomic Design** (atoms, molecules, organisms, templates, and pages); within components, a **Hooks Layer** exists to connect visual component actions with the **Services Layer**.
* **Services** contain the application's operations. [Business logic classes](/src/services)
* To perform their tasks, **Services** may require access to the **Utils**, **ApiClients**, and **Settings** layers.
* **ApiClients** contains all classes that access external APIs.
* **Settings** accesses environment variables in **Azure Key Vault** during rendering.
* **ApiClients** reads API keys and URLs from **Settings**.
* All **ApiClient** calls and returns use classes in **Models**, which are validated by the **DataValidation** layer.
* All layers can access the **Models**, **Utils**, and **State Management** layers.
* The **NotificationService** layer allows other layers to subscribe to events via **callback URLs**.
* Asynchronous API calls are always handled via callback using the **Notification Service** layer.
* The **Logs** layer provides classes to register system events, which are sent via **ApiClients**.
* ExceptionHandling layer is a shared layer

                +----------------------+
                |      User Browser    |
                +----------+-----------+
                           |
                           v
                +----------------------+
                |    Azure App Service |
                |  NodeJS + React SSR  |
                +----------+-----------+
                           |
                 SSR Request Handling
                           |
                    Authentication
                           |
                +----------------------+
                |   Components Layer   |
                | Atomic Design UI     |
                | Atoms → Pages        |
                +----------+-----------+
                           |
                         Hooks
                           |
                     Services Layer
                           |
         +----------------+----------------+
         |                |                |
       Utils          ApiClients        Settings
                                            |
                                    Azure Key Vault
                                            |
                                     Secrets / Config
                                            
ApiClients → External APIs
External APIs → Notification Service (Callbacks)

Shared Layers:
Models
Zod Validation
Redux State Management
Exception Handling
Logs → Azure Application Insights

CI/CD:
Azure DevOps Repo → Pipelines → Dev / Stage / Prod → Azure App Service


## 1.6  Design patterns 
- Use Builder Pattern and Strategy Pattern to create the diffrent document processors such as wordx, xlsx, pdf, jpg, png. 
- NotificationService subscriptions works with Obsever pattern
- Use adapter pattern to decide the output format to be writen in the documents, use FormatAdapters y Concret Format such as: Paragraph, Bullets, Table, Label, Amount. 
- Singleton for: ExceptionHandling, Document Parsers, Utils, StateManagement, The Api Clients, Settings classes. 
