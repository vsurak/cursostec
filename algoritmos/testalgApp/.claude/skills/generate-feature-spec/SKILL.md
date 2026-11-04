---
name: generate-feature-spec
description: >-
  Writes a draft algorithm spec from a problem description, using CLAUDE.md
  and the project rules for the language and guidelines. The spec fixes the
  problem size N, the data structures, and the step-by-step strategy of each
  key method so a developer can validate the approach before approval. Use
  when the user asks to generate a feature spec, specify an algorithm, or add
  a spec under specs/.
---

# Generate feature spec

Turn one problem description into one spec a coding agent can implement. The spec is where a developer validates the strategy of every algorithm, so it must be concrete about data structures and operations. Mark the file `draft`.

The method is language-independent. Definitions and signatures are written in the project's language, which the project guidelines decide.

## Input

The problem description is required. If the user did not give one, ask for it and stop.

## Read the project

Read `CLAUDE.md` at the repository root. It holds the programming language and the project guidelines. If the project stores that guidance under `.claude/rules/`, read those rules too. Prefer `CLAUDE.md` when both exist. If neither exists, stop and say so. Do not invent a language or stack.

From those guidelines, find:

- the language to use (for example Java, Python, C, or C++) and its version or standard;
- the source layout, file naming, and naming conventions;
- the test framework, the test layout, and the build and test commands.

If the guidelines name more than one language, use the one the description asks for; if it is still unclear, ask. Record the language in the spec as `language: <name>`. Specs name real paths from the guidelines and the repository layout.

## Create the spec tree

At the repository root, create `specs/` if it is missing. Leave existing files in place. Specs are not split by layer: one feature is one file.

## Write the file

Scan `specs/ft-*.md`. The next id is `ft-` plus one more than the highest number already used. The first id is `ft-1`.

File name: `specs/ft-<number>-<slug>.md`

`<slug>` is a few hyphenated words a person can read to know the feature. Example: `specs/ft-4-two-sum-sorted.md`.

````markdown
---
id: ft-4
language: <language from the guidelines>
status: draft
---

# Two sum on a sorted array

## General description

## Problem size (N)

## Data structures

### SortedArray

## Methods

### `two_sum_sorted`

## Test criteria

## Implementation guidelines
````

`status` stays `draft`. Do not set `approved`, `done`, or `ignore`.

Write for a coding agent and for the developer who approves it. Short bullets. No preamble and no restatement of the request.

- **General description** — what the algorithm computes, in two or three lines.
- **Problem size (N)** — for each input:
  - what N counts (elements, vertices, edges, characters, queries);
  - the minimum and maximum values of N, and the value range of the elements (they decide the numeric type and whether overflow is possible in the language);
  - the data structure the input arrives in, written with the language's own types (for example an array, list, adjacency list, string, or map);
  - the time limit or target complexity the strategy must meet. Say whether the chosen strategy fits that maximum N; if it does not, change the strategy before writing the steps.
- **Data structures** — one `###` subsection per structure the algorithms use, including built-in containers, with:
  - the exact definition in the project's language (a class, struct, record, or the container type with its element type), with fields and types;
  - what each field or element holds and the invariant that must stay true (for example "the stack is non-increasing from bottom to top");
  - the operations the algorithms call on it with their cost (for example append O(1) amortized, peek O(1)).
- **Methods** — one `###` subsection per key method. A key method is one that carries the algorithm's logic. Skip miscellaneous methods: input parsing, printing, small getters, swap or index helpers, and the program entrypoint. If one algorithm needs several key methods (for example `build`, `query`, and `update`), write one subsection for each. Each subsection has:
  - **Signature** — the full declaration with parameter and return types in the project's language.
  - **Strategy** — the technique in a single line (two pointers, monotonic stack, binary search on the answer, BFS over an adjacency list, DP over a table) and why it meets the target complexity for the N above.
  - **Input / Output** — which structure it receives and which it returns or mutates, and preconditions.
  - **Complexity** — time and space in terms of N.
  - **Steps** — a numbered list of every step the method performs. Each step names the structure it touches and the exact operation, and states the effect or the invariant afterwards. Include the initialization of each structure, the loop and its bounds, the condition checked at each iteration, the update applied to each structure, the termination condition, and what is returned. Write `Step 3: while the stack is not empty and a[stack.top] > a[i], pop the stack and set result[popped] = i`, not `process the elements`. A developer must be able to hand-trace an example through the steps.
- **Test criteria** — observable pass or fail conditions: concrete input and expected output pairs, edge cases (empty, N = 1, N at its maximum, duplicates, boundary values), and the complexity check at maximum N.
- **Implementation guidelines** — the language and rules from `CLAUDE.md` and the project rules that bind this feature, the files to create (source, entrypoint, and tests, named by the project's layout and naming), and the build and test command. Do not paste `CLAUDE.md`.

## Done

List the file written. A developer reviews the data structures and the steps of each method, then sets `status: approved` before `develop-feature` will implement it.
