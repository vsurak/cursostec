---
name: develop-feature
description: >-
  Implements an approved feature spec in layer order and reports that
  feature's tests without fixing failures. Use when the user asks to develop
  a feature by id, implement ft-N, or build from specs/.
---

# Develop feature

Implement one feature from its specs. The feature id is required (`ft-4`, or a spec file name that starts with that id). If it is missing, ask for it and stop.

`frontend`, `backend`, `database`, `testing`, and `deploy` are roles, not directory names. Change the source directories named in the spec and in `AGENTS.md`. Write Java only and follow the Java rules.

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

## Project skills

When every file is `approved`, check that `update-current-development` has written these project skills. Each one needs `SKILL.md` and `references/map.md`:

- `.cursor/skills/frontend`
- `.cursor/skills/backend`
- `.cursor/skills/database`
- `.cursor/skills/testing`
- `.cursor/skills/deploy`

If any of those are missing, run `update-current-development` (`.cursor/skills/update-current-development/SKILL.md`) and follow it before you change code. If that skill file is missing, say so and stop.

Read `references/map.md` for each layer this feature changes. Open the files named there.

## Implement

When every file is `approved`, read `AGENTS.md` and those specs. Implement only what they describe.

Work in this order, and only when that role's spec file exists:

1. database
2. backend
3. frontend
4. testing
5. deploy

## Tests

After that work, run the tests this feature created. Use the command in the testing spec or in `AGENTS.md`, otherwise `mvn test` (Maven) or `gradle test` (Gradle). If this feature has no testing spec, say that no feature tests were created.

Report the command, pass or fail, and the failure output. Then update the project skills.

Do not fix failures. Do not edit code because a test failed unless the user asks for a fix. Do not mark the feature `done`.

## Update the project skills

After that report, run `update-current-development` (`.cursor/skills/update-current-development/SKILL.md`) and follow it. That rewrites the layer project skills so they include the code this feature just added.

Do this only after you implemented the feature. Skip it when you stopped earlier. If that skill file is missing, say so.
