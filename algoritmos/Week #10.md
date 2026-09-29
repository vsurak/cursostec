# Probabilistic and Randomized Algorithms

## Monte Carlo Algorithms

A **Monte Carlo algorithm** is a randomized algorithm whose output may be incorrect with some probability.

The important property is that the probability of error can often be controlled.

For example:

$$
P(\text{correct}) \geq 0.99
$$

means that the algorithm is correct with probability at least 99%.

The exact form of the guarantee depends on the algorithm.

*One-Sided and Two-Sided Error*

Monte Carlo algorithms can have different types of errors.

*One-sided error*

One type of answer is always correct, while the other can have an error.

For example:

```text
If the algorithm says "NO":
    always correct

If the algorithm says "YES":
    may be incorrect
```

This is called **one-sided error**.

*Two-sided error*

Both possible answers may be incorrect with small probability.

For example:

$$
P(\text{correct}) \geq 1-\epsilon
$$

where:

$$
\epsilon
$$

is the error probability.


*Amplification*

One of the most useful techniques in randomized algorithms is **amplification**.

Suppose an independent execution succeeds with probability:

$$
p
$$

and fails with probability:

$$
1-p
$$

If we repeat the algorithm \(k\) times independently and can recognize a successful result, the probability that all executions fail is:

$$
(1-p)^k
$$

Therefore:

$$
P(\text{at least one success})=1-(1-p)^k
$$

### Example

Suppose:

$$
p=0.90
$$

Then one execution has a 10% failure probability.

After 5 independent executions:

$$
P(\text{all fail})=(0.10)^5=0.00001
$$

Therefore:

$$
P(\text{at least one success})=0.99999
$$

or:

$$
99.999\%
$$

This technique is called **probability amplification**.


*Monte Carlo Does Not Always Mean "Repeat Until Correct"*

There is an important limitation.

Sometimes the algorithm cannot determine whether its answer is correct.

For example:

```text
Run randomized algorithm
       |
       v
Answer
       |
       +--> Is it correct?
              |
              +--> Unknown
```

In such cases, simply repeating the algorithm does not automatically solve the problem.

The amplification strategy depends on the problem structure and on whether independent results can be combined or verified.

This is an important correction to the oversimplified idea that:

> "Just run a Monte Carlo algorithm again whenever it fails."

Sometimes that is possible; sometimes it is not.


## Las Vegas Algorithms

A **Las Vegas algorithm** is randomized but guarantees that every returned answer is correct.

The randomness affects:

* Which path is followed.
* How much time the algorithm requires.
* Whether a particular attempt succeeds immediately.

But it does not cause the algorithm to return an incorrect answer.

The typical guarantee is:

$$
P(\text{incorrect answer})=0
$$

while the running time may be a random variable.

---

*Monte Carlo vs. Las Vegas*

| Property                    | Monte Carlo                 | Las Vegas              |
| --------------------------- | --------------------------- | ---------------------- |
| Uses randomness             | Yes                         | Yes                    |
| Can return incorrect result | Yes                         | No                     |
| Correctness guarantee       | Probabilistic               | Guaranteed             |
| Running time can be random  | Often                       | Often                  |
| Repetition may help         | Yes, depending on algorithm | Yes                    |
| Main trade-off              | Correctness vs. computation | Runtime vs. randomness |

## Randomized Quicksort

Randomized Quicksort is one of the classic examples of a Las Vegas-style randomized algorithm.

Ordinary Quicksort can perform poorly when the pivot repeatedly produces highly unbalanced partitions.

Worst case:

$$
T(n)=T(n-1)+\Theta(n)
$$

which gives:

$$
T(n)=\Theta(n^2)
$$

Randomized Quicksort selects the pivot randomly.

The random pivot does not eliminate the theoretical worst case.

Instead, it makes it unlikely that a fixed adversarial input consistently causes poor partitions.

The expected running time becomes:

$$
E[T(n)] = O(n\log n)
$$

while the worst-case running time remains:

$$
O(n^2)
$$

This distinction is extremely important:

> **Randomization can improve expected performance without necessarily changing the theoretical worst-case bound.**



*C++ Example: Randomized Quicksort*

```cpp
#include <algorithm>
#include <iostream>
#include <random>
#include <vector>

int partition(std::vector<int>& a, int low, int high) {
    int pivot = a[high];

    int i = low - 1;

    for (int j = low; j < high; ++j) {
        if (a[j] <= pivot) {
            ++i;
            std::swap(a[i], a[j]);
        }
    }

    std::swap(a[i + 1], a[high]);

    return i + 1;
}

void randomizedQuickSort(
    std::vector<int>& a,
    int low,
    int high,
    std::mt19937& generator
) {
    if (low >= high) {
        return;
    }

    std::uniform_int_distribution<int> distribution(low, high);

    int randomPivot = distribution(generator);

    std::swap(a[randomPivot], a[high]);

    int pivotIndex = partition(a, low, high);

    randomizedQuickSort(a, low, pivotIndex - 1, generator);
    randomizedQuickSort(a, pivotIndex + 1, high, generator);
}

int main() {
    std::vector<int> values = {
        8, 3, 7, 4, 9, 2, 6, 5, 1
    };

    std::random_device rd;
    std::mt19937 generator(rd());

    randomizedQuickSort(
        values,
        0,
        static_cast<int>(values.size()) - 1,
        generator
    );

    for (int value : values) {
        std::cout << value << ' ';
    }

    std::cout << '\n';
}
```

## Random Sampling

Random sampling is another fundamental application.

Suppose we have:

$$
N
$$

objects and want a sample of:

$$
M
$$

objects, where:

$$
M<N
$$

There are two different questions:

### Question A

Can we select \(M\) objects randomly?

Yes.

### Question B

Does every possible subset of \(M\) objects have exactly the same probability?

This is a stronger requirement.

The number of possible subsets is:

$$
\binom{N}{M}=\frac{N!}{M!(N-M)!}
$$

A **uniform sample** requires every one of these subsets to have probability:

$$
\frac{1}{\binom{N}{M}}
$$

This distinction is essential in randomized algorithm design.

---

### C++ Example: Uniform Sampling Without Replacement

A simple implementation can use the Fisher-Yates/Knuth shuffle.

```cpp
#include <algorithm>
#include <iostream>
#include <random>
#include <vector>

std::vector<int> sample(
    const std::vector<int>& data,
    std::size_t m
) {
    if (m > data.size()) {
        throw std::invalid_argument(
            "Sample size cannot exceed data size"
        );
    }

    std::vector<int> result = data;

    std::random_device rd;
    std::mt19937 generator(rd());

    std::shuffle(result.begin(), result.end(), generator);

    result.resize(m);

    return result;
}

int main() {
    std::vector<int> data = {
        10, 20, 30, 40, 50, 60, 70, 80
    };

    auto selected = sample(data, 3);

    for (int value : selected) {
        std::cout << value << ' ';
    }

    std::cout << '\n';
}
```

The shuffle makes every permutation equally likely when used with an appropriate uniform random engine.

The first \(M\) elements can then be used as the sample.

---

### Sampling Very Large Data Sets

Suppose:

$$
N=10^9
$$

but:

$$
M=10^4
$$

Reading and storing all \(10^9\) objects may be expensive.

A randomized sampling algorithm can process the data using much less memory.

One important technique is **reservoir sampling**.

Reservoir sampling allows us to obtain a uniform sample from a stream when:

* The total number of elements may be unknown.
* The entire dataset does not fit in memory.
* We need a fixed sample size.

### C++ Example: Reservoir Sampling

```cpp
#include <iostream>
#include <random>
#include <vector>

std::vector<int> reservoirSample(
    const std::vector<int>& data,
    std::size_t k
) {
    if (k > data.size()) {
        throw std::invalid_argument(
            "Sample size cannot exceed data size"
        );
    }

    std::vector<int> reservoir(
        data.begin(),
        data.begin() + k
    );

    std::random_device rd;
    std::mt19937 generator(rd());

    for (std::size_t i = k; i < data.size(); ++i) {
        std::uniform_int_distribution<std::size_t>
            distribution(0, i);

        std::size_t j = distribution(generator);

        if (j < k) {
            reservoir[j] = data[i];
        }
    }

    return reservoir;
}
```

The important idea is that every element has the appropriate probability of appearing in the final sample.

This is especially useful for large streams of data.

---

### Randomized Numerical Estimation

Randomization can also be used to estimate quantities.

Suppose we want to estimate the probability of an event.

Run:

$$
n
$$

independent simulations.

Let:

$$
S
$$

be the number of successful simulations.

Then the estimated probability is:

$$
\hat{p}=\frac{S}{n}
$$

For example:

$$
S=7,800
$$

and:

$$
n=10,000
$$

gives:

$$
\hat{p}=0.78
$$

Therefore:

$$
\hat{p}=78\%
$$

This is a **Monte Carlo estimate**.

---

### Estimation vs. Exact Computation

Suppose a game needs to estimate the probability that a cannon hits a moving target.

An exhaustive method could attempt to model every possible combination of:

* Target position.
* Target velocity.
* Aiming error.
* Projectile trajectory.
* Wind.
* Distance.
* Target size.

A simulation can instead sample these variables.

```text
Generate random scenario
        |
        v
Simulate shot
        |
        v
Hit?
 / \
Yes No
 |   |
 +---+
   |
   v
Repeat many times
   |
   v
Estimate probability
```

The result is an estimate, not an exact analytical probability.

---

### C++ Example: Monte Carlo Estimation

Suppose a simplified game asks whether a randomly generated point falls inside a circle.

```cpp
#include <cmath>
#include <iostream>
#include <random>

int main() {
    const int trials = 1'000'000;

    std::random_device rd;
    std::mt19937 generator(rd());

    std::uniform_real_distribution<double> distribution(
        -1.0, 1.0
    );

    int inside = 0;

    for (int i = 0; i < trials; ++i) {
        double x = distribution(generator);
        double y = distribution(generator);

        if (x * x + y * y <= 1.0) {
            ++inside;
        }
    }

    double probability =
        static_cast<double>(inside) / trials;

    std::cout << "Estimated probability: "
              << probability << '\n';
}
```

The experiment estimates:

$$
P(X^2+Y^2\leq1)
$$

The fraction of successful experiments approximates the true probability.

---

### Accuracy of Monte Carlo Estimates

Increasing the number of simulations generally makes the estimate more stable.

However, the improvement is not linear.

For many basic Monte Carlo estimators, the standard error decreases approximately as:

$$
O\left(\frac{1}{\sqrt{n}}\right)
$$

where \(n\) is the number of samples.

Therefore, reducing statistical error by a factor of 10 may require approximately:

$$
100\times
$$

as many samples.

This explains why Monte Carlo methods are powerful but can become computationally expensive when very high precision is required.


## Pseudo-Random Number Generators

Computers normally generate **pseudo-random numbers** rather than true random numbers.

A pseudo-random number generator (PRNG) is deterministic.

Given the same:

```text
algorithm + seed
```

it normally produces the same sequence.

This is useful for:

* Simulations.
* Games.
* Testing.
* Reproducible experiments.
* Randomized algorithms.


### Linear Congruential Generator

A classic generator is:

$$
X_{i+1}=(AX_i+C)\mod M
$$

The original Lehmer generator is the special case:

$$
X_{i+1}=AX_i\mod M
$$

where:

* \(A\) = multiplier.
* \(C\) = increment.
* \(M\) = modulus.
* \(X_0\) = seed.

The quality of the generated sequence depends heavily on the chosen parameters.

Let:

$$
M=11
$$

$$
A=7
$$

$$
X_0=1
$$

Then:

$$
X_1=7(1)\mod11=7
$$

$$
X_2=7(7)\mod11=5
$$

The sequence becomes:

```text
1 → 7 → 5 → 2 → 3 → 10 → 4 → 6 → 9 → 8 → 1 → ...
```

The sequence eventually repeats.

The length before repetition is called the **period**.


```cpp
#include <iostream>
#include <random>

int main() {
    std::random_device rd;

    std::mt19937 generator(rd());

    std::uniform_int_distribution<int> distribution(1, 6);

    for (int i = 0; i < 10; ++i) {
        std::cout << distribution(generator) << ' ';
    }

    std::cout << '\n';
}
```

Here:

```cpp
std::mt19937
```

is a pseudo-random number generator.

And:

```cpp
std::uniform_int_distribution<int>
```

maps the generated values to a specified uniform integer distribution.

---

### Reproducible Randomness

Randomness is extremely useful during testing, but reproducibility is also important.

Instead of:

```cpp
std::random_device rd;
std::mt19937 generator(rd());
```

we can use a fixed seed:

```cpp
std::mt19937 generator(42);
```

Now the program produces the same pseudo-random sequence every time.

This is extremely useful for debugging randomized algorithms.

For example:

```cpp
#include <iostream>
#include <random>

int main() {
    std::mt19937 generator(42);

    std::uniform_int_distribution<int> distribution(1, 100);

    for (int i = 0; i < 10; ++i) {
        std::cout << distribution(generator) << ' ';
    }

    std::cout << '\n';
}
```


# 46. Practice Problems

## Exercise 1 — Biased Die

Write a C++ program that simulates a six-sided die.

First implement a fair die.

Then create a biased die in which some outcomes are more likely than others.

Estimate the probability of each outcome after:

$$
10^3,\quad10^4,\quad10^6
$$

experiments.

Compare the experimental probabilities with the theoretical probabilities.

---

## Exercise 2 — Random Loop

Consider:

```cpp
int index = 0;

do {
    int a = static_cast<int>(random() * 3);
    ++index;
} while (a < 2);
```

Assuming `random()` is uniformly distributed over \([0,1)\):

1. What is \(P(a<2)\)?
2. What is \(P(a\geq2)\)?
3. What is the expected number of iterations?
4. What is the probability of executing at least \(k\) iterations?

---

## Exercise 3 — Uniform Sampling

Given \(N\) objects and \(M<N\):

1. Design an algorithm that produces a uniform sample of \(M\) objects.
2. Explain why simply choosing \(M\) random indexes can produce duplicates.
3. Explain the difference between:

   * Randomly selecting elements.
   * Selecting uniformly from all possible subsets.
4. Implement your solution in C++.

---

## Exercise 4 — Reservoir Sampling

Assume that the total number of objects is unknown because they arrive as a stream.

Design an algorithm that maintains a uniform sample of size \(M\).

Analyze:

* Time complexity.
* Space complexity.
* Probability that an element remains in the reservoir.

---

## Exercise 5 — Randomized Quicksort

Implement randomized Quicksort.

Then compare:

```text
Deterministic Quicksort
vs.
Randomized Quicksort
```

using:

* Sorted input.
* Reverse-sorted input.
* Random input.
* Repeated values.

Measure:

* Execution time.
* Number of comparisons.
* Number of recursive calls.

Explain why the experimental results may differ from theoretical worst-case bounds.

---

## Exercise 6 — Moving Target

A game contains a moving target.

Design a Monte Carlo simulation to estimate:

$$
P(\text{hit})
$$

Define reasonable probability distributions for:

* Target position.
* Target velocity.
* Aiming error.
* Projectile velocity.

Run at least:

$$
100,000
$$

simulations.

Calculate the estimated probability and discuss its accuracy.

---

## Exercise 7 — Blackjack

Design a Monte Carlo simulation that estimates the probability of winning after:

```text
HIT
```

versus:

```text
STAND
```

using only information available to the computer.

Do not assume that simulation automatically produces an optimal strategy.

Explain the assumptions of your model.

---

## Exercise 8 — Restaurant Forecast

Given seven months of restaurant orders:

$$
(day,time,dish)
$$

estimate the probability of ordering each dish during every day of the following week.

Consider:

* Day.
* Time.
* Historical frequency.
* Sample size.
* Variability.

Explain why the prediction should be treated as probabilistic rather than deterministic.

---

## Exercise 9 — Large Object Collection

Given a collection containing billions of serialized objects, estimate:

1. The most common object type.
2. Its approximate frequency.
3. The uncertainty of the estimate.

Compare:

```text
Exhaustive counting
vs.
Random sampling
```

in terms of:

* Time.
* Memory.
* Accuracy.

---

## Exercise 10 — Logo Detection

Given:

```text
Image: 1080 × 1080
Logo:  190 × 100
```

design a sampling-based algorithm that estimates the probability that the logo occurs somewhere in the image.

Discuss:

* False positives.
* False negatives.
* Number of samples.
* Computational cost.
* Accuracy.

---

# 47. Final Takeaways

1. **Randomized algorithms use randomness as part of their computation.**
2. **Probabilistic analysis uses probability to analyze algorithmic behavior.**
3. These are related but distinct concepts.
4. Randomness does not necessarily imply an incorrect result.
5. **Las Vegas algorithms always return correct answers.**
6. **Monte Carlo algorithms may return incorrect answers with controlled probability.**
7. Expected running time is fundamental when analyzing randomized algorithms.
8. **Indicator random variables** and **linearity of expectation** are powerful analysis tools.
9. Sampling can make large problems computationally manageable.
10. Uniform sampling requires careful attention to the probability distribution.
11. Repetition can amplify the success probability under appropriate conditions.
12. Monte Carlo estimation typically becomes more accurate as the number of samples increases.
13. Randomized Quicksort demonstrates how randomization can improve expected performance while leaving the theoretical worst-case bound unchanged.
14. Pseudo-random number generators are deterministic mechanisms that produce sequences with useful statistical properties.
15. A fixed seed makes randomized experiments reproducible.
18. Modern C++ provides `<random>` for pseudo-random number generation and probability distributions.
19. The quality of a randomized algorithm depends not only on randomness but also on the probability model and assumptions.
20. Randomization is useful in sorting, hashing, sampling, simulation, graph algorithms, numerical computation, optimization, and large-scale data processing.
