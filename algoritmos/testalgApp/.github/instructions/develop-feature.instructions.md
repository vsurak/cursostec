---
applyTo: "specs/**/*.md"
description: "Implements an approved algorithm spec exactly as written, in the project language, and reports the feature tests without fixing failures"
---

# Develop feature

Implement one feature from its spec. The feature id is required (`ft-4`, or a spec file name that starts with that id). If it is missing, ask for it and stop.

The language comes from the project guidelines. Read `.github/copilot-instructions.md` and `.github/instructions/`, write only the spec's `language`, and follow that language's conventions and testing rules. If the spec's language is not covered by the guidelines, say so and stop.

## Find the spec

Collect every `specs/ft-<number>-*.md` for that id. If none exist, say the id was not found and stop.

Read `status` in the file's frontmatter. A missing or unknown status counts as `draft`.

## Status

Implement only when every file for that id is `approved`. Do not change `status` yourself.

- **done** — Tell the developer this feature was already implemented. A further change needs a new feature from `generate-feature-spec`. To implement this id again, they mark the file `approved`.
- **ignore** — Tell the developer this feature was marked ignore. A further change needs a new feature. To implement this id again, they mark the file `approved`.
- **draft** — Tell the user a developer must approve the feature before a coding agent implements it. They set `status: approved`.
- **mixed** — Report each file and its status, then stop.

When a file is `done` or `ignore`, also report any file for that id that is still `draft`.

## Project instructions

When the spec is `approved`, check that the repository has these project maps under `.github/instructions/`:

- `.github/instructions/data-structures.instructions.md`
- `.github/instructions/algorithms.instructions.md`
- `.github/instructions/testing.instructions.md`

If any of those are missing, run `update-current-development` (`.github/instructions/update-current-development.instructions.md`) and follow it before you change code. If that file is missing, say so and stop.

Read the `data-structures` and `algorithms` maps. Reuse an existing structure or function instead of writing a second one. Open the files named there that the spec touches.

## Implement

Read `.github/copilot-instructions.md`, the project instructions, and the spec. Implement only what the spec describes, in the layout and naming the guidelines require.

Work in this order:

1. **Data structures** — write each structure from the spec's `Data structures` section with the fields, types, and invariants given there, and the operations the methods call.
2. **Methods** — for each `###` section in `Methods`, in the order they appear, write the function with the spec's signature. Follow its numbered steps in order, using the structures and operations each step names. Keep the stated complexity.
3. **Entrypoint** — write the program entrypoint to read the input in the shape given in `Problem size (N)`, call the methods, and print the result.
4. **Tests** — write the tests for the `Test criteria`, following the project's testing rules.

Do not replace the spec's strategy with a different one, and do not add a structure the spec does not list. If a step cannot be implemented as written (it contradicts the invariant, cannot meet the complexity at the maximum N, or names an operation the structure lacks), stop, report the step and the reason, and let the developer revise the spec. Do not work around it silently.

## Tests

After that work, build and run the tests this feature created. Use the command in the spec's `Implementation guidelines` or in `.github/copilot-instructions.md`. If neither gives one, say so instead of guessing. If the spec lists no test criteria, say that no feature tests were created.

Report the command, pass or fail, and the failure output. Then update the project instructions.

Do not fix failures. Do not edit code because a test failed unless the user asks for a fix. Do not mark the feature `done`.

## Update the project instructions

After that report, run `update-current-development` (`.github/instructions/update-current-development.instructions.md`) and follow it. That rewrites the project maps so they include the code this feature just added.

Do this only after you implemented the feature. Skip it when you stopped earlier. If that file is missing, say so.
