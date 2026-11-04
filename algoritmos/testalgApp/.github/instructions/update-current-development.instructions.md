---
applyTo: "specs/**/*.md"
description: "Scans the implemented code and refreshes the data-structures, algorithms, and testing instruction maps, in the language the project guidelines name"
---
# Update current development

Scan the code that already exists. Update three map files under `.github/instructions/` so they reflect the current project state: `data-structures`, `algorithms`, and `testing`.

## Scan

Read `.github/copilot-instructions.md` at the repository root for the language, source layout, and test layout. If the project stores that guidance under `.github/instructions/`, read those instruction files too. If neither exists, infer the language and layout from the repository and say that the guidelines file was missing.

Scan the source and test directories the guidelines name, for the file types of the project's language (or languages). Ignore other languages. Also read the build or dependency file when present.

Skip dependencies, build output, caches, and vendored code, such as `build`, `out`, `bin`, `target`, `dist`, `node_modules`, `.venv`, `__pycache__`, `.idea`, `.vs`, `.git`, and compiled artifacts.

For each feature folder or module, record:

- **Data structures** — each class, struct, record, or type definition with its purpose, its path, its fields with types, its invariant, and its public operations with parameters, return type, and cost.
- **Algorithms** — each key function: signature, the problem it solves, the strategy in one line, time and space complexity, the data structures it uses, and the path. Skip miscellaneous helpers (parsing, printing, swaps, the entrypoint).
- **Tests** — each test file, what it covers, and the command that builds and runs it. Also the spec id (`ft-N`) the code came from when a `specs/ft-N-*.md` file names it.

Do not list private or internal members.

## Write the instructions

Write all three files, including one that has no code yet. Keep each file short, one line per item, and specific to the repository. Write signatures in the project's language.

- `.github/instructions/data-structures.instructions.md` — lists each structure under `## Structures` with its fields, invariant, and operations.
- `.github/instructions/algorithms.instructions.md` — lists `## Implemented`, `## Entrypoints`, and `## Functions` (signature, strategy, complexity, structures used, path).
- `.github/instructions/testing.instructions.md` — lists `## Test files` and `## Commands`.

Each file starts with frontmatter holding a `description` and an `applyTo` glob that matches the source directories (or the test directories, for `testing`) the guidelines name. Then comes the line `After you change this area, update this file so the next run stays current.`, then the items. Include a heading only when there are items for it. If the area has no code, write `Nothing implemented.` and list no paths.

## Commit

Commit the `.github/instructions/` folder so teammates get the same guidance with the repo. Stage only that folder. Do not push. If there is nothing new to commit, say so.
