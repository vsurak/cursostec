# Case #1 - Mutant Battle 25%

## General Description

You are going to build an automatic mutant battle game. The only input the user provides is the size of the teams; from that point on, the game generates random mutants for both teams and starts the match on its own, running the entire battle without further user intervention until a winner emerges. The work is organized into four layers, each with its own functional responsibility.

## Model Layer

Extend the work done in the [Week #5](Week #5.md) exercise. Every mutant must now also have a current energy value, starting at 100 for all of them. Each mutant can carry at most one mutant power. Each mutant also has a defense capacity, a value between 1 and 3. Each mutant power a mutant carries starts with a damage capacity between 1 and 3.

## Game Layer

This layer represents the battlefield: the non-visual space where the mutant battle is organized. It is responsible for creating two teams, each with a maximum number of mutants that can range from 3 to 11, with both teams starting with the same amount. It always keeps control over both teams, continuously monitoring how many mutants are alive and how many are dead, keeping a running scoreboard. Each team must be identifiable by a color and a shield or symbol. The battlefield is also responsible for providing its dimensions to every mutant that needs to move within it. The game continues until one of the two teams loses all of its mutants.

## Control Layer

Every mutant must be able to move arithmetically across the battlefield at a given speed. Movement should be random, though it is recommended to give it some kind of pattern rather than being fully unpredictable. When a mutant's movement brings it within a configurable radius of an enemy mutant, that mutant must decide, at that instant, whether to attack or defend. If a mutant attacks and the opponent does not defend, the opponent's energy is reduced by the attacking power's damage value. If the opponent does defend, the opponent's energy is instead reduced by the attacking power's damage value divided by the opponent's defense capacity. Whenever a mutant succeeds in reducing an opponent's energy, its own power increases by 1 unit, up to a maximum of 7. Mutants are always moving; every time one enters the radius of an opponent, both must decide whether to attack or defend and the corresponding action is executed. A mutant may find itself within radius of several opponents at once, but this only produces one attack-or-defend action per pair involved. Because many of these encounters can happen at the same time across the battlefield, you must design a threading scheme so that all of this can execute in parallel.

## UI Layer

This is the visual part of the game: a canvas or a JFrame where the battlefield is drawn, rendering everything happening in the mutant battle in real time at a configurable refresh rate. This must be achieved using the Observer design pattern together with the MVC (Model-View-Controller) UI pattern. The UI layer must only display what is happening in the underlying logic by querying the other layers, never implementing game logic itself. It is important that it always shows which mutants are alive, clearly identifies which team each one belongs to, monitors each player's energy, tracks how many are alive and dead per team, and announces the winner once the match ends. Once a match is finished, it must be possible to start a new one. All mutants are visible and moving at the same time in this visual screen. 

## Other Aspects

- All classes must comply with good coding practices: encapsulation, separation of concerns, no hard-coded values in the code (use a constants library instead), and heavy reliance on inheritance and polymorphism.
- This work is done in pairs.
- Before writing any code, the student must first write a spec of the objects to be designed, in Markdown. This spec must be pushed to a git repository and shared with the professor for review before programming begins, and it must live in the repository's `README.md`.
- Next, produce the UML diagram using PlantUML and add it to the `README.md`.
- Generate the skeleton classes for the mutant battle game.
- Then proceed to implement the methods and classes, properly separated into packages (layers).
- Each layer must have its own program with a `main` method that allows testing that the objects in that layer work correctly on their own.
- Finally, there must be a main program that runs the entire game end to end.
- The program must be written in Java.
- The student may use any AI assistance; however, if the student is unable to understand, explain, and defend the code, the class design, and the algorithms, and cannot account for any line of code, they may lose between 20 and 60 points on the review, depending on the severity of the knowledge gap. This requirement applies to all the code except the UI layer, strictly limited to the classes responsible for drawing the graphical part — never the classes containing game logic.
- The review will take place in a scheduled appointment with the professor, and all work must be tracked in GitHub. It will be verified that both students contributed to the code during development; otherwise, the student may lose up to 15 points on the review.
- Failing to demonstrate command of GitHub and the command line may cost up to 10 points on the review.
- Final commit deadline: Friday, September 25.
