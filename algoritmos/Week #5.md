# Practice: Divide and Conquer / Dynamic Programming

## Trends

### Context

Following a trend is difficult because of the speed at which values change and the timing of observation. A trend is not an average computed over a window of time; it is the behavior of a variable as it rises or falls. Real-world producers of such values can change at very different rates — a cryptocurrency price might update one to three times per second, while a stock ticker could update up to a thousand times per second. When a system needs to both generate values at high frequency and observe them at a much slower, configurable pace, the design must reconcile these two independent rates without losing information about how the value behaved between observations. This is the kind of problem where a divide and conquer strategy is appropriate, since the stream of produced values can be split into independent sub-ranges that are summarized separately and then combined into a final representative result.

### What the student must do

1. Design a producer that generates floating-point trend values continuously, at a configurable maximum production rate (up to 100 values per second).
2. Design an observer that reports the state of the trend at a configurable interval of X seconds, independent of the producer's rate.
3. Define what information the observer must report at each interval: whether the trend went up or down since the last report, and a single representative value for that interval.
4. Write the step-by-step algorithm design (in pseudocode or written specification) that generates the trend values and summarizes them for observation, applying a divide and conquer approach.
5. Make sure your step-by-step description is specific enough that it could be handed directly to an AI to generate working code in any programming language.
6. Verify that your design satisfies the properties/requirements of a divide and conquer algorithm covered in Week #4.
7. Once you have generated the code from your design, add comments in the code that point to the exact location where each divide and conquer requirement is satisfied.
8. Build a UI that displays statistics of the generated trends and follows the trend visually with a chart. This part does not need to be planned step-by-step; it can be generated directly through prompting once the producer/consumer with divide and conquer is working.
9. Prepare to present your strategy and final solution to your classmates at the end of class.

## Clusters

### Context

Dynamic programming is well suited to problems where a solution can be built incrementally from overlapping subproblems, reusing previously computed state rather than recomputing it from scratch. Clustering values that arrive over time is one such problem: a cluster is a group of values that are close to each other. For example, the values 1.4, 7.6, and 34.2 could be considered three separate clusters of one member each. If 33.1 is then added, there would still be three clusters, but the last one would now contain two members: 33.1 and 34.2. If 28.8 appears next, it might form a new cluster or join the existing one made of 33.1 and 34.2 — this depends on the magnitude of the distances between values and how those magnitudes are configured. These magnitudes must be dynamic: a value could move from one cluster to another over time. If the distance threshold were fixed, a value could end up appearing to belong to two clusters simultaneously, which would be an inconsistent result.

### What the student must do

1. Reuse the trend generator built in the Trends exercise as the source of values for this exercise.
2. Design a consumer that uses dynamic programming to group incoming trend values into clusters, where a cluster is defined as a set of values that are close to one another.
3. Define how the notion of "closeness" is represented and how it can change dynamically over time, such that a value may move between clusters as new values arrive.
4. Design the algorithm so that, given a sample size and sampling rate, it can report: the number of clusters currently in existence, how many items belong to each cluster, and the distance/magnitude that groups the members of each cluster together.
5. Write the step-by-step algorithm design (in pseudocode or written specification) with enough detail that it could be handed directly to an AI to generate working code in a specific programming language.
6. Verify that your design satisfies the properties/requirements of a dynamic programming algorithm.
7. Once the code has been generated in a specific language, add comments in the code that point to the exact location where each dynamic programming requirement is satisfied.


