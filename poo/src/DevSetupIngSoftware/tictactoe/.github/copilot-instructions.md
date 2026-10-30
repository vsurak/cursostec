# Project description
Este proyecto es un juego de tic tac toe, donde el jugador compite contra la computadora. Cada sesión de juego va estar compuesta por 5 rondas. Si el jugador gana 1 juego, gana $1.00. Si gana 2 o 3 juegos gana $4.0, si gana 4 juegos obtiene $7 y si gana los 5 juegos de la ronda gana $10. Para participar cada ronda tiene un costo de $2.00. Y que el jugador hace depósitos para poder jugar de ciertos montos. 

# Copilot project instructions

Use Java only. Java 26.0.2, Maven project, and Java Swing for the UI. Use JUnit for unit testing. Use GitHub for source control and code repository.

For project-specific execution flow and layer instructions, follow the repository instructions under `.github/instructions/`.

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

