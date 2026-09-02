# Case #1 - 25%

## Problem Description

A console server, `PasswordHackServer`, is provided in [src/passwordhack](src/passwordhack). It listens on TCP port 4000, generates a random password, and exchanges JSON messages with any client that connects to it. For this case, the student must build two separate "hacking" programs that each try to guess the password as fast as possible against that server, each one following a different, well-defined algorithmic style: one program must solve the problem using backtracking, with an explicit and justified pruning criterion; the other must solve it using a greedy algorithm, with clearly defined stages and clearly identified local optima at each step. Both programs must run at the same time, against the same server, competing to reach the password first, and both must keep detailed metrics of their own execution as they do so.

This case is designed to evaluate the student's ability to design algorithms that are both efficient and built around a deliberate, well-argued strategy, rather than around trial and error. Because of this, the strategy behind each program — how pruning is decided in the backtracking version, and how local optimality is decided in the greedy version — must be validated with the professor before the student invests significant effort in implementation. The final review will focus as much on whether the student can explain and defend the design and its computational complexity as on whether the programs work.

## What the student must do

1. Design two independent algorithms that attempt to discover the password exposed by `PasswordHackServer`: one following the backtracking paradigm, the other following the greedy paradigm.
2. For the backtracking algorithm, define and justify an explicit pruning criterion: the specific condition under which a partial guess is abandoned before being explored further.
3. For the greedy algorithm, define and justify its stages and the local optimum being chosen at each stage.
4. Validate both proposed strategies with the professor before moving forward with the full implementation.
5. Implement both programs, each in an object-oriented programming language of your choice, so that both can run in parallel against the server.
6. In each program, measure the number of attempts made and the time elapsed to arrive at the correct password.
7. Implement historical tracking across N configured runs (multiple password rounds), for both programs.
8. When either program discovers the password, have it notify the other program so that both save their metrics for that round at that point, including: how far each program got, the total number of iterations performed in each loop, how many of the N elements were traversed on each password attempt, the total number of loops, the total number of elements visited or compared, the total number of passwords attempted, and whether that program's outcome for the round was SUCCEED or inconclusive.
9. After a round ends, have both programs move on to the next password automatically and repeat the process, continuing to run in parallel.
10. Add comments in the code of each program that point to exactly where the requirements of its algorithmic style (backtracking pruning, or greedy stages/local optima) are being satisfied.
11. Document the Big-O complexity and the intended growth rate of each algorithm directly in the code comments, and be ready to explain and justify this analysis during the review.

## Other Aspects

- This is individual work.
- The student must be able to fully explain the code, the strategy, and the algorithm analysis, regardless of whether AI or other assistance was used to help produce them. Failure to do so results in a grade of 0.
- The review will take place in a scheduled appointment with the professor.
- Grading will consider the originality of the strategy implemented within the given algorithm style, and how effectively that strategy helps reach the correct password faster.
- Any suspicion of copying will void the work and result in a grade of 0.
- Any object-oriented programming language may be used.
- Submission must be made via GitHub, in the student's personal repository.
- Final commit deadline: Sunday, September 20, 2026, 8:00 PM.
- The final results report for each run must be an Excel file or Google Sheets document, generated dynamically.
- The Big-O complexity of each algorithm and its designed growth rate will be evaluated; this must be documented in the code comments and the student must be able to explain and support it fully during the review.
