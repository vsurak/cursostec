---
applyTo: "specs/**/*.md"
description: "Implements an approved feature spec in layer order and reports the feature's tests without fixing failing code"
---
# Develop feature

Implement one feature from its specs. The feature id is required (`ft-4`, or a spec file name that starts with that id). If it is missing, ask for it and stop.

`frontend`, `backend`, `database`, `testing`, and `deploy` are roles, not directory names. Change the source directories named in the spec and in `.github/copilot-instructions.md`. Write Java only and follow the Java conventions.

## Find the specs

Collect every `specs/**/ft-<number>-*.md` for that id. If none exist, say the id was not found and stop.

Read `status` in each file's frontmatter. A missing or unknown status counts as `draft`.

## Status

Implement only when every file for that id is `approved`. Do not change `status` yourself.

- **done** — Tell the developer this feature was already implemented. A further change needs a new feature from `generate-feature-spec`. To implement this id again, they mark the files `approved`.
- **ignore** — Tell the developer this feature was marked ignore. A further change needs a new feature. To implement this id again, they mark the files `approved`.
- **draft** — Tell the user a developer must approve the feature before a coding agent implements it. They set `status: approved`.
- **mixed** — Report each file and its status, then stop.

When a file is `done` or `ignore`, also report any file for that id that is still `draft`.

## Project instructions

When every file is `approved`, check that the repository has project guidance for each layer under `.github/instructions/`. Each one should correspond to the role it describes:

- `.github/instructions/frontend.instructions.md`
- `.github/instructions/backend.instructions.md`
- `.github/instructions/database.instructions.md`
- `.github/instructions/testing.instructions.md`
- `.github/instructions/deploy.instructions.md`

If any of those are missing, create or restore them before you change code. If a required instruction file is missing and cannot be created from the existing project guidance, say so and stop.

Read the relevant instructions files for each layer this feature changes. Open the files named there.

## Implement

When every file is `approved`, read `.github/copilot-instructions.md` and those specs. Implement only what they describe.

Work in this order, and only when that role's spec file exists:

1. database
2. backend
3. frontend
4. testing
5. deploy

## Tests

After that work, run the tests this feature created. Use the command in the testing spec or in `.github/copilot-instructions.md`, otherwise `mvn test` (Maven) or `gradle test` (Gradle). If this feature has no testing spec, say that no feature tests were created.

Report the command, pass or fail, and the failure output. Then update the project instructions.

Do not fix failures. Do not edit code because a test failed unless the user asks for a fix. Do not mark the feature `done`.

## Update the project instructions

After that report, refresh the project layer instructions so they match the current codebase. This is the Copilot equivalent of updating a project skill map.

Do this only after you implemented the feature. Skip it when you stopped earlier.
