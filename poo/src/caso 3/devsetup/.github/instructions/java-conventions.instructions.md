---
applyTo: "src/main/java/**/*.java"
description: "Conventions for simple Java applications (Maven/Gradle layout)"
---
- Use Java only. Target the JDK version declared in `pom.xml` or `build.gradle`.
- The entrypoint (`public static void main`) stays in `src/main/java/<package>/Main.java`.
- Domain classes stay in `src/main/java/<package>/model/`.
- Business logic stays in `src/main/java/<package>/service/`.
- Data access stays in `src/main/java/<package>/repository/`.
- Input and output types (requests, responses, DTOs) stay in `src/main/java/<package>/dto/`.
- Packages are lowercase; classes are `PascalCase`; methods and fields are `camelCase`; constants are `UPPER_SNAKE_CASE`.
- One public top-level type per file, and the file name matches the type name.
- Depend on interfaces for services and repositories; keep fields `private` and expose behavior through methods.
- Prefer the standard library. Add a dependency only when the standard library cannot do the job.
