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

Analysis of algorithms that reached production in commercial systems and exhibited poor performance, requiring re-engineering and mathematical analysis to optimize them and achieve algorithms with a lower Big-O order.

*Expected mastery*
- Well-documented problems from real commercial applications 
- Evidence of the original Big-O complexity, data structures, and algorithmic strategy, and how they had to be improved 
- Why those structures and strategies behaved that way; what the design or programming flaw was 
- How the problem was detected 
- Whether there were multiple approaches to the solution, or how the improvement was carried out 
- Concrete knowledge of the data structure or algorithm changes that led to the improvement, including their Big-O complexity analysis and an analysis in terms of N for the problem 
- How the results of the improvement were measured, and how the current capacity of the new approach is known 
- If the solution involved vertical or horizontal scalability in infrastructure, processes, or programs, how that is analyzed from a Big-O perspective and in terms of problem growth rates 

## Market Sheet

Conversation drivers: 

1. Qué tan común los ingenieros de software se enfrentan a problemas de optimización de algoritmos, donde de eso pueda depender si es un buen ingeniero o no?

2. Después de esto estudiado, cuáles podrían ser estrategias o estructuras de datos que normalmente llevan a un detrimento del rendimiento, y de la misma forma cuáles son técnicas o estructuras que normalmente van asociadas a la mejora?

3. En procesos de ingeniería de software, donde se evidencias problemas de rendimiento que deben ser abordados y solucionados, que técnicas o procesos se dan, para primero detectar y aceptar que el problema existe, luego para ubicarlo focalizadamente, y posteriormente para solucionarlo, que no implique prueba y error?

4. Qué son las variables que normalmente se están midiendo cuando se trata de rendimiento, escalabilidad vertical o horizontal?

5. Qué tan usual los problemas de rendimiento parecen venir de los vendors, productos de software como plataformas, drivers, librerías cuya programación está hecha de cierta forma que el usarla ha llevado a los problemas?

Shares: 

1. El estudiante en su exposición denota que estudió múltiples artículos, varias fuentes y las cruzó organzidamente para sostener sus afirmaciones, siempre dejó claro de donde estaba sacando sus hipotesis, sobre cuales casos de estudio? 25 shares.

2. El estudiante domina, extiende, explica y analiza de forma clara la complejidad algoritmica de los problemas que está exponiendo, del como sucedieron y el cómo los aborda. 30 shares. 

3. Hubo verificación de veracidad de los casos estudiados, de tal forma que se comprobó que en varios medios oficiales, la narrativa del caso es la misma consolidando como un evento real documentado. 20 shares.

4. En análisis del o los problemas abordados por el estudiante, tienen más de una dimensión, entre ellas: complejidad algoritmica, tamaño, formas de monitoreo o detección, mediciones anteriores y posteriores a la mejora. 20 shares.

5. El estudiante hizo pruebas programadas o medición analítica, que simulaban parcialmente el problema en estudio para verificar los rendimientos esperados y obtenidos. Es evidente ese ejercicio en su exposición. 20 shares. 
---

# Discussion Session #2 - Friday, September 11th, 2026

## Topic
Dynamic Programming and Greedy Algorithms, real business applications

When studying types of algorithms, it is common to find academic examples used to illustrate the concepts: the traveling salesman, the shortest path in a graph, a simple game, the queens problem, Huffman trees, making change, the towers of Hanoi, among others. Commercially, programmers sometimes solve problems using these techniques, knowing and applying them in a planned or unplanned way, with a complete or sometimes partial approach.

The student is expected to identify multiple real problems, either solved in a documented way or potential candidates to be solved by such techniques.

*Expected mastery*
- Fully masters the principles of each algorithmic strategy: what its steps and stages are, its formal requirements and criteria, how it manages the size of the problem, how it attacks, divides, and solves it, and the deterministic path it follows to arrive at a final answer.

- Masters and studies multiple business cases for each type of algorithm, so that they can explain the context of the problem, its size, the algorithmic complexity, how the algorithm was designed, the steps it takes, and the result to be obtained; and, very importantly, knows the successes as well as the cases where the algorithm could fail or not be optimal, to the point of even being able to analyze its code.

- For business cases that are potential candidates and/or have no detailed documentation, the student studies, analyzes, and develops a theory of application in which all the algorithm's requirements are addressed, can identify the steps to follow, the stages, the optima, the problem size N, the complexity measure, the correct cases and the corner cases that are not well handled, and clearly identifies the limitations and the potential of the proposed algorithm. This is applied to several problems and to both types of algorithms. In such a case, plenty of documentation was study to understand the real business problem. 

- The student has such command of the material that they do NOT need to read theory during the discussion session in order to explain the multiple facets of both the problems and the solution algorithms.


## Market Sheet

Shares:

1. El estudiante demostró que estudió más de un ejemplo o caso por cada tipo de algoritmo. 20 shares.

2. Siempre que explicó un caso existente o un candidato para programación dinámica fué claro en como le pasaba resultados de una etapa a otra, también donde y cómo ocurría la memorización de valores previamente calculados, y tuvo claridad en el tamaño n y etapas del algoritmo. 40 shares.

3. Cuando explicó casos existentes o candidatos para algoritmos voráces supo determinar cuál era el criterio de selección, la función de evaluación de la función, los óptimos locales y globales del algoritmo. 40 shares. 

4. Pudo explicar código de alguno de los algoritmos estudiados a cabalidad, haciendo énfasis en la estrategia del algoritmo y cómo esta se encuentra y es evidente en el código. 30 shares. 

5. Demuestra claro dominio del tamaño N del problema cuando discute y sobre las etapas que debe seguir ese algoritmo con respecto a ese N. 15 shares. 

---
# Discussion Session #3 - Miércoles 4 de Noviembre, 2026

## Topic
By this date, the student has studied and practiced both generic algorithms and probabilistic algorithms. It is said that a Genetic Algorithm (GA) is also probabilistic.

The student must look for a real-life problem from their daily routine—for example, attending classes at TEC, commuting to TEC, eating at the cafeteria, pending coursework, living with roommates in the apartment, grocery shopping, etc. A real-life problem that meets the following conditions:

The problem repeats multiple times, whether in hourly cycles, daily, or every certain number of days.

The action to take is not always the same, even if the problem itself is the same. Depending on additional variables, sometimes one decision must be taken over another; furthermore, emotions may influence which path is chosen as a solution.

Reduce this decision to a specific problem influenced by a limited set of variables.

Around this problem, the student will elaborate broadly to demonstrate and explain related concepts such as chromosomal representation, initial population, fitness function, crossover operation, mutation, and final population outcome. Additionally, the student must clarify why this problem, when solved with this algorithm, is also considered probabilistic.

## Market Sheet

Shares:

1. Logra para un ejemplo de la vida real plantear un algoritmo genético que resuelve el problema de la arbitrariedad de las decisiones de las personas de alguna forma controlada pero que podría ser algo impredecible. 50 shares.

2. 1. Logra para un ejemplo de la vida real plantear un algoritmo probabilista que resuelve el problema de la arbitrariedad de las decisiones de las personas de alguna forma controlada pero que podría ser algo impredecible. 50 shares.

3. Las partes, componentes y retos del algoritmo probabilista está claro para el estudiante, sabe como componer una distribución de probabilidad y usarla para guiar la decisión de obtener respuesta de un algoritmo? 50 shares. 

4. El estudiante puede diseñar una representación cromosomática, población, función de fitness e imaginar la ejecución de un algoritmo genético para lidear con problemas de este tipo de incertidumbre evolutiva. 50 shares. 

5. Las variables para plantear el problema y la solución con cualquiera de las tecnicas son reconocidas y bien delimitadas. 15 shares. 
---

# Discussion Session #4 #5 - Miércoles 4 y 6 de noviembre.

## Topic

Parallel algorithms, intractability, encryption, and choosing an algorithmic strategy.

This session asks the student to treat algorithms as engineering decisions: given a problem of size N, which family of techniques can attack it, at what cost, and with what hardware or cryptographic assumptions. The conversation will move among four areas that must stay connected.

**1. Parallel algorithms.** Every parallel discussion starts from a problem of N elements (or N units of work) and from how those N are partitioned among processes or hardware cores. The student must distinguish a *parallel algorithm*—work divided so that independent (or coordinated) pieces run on distinct processors/cores, with a defined mapping of N to workers, a merge or reduction step, and a complexity argument in terms of N and of the number of processors P—from a *process that uses threads*. Threads can implement parallelism, but spawning threads, sharing memory, or “doing several things at once” is not by itself a parallel algorithm: there must be a strategy for splitting N, assigning chunks, synchronizing, combining results, and reasoning about speedup, bottlenecks, and when extra cores stop helping. Students should recognize problems that are good candidates for parallel algorithms (independent subproblems, map-reduce style aggregations, data-parallel loops, search over disjoint spaces) and problems that are not (strict sequential dependence, tiny N, communication heavier than computation).

**2. Intractability and algorithmic complexity.** The student must know when a problem is intractable: not merely “slow on my laptop,” but a growth rate (typically exponential or worse in N, or NP-hard in the usual informal sense used in the course) that makes exact solution unusable as N grows. They should contrast polynomial vs exponential behavior, explain why adding machines does not magically make an intractable exact algorithm tractable, and name ways to attack such problems: heuristics, approximations, restrictions of the input, parameterization, preprocessing, greedy or DP on a simplified model, probabilistic methods, genetic search, parallel search that still does not change the worst-case class, or accepting a bounded-quality answer. Real-life examples are expected (routing, scheduling, packing, cryptographic brute force, constraint satisfaction, large combinatorial planning).

**3. Symmetric and asymmetric encryption.** The student must explain clearly how symmetric algorithms (same secret key for encrypt and decrypt) differ from asymmetric ones (public/private key pair): key distribution, typical use (bulk data vs key exchange and signatures), computational cost, and how the two are often combined in practice. Encryption here is treated as an algorithmic family with its own assumptions, not as a product name.

**4. Strategy on the fly.** Given problems stated in the session, the student must pick and justify a possible algorithmic strategy using techniques seen during the semester: divide and conquer, dynamic programming, backtracking, greedy, parallel, probabilistic, encryption, and genetic algorithms. The answer is a strategy, not a full implementation: problem size N, why that technique fits, what would go wrong with a mismatched technique, and how two techniques might be combined if one is not enough.

*Expected mastery*

- Given N and a number of processes or cores P, describe how work is split, what each worker does, how results are combined, and how time depends on N and P.
- Separate parallel *algorithm* (partition of N, independence or defined communication, reduction) from a sequential algorithm that merely uses threads, locks, or asynchronous calls.
- Point to real or plausible problems that admit parallel algorithms, and say why the subproblems are (or are not) independent.
- Decide whether a problem is tractable or intractable as N grows; justify with complexity, not with intuition alone.
- List concrete attack options for intractable problems and illustrate at least one with a real-life example (what is given up: optimality, completeness, exactness, or generality).
- Contrast symmetric vs asymmetric encryption: keys, typical algorithms or roles, when each is appropriate, and a realistic pipeline that uses both.
- Faced with an unseen problem, name a semester technique (or a mix), bind it to N, and sketch the strategy: stages, what is stored or branched, what is chosen greedily, what is evolved, what is encrypted, or what is run in parallel.

## Market Sheet

Shares:

1. El estudiante distingue con claridad un algoritmo paralelo (reparto de un problema de tamaño N entre procesos o cores, fusión de resultados, argumento en N y P) de un programa que simplemente usa hilos. 30 shares.

2. Identifica problemas donde un algoritmo paralelo es conveniente y explica cómo se distribuirían los N elementos, qué queda independiente y dónde está la sincronización o la reducción. 25 shares.

3. Determina cuándo un problema es intratable, relaciona esa conclusión con la complejidad algorítmica y propone formas concretas de atacarlo (aproximación, heurística, restricción del input, métodos probabilistas o genéticos, etc.), con ejemplos de la vida real. 35 shares.

4. Explica con precisión la diferencia entre algoritmos simétricos y asimétricos de encriptación: claves, usos típicos, costo y cómo se combinan en un escenario real. 25 shares.

5. Ante problemas planteados en la sesión, elige y justifica una estrategia algorítmica usando técnicas del semestre (divide y vencerás, programación dinámica, backtracking, voraz, paralelo, probabilista, cifrado, genéticos), dejando claro el N, por qué esa técnica y no otra, y si haría falta mezclarlas. 40 shares.

