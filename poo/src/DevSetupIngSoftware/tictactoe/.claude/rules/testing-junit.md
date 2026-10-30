---
paths:
  - "src/test/**/*.java"
---
- Use JUnit 5 (`org.junit.jupiter`).
- Tests mirror the package of the class under test in `src/test/java/<package>/`.
- Test classes are named `<ClassName>Test.java`.
- Test method names describe behavior, e.g. `returnsEmptyListWhenNoItemsExist`.
- Shared test helpers live in `src/test/java/<package>/helpers/`.
- Run tests with `mvn test` (Maven).
