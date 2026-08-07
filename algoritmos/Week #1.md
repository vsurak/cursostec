# Efficiency, Measurement, Analysis, and Order of Algorithms

## a. Definitions of Algorithm Analysis

Algorithm analysis is the process of studying an algorithm to predict the amount of resources (time, memory, or other) it requires as a function of the input size. It focuses on how the running time or space grows when the input grows, rather than measuring exact seconds or bytes on a specific machine. This allows comparisons between algorithms independent of hardware, programming language, or compiler.

**Example:** Comparing linear search and binary search by analyzing how many comparisons each performs as the array size `n` increases, instead of timing them on a specific computer.

---

## b. Importance of Analysis

Analyzing algorithms is essential because it helps predict performance before implementation, allows developers to choose the most suitable algorithm for a problem, and prevents costly mistakes in systems that must scale (e.g., handling millions of users or large datasets). It also provides a common language (Big-O, etc.) to communicate efficiency objectively.

**Example:** A company choosing between two sorting algorithms for a database with 10 million records must analyze both beforehand; picking the wrong one could mean the difference between seconds and hours of processing.

---

## c. Definition and Importance of Efficiency

Efficiency refers to how well an algorithm uses resources (time and memory) to solve a problem. An efficient algorithm produces correct results using the least possible time and space. Efficiency matters because inefficient algorithms can make software unusable at scale, waste hardware resources, and increase operational costs.

**Example:** Sorting 1,000 elements with an inefficient algorithm (O(n²)) may take noticeably longer than with an efficient one (O(n log n)), and the gap widens dramatically as `n` grows.

---

## d. Time and Space Complexity

- **Time complexity** measures how the execution time of an algorithm grows relative to the input size `n`.
- **Space complexity** measures how much additional memory an algorithm needs relative to `n`.

Both are usually expressed using asymptotic notation, focusing on growth rate rather than exact values, and are typically evaluated for best, average, and worst cases.

**Example:** A function that creates a copy of an input array has O(n) space complexity, while an in-place sorting algorithm like bubble sort has O(1) additional space but O(n²) time complexity.

---

## e. Order of Algorithms

The "order" of an algorithm describes its growth rate using asymptotic notation, primarily **Big-O (O)**, which represents the upper bound of growth. Related notations include **Big-Omega (Ω)** for lower bound and **Big-Theta (Θ)** for tight bound. Algorithms are classified into orders such as constant, logarithmic, linear, linearithmic, quadratic, and exponential.

**Example:** Common orders ranked from fastest to slowest growth: O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ).

---

## f. Measurement Techniques of Algorithms

There are two main approaches to measuring algorithm performance:

1. **Empirical (experimental) measurement:** running the algorithm and recording actual execution time or memory usage.
2. **Analytical measurement:** mathematically studying the algorithm's structure (loops, recursion, operations) to derive its complexity without running it.

Empirical results depend on hardware and environment, while analytical results are more general and portable.

**Example:** Timing a sorting function with `time.time()` in Python (empirical) versus counting the number of comparisons in its pseudocode to derive O(n log n) (analytical).

---

## g. Analytical Measurement

Analytical measurement studies an algorithm's pseudocode or structure directly, counting basic operations (comparisons, assignments, loop iterations) as functions of `n`. It typically involves identifying the dominant term as `n` approaches infinity and expressing it in asymptotic notation. This method does not require executing the code and yields results independent of hardware or implementation.

**Example:** For a single loop that runs from 1 to `n`, the number of iterations is exactly `n`, so the analytical complexity is O(n), regardless of the machine running it.

---

# Best Case, Average Case, Worst Case, Asymptotic Notation, and Big-O Calculation

## h. Best Case, Average Case, and Worst Case

These describe how an algorithm performs under different input conditions:

- **Best case:** the minimum time/resources an algorithm needs, occurring under the most favorable input.
- **Average case:** the expected time over all possible inputs, usually assuming a probability distribution.
- **Worst case:** the maximum time an algorithm can take, occurring under the least favorable input. It is the most commonly analyzed case because it guarantees an upper bound on performance.

**Example:** Linear search for a value `x` in an array of `n` elements:
- Best case: `x` is the first element → O(1).
- Average case: `x` is somewhere in the middle → O(n/2), simplified to O(n).
- Worst case: `x` is the last element or not present → O(n).

---

## i. Families: Big O, Omega, Theta, and Little o

These are asymptotic notations used to describe the growth rate of an algorithm's complexity:

- **Big O (O):** upper bound — the algorithm never grows faster than this rate ("at most").
- **Omega (Ω):** lower bound — the algorithm never grows slower than this rate ("at least").
- **Theta (Θ):** tight bound — the algorithm grows exactly at this rate (both upper and lower bounds match).
- **Little o (o):** strict upper bound — the algorithm grows strictly slower than this rate (never equal, only smaller).

Together they allow precise or approximate descriptions of an algorithm's efficiency depending on how much certainty is available.

**Example:** For an algorithm with complexity `f(n) = 3n² + 2n`:
- O(n²) — upper bound (correct and tight).
- Ω(n²) — lower bound (correct and tight).
- Θ(n²) — exact bound (since both O and Ω match).
- o(n³) — strictly slower than n³ (true, since n² < n³ for large n).

---

## j. Calculating Big-O Functions

To calculate the Big-O of an algorithm, follow these general steps:

1. Identify the basic operations (comparisons, assignments) inside loops or recursive calls.
2. Count how many times each operation executes as a function of `n`.
3. Add up the counts to get a total function `f(n)`.
4. Keep only the **dominant term** (the one that grows fastest as `n → ∞`).
5. Drop constants and lower-order terms, since Big-O describes growth trend, not exact value.

**Example:**
```
for i = 1 to n:        // runs n times
    for j = 1 to n:     // runs n times for each i
        print(i, j)     // constant time operation
```
Total operations = n × n = n². Dropping constants (if any), the complexity is **O(n²)**.

Another example: `f(n) = 5n² + 3n + 10` → dominant term is `5n²` → drop constant 5 and lower-order terms → **O(n²)**.

---

## Empirical measurement

# Empirical Algorithm Measurement

Empirical algorithm measurement is the process of evaluating an algorithm by **executing it on a computer and measuring its actual execution time**. Instead of analyzing the theoretical growth of the algorithm (such as Big O), this method records timestamps immediately before and after the algorithm runs and calculates the elapsed time.

The measured time depends on several factors, including the input size, processor speed, available memory, operating system, compiler or interpreter optimizations, and the current workload of the computer. For this reason, empirical measurements are useful for comparing implementations on the same environment, while theoretical analysis allows comparison independently of the hardware.

---

## Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them whenever they are in the wrong order. After each pass, the largest unsorted element moves to its correct position at the end of the array.


### Measuring Execution Time

```typescript
function bubbleSort(numbers: number[]): void {
    for (let i = 0; i < numbers.length - 1; i++) {
        for (let j = 0; j < numbers.length - i - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                const temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }
}

const values = [8, 5, 2, 9, 1, 4, 7, 3, 6];

const startTime = performance.now();

bubbleSort(values);

const endTime = performance.now();

console.log(`Execution time: ${endTime - startTime} ms`);
```


```java
public class BubbleSortExample {

    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] values = {8, 5, 2, 9, 1, 4, 7, 3, 6};

        long startTime = System.nanoTime();

        bubbleSort(values);

        long endTime = System.nanoTime();

        double elapsedMilliseconds = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution time: " + elapsedMilliseconds + " ms");
    }
}
```

Measure the time of the following algorithm:

```python
function linearSearch(numbers: number[], target: number): number {
    for (let i = 0; i < numbers.length; i++) {
        if (numbers[i] === target) {
            return i;
        }
    }

    return -1;
}

const numbers: number[] = [];

for (let i = 1; i <= 10000; i++) {
    numbers.push(i);
}

linearSearch(numbers, 75);

linearSearch(numbers, 5000);

linearSearch(numbers, 10000);
```



## Analytical method 

### Counting rules
0. Determine what is the size of the problem N, the input size, what is the size the drives the algorithm --> N 

1. Aritmetic operations count as 1 time, except the division and module / % which count as 2 times.  

2. Calling a function or method count as 2 times the call, and 1 time per parameter passed 

3. IF/SWITCH, count the condition time plus the MAX(true section, false section) 

4. Bucles for, while, do while, count the times it interates in function to the size of the problem  

5. Nested bucles, count the iterations size in functions of N of each bucle, then multiple them all 

6. Reductions of N, when the N size is reduce by K on each iteration for example N, N/K, N/K/K, N/K/K/K then the growth rate is log_k(n)

Let's procceed with some examples:

```
function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

function calculate(x, y, z) {
    let sum = add(x, y);
    let result = multiply(sum, z);
    return result;
}
```

```
function sumArray(numbers) {
    let total = 0;

    for (let i = 0; i < numbers.length; i++) {
        total += numbers[i];
    }

    return total;
}
```

```
function countEven(numbers) {
    let count = 0;

    for (let i = 0; i < numbers.length; i++) {
        if (numbers[i] % 2 === 0) {
            count++;
        }
    }

    return count;
}
```

```
function findValue(numbers, target) {
    let i = 0;

    while (i < numbers.length) {
        if (numbers[i] === target) {
            return i;
        }
        i++;
    }

    return -1;
}
```

```
function countEqualPairs(numbers) {
    let matches = 0;

    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (numbers[i] === numbers[j]) {
                matches++;
            }
        }
    }

    return matches;
}
```

```
function compareWithSteps(numbers) {
    let count = 0;

    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j += 2) {
            if (numbers[i] > numbers[j]) {
                count++;
            }
        }
    }

    return count;
}
```

```
function compareThreeArrays(arrayA, arrayB) {
    let total = 0;

    for (let i = 0; i < arrayA.length; i++) {
        for (let j = 0; j < arrayA.length; j++) {
            for (let k = 0; k < arrayB.length; k++) {
                if (arrayA[i] + arrayA[j] === arrayB[k]) {
                    total++;
                }
            }
        }
    }

    return total;
}
```
