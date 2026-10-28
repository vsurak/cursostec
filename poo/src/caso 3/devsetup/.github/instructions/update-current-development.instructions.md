---
applyTo: "**/*.java,**/*.md,**/pom.xml,**/build.gradle"
description: "Scans the implemented code and refreshes the project layer instruction files for the current repository state"
---
# Update current development

Scan the code that already exists. Update the layer instruction files under `.github/instructions/` so they reflect the current project state.

`frontend`, `backend`, `database`, `testing`, and `deploy` are roles, not directory names. Find the directories that hold the source for each role.

## Scan

Read `.github/copilot-instructions.md` at the repository root for the project stack and layout. If the project stores that guidance under `.github/instructions/`, read those instruction files too. If neither exists, infer the role directories from the repository and say that the guidelines file was missing.

Skip dependencies, build output, and vendored code (`target`, `build`, `out`, `.gradle`, `.idea`, `bin`, `.git`).

For each role, record:

- the real directories for that role
- what is already implemented, and the path that owns it
- routes, entrypoints, schema, migrations, test projects, and pipeline files when that role has them
- each Java class or interface with its purpose and path
- each public method, with its parameters and types and a one-line description

Do not list private methods.

The project is a simple Java application. Scan `src/main/java` and `src/test/java`, plus the build file (`pom.xml` or `build.gradle`). Ignore non-Java source.

## Write the instructions

Write all five instruction files, including roles with no code yet. Keep each file short, focused, and specific to the repository.

The files are:

- `.github/instructions/frontend.instructions.md`
- `.github/instructions/backend.instructions.md`
- `.github/instructions/database.instructions.md`
- `.github/instructions/testing.instructions.md`
- `.github/instructions/deploy.instructions.md`

Update these files so they describe what is implemented, what to open before editing, and which directories are authoritative for each layer.

## Commit

Commit the `.github/instructions/` folder so teammates get the same guidance with the repo. Stage only that folder. Do not push. If there is nothing new to commit, say so.
