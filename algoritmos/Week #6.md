# BACKTRACKING ALGORITHMS

## Description

Backtracking is a systematic search algorithm that explores the solution space by building partial solutions incrementally. When a partial solution cannot lead to a valid complete solution, the algorithm "backtracks" by removing the last element and trying a different alternative. It essentially performs an exhaustive search through all possible combinations of decisions, abandoning branches that cannot yield a solution.

**What it searches for:** A complete solution that satisfies all constraints by exploring all possible candidate solutions systematically.

## Requirements for Backtracking Algorithms

1. **Solution Vector**: A vector (V₁, V₂, ..., Vₘ) that represents a potential solution, initially empty.
2. **Constraint Validation**: A function to determine if a partial solution can be extended further (feasibility check).
3. **Completeness Check**: A function that identifies when a complete valid solution has been found.
4. **Backtrack Capability**: The ability to undo decisions and explore alternative paths when a dead end is reached.
5. **Systematic Exploration**: Exhaustive enumeration of the solution space without missing any viable paths.

## Java Example: N-Queens Problem

```java
public class NQueens {
    private int[] board;
    private int n;
    
    public NQueens(int n) {
        this.n = n;
        this.board = new int[n]; // board[i] = column position of queen at row i
    }
    
    public void solve() {
        backtrack(0);
    }
    
    private void backtrack(int row) {
        if (row == n) {
            printSolution();
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col; // Place queen
                backtrack(row + 1);
                // Implicit backtrack: move to next column in for loop
            }
        }
    }
    
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || // Same column
                Math.abs(board[i] - col) == Math.abs(i - row)) { // Same diagonal
                return false;
            }
        }
        return true;
    }
    
    private void printSolution() {
        for (int i = 0; i < n; i++) {
            System.out.println("Queen at Row " + i + " Column " + board[i]);
        }
        System.out.println("---");
    }
}
```

## Python Example: Permutation Generation

```python
def generate_permutations(elements):
    """Generate all permutations using backtracking"""
    result = []
    
    def backtrack(current_perm, remaining):
        if not remaining:
            result.append(current_perm[:])
            return
        
        for i in range(len(remaining)):
            # Choose
            current_perm.append(remaining[i])
            
            # Explore
            new_remaining = remaining[:i] + remaining[i+1:]
            backtrack(current_perm, new_remaining)
            
            # Unchoose (backtrack)
            current_perm.pop()
    
    backtrack([], elements)
    return result

# Usage
perms = generate_permutations([1, 2, 3])
for perm in perms:
    print(perm)
```

## Real-World Problems Solved with Backtracking

- **Traveling Salesman Problem (TSP)**: Finding the shortest route that visits every city exactly once and returns to the starting city. Critical for logistics optimization and delivery route planning.
- **Sudoku Puzzle Solver**: Filling a 9×9 grid with digits 1-9 such that each row, column, and 3×3 sub-grid contains each digit exactly once. Widely used in constraint satisfaction systems.
- **Maze Navigation**: Finding a path from entrance to exit in a maze by exploring possible routes and backtracking when hitting dead ends. Used in robotics and game AI.

## Common Mistakes When Implementing Backtracking Algorithms

- **Not properly resetting state**: Failing to undo/restore changes when backtracking, causing incorrect state propagation to subsequent recursive calls.
- **Missing or incorrect base case**: Without proper termination conditions, the algorithm may never return or explore infinite paths.
- **Inefficient constraint checking**: Performing expensive validation checks repeatedly instead of maintaining incremental constraint tracking.
- **Not pruning early enough**: Continuing exploration in branches that obviously cannot lead to valid solutions, wasting computational resources.
- **Redundant explorations**: Revisiting the same partial solution states multiple times due to lack of memoization or proper ordering.
- **Forgetting to remove elements from solution**: Failing to pop/remove the last added element before trying the next candidate in the loop.

---

# GREEDY ALGORITHMS

## Algorithm Description

A greedy algorithm makes locally optimal choices at each step with the hope of finding a global optimum solution. At every stage of the algorithm, it selects the candidate that appears to be the most promising without considering the consequences of future choices. The core strategy is "take the best you can get right now."

**What it searches for:** A solution by making a series of greedy choices, selecting the locally best option at each step.

### Requirements for Greedy Algorithms

1. **Candidate Set**: A collection of candidates to choose from (tasks, graph vertices, coins, etc.).
2. **Selection Function**: A function that identifies the most promising remaining candidate based on a greedy criterion.
3. **Feasibility Function**: A function to determine if adding a candidate maintains the feasibility of the solution.
4. **Solution Check Function**: A function that verifies whether the current set of selected candidates forms a complete solution.
5. **Completability Function**: A function to check if a current partial selection can possibly lead to a valid solution.
6. **Objective Function**: A function that assigns a value/cost to a solution, which the algorithm aims to optimize (minimize or maximize).

### Requirements for Greedy Algorithm to Guarantee Optimality

- **Greedy Choice Property**: A globally optimal solution can be arrived at by making locally optimal (greedy) choices.
- **Optimal Substructure**: An optimal solution contains optimal solutions to subproblems; solving a subproblem optimally after a greedy choice yields an optimal overall solution.

### Java Example: Activity Selection Problem

```java
import java.util.*;

public class ActivitySelection {
    static class Activity {
        int start;
        int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static List<Activity> selectActivities(Activity[] activities) {
        // Sort by end time (greedy criterion)
        Arrays.sort(activities, (a, b) -> Integer.compare(a.end, b.end));
        
        List<Activity> selected = new ArrayList<>();
        selected.add(activities[0]); // Always select first activity
        
        int lastEndTime = activities[0].end;
        
        // Greedily select activities that don't overlap
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEndTime) {
                selected.add(activities[i]);
                lastEndTime = activities[i].end;
            }
        }
        
        return selected;
    }
    
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 5),
            new Activity(4, 6),
            new Activity(6, 9),
            new Activity(5, 7)
        };
        
        List<Activity> result = selectActivities(activities);
        System.out.println("Maximum activities: " + result.size());
        for (Activity a : result) {
            System.out.println("Activity: " + a.start + " - " + a.end);
        }
    }
}
```

### Python Example: Huffman Coding Algorithm

```python
import heapq
from collections import defaultdict, Counter

class HuffmanNode:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None
    
    def __lt__(self, other):
        return self.freq < other.freq

def huffman_encoding(text):
    """Build Huffman tree using greedy algorithm"""
    # Count character frequencies
    freq_map = Counter(text)
    
    # Create a min-heap with leaf nodes
    heap = [HuffmanNode(char, freq) for char, freq in freq_map.items()]
    heapq.heapify(heap)
    
    # Build tree by repeatedly combining two smallest frequency nodes
    while len(heap) > 1:
        node1 = heapq.heappop(heap)
        node2 = heapq.heappop(heap)
        
        # Create parent node with combined frequency
        parent = HuffmanNode(None, node1.freq + node2.freq)
        parent.left = node1
        parent.right = node2
        
        heapq.heappush(heap, parent)
    
    root = heap[0]
    
    # Generate codes
    codes = {}
    def generate_codes(node, code):
        if node.char is not None:
            codes[node.char] = code if code else '0'
        else:
            if node.left:
                generate_codes(node.left, code + '0')
            if node.right:
                generate_codes(node.right, code + '1')
    
    generate_codes(root, '')
    return codes

# Usage
text = "hello world"
codes = huffman_encoding(text)
for char, code in sorted(codes.items()):
    print(f"'{char}': {code}")
```

### Real-World Problems Solved with Greedy Algorithms

- **Coin Change Problem**: Given denominations of coins, finding the minimum number of coins needed to make a specific amount. Essential for vending machines, payment systems, and financial applications.
- **Huffman Data Compression**: Creating optimal variable-length binary codes for characters based on their frequency. Achieves 25-60% compression and is fundamental in ZIP, JPEG, and MP3 formats.
- **Minimum Spanning Tree (MST)**: Finding the subset of edges that connects all vertices with minimum total weight. Critical in network design, telecommunications infrastructure, and power grid optimization.

### Common Mistakes When Implementing Greedy Algorithms

- **Assuming greedy always finds optimal solution**: Greedy algorithms don't guarantee global optimality for all problems; the problem must satisfy the greedy choice property and optimal substructure.
- **Poor greedy criterion selection**: Choosing the wrong "locally best" metric leads to suboptimal or incorrect solutions (e.g., selecting by start time instead of end time in activity selection).
- **Not validating feasibility**: Adding candidates without checking if they maintain solution feasibility or violate constraints.
- **Ignoring problem structure**: Applying greedy without understanding whether the problem actually admits a greedy solution.
- **Incorrect sorting or ordering**: Using wrong sort criteria that don't align with the greedy strategy, breaking the algorithm's correctness.
- **Not handling edge cases**: Failing to address empty inputs, single elements, or impossible constraints that might cause unexpected behavior.
