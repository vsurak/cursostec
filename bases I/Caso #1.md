# Caso #1, Merkadit, 25%

Groups: 2 persons

## Description

---

## System Description

**Merkadit** is a system designed to optimize the management of gastronomic and retail markets, where an administrator invests in remodeling a physical space and transforms it into multiple shops or kiosks rented by independent businesses. The platform allows managing the initial investment, ongoing operational expenses, the base rent of each space, and the automatic calculation of sales-based fees according to each tenant’s contract. This provides the administrator with centralized control over revenues, expenses, and the overall financial performance of the marketplace.

Additionally, Merkadit integrates a **point-of-sale (POS)** module for tenant businesses, where they can load their inventory, record real-time sales, and generate operational reports. This sales data flows directly to the administrator, who gains accurate visibility into revenues and the amount owed in rents and fees. With monthly settlement cycles configurable per tenant based on their contract start date, the system ensures transparency, efficiency, and streamlined financial management for both the administrator and the participating businesses.

---

## Functional Requirements

### 1. Space and Contract Management

1.1. Register and manage available physical spaces (food stalls, kiosks, retail stores). 

1.2. Configure attributes of each space: size, location, type (gastronomic/retail), status (available, occupied, under renovation). 

1.3. Register rental contracts for each tenant, including: 

* Start and end date.
* Base monthly rent.
* Percentage fee on sales.
* Custom monthly settlement date per contract.

---

### 2. Administrator Financial Management

2.1. Record initial investment in remodeling and setup. 

2.2. Record monthly operational expenses, categorized and numbered (e.g., utilities, security, cleaning, marketing). 

2.3. Generate financial reports for the administrator, including: 


* Total income from rents and fees.
* Total operational expenses.
* Monthly and cumulative cash flow.

2.4. Manage accounts receivable from tenants (base rent + fee). 

---

### 3. Tenant Point of Sale (POS)

3.1. Allow tenants to register product catalog with prices, descriptions, and inventory. 

3.2. Process real-time sales through the POS system. 

3.3. Automatically update inventory after each sale. 

3.4. Generate receipts/invoices for end customers. 

3.5. Provide sales reports per tenant (daily, weekly, monthly). 

    
---

### 4. Fee and Revenue Calculation

4.1. Automatically calculate the monthly fee for each tenant based on the agreed sales percentage. 

4.2. Integrate fee calculation with base rent to determine the total amount payable. 

4.3. Generate detailed reports per tenant: total sales, calculated fee, base rent, total settlement. 

4.4. Support tenant-specific monthly settlement dates based on contract start date. 

---

### 5. Reporting and Monitoring

5.1. Consolidated report of all tenants and their monthly contributions. 

5.2. Occupancy status of spaces (available, rented, under renovation). 

5.3. Comparative reports of revenues vs. expenses by month. 

5.4. Export reports in standard formats (PDF, Excel). 

---

### 6. User Roles and Access Control

6.1. **Administrator Role**: manage contracts, investments, expenses, receivables, and global reports. 

6.2. **Tenant Role**: manage inventory, sales, and reports related to their own business. 

6.3. Enforce access control with credentials and role-based permissions. 


## Case #1 Deliverables

1. **Research the problem domain**

   * Investigate and document all possible entities that are relevant to the *Merkadit* problem.
   * Example entities include: businesses (stores), inventories, prices, barcodes, payment security, reporting, addresses, shopping centers, commissions, and payments.
   * The purpose of this step is to understand the context before starting the database design.

2. **Design the database schema**

   * Based on your research, identify the entities, attributes, and relationships.
   * Create an Entity-Relationship Diagram (ERD) using MySQL Workbench or a similar tool.
   * Your design should include primary keys, foreign keys, and constraints where appropriate. Use as much as possible the data design patterns. 
   * Each team of two students will have the opportunity to review their preliminary design twice with the professor.
   * The goal is to receive feedback and refine the schema before deployment.
   * After final review proceed to adjust, improve and using the forward engineer tool, deploy the database to the mysql server 

3. **Insert sample data**
   Write a SQL script that inserts the following data:

   * At least two buildings.
   * One store space (local) in the first building, and two in the second.
   * For each store space, insert randomly between 4 and 7 different businesses.
   * Create contracts for each business linked to their respective store space.
   * Insert inventory for three different businesses chosen randomly and with different products categories
   * Generate random purchases for those two businesses with inventory:

     * Purchases should occur randomly within the last 4 months.
     * Ensure inventory levels never go negative (avoid unrealistic quantities).
     * Sale dates should also be randomized within the timeframe.
     * Include randomly between 50 to 70 purchases per month

4. **Enable and test an API**

You are to create a REST API to interact with the database. The implementation must follow the specified technical and architectural requirements.

**Technology Selection:**
*   Choose one of the following technologies for implementation:
    *   NodeJS + Express
    *   Flask or FastAPI (Python)
    *   Java Spring Boot
    *   ASP.NET Core Web API or .NET Minimal API

**Architectural Layers:**
The application must be structured into four distinct layers. The purpose of each layer is as follows:

*   **Handler Layer (API Routes/Endpoints):**
    *   Purpose: This is the outermost layer that receives HTTP requests and sends HTTP responses.
    *   Responsibilities: It handles protocol-specific tasks like parsing incoming request data (JSON, query parameters), validating basic input format, routing requests to the appropriate controller, and returning the controller's response to the client with the correct status codes and data formatting.

*   **Controller Layer (Business Logic Orchestration):**
    *   Purpose: This layer contains the core application logic and acts as a coordinator.
    *   Responsibilities: It processes the data received from the handler, makes decisions, validates business rules, and calls the appropriate methods in the service layer. It should not contain direct data access code.

*   **Service Layer (Complex Business Logic):**
    *   Purpose: This layer encapsulates complex business operations and transactions that may involve multiple entities or repository calls.
    *   Responsibilities: It implements use cases that are too complex for a single repository, often orchestrating calls to multiple repositories. It is called by the controller layer.

*   **Repository Layer (Data Access):**
    *   Purpose: This is the layer responsible for all direct communication with the database.
    *   Responsibilities: It executes SQL queries, calls stored procedures, and maps raw database data into application objects. It should be the only layer that knows about the database schema and technology.

**Stored Procedures to Implement:**
You must create and call two stored procedures from the repository layer.

*   **Stored Procedure 1: `registerSale`**
    *   Purpose: To record the sale of an item at a store.
    *   Input Parameters must have at least:
        *   Product name
        *   Store name (`comercio`)
        *   Quantity sold
        *   Amount paid (`monto pagado`)
        *   Payment method (`medio de pago`)
        *   Payment confirmations (`confirmaciones de pago`)
        *   Reference numbers (`numeros de referencia`)
        *   Invoice number (`numero de factura`)
        *   Customer (`cliente`)
        *   Applied discounts (`descuentos aplicados`)
    *   Implementation Requirements:
        *   Must include comprehensive exception handling.
        *   Must log details of the operation (e.g., computer, user, checksum).

*   **Stored Procedure 2: `settleCommerce`**
    *   Purpose: To settle the accounts for a store for the current month.
    *   Input Parameters it must have at least:
        *   Name of the store (`comercio`)
        *   Name of the location/premises (`local`)
    *   Logic it must perform:
        *   Check if the store has already been settled for the current month.
        *   If it has NOT been settled:
            *   Calculate the total fees owed to the premises administrator based on all sales.
            *   Calculate the remaining amount that belongs to the store.
            *   Execute the respective financial transactions (e.g., adjusting balances).
            *   Record the settlement to prevent it from being done a second time.
        *   If it has been settled, it should handle this scenario appropriately.
    *   Implementation Requirements:
        *   Must include comprehensive exception handling and transaction management to ensure data integrity.
        *   Must log details of the operation (e.g., computer, user, checksum).

*  **Postman test:**
    *   Create a postman collection to test your api
    *   Perform the calls and verify in the database the correctness of the REST request

5. **Write SQL queries for reporting**

   * Create a query that generates a business report as of the current date.
   * The report should include:

     * Business name
     * Store space name
     * Building name
     * Date of the first sale in the current month
     * Date of the last sale in the current month
     * Number of items sold
     * Total sales amount
     * Percentage and monetary amount due to the store space owner
     * Rental fee amount to be paid by the business

   * Transform this query into a view and use it as data source for a report
   * Create a professional-looking report that includes:

     * Title and subtitle
     * Current date
     * A table with the query results
     * Subtotals grouped by business
     * A final total at the end of the report
   * You may use any of the following tools (or a similar one): Power BI, Crystal Reports, Tableau, Kibana.
   * The report should demonstrate clear data visualization and professional presentation.

- Last date for reviews: Sunday 21st, September 2025
- Last date to commit: Tuesday 30th, September 2025. Create a repository in github, it must include the diagram as a PDF file and the script file, also one readme.md with the instructions to run the report. Is expected to find commits during the 3 weeks from both members, by the contrary hard penalties will be apply. 

---
**Class Activities:**

1. Work groups will be formed during class, and each group will focus on a separate topic: 

a) **User accounts** – individuals or companies that manage markets, including market information such as address, size, shops, and types of shops available. 

b) **Contracts** – businesses that rent one or more spaces within a market and the agreements they have with the administrator. 

c) **Inventory** – registration of the products that merchants will sell in their rented shop, stall, or space. 

d) **Sales** – registration of sales through the POS for each merchant. 


1. Proceed to create the design, either digitally or on paper, and send it to the teacher to review and discuss with classmates.

2. Using the designs in activity 4, proceed to write queries that use: order by, top, nested queries, exists, in, calculated fields. 
