# Caso #1, Merkadit, 20%

Groups: 2 persons

## Description

Got it 👍 — here’s the full version in **English**, with both the **functional requirements** and the **two descriptive paragraphs**:

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


**Class Activity:**

1. Work groups will be formed during class, and each group will focus on a separate topic:

a) **User accounts** – individuals or companies that manage markets, including market information such as address, size, shops, and types of shops available.

b) **Contracts** – businesses that rent one or more spaces within a market and the agreements they have with the administrator.

c) **Inventory** – registration of the products that merchants will sell in their rented shop, stall, or space.

d) **Sales** – registration of sales through the POS for each merchant.

Proceed to create the design, either digitally or on paper, and send it to the teacher to review and discuss with classmates.
