# Genethic Algorithms 


## In person example 

All the group at the board, collaboratively guided by the professor, will proceed to design a genetic algorithm for a given problem, in which the following will be decided:

- Chromosomal representation  
- Initial population  
- Fitness function  
- Crossover and mutation operations  
- Current population cleanup  
- New population  
- Iterations to reach the answer  

*Problem:*

There is historical information about half marathon runners (21Km), around 2000 competitors, and each one has data from between 7 to 15 of their last events—events that are not necessarily the same among competitors. Additionally, there is information about the number of slopes encountered during the race (areas where the track goes up/down), as well as the minimum and maximum elevation reached along the course.  

In other words, the information could look like this:

05/23/2025, Elena Fallas, Salvador Nevado, 21, 4, 170, 320, 2:30:15  

Which means: 21km, 4 slopes, minimum elevation 170 meters, maximum elevation 320 meters, with a duration of 2 hours 30 minutes and 15 seconds.  

The goal is to attempt, given a race configuration that specifies the number of slopes, minimum elevation, and maximum elevation, to obtain the list of competitors who would face the greatest challenge in that race, and at the same time indicate to each one what they need to improve.  

---

# Probabilistic and Randomized Algorithms

## 1. Introduction

A **randomized algorithm** is an algorithm that uses random choices as part of its execution.

Unlike a deterministic algorithm, a randomized algorithm can behave differently on different executions even when given exactly the same input.

For example, a deterministic algorithm might always choose:

```text
the first element as a pivot
```

while a randomized algorithm might choose:

```text
a randomly selected element as the pivot
```

The input is the same, but the execution can be different.

Randomization can be useful when:

* The optimal deterministic decision is expensive to compute.
* Certain inputs cause poor worst-case behavior.
* We want good expected performance.
* The problem is too large for exhaustive computation.
* Sampling can provide a sufficiently accurate estimate.
* A small probability of error is acceptable.

A fundamental principle is:

> **Randomness can be used as a computational resource.**

# 2. Deterministic vs. Randomized Algorithms

## Deterministic algorithm

For a fixed input, a deterministic algorithm follows the same sequence of decisions.

```text
Input
  |
  v
Same decisions
  |
  v
Same execution
  |
  v
Same output
```

## Randomized algorithm

A randomized algorithm uses random choices.

```text
             Input
               |
               v
        Random decision
          /         \
         /           \
        v             v
     Path A         Path B
        |             |
        +------ + ----+
               |
               v
             Output
```

Therefore, two executions with the same input may have:

* Different execution paths.
* Different running times.
* In some algorithms, different outputs.

# 3. Probabilistic Analysis vs. Randomized Algorithms

These two concepts are related but should not be confused.

## Probabilistic analysis

We analyze an algorithm using probability.

The algorithm itself may be deterministic.

For example, we might assume that the input is randomly distributed and ask:

$$
E[T(n)]
$$

where \(T(n)\) is the running time.

## Randomized algorithm

The algorithm itself makes random choices.

For example:

```cpp
int pivotIndex = randomIndex(0, n - 1);
```

The randomness comes from the algorithm rather than from an assumption about the input.

### Important distinction

> **Probabilistic analysis is a method of analysis. Randomization is a method of algorithm design.**

This distinction is important when studying randomized algorithms.

# 4. Why Use Randomness?

Suppose an algorithm must choose between several alternatives.

A deterministic approach might spend a large amount of time trying to identify the best alternative.

A randomized algorithm might make a random choice instead.

The random choice does not guarantee that the selected option is optimal.

However, it may be much cheaper computationally.

The trade-off can be expressed conceptually as:

$$
\text{Computation saved}
\quad \text{vs.} \quad
\text{probabilistic uncertainty}
$$

In other situations, randomness does not introduce uncertainty into the answer at all. It only changes the execution path.

This is the case with randomized Quicksort.


# 5. Three Important Ideas

When studying probabilistic algorithms, keep these concepts separate:

### 1. Randomized execution

The algorithm makes random decisions.

### 2. Probabilistic correctness

The algorithm may produce an incorrect answer with some probability.

### 3. Probabilistic performance

The algorithm may always produce the correct answer, but its running time depends on random choices.

These three properties are independent.


# 6. Random Variables in Algorithms

A randomized algorithm can be analyzed using **random variables**.

Suppose:

$$
X =
\begin{cases}
1 & \text{if an event occurs}\\
0 & \text{otherwise}
\end{cases}
$$

This is called an **indicator random variable**.

Its expected value is:

$$
E[X] = P(X=1)
$$

This simple relationship is extremely useful.

For example, suppose we perform 1,000 experiments and define:

$$
X_i =
\begin{cases}
1 & \text{if experiment } i \text{ succeeds}\\
0 & \text{otherwise}
\end{cases}
$$

Then the total number of successes is:

$$
X = X_1 + X_2 + \cdots + X_{1000}
$$

and:

$$
E[X]
=
E[X_1]+\cdots+E[X_{1000}]
$$

This is the **linearity of expectation**.

An important property is:

> **Linearity of expectation does not require the random variables to be independent.**

This becomes extremely useful when analyzing randomized algorithms.

# 7. Expected Running Time

A randomized algorithm can have different running times on different executions.

Therefore, instead of asking only:

> "What is the running time?"

we can ask:

> "What is the expected running time?"

If \(T\) is the random variable representing running time:

$$
E[T]
=
\sum_t tP(T=t)
$$

For a simple example, suppose an algorithm takes:

* 1 ms with probability 0.8.
* 5 ms with probability 0.2.

Then:

$$
E[T]
=
(1)(0.8)+(5)(0.2)
$$

$$
E[T]=1.8\text{ ms}
$$

The algorithm does not necessarily take 1.8 ms on any individual execution. It is the average value over repeated executions under the specified probability model.

