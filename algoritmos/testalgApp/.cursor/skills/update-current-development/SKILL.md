---
name: update-current-development
description: >-
  Scans the implemented code and writes one short project skill for data
  structures, one for algorithms, and one for testing, in whatever language
  the project guidelines name. Use when the user asks to update the current
  development map, refresh the project skills, or inventory what is already
  implemented.
---

# Update current development

Scan the code that already exists. Write three project skills under `.cursor/skills/`: `data-structures`, `algorithms`, and `testing`. Commit that folder so teammates get the same maps.

## Scan

Read `AGENTS.md` at the repository root for the language, source layout, and test layout. If the project stores that guidance under `.cursor/rules/`, read those rules too. If neither exists, infer the language and layout from the repository and say that the guidelines file was missing.

Scan the source and test directories the guidelines name, for the file types of the project's language (or languages). Ignore other languages. Also read the build or dependency file when present.

Skip dependencies, build output, caches, and vendored code, such as `build`, `out`, `bin`, `target`, `dist`, `node_modules`, `.venv`, `__pycache__`, `.idea`, `.vs`, `.git`, and compiled artifacts.

For each feature folder or module, record:

- **Data structures** — each class, struct, record, or type definition with its purpose, its path, its fields with types, its invariant, and its public operations with parameters, return type, and cost.
- **Algorithms** — each key function: signature, the problem it solves, the strategy in one line, time and space complexity, the data structures it uses, and the path. Skip miscellaneous helpers (parsing, printing, swaps, the entrypoint).
- **Tests** — each test file, what it covers, and the command that builds and runs it. Also the spec id (`ft-N`) the code came from when a `specs/ft-N-*.md` file names it.

Do not list private or internal members.

## Write the skills

Write all three skills, including one that has no code yet. Do not add `disable-model-invocation`. With that flag set, the skill loads only when someone types its name, such as `/algorithms`.

Cursor shows the agent only the description. The agent opens the skill when the task is about that topic. Put the inventory in `references/map.md` only. Skills load `references/` only when the instructions point at them, so an algorithm change does not pull in the testing map.

`.cursor/skills/data-structures/SKILL.md`:

```markdown
---
name: data-structures
description: >-
  Map of the implemented data structures, their fields, invariants, and
  operations, and the files to open before editing. Use when adding or
  changing a class, struct, container, or its operations.
---
# Data structures
Before searching the source tree, read `references/map.md`.
Open only the files named there for the structure you are changing.
```

`.cursor/skills/algorithms/SKILL.md`:

```markdown
---
name: algorithms
description: >-
  Map of the implemented algorithms, their signatures, strategy, and
  complexity, and the files to open before editing. Use when adding,
  changing, or reusing an algorithm or one of its methods.
---
# Algorithms
Before searching the source tree, read `references/map.md`.
Open only the files named there for the algorithm you are changing.
```

`.cursor/skills/testing/SKILL.md`:

```markdown
---
name: testing
description: >-
  Map of the implemented tests, what each covers, and the commands that
  build and run them. Use when adding, changing, or running tests.
---
# Testing
Before searching the tests tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

## Maps

Write `.cursor/skills/<skill>/references/map.md` beside each skill. Keep it a short list. One line per item. Write signatures in the project's language.

```markdown
# Algorithms

After you change this area, update this file so the next run stays current.

Source: `<source directory of the feature>`

## Implemented
- ft-4 Two sum on a sorted array: `<path to the implementing file>`

## Entrypoints
- `<path to the entrypoint>`

## Functions
### two_sum_sorted
Finds two indexes whose values add to a target. `<path>`
- `<signature in the project's language>` — two pointers from both ends of the array; O(N) time, O(1) space
- Uses: `<data structures>`
```

For `data-structures`, list each structure under `## Structures` with its fields, invariant, and operations. For `testing`, list `## Test files` and `## Commands`. Replace every example with this repository. Include a heading only when there are items for it. If the area has no code, write `Nothing implemented.` and list no paths.

The line `After you change this area, update this file so the next run stays current.` stays at the top of every map.

## Commit

Commit `.cursor/skills/` so teammates get the same maps with the repo. Stage only that folder. Do not push. If there is nothing new to commit, say so.
