# GENETIC ALGORITHMS

## History

Genetic algorithms (GAs) originated from the field of evolutionary computation in the 1960s and 1970s, inspired directly by Charles Darwin's theory of natural selection. **John Holland**, at the University of Michigan, is widely credited as the father of genetic algorithms; his 1975 book *Adaptation in Natural and Artificial Systems* formalized the technique and introduced the theoretical foundation known as the "Schema Theorem," which explains why GAs are effective at searching large solution spaces. Holland's goal was not only to solve optimization problems but to formally study the phenomenon of adaptation as it occurs in nature and to develop ways in which the mechanisms of natural adaptation might be imported into computer systems. In the 1980s, his student **David Goldberg** popularized the technique with practical applications (most famously optimizing gas pipeline control systems) and wrote the seminal textbook *Genetic Algorithms in Search, Optimization, and Machine Learning* (1989), which became the standard reference for decades. Since then, GAs have become one of the core techniques of the broader field of **evolutionary computation**, alongside genetic programming, evolution strategies, and evolutionary programming, and are used today in engineering design, scheduling, machine learning hyperparameter tuning, and game AI.

## Description

A genetic algorithm is a **metaheuristic search and optimization technique** that mimics biological evolution to find good (not necessarily perfect) solutions to problems where the search space is too large to explore exhaustively. Instead of working with a single candidate solution, a GA maintains a **population** of candidate solutions (called **individuals** or **chromosomes**), each encoding a possible answer to the problem (as a bit string, array of numbers, tree, etc.). The population evolves over successive **generations** through three main biologically-inspired operators:

1. **Selection**: Individuals are chosen to reproduce based on their **fitness** (how good a solution they represent), so that better solutions have a higher chance of passing their traits on — survival of the fittest.
2. **Crossover (recombination)**: Pairs of selected individuals ("parents") exchange parts of their genetic material to produce new individuals ("offspring"), combining traits from both parents.
3. **Mutation**: Small, random changes are introduced into offspring to maintain genetic diversity and avoid the population getting stuck in local optima.

**What it searches for:** A solution (or set of parameters) that maximizes (or minimizes) a **fitness function**, by evolving a population of candidate solutions over many generations rather than deriving the answer analytically.

## Genetic Algorithms in Detail

### Guiding Principles

Not every detail of how evolution works is settled science, but the community that studies GAs broadly agrees on a few foundational principles:

1. **Evolution acts on chromosomes, not on the individuals they represent.** The algorithm manipulates the *encoded* representation of a solution, not the real-world solution itself.
2. **Natural selection is the process by which chromosomes with "good" structure reproduce more often than others.**
3. **Reproduction is where evolution actually happens**, through **recombination** — the process of building an offspring's chromosome out of its parents' chromosomes — together with occasional **mutations** that alter that code.
4. **Biological evolution has no memory.** Building a new generation's chromosomes only uses information from the immediately previous generation; nothing further back is tracked.

As John Holland himself put it: *"Approximate solutions to problems of great computational complexity can be found through a process of simulated evolution."*

### Elements Needed to Build a GA

Turning this idea into a working algorithm means defining:

- A **chromosome representation** — how a solution is encoded.
- An **initial population**.
- An **evaluation measure** — the fitness function.
- A **selection / elimination criterion** for chromosomes.
- One or more **recombination operators**.
- One or more **mutation operators**.

### Anatomy of a GA

A GA implementation is typically organized into three modules:

1. **Evolutionary module** — the decoding mechanism (turns a chromosome back into a candidate solution) plus the fitness function (scores that solution). This is the *only* module that needs knowledge about the specific problem being solved.
2. **Population module** — how the population is represented and manipulated: the initialization technique, the selection criterion, the replacement criterion, the population size, and the stopping condition.
3. **Reproductive module** — the genetic operators themselves (crossover, mutation, etc.).

This separation matters in practice: swapping a GA from one problem to another mostly means rewriting the evolutionary module, while the population and reproductive modules stay largely reusable.

### Design Considerations

- **Fitness function** — needs to be balanced. Differences between individuals that are too large cause **premature convergence** (a few individuals take over the population too quickly); differences that are too small cause **stagnation** (the population can no longer tell good solutions from bad ones, so it stops improving).
- **Population size** — also a balance. Too small risks converging on a **local optimum**; too large costs computational resources. Population size is usually fixed for the whole run, although variable-size schemes exist too.
- **Selection criterion** — individuals are copied into the next generation in proportion to their fitness, so fitter individuals are more likely to contribute one or more copies — simulating natural selection. The most common implementation is **roulette-wheel selection**, where each chromosome gets a slice of the wheel proportional to its fitness:

  `Pr(h_i) = fitness(h_i) / Σ fitness(h_j)`  — the sum runs over every individual `h_j` in the population.

  For **replacement**, a new population can either fully replace the previous one, or — usually the better choice — keep the best individuals from the previous generation alongside the new ones. This is called **elitism**.
- **Stopping criterion** — the run usually ends once a high percentage of the population has converged to a similar value. If that value isn't good enough, the algorithm can inject **genetic diversity** (generate some brand-new random individuals) or replace the whole population outright and keep searching.
- **Genetic operators, in more depth:**
  - **Crossover** — used with high probability, and generally considered the most important GA operator. Two parents (already chosen by selection) are cut at a random position, and the resulting sections are swapped to build the offspring's chromosomes. Variants include **single-point crossover** (one cut point — equivalent to a mask of 1s followed by 0s), **two-point crossover** (two cut points), and **uniform crossover** (each gene is independently taken from one parent or the other).
  - **Mutation** — used with low probability. It operates on a single individual: it picks a position and flips it with some probability. This is what introduces genetic material that didn't exist anywhere in the population, letting the algorithm escape local optima.
  - **Inversion** — also used with low probability. It increases exploration by producing chromosomes that would be hard to reach with crossover or mutation alone. It operates on one individual by picking two positions and reversing the sub-chromosome between them.

### Worked Example: The Cookie Factory

A cookie manufacturer knows that the quality of a batch of cookies depends on how many kilograms of **sugar** and **flour** go into it. Suppose experience has shown that quality follows this matrix, where each cell is the quality obtained for a given sugar/flour combination (1-9 kg of each):

|Sugar \ Flour|1|2|3|4|5|6|7|8|9|
|---|---|---|---|---|---|---|---|---|---|
|**9**|1|2|3|4|5|4|3|2|1|
|**8**|2|3|4|5|6|5|4|3|2|
|**7**|3|4|5|6|7|6|5|4|3|
|**6**|4|5|6|7|8|7|6|5|4|
|**5**|5|6|7|8|**9**|8|7|6|5|
|**4**|4|5|6|7|8|7|6|5|4|
|**3**|3|4|5|6|7|6|5|4|3|
|**2**|2|3|4|5|6|5|4|3|2|
|**1**|1|2|3|4|5|4|3|2|1|

For a table this small, it would be easier to just check every cell one by one. But as the number of ingredients grows, or the range of possible values gets larger, brute-force search quickly stops being practical — which is exactly the kind of problem a GA is built for. Here is how the cookie factory maps onto the GA elements introduced above:

- **Chromosome (individual)**: each batch of cookies is one individual, made of two **genes** — the amount of sugar and the amount of flour.
- **Mutation**: randomly pick one of the two genes and randomly add or subtract 1 from it, as long as the result stays within the valid range of 1-9.
- **Crossover**: pick two chromosomes, cut both of them in half, and swap the halves — in this two-gene example, that means swapping the sugar gene, the flour gene, or both, between the two parents.
- **Fitness function**: use the standard fitness formula described above. For example, given a population made of the chromosomes `1-4`, `3-1`, `1-2`, and `1-1`, their quality (read straight from the matrix) and standard fitness (quality divided by the population's total quality) would be:

|Chromosome|Quality|Standard Fitness|
|---|---|---|
|1-4|4|0.4|
|3-1|3|0.3|
|1-2|2|0.2|
|1-1|1|0.1|

- **Natural selection method** — putting it all together, building one new generation looks like:
  1. Start from the current population of chromosomes.
  2. Mutate one or more genes (sugar or flour) in one or more chromosomes of the current generation — each mutation produces one extra chromosome.
  3. Cross one or more pairs of chromosomes.
  4. Add the newly mutated and crossed chromosomes into the population.
  5. Build the next generation by keeping the best individuals and randomly picking the rest from the current population, biased by each chromosome's standard fitness — i.e., roulette-wheel selection.

## Pseudocode

```
BEGIN
    generation := 0
    population := INITIALIZE_POPULATION(populationSize)   // random individuals
    EVALUATE_FITNESS(population)

    WHILE (termination condition not met) DO              // e.g. max generations, fitness threshold
        newPopulation := EMPTY SET

        WHILE (size of newPopulation < populationSize) DO
            parent1 := SELECT(population)                  // e.g. roulette wheel, tournament
            parent2 := SELECT(population)

            IF (random() < crossoverRate) THEN
                (child1, child2) := CROSSOVER(parent1, parent2)
            ELSE
                (child1, child2) := (parent1, parent2)
            END IF

            child1 := MUTATE(child1, mutationRate)
            child2 := MUTATE(child2, mutationRate)

            ADD child1, child2 TO newPopulation
        END WHILE

        population := newPopulation
        EVALUATE_FITNESS(population)
        generation := generation + 1
    END WHILE

    RETURN best individual found in population
END
```

## Explanation of the Pseudocode

- **INITIALIZE_POPULATION**: Creates the first generation by generating `populationSize` individuals at random (or with a heuristic seed). Each individual represents a full candidate solution.
- **EVALUATE_FITNESS**: Runs the fitness function on every individual, assigning a numeric score that measures how good that candidate solution is relative to the problem being solved.
- **Termination condition**: The evolutionary loop stops when a maximum number of generations is reached, an acceptable fitness value is found, or the population's fitness stops improving (convergence).
- **SELECT**: Picks parents from the current population, favoring higher-fitness individuals but still giving lower-fitness ones a small chance, which preserves diversity. Common strategies are **roulette-wheel selection** (probability proportional to fitness) and **tournament selection** (pick the best among a random few).
- **CROSSOVER**: With probability `crossoverRate`, combines the genetic material of two parents (e.g., single-point, two-point, or uniform crossover) to produce two children that inherit traits from both. If crossover doesn't happen, the parents are cloned as-is.
- **MUTATE**: With probability `mutationRate` (usually small, e.g., 5%), randomly alters part of a child's genetic encoding. This introduces new genetic material that selection and crossover alone could never produce, preventing premature convergence to a local optimum.
- **New population replacement**: The offspring replace (fully or partially, depending on the elitism strategy used) the previous generation, and the cycle repeats.
- **Return**: Once the loop ends, the best individual ever found (tracked across generations, or the best of the final population) is returned as the solution.

## Common Mistakes When Implementing Genetic Algorithms

- **Poorly designed fitness function**: A fitness function that doesn't correlate well with actual solution quality misguides the entire search.
- **Mutation rate too high or too low**: Too high turns the search into random noise (losing good traits); too low causes premature convergence and stagnation in local optima.
- **Population too small**: Reduces genetic diversity and causes the algorithm to converge too quickly to a suboptimal solution.
- **No elitism**: Losing the best individual found so far because it wasn't selected/survived into the next generation, causing the algorithm to regress.
- **Bad chromosome encoding**: Representing the solution in a way that makes crossover/mutation produce mostly invalid or meaningless individuals.
- **Ignoring premature convergence**: Not monitoring population diversity, allowing all individuals to become near-identical too early.

## Java Example: Genetic Algorithm Deciding a Game Car's Movement

In this example, a simple game "bot" controls a car that must decide, **every 7 generations**, whether to move **left** or **right**, and at what **speed** (1-10). Each individual's chromosome is packed into a single **byte (8 bits)**, and all genetic operators (crossover, mutation, gene extraction) are implemented with **bitwise operators** (`&`, `|`, `^`, `~`, `<<`) instead of separate object fields. The fitness function rewards individuals that keep the car centered on the track and moving at a reasonable speed (this stands in for whatever real objective the game defines, e.g., avoiding obstacles or staying on the road).

```java
import java.util.Random;

public class CarGeneticController {

    private static final int POPULATION_SIZE = 20;
    private static final double MUTATION_RATE = 0.05;
    private static final double CROSSOVER_RATE = 0.8;
    private static final int GENERATIONS_PER_DECISION = 7; // decide direction/speed every 7 generations

    private static final Random random = new Random();

    // ---------------------------------------------------------------------
    // Chromosome layout: a single byte (8 bits) encodes the whole decision.
    //
    //   bit index:   7    6    5    4    3    2    1    0
    //              [ D  |            S (7 bits)          ]
    //
    //   D (bit 7, mask 0x80 = 0b1000_0000): DIRECTION gene
    //       -> 2 possible values: 0 = LEFT, 1 = RIGHT
    //
    //   S (bits 6-0, mask 0x7F = 0b0111_1111): raw SPEED gene
    //       -> 2^7 = 128 possible raw values (0-127, unsigned)
    //       -> folded down with (raw % 10) + 1 into the usable speed range 1-10
    //
    //   Together, 2 (direction) x 128 (raw speed) = 256 = 2^8 total
    //   reachable chromosomes, matching every possible value of a byte.
    // ---------------------------------------------------------------------
    private static final int DIRECTION_MASK = 0b1000_0000; // 0x80, isolates bit 7
    private static final int SPEED_MASK      = 0b0111_1111; // 0x7F, isolates bits 6-0

    // Chromosome: a single byte holds the entire movement decision for the car
    static class Individual {
        byte genes; // the 8-bit chromosome itself
        double fitness;

        Individual(byte genes) {
            this.genes = genes;
        }

        static Individual random() {
            // any of the 256 (2^8) bit patterns is a valid chromosome
            return new Individual((byte) random.nextInt(256));
        }

        // decode bit 7 -> direction gene (0 = LEFT, 1 = RIGHT)
        boolean moveRight() {
            return (genes & DIRECTION_MASK) != 0;
        }

        // decode bits 6-0 -> raw speed gene (0-127), folded into a driveable 1-10 range
        int speed() {
            int rawSpeed = genes & SPEED_MASK; // AND with 0x7F strips bit 7, keeps bits 6-0
            return (rawSpeed % 10) + 1;
        }

        // human-readable 8-bit representation, e.g. "10010110"
        String toBitString() {
            String bits = Integer.toBinaryString(genes & 0xFF); // & 0xFF avoids sign extension
            return String.format("%8s", bits).replace(' ', '0');
        }
    }

    // Simulated car/track state used to score each individual
    static class CarState {
        double trackPosition; // 0 = left edge, 100 = right edge, 50 = center
        double carSpeed;
    }

    private final CarState car = new CarState();
    private Individual[] population;
    private Individual bestSoFar;

    public CarGeneticController() {
        car.trackPosition = 50; // start centered
        population = new Individual[POPULATION_SIZE];
        for (int i = 0; i < POPULATION_SIZE; i++) {
            population[i] = Individual.random();
        }
    }

    // Fitness: reward staying near the center of the track at a moderate-to-fast speed
    private double evaluateFitness(Individual ind) {
        int speed = ind.speed();
        double projectedPosition = car.trackPosition + (ind.moveRight() ? speed : -speed);
        double distanceFromCenter = Math.abs(50 - projectedPosition);
        double centeringScore = Math.max(0, 100 - distanceFromCenter);
        double speedScore = speed * 2; // faster is generally better, if it stays on track
        boolean staysOnTrack = projectedPosition >= 0 && projectedPosition <= 100;
        return staysOnTrack ? centeringScore + speedScore : 0;
    }

    private void evaluatePopulation() {
        for (Individual ind : population) {
            ind.fitness = evaluateFitness(ind);
            if (bestSoFar == null || ind.fitness > bestSoFar.fitness) {
                bestSoFar = ind;
            }
        }
    }

    // Tournament selection: pick the fittest of 3 random individuals
    private Individual select() {
        Individual best = population[random.nextInt(POPULATION_SIZE)];
        for (int i = 0; i < 2; i++) {
            Individual candidate = population[random.nextInt(POPULATION_SIZE)];
            if (candidate.fitness > best.fitness) {
                best = candidate;
            }
        }
        return best;
    }

    // Single-point crossover done at the bit level: pick a bit position 1-7,
    // then take the high bits from one parent and the low bits from the other.
    private Individual[] crossover(Individual parent1, Individual parent2) {
        if (random.nextDouble() < CROSSOVER_RATE) {
            int crossoverPoint = 1 + random.nextInt(7); // bit position 1-7 (0 would exchange nothing)

            int highMask = (0xFF << crossoverPoint) & 0xFF; // bits ABOVE the crossover point -> 1s
            int lowMask = (~highMask) & 0xFF;                // bits AT/BELOW the point -> 1s (complement)

            int p1 = parent1.genes & 0xFF; // & 0xFF: read the byte as unsigned (0-255)
            int p2 = parent2.genes & 0xFF;

            byte child1 = (byte) ((p1 & highMask) | (p2 & lowMask)); // parent1's high bits + parent2's low bits
            byte child2 = (byte) ((p2 & highMask) | (p1 & lowMask)); // parent2's high bits + parent1's low bits

            return new Individual[] { new Individual(child1), new Individual(child2) };
        }
        return new Individual[] { new Individual(parent1.genes), new Individual(parent2.genes) };
    }

    // Mutation: each of the 8 bits independently has MUTATION_RATE chance of flipping
    private Individual mutate(Individual ind) {
        int mutatedGenes = ind.genes & 0xFF;
        for (int bit = 0; bit < 8; bit++) {
            if (random.nextDouble() < MUTATION_RATE) {
                mutatedGenes ^= (1 << bit); // XOR with a single 1-bit flips only that position
            }
        }
        return new Individual((byte) mutatedGenes);
    }

    private void evolveOneGeneration() {
        Individual[] newPopulation = new Individual[POPULATION_SIZE];
        int i = 0;
        while (i < POPULATION_SIZE) {
            Individual parent1 = select();
            Individual parent2 = select();
            Individual[] children = crossover(parent1, parent2);

            newPopulation[i++] = mutate(children[0]);
            if (i < POPULATION_SIZE) {
                newPopulation[i++] = mutate(children[1]);
            }
        }
        population = newPopulation;
        evaluatePopulation();
    }

    // Runs GENERATIONS_PER_DECISION generations, then applies the best individual's genes to the car
    public void decideNextMove() {
        evaluatePopulation();
        for (int gen = 1; gen <= GENERATIONS_PER_DECISION; gen++) {
            evolveOneGeneration();
        }

        // Apply the fittest individual's decoded genes to the actual car
        int speed = bestSoFar.speed();
        car.trackPosition += bestSoFar.moveRight() ? speed : -speed;
        car.trackPosition = Math.max(0, Math.min(100, car.trackPosition));
        car.carSpeed = speed;

        System.out.println("Chromosome: " + bestSoFar.toBitString()
                + " -> direction: " + (bestSoFar.moveRight() ? "RIGHT" : "LEFT")
                + ", speed: " + speed
                + ", new track position: " + car.trackPosition);
    }

    public static void main(String[] args) {
        CarGeneticController controller = new CarGeneticController();
        // Simulate 5 movement decisions, each evolved over 7 generations
        for (int decision = 1; decision <= 5; decision++) {
            System.out.println("=== Decision #" + decision + " ===");
            controller.decideNextMove();
        }
    }
}
```

### Walkthrough of the Example

- Each **individual** is now a single `byte` (8 bits): bit 7 is the **direction gene** (LEFT/RIGHT, 2 possible values) and bits 6-0 are the **speed gene** (0-127 raw, 128 possible values, folded into 1-10 with `% 10 + 1`). Masking with `0x80`/`0x7F` and reading with `& 0xFF` (to avoid Java's sign extension on `byte`) decodes each gene straight from the bits.
- **Crossover** is a true single-point bit crossover: a random bit position (1-7) splits the byte into a high mask and low mask (built with `<<` and `~`), and the two children are assembled with `&`/`|` by swapping which parent contributes the upper vs. lower bits — no separate fields are copied, only bits.
- **Mutation** loops over all 8 bit positions and, independently for each one, XORs (`^`) it against a single set bit (`1 << bit`) with probability `MUTATION_RATE`, flipping that bit only. This is the classic **bit-flip mutation** used in canonical binary-encoded GAs.
- The **fitness function** scores a decision by simulating where the car would end up: it rewards positions close to the center of the track and higher speeds, but zeroes out any decision that would drive the car off the track.
- `decideNextMove()` runs the full genetic algorithm loop (selection → crossover → mutation → evaluation) for exactly **7 generations**, then commits to the fittest individual's decoded direction and speed as the car's actual move — mirroring how a game bot might only "think" periodically instead of every frame, evolving a better decision each time before acting on it.
- Because a new population is randomly seeded before each 7-generation cycle, the bot doesn't just converge once, it re-evolves a fresh decision for the car's current situation every time `decideNextMove()` is called, adapting to a track that could be different or an obstacle that could have moved since the last decision.

