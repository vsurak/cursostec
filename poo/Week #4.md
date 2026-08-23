# Object-Oriented Programming in Java

---

## Access Modifiers: `public` and `private`

Access modifiers control **who can see and use** a class member (field or method). In Java, the two most important modifiers for encapsulation are:

- **`public`** — The member is visible from **any** class, including classes in other packages. Use it for the parts of your API that callers are meant to use directly (constructors, intentional public methods).
- **`private`** — The member is visible **only inside the same class**. Other classes — even subclasses — cannot access it directly. Use it for internal state and helper logic you want to hide.

The goal is not to hide everything, but to expose a **controlled interface** while keeping implementation details safe from accidental misuse.

```java
// File: bank/Account.java
package bank;

public class Account {
    // PRIVATE — internal state; callers must not change balance directly
    private double balance;
    private String owner;

    // PUBLIC constructor — part of the intended public API
    public Account(String owner, double initialBalance) {
        this.owner = owner;
        // Validation belongs inside the class, not in calling code
        this.balance = initialBalance >= 0 ? initialBalance : 0;
    }

    // PUBLIC — safe, controlled way to read state
    public double getBalance() {
        return balance;
    }

    // PUBLIC — business rule enforced here
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
    }

    // PRIVATE — helper used only inside this class
    private String formatReceipt(String action, double amount) {
        return owner + ": " + action + " $" + amount + " | balance=$" + balance;
    }

    public void printDepositReceipt(double amount) {
        deposit(amount);
        System.out.println(formatReceipt("deposit", amount));
    }
}

// File: bank/Main.java
package bank;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("Alice", 100.0);
        acc.deposit(50.0);
        System.out.println(acc.getBalance()); // OK — public method

        // acc.balance = 1_000_000;  // COMPILE ERROR — balance is private
        // acc.formatReceipt("hack", 0); // COMPILE ERROR — method is private
    }
}
```

**Common mistakes**

```java
public class BrokenAccount {
    public double balance; // Mistake: exposing mutable state as public

    public void transfer(BrokenAccount other, double amount) {
        balance -= amount;
        other.balance += amount; // Any external code can also do this — no rules enforced
    }
}

// Another mistake: making everything private, including the constructor
public class LockedOut {
    private LockedOut() { } // No public way to create instances from outside
}
// LockedOut obj = new LockedOut(); // COMPILE ERROR in another class
```

---

## Packages

A **package** is a namespace that groups related classes and helps organize large projects. It also affects **visibility**: a class or member with no modifier (package-private / default) is visible only within the same package.

Package names follow a reversed-domain convention, e.g. `com.mycompany.app.model`. The first line of a `.java` file (when used) declares membership:

```java
// File: geometry/shapes/Circle.java
package geometry.shapes;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

// File: geometry/app/Main.java
package geometry.app;

// IMPORT — use a short name instead of the fully qualified name
import geometry.shapes.Circle;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5.0);
        System.out.println(c.area());

        // Fully qualified name works without import:
        geometry.shapes.Circle c2 = new geometry.shapes.Circle(3.0);
    }
}
```

Directory structure must match the package name:

```
src/
  geometry/
    shapes/
      Circle.java    →  package geometry.shapes;
    app/
      Main.java      →  package geometry.app;
```

**Common mistakes**

```java
// Mistake 1: package declaration does not match folder path
// File is in folder "shapes/" but declares:
package geometry.app; // WRONG — compiler error or confusing layout

// Mistake 2: class name ≠ file name
public class Triangle { } // File must be Triangle.java, not triangle.java

// Mistake 3: forgetting import (or wrong import)
// Main.java without import:
Circle c = new Circle(2); // COMPILE ERROR — cannot find symbol Circle

// Mistake 4: assuming public classes in another package are fully open
// Only public members are accessible; private fields still hidden
```

---

## Encapsulation

**Encapsulation** means bundling data and the methods that operate on that data inside a class, and **hiding internal details** behind a well-defined interface. Callers interact through public methods (getters, setters, business operations) instead of touching raw fields.

Benefits:
- **Validation** — reject invalid state before it is stored.
- **Flexibility** — change internal representation without breaking callers.
- **Maintainability** — rules live in one place.

```java
public class Temperature {
    // Internal representation: always stored in Celsius
    private double celsius;

    public Temperature(double celsius) {
        setCelsius(celsius); // reuse validation logic
    }

    // Controlled write access with validation
    public void setCelsius(double value) {
        if (value < -273.15) {
            throw new IllegalArgumentException("Below absolute zero.");
        }
        this.celsius = value;
    }

    public double getCelsius() {
        return celsius;
    }

    // Convenience API — callers need not know we store Celsius internally
    public void setFahrenheit(double f) {
        setCelsius((f - 32) * 5.0 / 9.0);
    }

    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }
}

public class Demo {
    public static void main(String[] args) {
        Temperature t = new Temperature(25.0);
        System.out.println(t.getFahrenheit()); // 77.0
        t.setFahrenheit(32.0);
        System.out.println(t.getCelsius());    // 0.0
    }
}
```

**Common mistakes**

```java
public class LeakyEncapsulation {
    private int[] scores;

    public int[] getScores() {
        return scores; // Mistake: returns reference to internal array
    }
}

// Caller can mutate internal state without permission:
LeakyEncapsulation exam = new LeakyEncapsulation();
exam.getScores()[0] = 100; // bypasses any validation

// Better: return a copy or an unmodifiable view
public int[] getScoresCopy() {
    return scores.clone();
}
```

---

## Destructor (and How Java Handles Cleanup)

Languages like C++ have **destructors** — special methods invoked automatically when an object is destroyed. **Java has no destructor keyword.** Instead, cleanup happens through:

1. **Garbage collection** — reclaims memory when objects are no longer reachable (see the Garbage Collector section).
2. **`try-with-resources`** — automatically closes resources (`AutoCloseable`) when a block ends.
3. **`finalize()`** — deprecated since Java 9; unreliable and not recommended.

Think of Java cleanup as **non-deterministic for memory** (GC decides when) but **deterministic for resources** when you use `try-with-resources`.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Resource class — defines what "cleanup" means
class LogReader implements AutoCloseable {
    private BufferedReader reader;

    public LogReader(Path path) throws IOException {
        reader = Files.newBufferedReader(path);
        System.out.println("Opened: " + path);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    // Called automatically at end of try-with-resources block
    @Override
    public void close() throws IOException {
        reader.close();
        System.out.println("Closed reader.");
    }
}

public class CleanupDemo {
    public static void main(String[] args) {
        // When the block exits (normally or with exception), close() runs
        try (LogReader lr = new LogReader(Path.of("app.log"))) {
            System.out.println(lr.readLine());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // lr is out of scope; memory reclaimed later by GC
    }
}
```

**Common mistakes**

```java
// Mistake 1: expecting immediate destruction like in C++
public class Box {
    public Box() { System.out.println("Created"); }
    // No reliable "destroyed" message — GC timing is unpredictable
}

// Mistake 2: relying on finalize() for critical cleanup (deprecated)
@Override
protected void finalize() throws Throwable {
    closeConnection(); // Unreliable — may never run, or run very late
}

// Mistake 3: forgetting to close resources
BufferedReader r = Files.newBufferedReader(path);
// ... use r ...
// r.close(); // If skipped and not in try-with-resources → file handle leak
```

---

## Instance Variables

**Instance variables** (also called **fields** or **attributes**) belong to each **object**. Every instance gets its **own copy** (for non-static fields). They define the object's **state** and typically live for the object's lifetime.

They are declared inside the class body, outside any method. Unless marked `static`, they are tied to instances, not to the class itself.

```java
public class Student {
    // INSTANCE VARIABLES — each Student object has its own values
    private String name;
    private int id;
    private double gpa;

    // Constructor initializes instance variables for THIS object
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public void updateGpa(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            this.gpa = newGpa; // modifies THIS object's state
        }
    }

    public void printProfile() {
        // Instance method reads THIS object's instance variables
        System.out.println(id + " | " + name + " | GPA=" + gpa);
    }
}

public class InstanceDemo {
    public static void main(String[] args) {
        Student a = new Student("Ana", 101, 3.5);
        Student b = new Student("Ben", 102, 3.8);

        a.updateGpa(3.9);
        a.printProfile(); // Ana's GPA changed
        b.printProfile(); // Ben's GPA unchanged — separate instance variables
    }
}
```

**Common mistakes**

```java
public class ConfusedFields {
    int count; // instance variable — default 0 per object

    public void increment() {
        int count = count + 1; // Mistake: local variable shadows instance variable
        // The instance field is never updated!
    }

    public static void show() {
        // System.out.println(name); // COMPILE ERROR — no instance, no instance vars
    }
}

// Mistake: confusing instance variable with method parameter/local
public void setName(String name) {
    name = name; // assigns parameter to itself — field not updated
    // Correct: this.name = name;
}
```

---

## Method Overloading

**Method overloading** means defining **multiple methods with the same name** in the same class, as long as their **parameter lists differ** (number, type, or order of parameters). The return type alone is **not** enough to overload.

The compiler picks the best match at compile time (**static binding**). Overloading improves readability: one intuitive name (`print`, `add`, `open`) for related operations.

```java
public class Printer {

    // Overload 1 — one String
    public void print(String message) {
        System.out.println("[TEXT] " + message);
    }

    // Overload 2 — two Strings (different parameter count)
    public void print(String label, String message) {
        System.out.println("[" + label + "] " + message);
    }

    // Overload 3 — int instead of String (different parameter type)
    public void print(int code) {
        System.out.println("[CODE] " + code);
    }

    // Overload 4 — array of Strings (different type)
    public void print(String[] lines) {
        for (String line : lines) {
            System.out.println("[LINE] " + line);
        }
    }
}

public class OverloadDemo {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Hello");                  // calls print(String)
        p.print("ERR", "Disk full");       // calls print(String, String)
        p.print(404);                      // calls print(int)
        p.print(new String[]{"a", "b"});   // calls print(String[])
    }
}
```

**Common mistakes**

```java
public class BadOverload {
    public int compute(int x) { return x * 2; }
    // public double compute(int x) { return x * 2.0; }
    // COMPILE ERROR — same parameter list, only return type differs

    public void show(int x) { }
    public void show(Integer x) { }
    // Legal overloads, but ambiguous calls confuse beginners:
    // show(5); // exact match: show(int)
}

// Mistake: expecting overloading to work across subclasses only by signature
class Parent { void draw() { } }
class Child extends Parent {
    void draw(int scale) { } // This is overload only if both visible on same type
}
```

---

## The `static` Keyword (Attributes and Methods)

`static` members belong to the **class**, not to any single object. There is **one shared copy** of a static field for the entire class, and static methods can run **without creating an instance**.

Use `static` for:
- **Constants** shared by all instances (`public static final`).
- **Utility methods** that do not need object state (`Math.max`, factory helpers).
- **Counters or shared configuration** common to all objects.

Static methods can access static fields directly, but **cannot** use `this` or access instance fields/methods unless they receive an object reference as a parameter.

```java
public class User {
    // STATIC FIELD — shared across all User objects
    private static int userCount = 0;

    // STATIC CONSTANT — typical use of static + final
    public static final String DEFAULT_ROLE = "guest";

    // INSTANCE FIELDS — each user has its own
    private final int id;
    private String username;

    public User(String username) {
        userCount++;           // every new user bumps the shared counter
        this.id = userCount;
        this.username = username;
    }

    // INSTANCE METHOD — works with a specific user's data
    public void rename(String newName) {
        this.username = newName;
    }

    // STATIC METHOD — no particular user needed
    public static int getUserCount() {
        return userCount;
    }

    public static User createGuest() {
        return new User("guest-" + (userCount + 1));
    }

    public void describe() {
        System.out.println("User#" + id + " " + username + " role=" + DEFAULT_ROLE);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println(User.DEFAULT_ROLE); // access via class name
        User a = new User("alice");
        User b = new User("bob");
        System.out.println(User.getUserCount()); // 2 — shared static field
        User guest = User.createGuest();         // static factory method
        guest.describe();
    }
}
```

**Common mistakes**

```java
public class StaticErrors {
    private int instanceValue;

    public static void broken() {
        // System.out.println(instanceValue); // COMPILE ERROR — no instance context
        // rename("x");                       // COMPILE ERROR — instance method
    }

    public void oops() {
        // Calling static method via instance works but misleads readers:
        User.getUserCount(); // OK
        // new User().getUserCount(); // Works but poor style — hides that method is static
    }
}

// Mistake: static mutable shared state without care → bugs in concurrent code
public class VisitCounter {
    private static int visits = 0; // shared — all callers affect the same variable
    public static void hit() { visits++; }
}
```

---

## Garbage Collector — How It Works

The **Garbage Collector (GC)** is Java's automatic memory manager. When objects are no longer **reachable** from any **GC root** (active threads, static fields, local variables on the stack, etc.), the GC may reclaim their memory. You do **not** call `free` or `delete`.

Typical lifecycle:
1. You create objects with `new`.
2. References (variables) point to them.
3. When no chain of references connects an object to a root, it becomes **eligible for collection**.
4. The GC runs (when the JVM decides), marks unreachable objects, and reclaims space.

You cannot predict **when** collection happens; only that unreachable objects **may** be collected.

```java
public class Node {
    String label;
    Node next;

    public Node(String label) {
        this.label = label;
        System.out.println("Node created: " + label);
    }

    // Called by GC before memory is reclaimed (usually for debugging/demo only)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC finalized: " + label);
        super.finalize();
    }
}

public class GcDemo {
    public static void main(String[] args) {
        Node a = new Node("A"); // a → A
        Node b = new Node("B"); // b → B, A.next → B

        a.next = b;
        b = null;     // still reachable: a → A → B
        a = null;     // A and B now unreachable (assuming no other references)

        // Suggest GC — NOT guaranteed; JVM may ignore
        System.gc();

        // Creating many short-lived objects triggers GC under memory pressure
        for (int i = 0; i < 100_000; i++) {
            new Node("temp-" + i);
        }
    }
}
```

**Reachability sketch**

```
Roots (stack locals, static fields, ...)
   │
   ├─ reference chain exists ──► object KEPT
   │
   └─ no chain ──► object ELIGIBLE for GC
```

**Common mistakes**

```java
// Mistake 1: thinking setting a reference to null instantly frees memory
Object big = new byte[1_000_000];
big = null; // only removes YOUR reference; GC decides timing

// Mistake 2: accidental reachability — memory leak
public class Cache {
    private static java.util.List<Object> items = new java.util.ArrayList<>();
    public static void add(Object o) { items.add(o); } // never removed → never collected
}

// Mistake 3: relying on finalize() for cleanup (deprecated, nondeterministic)
// Use try-with-resources for files, sockets, DB connections.

// Mistake 4: calling System.gc() expecting immediate behavior in production code
System.gc(); // hint only — do not design logic around it
```
