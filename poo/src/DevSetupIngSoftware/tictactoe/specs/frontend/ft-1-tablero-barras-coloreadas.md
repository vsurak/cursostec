---
id: ft-1
layer: frontend
status: approved 
---

# Tablero con barras coloreadas

## General description

- Panel Swing que dibuja el área de juego de tic tac toe.
- El área se divide en 9 zonas (3x3) mediante 4 barras: 2 verticales y 2 horizontales.
- Todo se pinta por código con `Graphics2D`. No se usan imágenes, `ImageIcon`, `ImageIO` ni archivos de recursos.
- El dibujo se recalcula con el tamaño actual del panel.

## Inputs

- Tamaño del panel: `getWidth()` y `getHeight()`, en cada `paintComponent`.
- Colores: constantes de `src/game/util/IConstants.java`.
- Ninguna entrada del usuario en esta fase.

## Outputs

- Ninguna salida de datos.
- Salida visual: 4 barras y el fondo dibujados dentro del panel.

## Test criteria

- Existe exactamente 4 barras: 2 verticales en x = `W / 3` y x = `2 * W / 3`, y 2 horizontales en y = `H / 3` y y = `2 * H / 3`, con `W` y `H` el ancho y alto del panel.
- Cada barra tiene un grosor de `BAR_THICKNESS` px centrado en su posición.
- Las barras verticales ocupan toda la altura del panel. Las horizontales ocupan todo el ancho.
- Los 4 colores de barra son distintos entre sí.
- El color del background va a ser gris claro. 
- Al muestrear el píxel central de cada una de las 9 zonas, se obtiene `BOARD_BACKGROUND_COLOR`.
- Al cambiar el tamaño del panel, las barras se mueven a las nuevas posiciones proporcionales.
- El dibujo no depende de imágenes ni de recursos externos: el paquete `src/game/ui/` no importa `javax.swing.ImageIcon`, `javax.imageio` ni carga archivos.
- La ventana abre sin errores al ejecutar `mvn compile exec:java`.

## Assets

- Constantes nuevas en `src/game/util/IConstants.java` (`public static final`):
  - `BOARD_BACKGROUND_COLOR`: fondo del tablero, blanco sugerido `new Color(255, 255, 255)`.
  - `BAR_COLOR_1`: barra vertical izquierda, azul sugerido `new Color(0, 102, 204)`.
  - `BAR_COLOR_2`: barra vertical derecha, naranja sugerido `new Color(255, 128, 0)`.
  - `BAR_COLOR_3`: barra horizontal superior, morado sugerido `new Color(128, 0, 128)`.
  - `BAR_COLOR_4`: barra horizontal inferior, turquesa sugerido `new Color(0, 170, 170)`.
  - `BAR_THICKNESS`: grosor en px, `int`, valor sugerido `8`.
- Los colores sugeridos pueden cambiarse, pero los 4 de barra deben ser distintos entre sí y distintos del fondo.
- No se usan los colores de los símbolos (estrella verde del bot y diamante rojo del jugador) para las barras.

## Implementation guidelines

- Stack: Java 26 (`maven.compiler.release` en `pom.xml`), Swing. Sin dependencias nuevas.
- Crear `src/game/ui/BoardPanel.java`: clase pública que extiende `javax.swing.JPanel`, con un solo tipo público por archivo.
- Sobrescribir `paintComponent(Graphics pG)`: llamar a `super.paintComponent(pG)`, convertir a `Graphics2D` y dibujar con `fillRect`.
- Calcular posiciones con `getWidth()` y `getHeight()` en cada pintado. No usar tamaños fijos.
- Orden de dibujo: fondo, barras verticales, luego barras horizontales. En los cruces gana el color de la barra horizontal.
- Modificar `src/game/TicMain.java`: reemplazar el `System.out.println` por el arranque de Swing en el Event Dispatch Thread (`SwingUtilities.invokeLater`). Crear un `JFrame` con `BoardPanel`, `setDefaultCloseOperation(EXIT_ON_CLOSE)`, tamaño inicial de 300x300 px y `setVisible(true)`. `main` sigue en `TicMain`.
- Convenciones (`.github/instructions/java-conventions.instructions.md`):
  - Paquetes en minúscula, clases en `PascalCase`, constantes en `UPPER_SNAKE_CASE`.
  - Todos los parámetros de métodos empiezan con `p` (`pG`, `pWidth`, `pHeight`).
  - Campos `private`.
- Rutas a crear o tocar:
  - `src/game/ui/BoardPanel.java` (nuevo)
  - `src/game/util/IConstants.java` (nuevo, si no existe)
  - `src/game/TicMain.java` (modificar)
- No crear `specs/` ni tocar `src/test/` en esta capa.

## Business workflow

1. Abrir `TicMain.main`, lanzar la ventana en el EDT.
2. La ventana crea un `BoardPanel` y lo muestra.
3. Al pintar, `BoardPanel` pinta el fondo con `BOARD_BACKGROUND_COLOR`.
4. Calcular las coordenadas de las 4 barras a partir de `getWidth()` y `getHeight()`.
5. Pintar las 2 barras verticales con `BAR_COLOR_1` (izquierda) y `BAR_COLOR_2` (derecha), de lado a lado de la altura del panel.
6. Pintar las 2 barras horizontales con `BAR_COLOR_3` (arriba) y `BAR_COLOR_4` (abajo), de lado a lado del ancho del panel.
7. Al redimensionar la ventana, repetir desde el paso 3. Las barras se reubican en proporción.
