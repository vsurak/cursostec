---
name: generate-feature-spec
description: >-
  Writes draft spec-driven feature specs from a feature description, using
  AGENTS.md for the stack and project guidelines. Use when the user asks to
  generate a feature spec, specify a feature, or add a spec under specs/.
---

# Generate feature spec

Turn one feature description into short specs a coding agent can implement. Mark every file `draft`.

## Input

The feature description is required. If the user did not give one, ask for it and stop.

## Read the project

Read `AGENTS.md` at the repository root. It holds the technology stack and the project guidelines. If the project stores that guidance under `.cursor/rules/`, read those rules too. Prefer `AGENTS.md` when both exist. If neither exists, stop and say so. Do not invent a stack.

`frontend`, `backend`, `database`, `testing`, and `deploy` are roles, not directory names. From those guidelines and the repository layout, find the directories that hold the source for each role. Specs name those real paths.

The project is a simple Java application. Specs target Java only (Maven or Gradle layout, JDK version from the build file). Map the roles like this, and skip the ones the app does not have:

- **frontend** — console, Swing, or JavaFX user interface
- **backend** — `service`, `model`, and `dto` packages under `src/main/java`
- **database** — `repository` package, JDBC, or file persistence
- **testing** — JUnit 5 tests under `src/test/java`
- **deploy** — build file, jar packaging, and run scripts

## Create the spec tree

At the repository root, create `specs/` if it is missing, then these subfolders if they are missing:

- `specs/frontend`
- `specs/backend`
- `specs/database`
- `specs/deploy`
- `specs/testing`

Leave existing files in place.

## Choose layers

Write a file only for a role this feature needs.

- **database** — persisted data, schema, migrations, or queries
- **backend** — APIs, services, or server-side rules
- **frontend** — UI or client behavior
- **testing** — behavior a test can accept or reject
- **deploy** — pipelines, infrastructure, hosting, or release config

## Write the files

Scan `specs/**/ft-*.md`. The next id is `ft-` plus one more than the highest number already used. The first id is `ft-1`. Reuse that id for every layer file of this feature.

File name: `ft-<number>-<slug>.md`

`<slug>` is a few hyphenated words a person can read to know the feature. Example: `specs/backend/ft-4-reset-password.md`.

Put each file in that role's `specs/` folder.

```markdown
---
id: ft-4
layer: backend
status: draft
---

# Reset password

## General description

## Inputs

## Outputs

## Test criteria

## Assets

## Implementation guidelines

## Business workflow
```

`status` stays `draft`. Do not set `approved`, `done`, or `ignore`.

Write for a coding agent. Short bullets. No preamble and no restatement of the request.

- **General description** — what this layer does for the feature, in a few lines.
- **Inputs / Outputs** — names, types, and where they come from or go. `None` when the layer has none.
- **Test criteria** — observable pass or fail conditions.
- **Assets** — contracts, payloads, copy, config keys, or mockups this layer needs. `None` when it needs none.
- **Implementation guidelines** — the stack and rules from `AGENTS.md` that bind this layer, plus the real source paths to change. Do not paste `AGENTS.md`.
- **Business workflow** — the ordered steps for this layer only.

Keep the shared behavior aligned across the layer files. Do not copy a section that belongs to another layer.

## Done

List the files written. A developer sets `status: approved` before `develop-feature` will implement them.
