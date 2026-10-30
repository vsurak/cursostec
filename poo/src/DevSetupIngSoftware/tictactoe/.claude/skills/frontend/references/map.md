# Frontend

After you change this layer, update this file so the next run stays current.

Source: `src/game/ui` (Swing)

## Implemented
- Tablero de 9 zonas con 4 barras coloreadas (2 verticales, 2 horizontales), pintado con `Graphics2D`: `src/game/ui/BoardPanel.java`
- Ventana Swing que muestra el tablero: `src/game/TicMain.java`
- Constantes de colores y grosor del tablero: `src/game/util/IConstants.java`

## Entrypoints
- `src/game/TicMain.java`

## Classes
### BoardPanel
Panel Swing del área de juego. `src/game/ui/BoardPanel.java`
- `paintComponent(Graphics pG)` — pinta el fondo y las 4 barras según el tamaño actual del panel

### TicMain
Entrypoint. Abre la ventana con `BoardPanel` en el EDT. `src/game/TicMain.java`
- `main(String[] pArgs)` — arranca la aplicación

### IConstants
Constantes públicas del juego: `BOARD_INITIAL_SIZE`, `BAR_THICKNESS`, `BOARD_BACKGROUND_COLOR`, `BAR_COLOR_1` a `BAR_COLOR_4`. `src/game/util/IConstants.java`
