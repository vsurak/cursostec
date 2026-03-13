# DUA Streamliner - Project Instructions

## Overview

DUA Streamliner is an automated system that processes customs declaration documents (DUA - Declaración Única Aduanera). It reads multiple file formats (Word, Excel, PDF, images), extracts structured and unstructured data using AI-driven semantic interpretation, and generates a pre-filled DUA Word document with confidence indicators.

---

## Prerequisites

- **Node.js** >= 21.0.0
- **npm** >= 10.0.0
- **Azure Subscription** with the following services configured:
  - Azure Entra ID (authentication)
  - Azure Key Vault (secrets management)
  - Azure Application Insights (observability)
  - Azure App Service (hosting)
  - Azure DevOps (CI/CD, repositories)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone <azure-devops-repo-url>
cd dua-streamliner/src
```

### 2. Install Dependencies

```bash
npm install
```

### 3. Configure Environment Variables

Copy the example environment file and fill in the required values:

```bash
cp .env.example .env.local
```

Edit `.env.local` with your Azure configuration:

| Variable | Description |
|---|---|
| `AZURE_AD_CLIENT_ID` | Azure Entra ID application client ID |
| `AZURE_AD_TENANT_ID` | Azure Entra ID tenant ID |
| `AZURE_AD_CLIENT_SECRET` | Azure Entra ID client secret |
| `AZURE_AD_REDIRECT_URI` | OAuth redirect URI |
| `AZURE_KEYVAULT_URL` | Azure Key Vault URL (`https://customsidentityserver.vault.azure.net/`) |
| `NEXT_PUBLIC_APPINSIGHTS_CONNECTION_STRING` | Azure Application Insights connection string |
| `API_BASE_URL` | Backend API base URL |
| `NOTIFICATION_CALLBACK_URL` | Callback URL for async notification service |

### 4. Setup Husky Git Hooks

```bash
npm run prepare
```

---

## Running the Application

### Development Mode

```bash
npm run dev
```

The application will be available at `http://localhost:3000`.

### Production Build

```bash
npm run build
npm start
```

---

## Testing

### Unit Tests (Jest)

```bash
npm test                 # Run all unit tests
npm run test:watch       # Watch mode
npm run test:coverage    # With coverage report
```

### Integration / E2E Tests (Playwright)

```bash
npx playwright install   # First time only - install browsers
npm run test:e2e         # Run e2e tests
npm run test:e2e:ui      # Run with Playwright UI
```

---

## Code Quality

### Linting

```bash
npm run lint             # Check for lint errors
npm run lint:fix         # Auto-fix lint errors
```

### Formatting

```bash
npm run format           # Format all files
npm run format:check     # Check formatting
```

Pre-commit hooks are configured via Husky + lint-staged to automatically lint and format staged files.

---

## Project Architecture

### Layer Structure

```
src/
├── app/                     # Next.js App Router (SSR pages & routing)
├── components/              # Atomic Design UI components
│   ├── atoms/               #   Basic elements (Button, Input, Label)
│   ├── molecules/           #   Composite elements (FormField, FileUploader)
│   ├── organisms/           #   Complex sections (Navbar, DuaForm)
│   ├── templates/           #   Page layouts (MainLayout)
│   └── pages/               #   Page-level styles
├── hooks/                   # React hooks connecting components to services
├── services/                # Business logic and orchestration
├── apiClients/              # HTTP clients for external API communication
├── models/                  # TypeScript interfaces and types
├── validation/              # Zod schemas for data validation
├── state/                   # Redux store, slices, and typed hooks
├── settings/                # Azure Key Vault integration & configuration
├── utils/                   # Shared utilities and constants
├── auth/                    # Azure Entra ID config, roles, and permissions
├── i18n/                    # Internationalization (en, es)
├── logs/                    # Azure Application Insights logging
├── exceptionHandling/       # Centralized error handling
├── notificationService/     # Observer pattern for async callback events
├── documentProcessors/      # Document extraction with Builder + Strategy patterns
│   ├── strategies/          #   Per-format extraction (Word, Excel, PDF, Image)
│   └── formatAdapters/      #   Output formatting (Paragraph, Table, Amount, etc.)
└── __tests__/               # Unit and E2E test suites
```

### Design Patterns

| Pattern | Applied To | Description |
|---|---|---|
| **Builder** | `DocumentProcessorBuilder` | Configures which document strategies to include |
| **Strategy** | `IDocumentStrategy` implementations | Format-specific extraction logic (Word, Excel, PDF, Image) |
| **Observer** | `NotificationService` | Subscribe/notify for async API callback events |
| **Adapter** | `IFormatAdapter` implementations | Transforms data into output formats (Paragraph, Bullets, Table, Label, Amount) |
| **Singleton** | Settings, Logger, ExceptionHandler, ApiClients, NotificationService | Single shared instance across the application |

### Roles and Permissions

| Role | Permissions |
|---|---|
| **Manager** | `MANAGE_USERS`, `VIEW_REPORTS`, `EDIT_TEMPLATES` |
| **Customs Agent** | `LOAD_FILES`, `GENERATE_DUA`, `DOWNLOAD_DUA` |

### CSS Conventions

- One CSS file per component type (e.g., `atoms.css`, `molecules.css`)
- Class name pattern: `ComponentName-StyleName` (e.g., `Button-Root`, `Navbar-Links`)
- Positional units: `em` only (for responsiveness)

---

## Environments

| Environment | Description |
|---|---|
| **Development** | Local development with `.env.local` |
| **Stage** | Pre-production deployed via Azure DevOps Pipelines |
| **Production** | Live deployed via Azure DevOps Pipelines |

Deployments are managed via **Azure DevOps Environments** and **Azure DevOps Pipelines**.

---

## Key Technology Versions

| Technology | Version |
|---|---|
| React | 19.2.0 |
| Next.js | 15.3.0 |
| Node.js | >= 21 |
| TypeScript | 5.9.3 |
| Redux | 5.0.1 |
| Zod | 4.3.6 |
| Jest | 30.2.0 |
| Playwright | 1.58.2 |
| ESLint | 10.0.2 |
| Prettier | 3.8.1 |
| Husky | 9.1.7 |
| react-i18next | 16.5.8 |

---

## Additional Notes

- Authentication flows through **Azure Entra ID** with **MFA** (mobile authenticator only)
- Secrets are stored in **Azure Key Vault** (server name: `customsidentityserver`)
- All logging is sent to **Azure Application Insights**
- Asynchronous API calls use callback-based notifications via the **NotificationService** layer
- The application supports **SSR** (Server-Side Rendering) via Next.js on Azure App Service
