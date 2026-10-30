# Testing

After you change this layer, update this file so the next run stays current.

Source: `src/test` (JUnit Jupiter 5.11.4, declared in `pom.xml`)

## Implemented
- Pruebas del tablero: colores, barras, zonas de fondo, redimensionado y grosor: `src/test/game/ui/BoardPanelTest.java`

## Test classes
### BoardPanelTest
Pinta `BoardPanel` en un `BufferedImage` y verifica píxeles. Corre headless. `src/test/game/ui/BoardPanelTest.java`
- `pintaCuatroBarras()`
- `coloresDeBarraSonDistintos()`
- `nueveZonasConFondo()`
- `barraVerticalOcupaAltura()`
- `barraHorizontalOcupaAncho()`
- `barrasSeReubicanAlRedimensionar()`
- `grosorDeBarra()`

## Run
- `mvn test` (ver `pom.xml`)
