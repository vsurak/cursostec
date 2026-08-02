# 1. Introduction to Software Engineering

Software engineering is the discipline that applies engineering principles, methods, and tools to develop, maintain, and evolve software systems in a systematic, reliable, and economically viable way. Unlike isolated programming, software engineering spans the entire product lifecycle: from requirements gathering to post-delivery maintenance, passing through design, construction, testing, and deployment. Its central goal is to produce quality software — correct, maintainable, scalable, and secure — within real-world constraints of time, budget, and human resources. This unit introduces the foundational concepts that underpin the rest of the Object-Oriented Programming (OOP) course, since OOP is not just a coding technique but a conceptual tool grounded in engineering principles for organizing complex systems. Understanding who participates in a project, what principles guide good design decisions, what processes exist to organize the work, and how systems are modeled before being coded, allows a developer to write code that not only works, but is part of a professional and sustainable software product over time.

## Key points

- Software engineering emerged as a formal discipline in the late 1960s (NATO Conference, 1968) in response to the so-called "software crisis."
- It combines foundations from computer science, project management, and traditional engineering principles.
- Its scope covers the entire lifecycle: requirements, analysis, design, implementation, testing, deployment, and maintenance.
- It seeks to balance quality, cost, and time (the classic "constraint triangle").
- OOP is one of the most widely used methodological tools within modern software engineering for managing complexity.

---

## 1.1 What is Software Engineering?

Software Engineering is the systematic, disciplined, and quantifiable approach applied to the development, operation, and maintenance of software (classic IEEE definition). It differs from simply "programming" in that it incorporates repeatable processes, documentation, quality control, risk management, and large-scale teamwork. While writing a small script can be solved with programming knowledge alone, building a banking system, a health app, or an e-commerce platform requires coordinating dozens or hundreds of people, managing changing requirements, ensuring security and scalability, and making sure the system keeps working correctly for years. Software engineering provides the framework of principles (modularity, abstraction, separation of concerns), processes (development methodologies), and tools (version control, automated testing, continuous integration) needed to achieve that. It is a living discipline that constantly evolves: from the rigid waterfall processes of the 1970s-80s, it moved to agile methodologies in the 2000s, and today it incorporates DevOps, AI-assisted automation, and continuous delivery as industry standards.

### Key points

- IEEE definition: systematic, disciplined, and quantifiable approach to software development.
- It is not the same as "programming": it includes management, documentation, quality, and processes.
- It aims to solve the "software crisis": projects that run late, exceed budget, or fail in quality.
- It rests on three pillars: **processes**, **methods**, and **tools**.
- It evolves over time: waterfall → iterative → agile → DevOps → AI-assisted.

---

## 1.2 Stakeholders in Software Engineering (Roles)

### Description

A software project involves different profiles that collaborate at specific stages of the lifecycle. Traditionally these roles were very siloed, but with the adoption of agile methodologies and, more recently, with the rise of generative AI, many roles have become hybrid: a single person can now cover several functions supported by AI tools that automate repetitive tasks (generating boilerplate code, documentation, test cases, code review). Below are the main roles and how AI has changed the way they work.

### Roles and their function (updated with AI)

- **Requirements Analyst / Product Owner** — Translates business or client needs into clear requirements. *With AI*: uses tools to generate draft user stories and automatically detect ambiguities in requirements.
- **Software Architect** — Defines the overall technical structure (patterns, technologies, scalability). *With AI*: uses assistants to quickly evaluate trade-offs between architectures and generate diagrams from natural-language descriptions.
- **Developer / Programmer** — Implements features following the design. *With AI*: works in "pair programming" with code copilots (GitHub Copilot, Claude Code) that autocomplete, refactor, and explain code, speeding up writing but demanding stronger critical review skills.
- **QA / Tester** — Designs and executes tests to validate quality. *With AI*: automatically generates test cases from code or requirements, and uses AI to detect recurring bug patterns.
- **DevOps Engineer / SRE** — Manages infrastructure, deployment, and monitoring. *With AI*: uses models that detect anomalies in logs and predict failures before they happen (predictive observability).
- **Scrum Master / Project Manager** — Facilitates the agile process and manages timelines, risks, and blockers. *With AI*: relies on tools that summarize meetings, generate progress reports, and detect backlog delay risks.
- **UX/UI Designer** — Designs the user experience and interface. *With AI*: quickly generates prototypes and design variants from sketches or text descriptions.
- **Prompt Engineer / AI Engineer** *(emerging role)* — Designs and tunes the interaction with AI models embedded in the product or in the development workflow. This role barely existed before 2022-2023.
- **Client / End User** — Defines the original need and validates that the product solves it; still irreplaceable by AI, since it provides human value judgment.

### Key points

- Roles are no longer strict silos: today we talk about "full-stack" and "T-shaped" profiles (broad across several areas, deep in one).
- Generative AI acts as a "productivity multiplier," not a replacement for roles, but it does redefine which tasks each person performs.
- New roles have emerged (Prompt Engineer, AI Engineer) and others have transformed (QA shifts from "running manual tests" to "supervising AI-generated tests").
- Human judgment remains critical for business decisions, ethics, and final quality validation.

---

## 1.3 Software Engineering Principles

### Description

Software engineering principles are design guidelines aimed at producing maintainable, flexible code free of unnecessary duplication. Two of the most influential sets of principles in the context of Object-Oriented Programming are **DRY** (Don't Repeat Yourself) and **SOLID** (five object-oriented design principles proposed mainly by Robert C. Martin). Applying them correctly reduces technical debt, facilitates testing, and allows systems to evolve without breaking every time a new feature is added.

### DRY — Don't Repeat Yourself

Avoid duplicating logic: every piece of knowledge should have a single representation in the system.

```python
# ❌ Without DRY: the discount formula is repeated
def final_price_product_a(price):
    return price - (price * 0.10)

def final_price_product_b(price):
    return price - (price * 0.10)

# ✅ With DRY: one reusable function
def apply_discount(price, rate=0.10):
    return price - (price * rate)
```

### SOLID

**S — Single Responsibility Principle**
A class should have only one reason to change.

```python
# ❌ One class does too much
class Report:
    def generate_data(self): ...
    def save_as_pdf(self): ...  # different responsibility

# ✅ Split into two responsibilities
class Report:
    def generate_data(self): ...

class PDFExporter:
    def export(self, report): ...
```

**O — Open/Closed Principle**
Classes should be open for extension, but closed for modification.

```python
class Discount:
    def calculate(self, price):
        raise NotImplementedError

class ChristmasDiscount(Discount):
    def calculate(self, price):
        return price * 0.8

class BlackFridayDiscount(Discount):
    def calculate(self, price):
        return price * 0.5
# New discounts are added without touching existing code
```

**L — Liskov Substitution Principle**
A subclass should be able to replace its base class without breaking the program.

```python
class Bird:
    def fly(self):
        return "Flying"

class Penguin(Bird):
    def fly(self):
        raise Exception("Penguins can't fly")  # ❌ violates LSP

# Better: don't inherit behavior that doesn't apply to all cases
```

**I — Interface Segregation Principle**
Several specific interfaces are better than one general-purpose one.

```python
from abc import ABC, abstractmethod

class Printable(ABC):
    @abstractmethod
    def print_document(self): ...

class Scannable(ABC):
    @abstractmethod
    def scan(self): ...

# A simple printer isn't forced to implement scan()
class SimplePrinter(Printable):
    def print_document(self):
        print("Printing...")
```

**D — Dependency Inversion Principle**
Depend on abstractions, not on concrete implementations.

```python
class Database(ABC):
    @abstractmethod
    def save(self, data): ...

class MySQLDatabase(Database):
    def save(self, data):
        print(f"Saving {data} to MySQL")

class UserService:
    def __init__(self, db: Database):  # depends on the abstraction
        self.db = db

    def register(self, user):
        self.db.save(user)
```

---

## 1.4 Software Processes and Projects

### Description

A software process is the ordered set of activities, roles, and artifacts that guide the construction of a software product from conception through delivery and maintenance. Different process models exist — each with different assumptions about how predictable requirements are and how much can be planned in advance. Choosing the right process depends on the type of project, team size, tolerance for change, and level of uncertainty in the product. Object-Oriented Programming carries different weight depending on the process: in processes with extensive upfront design (like Waterfall), class modeling is done in advance; in iterative and agile processes, object-oriented design evolves alongside the product (emergent design).

### Comparative matrix of software engineering processes

| Criterion | **Waterfall** | **Scrum (Agile)** | **DevOps** |
|---|---|---|---|
| **Approach** | Sequential, phase by phase | Iterative and incremental (sprints) | Continuous integration and delivery |
| **Flexibility to change** | Low — changes are costly once a phase has started | High — adjusted every sprint | High — small, frequent changes |
| **Documentation** | Extensive and formal from the start | Lightweight, "just enough" | Automated (pipelines, infrastructure as code) |
| **Delivery to client** | At the end of the project | At the end of each sprint (2-4 weeks) | Continuous (several times a day/week) |
| **Key roles** | Analyst, architect, developer, QA (sequential) | Product Owner, Scrum Master, development team | Developers + Ops merged (SRE) |
| **Project risk** | High if requirements change | Medium, mitigated by iteration | Low, due to constant feedback |
| **Where OOP matters** | 🟢 **High** — class and architecture design is defined exhaustively before coding (detailed UML diagrams during the design phase) | 🟡 **Medium-High** — object-oriented design is constantly refactored; principles like SOLID are key so code tolerates sprint-to-sprint changes | 🟡 **Medium** — OOP supports modularity for independent deployments (microservices, containers), but the focus is more on automation than class design |

### Key points

- There is no universally "best" process: it depends on the project's context.
- Waterfall works well for projects with very stable requirements (e.g., regulatory systems).
- Scrum and agile methodologies dominate digital products with changing requirements.
- DevOps doesn't replace Scrum: they complement each other (Scrum organizes the "what" and "when"; DevOps automates the "how it's delivered").
- OOP becomes more critical the more the problem domain's complexity needs to be anticipated and structured.

---

## 1.5 Modeling in Software Development

### Description

Modeling is the abstract, simplified representation of a system, allowing decisions to be analyzed, communicated, and validated before (or during) actual software construction. A model omits details irrelevant to its purpose in order to focus on what matters for a given analysis: it can focus on data, on processes, on behavior, or on objects and their relationships. Object-oriented modeling, in particular, represents the system as a set of interacting objects, each with attributes (state) and methods (behavior), and it is the conceptual foundation on which the rest of the Object-Oriented Programming studied throughout the course is built.

### Types of modeling (examples)

- **Data modeling (Entity-Relationship)** — Represents the domain's entities and their relationships, typically used to design databases. Example: an ER diagram with the entities `Customer`, `Order`, and `Product` and their relationships (one-to-many, many-to-many).
- **Process modeling (Flowcharts / BPMN)** — Represents the sequence of activities in a business process. Example: the flow from when a customer places an order to when it's delivered, including decisions (is there stock? yes/no).
- **Functional modeling (Data Flow Diagrams, DFD)** — Shows how data is transformed as it flows through the system's processes. Example: a DFD of a billing system showing inputs, calculation processes, and outputs.
- **Behavioral modeling (State machines)** — Represents the possible states of an entity and the transitions between them. Example: the states of an `Order` (Created → Paid → Shipped → Delivered → Cancelled).
- **Object-oriented modeling (UML)** — Represents the system as objects with attributes, methods, and relationships (inheritance, association, composition). Example: a UML class diagram with `Vehicle` as a base class and `Car`, `Motorcycle` as subclasses, plus use-case and sequence diagrams showing how objects interact with each other during a system flow.
