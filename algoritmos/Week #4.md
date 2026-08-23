# Week 4 — Divide and Conquer & Dynamic Programming

# 1. Divide and Conquer

**Divide and conquer** is a recursive algorithm design paradigm in which a problem of size *n* is broken down into *a* independent (or mostly independent) subproblems, each of size approximately *n/b*, where *a* ≥ 1 and *b* > 1. Each subproblem is solved recursively until it reaches a **base case** (a trivial instance that can be solved directly). The solutions of the subproblems are then **combined** to produce the solution to the original problem.

Formally, the recurrence relation for the running time *T(n)* is:

```
T(n) = a · T(n/b) + f(n)
```

where *f(n)* is the cost of dividing the problem and combining the subproblem results. Using the Master Theorem, when *a* ≥ 1 and *b* > 1:

| Condition | Time complexity |
|-----------|-----------------|
| *a* > b^k* | O(n^log_b(a)) |
| *a* = b^k* | O(n^k · log n) |
| *a* < b^k* | O(n^k) |

where *f(n)* = O(n^k).

---
Imagine a professor receives 1,000 unsorted exam papers and needs to arrange them alphabetically by student name. Instead of sorting all 1,000 at once (slow and overwhelming), the professor:

1. **Divides** the stack into two piles of 500 papers each.
2. **Conquers** by handing each pile to a teaching assistant to sort independently.
3. **Combines** the two sorted piles by merging them into one final sorted stack.

If a pile is still too large, each assistant repeats the same process: split, sort, merge — until a pile is small enough (say, 3 papers) to sort by hand in seconds.

This is exactly how **merge sort** works. The professor never re-sorts papers that are already in order; each subproblem is solved independently, and only at the end are the partial results merged. The time saved is dramatic: sorting 1,000 items with a naive method might require ~1,000,000 comparisons, while divide and conquer reduces this to roughly 10,000.

An algorithm qualifies as **divide and conquer** when it satisfies all of the following:

1. **Decomposability** — The original problem can be split into smaller subproblems of the same type and similar structure.
2. **Independence** — Subproblems can be solved separately; solving one does not require the result of another (unlike dynamic programming).
3. **Recursive structure** — The same strategy is applied recursively to each subproblem until a base case is reached.
4. **Base case (threshold)** — There exists a size below which the problem is solved directly without further division (e.g., an array of length 1 is already sorted).
5. **Combine step** — Partial solutions are merged or combined into the final answer (e.g., merging two sorted arrays).
6. **Efficiency gain** — The divide step reduces problem size enough that the total work grows slower than solving the full problem naively (often yielding O(n log n) instead of O(n²)).

---

## Example 1 — Binary Search (Java)

**Problem:** Given a sorted array of integers and a target value, find the index of the target or return -1 if it is not present.

```java
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // base case: not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // base case: found
        } else if (arr[mid] > target) {
            return search(arr, target, left, mid - 1);   // conquer left half
        } else {
            return search(arr, target, mid + 1, right);  // conquer right half
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println(binarySearch(arr, 23)); // Output: 5
        System.out.println(binarySearch(arr, 40)); // Output: -1
    }
}
```

**How it applies divide and conquer:**
- **Divide:** Split the search range into left and right halves at `mid`.
- **Conquer:** Recursively search only the half that could contain the target.
- **Combine:** No explicit combine step — the recursive call returns the answer directly.

## Example 2 — Merge Sort (Python)

**Problem:** Sort an array of integers in ascending order.

```python
def merge_sort(arr):
    if len(arr) <= 1:
        return arr  # base case: trivially sorted

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])       # divide & conquer left half
    right = merge_sort(arr[mid:])      # divide & conquer right half
    return merge(left, right)          # combine


def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result


if __name__ == "__main__":
    data = [38, 27, 43, 3, 9, 82, 10]
    print(merge_sort(data))  # Output: [3, 9, 10, 27, 38, 43, 82]
```

**How it applies divide and conquer:**
- **Divide:** Split the array into two halves.
- **Conquer:** Recursively sort each half.
- **Combine:** Merge the two sorted halves into one sorted array.

# 2. Dynamic Programming

**Dynamic programming (DP)** is an algorithm design technique for optimization problems that can be decomposed into **overlapping subproblems** exhibiting **optimal substructure**. Instead of solving each subproblem independently (as in divide and conquer), DP stores the result of each subproblem — typically in a table or cache — so that each subproblem is solved **at most once**.

A DP solution can be built in two ways:

- **Top-down (memoization):** Recursively define the problem, caching results as they are computed.
- **Bottom-up (tabulation):** Iteratively fill a table from the smallest subproblems up to the full problem.

Formally, if a problem of size *n* has optimal value *OPT(n)* and satisfies optimal substructure, then:

```
OPT(n) = min/max over choices { cost(choice) + OPT(subproblem(choice)) }
```

The **principle of optimality** (Bellman, 1953) states: *An optimal sequence of decisions contains optimal subsequences.* That is, if a path or policy is globally optimal, every portion of it must also be optimal.

**Planning the cheapest road trip:**

You want to drive from City A to City E using the cheapest route through intermediate cities. You could list every possible path (exhaustive search), but that explodes quickly as the map grows.

Instead, you work **stage by stage**:

1. At **Stage 1**, you record the cheapest cost to reach each city one step away from A.

2. At **Stage 2**, you ask: "What is the cheapest way to reach each new city, using the best costs I already know?"

3. You repeat until you reach City E.

You never forget a good partial result — if you already know the cheapest way to reach City C, you reuse that number instead of recalculating it from scratch every time someone asks about routes through C.

This mirrors the **shortest-path example** from the course: traveling from node 1 to node 7 through a network of roads. Stage 1 finds the cheapest distances to nodes 2, 3, and 4 (7 km, 8 km, 5 km). Stage 2 uses those values to compute the cheapest paths to nodes 5 and 6. Stage 3 yields the final answer: 21 km to node 7 via the path 1 → 4 → 5 → 7.

An algorithm qualifies as **dynamic programming** when it satisfies all of the following:

1. **Optimal substructure** — The optimal solution to the full problem is composed of optimal solutions to its subproblems. Min/Max.
2. **Overlapping subproblems** — The same subproblems recur many times; naive recursion would recompute them repeatedly.
3. **Memoization or tabulation** — Results of subproblems are stored (in an array, hash map, or matrix) and reused.
4. **Stage-by-stage decomposition** — The problem can be broken into sequential stages or states, each depending on previously computed results.
5. **Principle of optimality** — Any optimal policy remains optimal regardless of how the earlier stages were reached; optimal partial solutions feed into the next stage.
6. **Optimization goal** — DP is typically used to find a minimum, maximum, or counting solution (shortest path, fewest coins, maximum profit, etc.).
7. **Efficiency over brute force** — Storing and reusing subproblem results reduces exponential or redundant polynomial work to polynomial time.

## Example 1 — Coin Change: Minimum Coins (Java)

**Problem:** Given coin denominations `{1, 4, 6}` and an amount `8`, find the minimum number of coins needed to make that amount. A greedy approach gives 3 coins (6 + 1 + 1), but the optimal answer is 2 coins (4 + 4).

```java
public class CoinChange {

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 6};
        System.out.println(minCoins(coins, 8)); // Output: 2
    }
}
```

**How it applies dynamic programming:**
- **Optimal substructure:** The minimum coins for amount `i` depends on the minimum coins for `i - coin`.
- **Overlapping subproblems:** Amounts like 4 are needed when computing amounts 5, 8, 9, etc.
- **Bottom-up tabulation:** `dp[i]` stores the best answer for each amount from 0 to 8.

## Example 2 — Fibonacci with Memoization (Python)

**Problem:** Compute the *n*-th Fibonacci number efficiently. Naive recursion recalculates the same values many times; memoization solves each subproblem once.

```python
def fibonacci(n, memo=None):
    if memo is None:
        memo = {}

    if n in memo:
        return memo[n]          # reuse stored result

    if n <= 1:
        return n                  # base case

    memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
    return memo[n]


if __name__ == "__main__":
    print(fibonacci(10))   # Output: 55
    print(fibonacci(50))   # Output: 12586269025 (fast, no redundant work)
```

**How it applies dynamic programming:**
- **Optimal substructure:** `F(n) = F(n-1) + F(n-2)`.
- **Overlapping subproblems:** `F(5)` is needed when computing both `F(6)` and `F(7)`.
- **Top-down memoization:** Results are cached in a dictionary as they are computed.

---

