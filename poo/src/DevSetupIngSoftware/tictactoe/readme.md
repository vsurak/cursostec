# TicTacToe

Juego de tic tac toe en el que el jugador compite contra la computadora. Cada sesión está compuesta por 5 rondas.

## Prerrequisitos

| Herramienta | Versión | Verificar |
|---|---|---|
| JDK (Java) | 26 | `java -version` |
| Apache Maven | 3.9 o superior | `mvn -version` |
| Git (opcional, para clonar) | cualquiera | `git --version` |

### Instalar JDK 26 (Windows)

1. Descarga el JDK 26 desde [jdk.java.net](https://jdk.java.net/26/) o desde Oracle.
2. Instálalo y verifica con `java -version`. Debe mostrar `26`.
3. Define la variable de entorno `JAVA_HOME` apuntando a la carpeta del JDK (por ejemplo `C:\Program Files\Java\jdk-26.0.2`).

### Instalar Maven (Windows)

Con [Scoop](https://scoop.sh/):

```powershell
scoop install maven
```

O descarga el binario desde [maven.apache.org](https://maven.apache.org/download.cgi), descomprímelo y agrega su carpeta `bin` al `PATH`.

Verifica con:

```powershell
mvn -version
```

Debe mostrar Maven 3.9 o superior y Java 26.

> Si PowerShell bloquea la ejecución de scripts, consulta la sección de políticas de ejecución de PowerShell (`Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser`).

## Clonar el repositorio

```powershell
git clone <url-del-repositorio>
cd tictactoe
```

## Correr el programa

Desde la carpeta raíz del proyecto (donde está `pom.xml`):

```powershell
mvn compile exec:java
```

Este comando compila el código y ejecuta la clase de entrada `game.TicMain`.

## Compilar y ejecutar tests

```powershell
mvn clean verify
```

Para compilar el proyecto y generar el `.jar` en `target/`:

```powershell
mvn clean package
java -cp target/tictactoe-1.0-SNAPSHOT.jar game.TicMain
```

## Estructura del proyecto

```
tictactoe/
├── pom.xml
├── readme.md
├── CLAUDE.md
└── src/
    └── game/
        ├── TicMain.java   # Punto de entrada (main)
        ├── model/         # Clases de dominio
        ├── service/       # Lógica de negocio
        ├── ui/            # Interfaz Swing
        └── util/          # Constantes (IConstants)
```

Las pruebas unitarias van en `src/test/`, con la misma estructura de paquetes del código principal.
