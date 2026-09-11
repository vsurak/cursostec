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


## Exceptions in java

### What is an exception?

An **exception** is an object that represents an abnormal event that disrupts the normal flow of a program (a missing file, invalid input, division by zero, a network call that fails, etc.). Instead of letting the program crash or returning error codes that are easy to ignore, Java lets you **throw** an exception object and **catch** it somewhere else in the call stack, keeping error-handling code separate from normal business logic.

Java exceptions form a hierarchy rooted at `Throwable`:

- `Error` — serious problems the application shouldn't try to handle (e.g. `OutOfMemoryError`).
- `Exception`
  - **Checked exceptions**: must be declared (`throws`) or caught at compile time (e.g. `IOException`). Used for recoverable conditions the caller is expected to plan for.
  - **Unchecked exceptions** (`RuntimeException` and subclasses): not enforced by the compiler (e.g. `NullPointerException`, `IllegalArgumentException`). Used for programming errors.

### When is it recommendable to scope code in exceptions?

- Wrap code that can fail for reasons **outside your control**: I/O, parsing, network calls, database access.
- Keep the `try` block as **small as possible** — only the statements that can actually throw. Don't wrap entire methods "just in case".
- Use exceptions for **exceptional situations**, not for normal control flow (don't use exceptions to replace an `if` check that could easily prevent the error).
- Throw your **own exceptions on purpose** when a method receives invalid arguments or reaches a state it cannot continue from — this documents a contract and forces callers to deal with it.

### How exceptions work in nested scopes

When an exception is thrown, Java stops normal execution and starts **unwinding the call stack**: it looks for a matching `catch` in the current method; if none exists, it exits that method (running any `finally` blocks along the way) and looks in the caller, and so on, until a handler is found or the program terminates.

```java
public class NestedExample {

    public static void main(String[] args) {
        try {
            outer(); // outer() calls inner(), inner() throws
        } catch (RuntimeException e) {
            // caught here, even though the throw happened two levels down
            System.out.println("Caught in main: " + e.getMessage());
        }
    }

    static void outer() {
        inner(); // no try here, so it just propagates upward
    }

    static void inner() {
        throw new RuntimeException("failure in inner()");
        // stack unwinds: inner -> outer -> main, until a catch matches
    }
}
```

### Example: normal use for unexpected errors

```java
public class DivisionExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 0};

        for (int divisor : numbers) {
            try {
                int result = 100 / divisor; // may throw ArithmeticException when divisor == 0
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // handle only the unexpected error, loop keeps going
                System.out.println("Cannot divide by zero, skipping.");
            }
        }
    }
}
```

### Example: raising an exception on purpose

```java
public class Section {
    private int fertilizerAmount;

    public void applyFertilizer(int amount) {
        if (amount < 0) {
            // invalid input: throw instead of silently accepting bad data
            throw new IllegalArgumentException("Fertilizer amount cannot be negative");
        }
        this.fertilizerAmount = amount;
    }
}
```

### Catching one or multiple exceptions at a time

```java
public class MultiCatchExample {
    public static void main(String[] args) {
        String[] values = {"10", "abc", null};

        for (String value : values) {
            try {
                int n = Integer.parseInt(value); // may throw NumberFormatException
                System.out.println(100 / n);      // may throw ArithmeticException
            } catch (NumberFormatException | ArithmeticException e) {
                // one catch block handles either exception type (multi-catch)
                System.out.println("Invalid value, error: " + e.getMessage());
            } catch (NullPointerException e) {
                // a separate catch for a different exception type
                System.out.println("Value was null.");
            }
        }
    }
}
```

Rules of thumb for multiple `catch` blocks:

- Order matters: put **more specific** exception types before more general ones (a general one like `Exception` placed first would swallow everything below it, and the code won't even compile).
- Use `|` (multi-catch) when several exception types get the exact same handling, to avoid duplicated code.

### What to do when exceptions occur — advice

- **Don't swallow exceptions silently** (empty `catch` blocks hide bugs).
- **Log or report** enough information to diagnose the problem (message, and when useful, the stack trace).
- **Only catch what you can actually handle.** If a method can't meaningfully recover, let the exception propagate (or declare `throws`) rather than catching just to print something.
- **Fail fast** for programming errors (invalid arguments, broken invariants) — throwing early is better than continuing with corrupt state.
- **Clean up resources** (files, connections) regardless of success or failure — use `finally` or try-with-resources.

### How `finally` works

The `finally` block **always runs**, whether the `try` succeeded, an exception was thrown and caught, or even if it wasn't caught at all — it's the right place for cleanup code (closing files, releasing locks, etc.).

```java
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("data.txt"); // may throw IOException
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            System.out.println("Could not open file: " + e.getMessage());
        } finally {
            // runs no matter what happened above: success, catch, or uncaught error
            System.out.println("Cleaning up...");
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                // closing can also fail, handle it too
            }
        }
    }
}
```

Modern Java prefers **try-with-resources** for anything that implements `AutoCloseable`, since it closes the resource automatically without needing a manual `finally`:

```java
try (FileReader reader = new FileReader("data.txt")) {
    // use reader
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// reader.close() is called automatically here, even if an exception occurred
```

## Exercise to be done in class on paper

Select, from the discord text channel, one of the designs made by a group you did NOT work with, and following that design proceed to answer the following questions:

Given an inheritance relationship you have identified in the design, give your assessment:

- justify whether you consider the inheritance to be well used
- what polymorphism advantages can be obtained for that design
- what code will be reused through that inheritance
- what should be public, private, and protected
- how method code can be advantageous where it is necessary to use the parent's code, the child's code, or a mix of both
- be clear in the use of this and super in your explanations




