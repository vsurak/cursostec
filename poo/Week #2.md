# Object Orientation
## Introduction to Object Orientation

**Object** — A specific instance that represents a real-world entity or concept in a program. It bundles together data (attributes) and behavior (methods). For example, a single car parked in a lot, or one specific bird tracked during migration, is an object.

**Class** — A blueprint or template that defines what attributes and methods the objects created from it will have. The class itself is not a thing in the world; it's the description used to create (instantiate) objects. For example, `Car` is a class; a particular red car with a specific plate number is an object of that class.

**Attribute** — A piece of data that describes the state of an object (its characteristics or properties). For example, `color`, `speed`, or `fuelLevel` could be attributes of a `Car` object.

**Method** — A behavior or action that an object can perform, usually operating on its own attributes. For example, `accelerate()`, `refuel()`, or `stop()` could be methods of a `Car` object.

We are going to write object specifications to model real-world things. These specifications will help us create class designs and later generate the code for the programs we want to build.

For example, we could specify a simple hierarchy of objects to place geometric shapes on a plane.

*Spec Definition
---------------------------- 

Use the following class definition to create the PlantUML code for the diagram. 

Point
- X number
- Y number

Triangulo
- Tipo text
- lados array of number
- angulos array of float
- positions array of Point

Circulo
- radio float
- circunferencia float
- diametro float
- position Point

Cuadrado
- lado number
- position Point

Window
- alto number
- ancho number
- circulos LIST of Circulo
- cuadrados LIST of Cuadrado
- triangulos LIST of Triangulo


@startuml

class Point {
  - X : number
  - Y : number
}

class Triangulo {
  - Tipo : text
  - lados : number[]
  - angulos : float[]
  - positions : Point[]
}

class Circulo {
  - radio : float
  - circunferencia : float
  - diametro : float
  - position : Point
}

class Cuadrado {
  - lado : number
  - position : Point
}

class Window {
  - alto : number
  - ancho : number
  - circulos : List<Circulo>
  - cuadrados : List<Cuadrado>
  - triangulos : List<Triangulo>
}

' Relationships
Triangulo "many" --> Point
Circulo --> Point
Cuadrado --> Point
Window --> Circulo
Window --> Cuadrado
Window --> Triangulo

@enduml

---

## Exercises

For each domain below, identify the classes needed to model the described scenario. For every class, specify its **attributes** and its **methods**. 

### 1. Fuel Station

Model a fuel station that serves vehicles. The station has multiple fuel pumps, each dispensing one or more fuel types (e.g., regular, premium, diesel) at a given priceper unit. Vehicles arrive, select a pump, and get refueled; the amount dispensed and its cost must be tracked. The station also keeps a record of the transactions performed during the day.

### 2. Birds in Migration

Model a system that tracks birds during their migration. Each bird belongs to a species and carries a tracking device that records its position (coordinates) at different points in time. Birds travel as part of a flock, moving together along a migration route made up of several waypoints. The system must be able to represent the bird's traveled path over time.

