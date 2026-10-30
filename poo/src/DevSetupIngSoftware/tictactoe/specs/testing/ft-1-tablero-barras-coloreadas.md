---
id: ft-1
layer: testing
status: approved 
---

# Tablero con barras coloreadas

## General description

- Pruebas JUnit 5 del `BoardPanel` que dibuja el área de juego de 9 zonas.
- Las pruebas pintan el panel en un `BufferedImage` y leen píxeles. No abren ventana, así que corren en modo headless.
- Verifican posición, color y proporción de las 4 barras, y que las 9 zonas quedan con el color de fondo.

## Inputs

- `BoardPanel` de `src/game/ui/BoardPanel.java`, con tamaño fijado por `setSize(pWidth, pHeight)`.
- Constantes de `src/game/util/IConstants.java`: `BOARD_BACKGROUND_COLOR`, `BAR_COLOR_1` a `BAR_COLOR_4`, `BAR_THICKNESS`.
- Tamaños de prueba: 300x300 y 600x600.

## Outputs

- Resultado pass o fail de cada prueba.
- No se escriben archivos.

## Test criteria

- `pintaCuatroBarras`: en un panel de 300x300, el píxel en (100, 150) tiene `BAR_COLOR_1`, el píxel en (200, 150) tiene `BAR_COLOR_2`, el píxel en (150, 100) tiene `BAR_COLOR_3` y el píxel en (150, 200) tiene `BAR_COLOR_4`.
- `coloresDeBarraSonDistintos`: los 4 colores de barra son distintos entre sí y distintos de `BOARD_BACKGROUND_COLOR`.
- `nueveZonasConFondo`: en un panel de 300x300, los píxeles en el centro de cada zona (50, 50), (150, 50), (250, 50), (50, 150), (250, 150), (50, 250), (150, 250), (250, 250) tienen `BOARD_BACKGROUND_COLOR`. La zona central (150, 150) también tiene el fondo.
- `barraVerticalOcupaAltura`: en un panel de 300x300, el píxel (100, 0) y el píxel (100, 299) tienen `BAR_COLOR_1`.
- `barraHorizontalOcupaAncho`: en un panel de 300x300, el píxel (0, 100) y el píxel (299, 100) tienen `BAR_COLOR_3`.
- `barrasSeReubicanAlRedimensionar`: en un panel de 600x600, el píxel (200, 300) tiene `BAR_COLOR_1`, el píxel (400, 300) tiene `BAR_COLOR_2`, el píxel (300, 200) tiene `BAR_COLOR_3` y el píxel (300, 400) tiene `BAR_COLOR_4`.
- `grosorDeBarra`: en un panel de 300x300, la barra vertical izquierda ocupa x desde `100 - BAR_THICKNESS / 2` hasta `100 - BAR_THICKNESS / 2 + BAR_THICKNESS - 1`. El píxel en x = `100 - BAR_THICKNESS / 2` tiene `BAR_COLOR_1`. El píxel en x = `100 - BAR_THICKNESS / 2 - 1` tiene `BOARD_BACKGROUND_COLOR`.
- No se prueban los cruces de barras: el color del cruce depende del orden de dibujo y no forma parte del contrato.

## Assets

- Ninguno. Las pruebas usan solo las constantes de `IConstants`.

## Implementation guidelines

- Stack: Java 26, JUnit Jupiter 5.11.4 (ya declarado en `pom.xml`), Surefire 3.5.2. Sin dependencias nuevas.
- Crear `src/test/game/ui/BoardPanelTest.java`, en el mismo paquete que `BoardPanel` (`game.ui`). Así puede llamar al `paintComponent` protegido.
- Para pintar: crear `BufferedImage(pWidth, pHeight, BufferedImage.TYPE_INT_RGB)`, obtener `createGraphics()`, llamar a `paintComponent(graphics)` y liberar con `dispose()`.
- Comparar colores con `getRGB()` contra `Color.getRGB()` de la constante. No comparar objetos `Color` con `equals` sobre píxeles.
- Convenciones (`.github/instructions/testing-junit.instructions.md` y `java-conventions.instructions.md`):
  - Las pruebas viven en `src/test/` y reflejan el paquete de `src/game/`.
  - Nombres de método descriptivos. Parámetros con prefijo `p` si los hay.
  - Un tipo público por archivo; el nombre del archivo coincide con la clase.
- Rutas a crear: `src/test/game/ui/BoardPanelTest.java` (nuevo).
- No tocar `src/game/` en esta capa.

## Business workflow

1. Crear `BoardPanelTest` con un método auxiliar que, dados ancho y alto, devuelve la imagen pintada del panel.
2. Escribir primero las pruebas de barras: `pintaCuatroBarras`, `barraVerticalOcupaAltura`, `barraHorizontalOcupaAncho`.
3. Escribir la prueba de zonas: `nueveZonasConFondo`.
4. Escribir la prueba de redimensionado: `barrasSeReubicanAlRedimensionar`.
5. Escribir la prueba de grosor: `grosorDeBarra`.
6. Escribir la prueba de colores: `coloresDeBarraSonDistintos`.
7. Ejecutar `mvn clean verify` y reportar el resultado de cada prueba.
