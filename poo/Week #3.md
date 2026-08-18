# Java content

Primitives 

// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

Arrays 

https://www.w3schools.com/java/java_arrays.asp

Control structures 

https://w3schoolofcoding.com/control-structures-in-java/


Stream instructions

https://docs.oracle.com/en/java/javase/21/docs/api//java.base/java/util/stream/Stream.html

Java Packages 

https://www.w3schools.com/java/java_packages.asp


# Object Orientation — Concepts in Java

This section elaborates the four foundational OOP terms introduced in [Week #2](Week%20%232.md) and maps each one to concrete Java syntax. Two independent domains illustrate the same ideas from different angles: **Animals** (living entities with behavior) and **Geometry** (mathematical figures with measurable properties).

| Concept    | Plain meaning                                      | Java keyword / syntax              |
|------------|----------------------------------------------------|------------------------------------|
| **Class**  | Blueprint that defines structure and behavior      | `class Animal { ... }`             |
| **Object** | One concrete instance created from a class         | `Animal parrot = new Animal(...);` |
| **Attribute** | Data that describes the object's current state  | `private String species;`          |
| **Method** | Behavior the object can perform on its own data    | `public void eat() { ... }`        |

---

## Example 1 — Animals

In this domain, `Animal` is the **class** (the general idea of an animal). Each individual animal you create in memory — a parrot named Kiwi, a wolf named Luna — is an **object**. The **attributes** hold facts about that particular animal (`name`, `species`, `weightKg`). The **methods** express what the animal can *do* (`eat`, `makeSound`), usually reading or changing those attributes.

```java
// ============================================================
// CLASS — A blueprint (template) for objects of type Animal.
// It declares which attributes exist and which methods objects
// of this type will have. The class itself is NOT a real animal;
// it is the specification used to build them.
// ============================================================
public class Animal {

    // ========================================================
    // ATTRIBUTES — Pieces of data that describe the STATE of
    // each object. Every Animal object gets its own copy of
    // these variables with its own values.
    // ========================================================
    private String name;       // e.g. "Kiwi"
    private String species;    // e.g. "Parrot"
    private double weightKg;   // e.g. 0.4

    // Constructor — special method invoked with `new` to create
    // an OBJECT and give its attributes initial values.
    public Animal(String name, String species, double weightKg) {
        this.name = name;
        this.species = species;
        this.weightKg = weightKg;
    }

    // ========================================================
    // METHODS — Behaviors (actions) the object can perform.
    // They usually read or modify the object's own attributes.
    // ========================================================
    public void eat(double foodGrams) {
        // Behavior: eating increases the animal's weight.
        this.weightKg += foodGrams / 1000.0;
        System.out.println(name + " ate " + foodGrams + " g.");
    }

    public void makeSound() {
        // Behavior: produce a species-specific sound.
        System.out.println(name + " the " + species + " makes a sound!");
    }

    public double getWeightKg() {
        // Accessor method — returns attribute data to callers.
        return weightKg;
    }
}

// ============================================================
// Using the class — creating OBJECTS (instances)
// ============================================================
public class AnimalDemo {
    public static void main(String[] args) {

        // OBJECT — A specific instance built from the Animal class.
        // `parrot` is a variable that REFERENCES one object in memory.
        // `new Animal(...)` allocates that object and runs the constructor.
        Animal parrot = new Animal("Kiwi", "Parrot", 0.4);

        // Another OBJECT — same class, different attribute values.
        Animal wolf = new Animal("Luna", "Wolf", 38.0);

        // Calling METHODS on each object. The same method name runs,
        // but each object uses its own attribute values.
        parrot.makeSound();   // "Kiwi the Parrot makes a sound!"
        wolf.makeSound();     // "Luna the Wolf makes a sound!"

        parrot.eat(25);       // Changes parrot's weightKg only
        wolf.eat(500);        // Changes wolf's weightKg only

        System.out.println("Kiwi weighs " + parrot.getWeightKg() + " kg");
        System.out.println("Luna weighs " + wolf.getWeightKg() + " kg");
    }
}
```

**Takeaway:** `Animal` is one class; `parrot` and `wolf` are two distinct objects. They share the same methods (`eat`, `makeSound`) but each keeps its own attribute values.

---

## Example 2 — Geometry figures

Geometry fits naturally with the shape hierarchy already sketched in Week #2. Here `Circle` is the **class**, each drawn circle on a canvas is an **object**, **attributes** store measurements and position (`radius`, `centerX`, `centerY`), and **methods** compute derived values or move the figure (`getArea`, `translate`).

```java
// ============================================================
// CLASS — Blueprint for circular shapes on a plane.
// Defines the data every circle object must hold and the
// operations every circle object can perform.
// ============================================================
public class Circle {

    // ========================================================
    // ATTRIBUTES — Numeric state describing this circle.
    // ========================================================
    private double radius;   // length of the radius
    private double centerX;  // x-coordinate of the center
    private double centerY;  // y-coordinate of the center

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    // ========================================================
    // METHODS — Computations and actions based on attributes.
    // ========================================================
    public double getArea() {
        // Behavior: derive area from the radius attribute.
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        // Behavior: derive perimeter from the radius attribute.
        return 2 * Math.PI * radius;
    }

    public void translate(double deltaX, double deltaY) {
        // Behavior: change position by updating attributes.
        this.centerX += deltaX;
        this.centerY += deltaY;
    }

    public void printInfo() {
        System.out.printf(
            "Circle at (%.1f, %.1f) r=%.1f area=%.2f%n",
            centerX, centerY, radius, getArea()
        );
    }
}

// A second CLASS in the same domain — squares are a different blueprint.
public class Square {

    // ATTRIBUTES — side length and top-left corner position.
    private double side;
    private double topLeftX;
    private double topLeftY;

    public Square(double side, double topLeftX, double topLeftY) {
        this.side = side;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    // METHOD — area computed from the side attribute.
    public double getArea() {
        return side * side;
    }

    public void printInfo() {
        System.out.printf(
            "Square at (%.1f, %.1f) side=%.1f area=%.2f%n",
            topLeftX, topLeftY, side, getArea()
        );
    }
}

// ============================================================
// Using the classes — creating OBJECTS
// ============================================================
public class GeometryDemo {
    public static void main(String[] args) {

        // OBJECT — one specific circle (radius 5, centered at origin).
        Circle unitDisk = new Circle(5.0, 0.0, 0.0);

        // OBJECT — another circle with different attribute values.
        Circle smallCircle = new Circle(2.5, 10.0, 3.0);

        // OBJECT — a square, built from a different CLASS.
        Square tile = new Square(4.0, 1.0, 1.0);

        unitDisk.printInfo();
        smallCircle.printInfo();
        tile.printInfo();

        // METHOD call that mutates an object's attributes (state change).
        unitDisk.translate(3.0, -1.0);
        System.out.println("After moving the disk:");
        unitDisk.printInfo();

        // Same method name (`getArea`) on different CLASSES returns
        // different results because each class defines its own formula
        // using its own ATTRIBUTES.
        System.out.println("Disk area:   " + unitDisk.getArea());
        System.out.println("Tile area:   " + tile.getArea());
    }
}
```

**Takeaway:** `Circle` and `Square` are two classes in the geometry domain. `unitDisk`, `smallCircle`, and `tile` are three separate objects. Even when two classes expose a method with the same name (`getArea`), each class implements it using its own attributes.

---

## Side-by-side comparison

| Term        | Animals domain                         | Geometry domain                          |
|-------------|----------------------------------------|------------------------------------------|
| **Class**   | `Animal`                               | `Circle`, `Square`                       |
| **Object**  | `parrot`, `wolf`                       | `unitDisk`, `smallCircle`, `tile`        |
| **Attribute** | `name`, `species`, `weightKg`      | `radius`, `centerX`, `side`, …           |
| **Method**  | `eat()`, `makeSound()`                 | `getArea()`, `translate()`, `printInfo()` |

---

## From concept to code — quick reference

```java
// CLASS declaration
public class ClassName {

    // ATTRIBUTE (field) — object state
    private Type attributeName;

    // METHOD — object behavior
    public ReturnType methodName(/* parameters */) {
        // uses this.attributeName
    }
}

// OBJECT creation (instantiation)
ClassName objectName = new ClassName(/* constructor arguments */);

// METHOD invocation on a specific object
objectName.methodName(/* arguments */);
```

When you read or write Java OOP code, ask four questions:

1. **Which class** (blueprint) am I defining or using?
2. **Which object** (instance) am I operating on right now?
3. **Which attributes** hold the data that matters for this operation?
4. **Which method** should run to express the behavior I need?
