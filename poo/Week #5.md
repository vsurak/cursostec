# Object Relationships

Continue the design and programming of our small Person program. We are going to carry out the following activities.

1. **Inheritance.** Inheritance lets a class share and specialize the structure and behavior of a more general class: a subclass inherits the attributes and methods of its parent and can override or extend them to behave differently. Use inheritance to model different types of Person professions, so that each profession can perform different actions depending on what it is. Create 3 different professions. Each class must have proper getters and setters, and must correctly control what is private, public, protected and static.

2. **Polymorphism.** Polymorphism lets objects of different classes be treated through a common type, while each one still executes its own specific version of a behavior when that behavior is invoked. Using polymorphism, create mutant powers — 5 different mutant powers in total. Each power must print to the console a different string of characters that visually represents that power when it is used.

3. **Packages.** Packages let you organize related classes into separate namespaces, keeping the codebase structured and making responsibilities clear across the project. Organize your classes into the following packages: `personas`, `profesiones`, `poderes`, and `programaMutante`.

4. Create a program with a `main` method that creates 5 people with different professions and different powers each. The goal of this step is to prove that inheritance and polymorphism actually work, so your test should exercise a variety of combinations: people from different professions performing their profession-specific actions, people using different mutant powers, and at least one case where a person of one profession is paired with a power that could just as easily belong to a person of a different profession — showing that the profession behavior and the power behavior are independent of each other and both still resolve correctly at runtime.

5. Generate a PlantUML class diagram based on the classes you built, showing the relationships between them (inheritance, associations, and package organization). Push everything to a git repository, including its `src` folder, and add a `README.md` at the root that explains what the program does, describes its classes, and includes the diagram as code, either in PlantUML or in Mermaid.

This exercise must be submitted for review and will count as two exercises.
