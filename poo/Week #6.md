# Practicing Object-Oriented Design and Implementation

## Project Overview: Pineapple Production System Modeling

You will design and model a comprehensive pineapple production system consisting of **three main productive areas**: Planting (Siembra), Processing (Procesamiento), and Sales (Ventas). Your task is to create object-oriented designs that clearly represent the relationships, responsibilities, and behaviors of each component within these areas.

---

## System Requirements by Productive Area

### 1. **Planting Area (Siembra)**

The planting area manages the cultivation of pineapples from seed to harvest. Your design must model:

- **Farms (Fincas)**: Represent agricultural properties that contain multiple sections
- **Sections (Secciones)**: Subdivisions within farms where pineapples are planted
  - Planting date
  - Expected harvest period (in months)
  - Applied inputs: fertilizer amounts, pesticides, water quantity
  - Status tracking (planted, growing, ready for harvest)
- **Harvesting & Transportation**:
  - Harvested pineapples are transported via carts (carretas) with defined capacity
  - Carts transport produce from sections to the processing plant
  - Track transportation dates and cart utilization

### 2. **Processing Area (Procesamiento)**

The processing area receives raw pineapples and converts them into market-ready products:

- **Receiving & Washing**: Incoming pineapples from specific sections
- **Quality Classification**:
  - First quality (Primera calidad)
  - Second quality (Segunda calidad)
- **Quality Testing** (for first quality only):
  - Water content tests
  - Sugar level tests
  - Texture tests
  - Other quality parameters
- **Batch Management**:
  - Batches labeled with characteristics and origin (farm + section)
- **Packaging & Storage**:
  - Packing into boxes with defined pineapples per box capacity
  - Label application (stickers) when required
  - Palletizing: stacking boxes onto pallets
  - Refrigerated storage in cold warehouses
- **Warehouse Organization**:
  - Warehouses divided into areas
  - Track collection date age
  - Record origin farm and section for each pallet
  - Monitor temperature and storage conditions

### 3. **Sales Area (Ventas)**

The sales area manages customer orders and coordinates logistics:

- **Customer Orders (Pedidos)**:
  - Customer requests with required delivery date
  - Quality specifications (first or second quality, or combination)
  - Quantity requirements
  - Labeling requirements (sticker specifications if needed)
- **Order Fulfillment**:
  - Coordinate with planting and processing to verify capacity
  - Determine available inventory from cold storage
  - Select appropriate pineapples based on order requirements
- **Shipping Logistics**:
  - Assign to trucks (camiones) for transport
  - Assign to ships (barcos) for international transport
  - Specify shipping dates and delivery dates
  - Track shipment status and destination country

---

## Exercise Instructions

### **Phase 1: Team Design (20 minutes)**

**Step 1: Form Pairs and Assign Areas**
- The class will be divided into pairs
- Each pair is assigned ONE of the three areas (Planting, Processing, or Sales)
- All teams work on the same phase simultaneously

**Step 2: Create a UML Class Diagram**
- Design all object classes required for your assigned area
- Include only the ESSENTIAL attributes and methods (not exhaustively complete)
- For each class, identify:
  - Core responsibilities
  - Key attributes and their data types
  - Key methods and their purposes
  - Relationships with other classes (aggregation, composition, association)

**Step 3: Apply OOP Principles Clearly**
- **Inheritance**: Show generalization hierarchies (parent-child relationships)
  - Example: `Pineapple` could be parent to `FirstQualityPineapple` and `SecondQualityPineapple`
  - Show this clearly with inheritance arrows in your diagram
- **Interfaces**: Define contracts that multiple classes might implement
  - Example: `Transportable`, `Packagable`, `Storable`
  - Show implementation relationships clearly
- **Polymorphism**: Demonstrate method overriding and interface implementation
  - Show how different classes respond differently to the same method call
  - Example: Different `Box` types could have different `pack()` implementations

**Step 4: Document Your Design**
- Create a UML diagram (hand-drawn or digital)
- Label all classes, attributes, methods, and relationships
- Prepare brief notes explaining key design decisions

---

### **Phase 2: Integration and Cross-Area Communication (20 minutes)**

**Step 1: Form Integration Groups**
- Select one representative (spokesperson) from each area team
- These three representatives form an integration group
- If you have more pairs, form multiple groups of three (one from each area)

**Step 2: Exchange Ideas and Identify Integration Points**
- Each representative presents their area's design to the group
- Discuss and identify where areas interact:
  - **Planting → Processing**: How do harvested batches transfer?
  - **Processing → Sales**: How does inventory become available orders?
  - **Sales → Planting/Processing**: How do customer orders trigger production planning?

**Step 3: Design Integration Classes and Methods**
- Add classes that facilitate communication between areas:
  - Example: `HarvestBatch` (bridges Planting and Processing)
  - Example: `OrderFulfillment` or `InventoryManager` (bridges Processing and Sales)
  - Example: `ProductionScheduler` (bridges Sales back to Planting)
- Define methods that coordinate:
  - Transferring data from planting to processing
  - Checking inventory availability for orders
  - Triggering production based on customer demand
  - Tracking products through the entire supply chain

**Step 4: Update Your Diagrams**
- Extend all three area designs to include:
  - New integration classes
  - New attributes needed for tracking cross-area information
  - New methods for coordination and communication
- Show how inheritance, interfaces, and polymorphism support the integration

---

### **Phase 3: Selective Presentations and Review (Remaining Time)**

**Step 1: Prepare Your Presentation**
- Take photos/screenshots of your final UML diagram (hand-drawn or digital)
- Prepare specifications (specs) document explaining:
  - Key classes in your design
  - Major responsibilities of each class
  - Integration points and how they work
  - How inheritance, interfaces, and polymorphism are utilized

**Step 2: Present Your Design**
- Time limit: 3-5 minutes per group
- Include:
  - Overview of your area (or integrated system)
  - UML diagram walkthrough
  - Explanation of OOP principles used
  - Key integration decisions and how you solved coordination challenges

**Step 3: Peer Feedback and Discussion**
- Other teams ask questions
- Discuss alternative design approaches
- Identify strengths and potential improvements
