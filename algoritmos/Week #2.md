# Algorithm Analysis - Analytical method

This week's goal: given each algorithm, **count the basic operations** as a function of `n`,
build the summation/recurrence, and confirm it matches the stated Big O.

---

## O(log₂ n) — divide the input in half each step

### 1. Binary Search

```java
public static int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;   // 3   
    int steps = 0; // count how many times the loop runs //1

    while (low <= high) {  // 1
        steps++;  // 2 
        int mid = (low + high) / 2; // 4

        if (arr[mid] == target) {  // 2 
            System.out.println("Found at index " + mid + " in " + steps + " steps"); // 7
            return mid; // 3
        } else if (arr[mid] < target) {  // 2
            low = mid + 1; // 2
        } else {
            high = mid - 1; // 2
        }
    }
    System.out.println("Not found, " + steps + " steps");  // 5
    return -1; // 3 
    // f(n) = 3+1+3+5+ 17 log_2 n 
    // f(n) = 17 log_2 n + 12
    // O(log_2 n)
}
```

**Why O(log₂ n):** each iteration discards half of the remaining elements.
After `k` steps, the search space is `n / 2^k`. The loop ends when `n / 2^k = 1`,
so `k = log₂ n`.

### 2. Counting Bits (halve the number until it reaches 0)

```java
public static int countBitsByHalving(int n) {
    int count = 0;
    while (n > 0) {
        n = n / 2;   // integer division by 2, same as a right shift
        count++;
    }
    return count;
}
```

**Why O(log₂ n):** `n` is divided by 2 every iteration, so the loop runs
`log₂ n` times before `n` reaches 0 (this is exactly the number of bits needed to
represent `n`).

---

## O(log₃ n) — divide the input by three each step

### 3. Ternary Search (find a value in a sorted array by splitting into 3 parts)

```java
public static int ternarySearch(int[] arr, int low, int high, int target) {
    if (low > high) return -1;  // 4

    int mid1 = low + (high - low) / 3; // 5
    int mid2 = high - (high - low) / 3; // 5

    if (arr[mid1] == target) return mid1; // 5 
    if (arr[mid2] == target) return mid2; // 5

    if (target < arr[mid1]) {  // 2
        return ternarySearch(arr, low, mid1 - 1, target); // 10 
    } else if (target > arr[mid2]) { // 2
        return ternarySearch(arr, mid2 + 1, high, target); // 10 
    } else {
        return ternarySearch(arr, mid1 + 1, mid2 - 1, target); // 11
    }

    // f(n) = 4+5+5+5+5+2+11 
    // f(n) = O(c) X falso
    // iteracion #1 , size = n
    // iteracion #2 , size = n/3
    // iteracion #3 , size = n / 9
    // por tanto es f(n) = 37 log_3 n => O(log_3 n)
}
```

**Why O(log₃ n):** every call throws away roughly two thirds of the array,
keeping only one third. The recurrence is `T(n) = T(n/3) + O(1)`, which solves to
`O(log₃ n)`.

### 4. Counting Digits in Base 3

```java
public static int countDigitsBase3(int n) {
    int digits = 0;
    while (n > 0) {
        n = n / 3;   // divide by 3 each time
        digits++;
    }
    return digits;
}
```

**Why O(log₃ n):** `n` shrinks by a factor of 3 each iteration, so the loop runs
`log₃ n` times before reaching 0.

---

## O(n log n) — do a linear amount of "divide in half" work

### 5. Merge Sort

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;

    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);       // sort left half
    mergeSort(arr, mid + 1, right);  // sort right half
    merge(arr, left, mid, right);    // merge, O(n) work
}

private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
    }
    while (i <= mid)  temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    System.arraycopy(temp, 0, arr, left, temp.length);
}
```

**Why O(n log n):** the array is split in half `log₂ n` times (the recursion depth),
and at every level the `merge` step touches all `n` elements. Total work =
`n` (elements per level) `× log₂ n` (number of levels).

### 6. Binary Search Inside a Loop (build a sorted list by inserting n items)

```java
public static void insertAllWithBinarySearch(int[] source) {
    int[] sorted = new int[source.length];
    int size = 0;

    for (int value : source) {          // n iterations
        int pos = findInsertPosition(sorted, size, value); // O(log n) each
        for (int i = size; i > pos; i--) {
            sorted[i] = sorted[i - 1];   // shifting is not counted for THIS analysis,
        }                                 // we focus on the search cost only
        sorted[pos] = value;
        size++;
    }
}

private static int findInsertPosition(int[] sorted, int size, int value) {
    int low = 0, high = size - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (sorted[mid] < value) low = mid + 1;
        else high = mid - 1;
    }
    return low;
}
```

**Why O(n log n):** the outer loop runs `n` times, and for each of those runs we do a
binary search that costs `O(log n)`. Total = `n × log n`.

---

## O(xⁿ) — exponential growth

### 7. Naive Recursive Fibonacci (O(2ⁿ))

```java
public static long fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

**Why O(2ⁿ):** each call spawns 2 more calls (except at the base cases), forming a
binary call tree of depth `n`. The recurrence is `T(n) = T(n-1) + T(n-2) + O(1)`,
which grows proportionally to `2ⁿ` (a looser but common way to state its exponential class).

---

## Excercises 

For the following exercises, design a solution algorithm aiming to obtain a solution with a complexity below **O(n³)**. After designing the algorithm in pseudocode, calculate its **polynomial** and **Big O complexity**.


1. **Maximum Subarray Sum**

   Given an array of integers, determine the subarray containing at least one element that has the maximum possible sum. Provide both a **linear-time solution** and a **logarithmic-time solution**.

   public sumSubArray(int values[], int sum) {
     // encontrar si existe el sub arreglo mas grande 
     // que sumando sus numeros se obtenga sum 
     // | 4 | 3 | 2 | 8 | 7 | 10 | 15 | 1 | , sum = 15
     // subarray [3-4] posicion 3 y 4
   }

2. **Range Classification**

   Given a list of integers and a list of ranges in the form `{{100…400}, {401…1000}, {20…99}, {3000…6000}}`, classify the numbers according to the range to which they belong. Numbers that do not fall within any of the specified ranges should be placed in a **residual list**.

3. **Concentric Circles**

   Given an unordered list of circles, where each circle is defined by its **radius** and its **center coordinates (X, Y)**, generate a list of circles such that they form **concentric circles**, with no repetitions. Circles sharing the same center must be separated by at least **3 radius units** and must not overlap. Additionally, the concentric circles associated with different centers must not overlap each other.

4. **Minimum-Cost Chocolate Bar Cutting**

   Given a chocolate bar consisting of **N × M pieces**, where each piece is 1 × 1, determine the minimum cost required to cut the chocolate bar into individual pieces, given that each cut has an associated cost.

   Let `x₁, x₂, …, xₘ` represent the costs of making the **vertical cuts**, and `y₁, y₂, …, yₙ` represent the costs of making the **horizontal cuts**.

   For example, if all horizontal cuts are made first, followed by all vertical cuts, the total cost would be:

   `y₁ + y₂ + … + yₙ₋₁ + N(x₁ + x₂ + … + xₘ₋₁)`.

