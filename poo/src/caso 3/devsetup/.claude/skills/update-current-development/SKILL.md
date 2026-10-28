---
name: update-current-development
description: >-
  Scans the implemented frontend, backend, database, testing, and deploy
  code and writes one short project skill per layer. Use when the user asks
  to update the current development map, refresh layer skills, or inventory
  what is already implemented.
---

# Update current development

Scan the code that already exists. Write one project skill per layer under `.claude/skills/`. Commit that folder so teammates get the same maps.

`frontend`, `backend`, `database`, `testing`, and `deploy` are roles, not directory names. Find the directories that hold the source for each role.

## Scan

Read `CLAUDE.md` at the repository root for the stack and layout. If the project stores that guidance under `.claude/rules/`, read those rules too. If neither exists, infer the role directories from the repository and say that the guidelines file was missing.

Skip dependencies, build output, and vendored code (`target`, `build`, `out`, `.gradle`, `.idea`, `bin`, `.git`).

For each role, record:

- the real directories for that role
- what is already implemented, and the path that owns it
- routes, entrypoints, schema, migrations, test projects, and pipeline files when that role has them
- each Java class or interface with its purpose and path
- each public method, with its parameters and types and a one-line description

Do not list private methods.

The project is a simple Java application. Scan `src/main/java` and `src/test/java`, plus the build file (`pom.xml` or `build.gradle`). Ignore non-Java source.

## Write the skills

Write all five skills, including a role that has no code yet. Do not add `disable-model-invocation`. With that flag set, the skill loads only when someone types the layer name, such as `/frontend`.

Claude sees only the description until it loads the skill. Claude opens the skill when the task is about that layer. Put the inventory in `references/map.md` only. Skills load `references/` only when the instructions point at them, so a database change does not pull in the frontend or deploy maps.

`.claude/skills/frontend/SKILL.md`:

```markdown
---
name: frontend
description: >-
  Map of the implemented frontend, the modules that exist, and the files
  to open before editing. Use when changing UI, client code, Swing/JavaFX/
  console UI classes, or frontend behavior.
---
# Frontend
Before searching the frontend tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

When `CLAUDE.md` names a different UI stack, name that stack instead of `Swing/JavaFX/console UI classes`.

`.claude/skills/backend/SKILL.md`:

```markdown
---
name: backend
description: >-
  Map of the implemented backend, the modules that exist, and the files
  to open before editing. Use when changing APIs, services, server code,
  or backend behavior.
---
# Backend
Before searching the backend tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

`.claude/skills/database/SKILL.md`:

```markdown
---
name: database
description: >-
  Map of the implemented database, the schema that exists, and the files
  to open before editing. Use when changing tables, migrations, queries,
  or persistence.
---
# Database
Before searching the database tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

`.claude/skills/testing/SKILL.md`:

```markdown
---
name: testing
description: >-
  Map of the implemented tests, the suites that exist, and the files
  to open before editing. Use when adding, changing, or running tests.
---
# Testing
Before searching the testing tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

`.claude/skills/deploy/SKILL.md`:

```markdown
---
name: deploy
description: >-
  Map of the implemented deploy setup, the pipelines that exist, and the
  files to open before editing. Use when changing deployment, CI,
  infrastructure, or release configuration.
---
# Deploy
Before searching the deploy tree, read `references/map.md`.
Open only the files named there for the area you are changing.
```

## Maps

Write `.claude/skills/<layer>/references/map.md` beside each skill. Keep it a short list. One line per item.

```markdown
# Frontend

After you change this layer, update this file so the next run stays current.

Source: `src/main/java/com/example/app/ui`

## Implemented
- Login screen: `src/main/java/com/example/app/ui/LoginScreen.java`

## Entrypoints
- `src/main/java/com/example/app/Main.java`

## Classes
### LoginScreen
Sign-in form. `src/main/java/com/example/app/ui/LoginScreen.java`
- `submit(String email, String password)` — validates credentials and stores the session
```

Replace every example with this repository. Include a heading only when that layer has those paths. Add `Schema`, `Test classes`, or `Build files` when this layer has them. If the role has no code, write `Nothing implemented.` and list no paths.

The line `After you change this layer, update this file so the next run stays current.` stays at the top of every map.

## Commit

Commit `.claude/skills/` so teammates get the same maps with the repo. Stage only that folder. Do not push. If there is nothing new to commit, say so.
