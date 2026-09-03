# Discussion Sessions (Conversatorios)

Discussion sessions are optional activities that allow students to participate on the Codex platform at https://wallstreet-zeta.vercel.app for an additional 7% of the course grade throughout the semester. There will be 5 discussion sessions in total, where students can "buy" shares through demonstrated knowledge. Those shares may rise or fall in price on the Codex market, and students can redeem them for course percentage points whenever they choose. The accumulated percentage redeemed during the semester will be added to the total grade at the end of the semester.

## Discussion Session Rules

1. The instructor will publish the topic and the expected mastery levels at least 5 days before the discussion session.

2. In each discussion session, a student may buy a maximum of 100 shares.

3. On the day of the discussion session, the instructor will publish the "price sheet," which defines the criteria used to determine the value of each student's contribution during the session. This corresponds to the shares "purchased," from 0 to 100.

4. The instructor will record the discussion session and take notes. The transcription, notes, and price sheet will be analyzed by an AI agent that decides how many shares each participant acquires, in order to avoid subjective bias.

5. Each discussion session will last a maximum of 12 minutes in groups of up to 5 people. Only discussion session participants may be present; all other students will wait outside.

6. Students will know the topic and the expected scope of mastery, but they will not know the questions or the direction of the conversation led by the discussion moderator (the instructor).

7. Students may not read material or look up answers through any digital means or books, but they may use them to show something they prepared in advance for the topic and question at hand.

8. Each student may participate for a maximum of 2 minutes, which does not necessarily have to be consecutive. Being concise is strongly recommended.

9. When a student addresses an aspect of the topic in the discussion session, if another student—or the same student—brings up that aspect or topic again, it will no longer be counted. This is to avoid repeating matters already discussed. In other words, contributions must always be incremental.

10. In each discussion session, the moderator's questions or focus areas are different.

---

# Discussion Session #1 - Friday, August 28th

## Topic

The power of the Java API: https://docs.oracle.com/javase/8/docs/api/. The Java API is the extensive documentation of Java's object-oriented language. It covers not only the core language, but also a broad collection of packages and classes that extend Java's functionality to solve many types of applications and solutions in the market. Understanding how to read, navigate, and use it is of great importance in Java's commercial and scientific environments.

*Expected mastery*

- What is the power and foundation of `java.lang`
- Why do primitives exist in `java.lang`? There are primitives such as `int`, `float`, `char`, `boolean`, etc., but there are also classes such as `Integer`, `Float`, `Byte`, `Boolean`, etc.
- What are standard in and out, why are they called `InputStream` and `OutputStream`, and why is it said that in Java everything is a file
- How the JVM manages processes and threads, and in particular how the programmer manipulates them with the `Thread` class
- What skills and capabilities can be gained by mastering packages such as `java.math`, `java.time`, and `java.util`
- Why some packages are `java.*` and others are `javax.*`
- How would you explain reading the Java API help documentation: what it consists of, how it is organized, and why it sometimes refers to Implemented Interfaces and Direct Known Subclasses
- How these APIs are affected by different versions of Java and the JDK


## Market Sheet
 
Conversation drivers: 

1. Por qué si existen classes para Integer, Boolean, Float, Byte, etc existen primitivas? incluso esas clases muchas veces son creadas con primitivas, o tienen métodos que retornan primitivas. Si las primitivas tienen métodos para que existen las clases. Deberían ser una o la otra únicamente?

2. Cómo java.lang da soporte a las Excepciones y Errores en todo el lenguaje?

3. Si java.lang.Math me da un amplio repertorio de operaciones, para que tengo el paquete de java.math

4. Que controles y como puede administrar java lo que son procesos y threads desde las classes en java.lang

5. Por qué existen los Input y Output streams, qué es el concepto de stream que nos da java?

6. Cuáles son los alcances de java.lang.System class

7. Cuándo se construyen sistemas que van a ser usados en múltiples países, que ventajas me dota java.time

8. Qué tipo de algoritmos, operaciones, técnicas, estructuras y/o soluciones puedo fácilmente crear con java.util, donde se vuelve un aliado en la programación? 

9. Por qué será que Calendar y Date están en java.util y no en java.time. 

10. Cómo podríamos hacer que la AI use cierta versión del JDK, y que solo genere código oficial del java api de la versión específica? Cómo podríamos hacer incluso que ciertos métodos o clases del JDK, los use de únicamente la forma en que queramos todo el tiempo?


Shares: 

1. El estudiante dió más que definiciones teóricas de los conceptos, habló de casos concretos de uso, correlacionó el concepto con otros existentes para ampliar la comprensión. 20 shares.

2. El estudiante realizó programación ejemplo en código java para demostrar los aspectos estudiantes y para soportar las afirmaciones que está aportando. 30 shares.

3. El estudiante logró crear deducciones propias, simplificaciones propias, teorías propias sobre el entendimiento y uso de los conceptos y técnicas que está aplicando. 20 shares.

4. Pudo correlacionar los temas estudiados y expuestos con el entorno del mundo real, ya sea dentro del contexto de sus estudios en ingeniería de sistemas, o también contextualizando situaciones de desarrollo de programas de la vida real donde lo expuesto consolida esos escenarios. 25 shares.

5. Para aquello que no supo una respuesta, logro conectar múltiples conceptos estudiados para llegar a una respuesta que aún tal vez no sea correcta, tiene coherencia técnica. 15 shares.

6. No solo glorificó las caracteristicas del lenguaje, los paquetes, los alcances poniendo java como un gran lenguaje y plataforma de programación, si no que más bien, logró evidenciar en teoría y en código, deficiencias, mejoras y retos de uso de los diferentes paquetes, clases o implementaciones discutidas sobre su intervensión.  25 shares. 

---

# Discussion Session #2 - Friday, September 11th, 2026

## Topic
There are concepts that are pillars for mastering the object-oriented paradigm in any programming language: abstraction, encapsulation, inheritance, and polymorphism. The student not only comes to master these concepts in theory and in Java, but also masters them in practice and extrapolates them to other programming languages.

*Expected mastery*

- The student can explain real situations in class design where the principles of encapsulation are met or not met, knowing and mastering the scenarios in which the use of public, private, and protected is appropriate. They understand the effect of those modifiers on classes, constructors, methods, and instance variables.

- Given example problems, they can mentally design in seconds the classes needed to solve a variety of problems, applying a correct separation of concerns.

- Fully masters how inheritance is done not only in Java but also in some other language; thoroughly understands aspects associated with inheritance, such as the use of abstract classes, abstract methods, and the use of this and super when there is inheritance, in both methods and constructors. Knows how to build multi-level inheritance, how to override inherited methods, and also how to extend them when both the functionality programmed in the parent and the additional code written in the child are required in a given order; and applies those skills to real-life examples in different languages.

- Is able to imagine and create new possibilities and worlds supported by polymorphism; knows and fully masters how to achieve polymorphic classes and methods by means of concrete classes, abstract classes, and interfaces. Combines polymorphism and inheritance skillfully and recognizes their particularities in Java and in some other language.

- The student masters all of the above without reading documentation, and can explain it to other people fluently, with real examples and situations that could arise in programs they have built or could be building in the future.

- The 4 pillars are identifiable not only in code and in theory, but also graphically using UML.

## Market Sheet

---

# Discussion Session #3

## Topic

## Market Sheet

---