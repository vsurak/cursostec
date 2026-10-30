# Project description
Este proyecto es un juego de tic tac toe, donde el jugador compite contra la computadora. Cada sesión de juego va estar compuesta por 5 rondas. Si el jugador gana 1 juego, gana $1.00. Si gana 2 o 3 juegos gana $4.0, si gana 4 juegos obtiene $7 y si gana los 5 juegos de la ronda gana $10. Para participar cada ronda tiene un costo de $2.00. Y que el jugador hace depósitos para poder jugar de ciertos montos. 

# Tech stack
- java 26.0.2
- maven project 
- java swing para el UI
- unit testing junit
- github source control and code repository 
- The entrypoint (`public static void main`) stays in `src/game/TicMain.java`.
- Domain classes stay in `src/game/model/`.
- Business logic stays in `src/game/service/`.
- Packages are lowercase; classes are `PascalCase`; methods and fields are `camelCase`; constants are `UPPER_SNAKE_CASE`.
- One public top-level type per file, and the file name matches the type name.
- Los símbolos del tictactoe son formato SVG y los símbolos del juego son estrella verde para el bot de la computadora y un diamante rojo para el jugador. 

# Specs de alto nivel para ciertas classes minimas del model

Player
    - nickname
    - saldo
    - juegos realizados
    - juegos ganados
    - historial de rondas y juegos como array list

Bot
    - nickname
    - juegos realizados
    - juegos ganados

