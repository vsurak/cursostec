# Deploy

After you change this layer, update this file so the next run stays current.

Source: `pom.xml` (Maven build, `mainClass` = `game.TicMain`), `readme.md`

## Implemented
- Maven build con `maven-compiler-plugin` (release 26) que excluye `test/**` de la compilación principal, porque `sourceDirectory` es `src`.
- `exec-maven-plugin` para `mvn compile exec:java`.
- Surefire 3.5.2 para `mvn test`.
- No hay archivos de pipeline CI.

## Build files
- `pom.xml`
