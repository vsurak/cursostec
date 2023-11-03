## actividades fuera de clase

1. trabajar en el preliminar #2 del caso 3

## actividades dentro de clase

1. exposiciones de patrón observer y visitor

2. ejercicio evaluado especial por un 3%. existen diversos tipos de dispositivos de control como por ejemplo smartphones, google home, alexa, firestick. también existen varios dispositivos en la casa como laptops, smart tv y proyectores smart. implemente en java las clases necesarias para por medio de un bridge pattern hacer que cualquier dispositivo de control pueda controlar los dispositivos de la casa. para efectos del ejemplo los dispositivos de la casa pueden mostrar fotografías, cambiar el volumen actual y automáticamente ajustan el display de la foto al tamaño soportado por el dispositivo.

enviar el link de git con las clases implementadas al asistente [fvsasistencia@gmail.com](fvsasistencia@gmail.com) vía email , subject: poo - bridge pattern, antes de la media noche.

3. patrón productor consumidor explicación por parte del profesor.

4. ejercicio evaluado especial por un 7%. se quiere crear un generador de arte abstracto en java el cual vaya creando una "pintura" artística multiculor en forma automática en la pantalla y con un tamaño definido. el generador deberá tener N pintores funcionando en paralelo, existen 3 tipos de pintores, los que saben pintar lunares de colores de diversos tamaños, los que saben pintar rayas de diversos colores y grosores, finalmente los que saben pintar polígonos de diversos tamaños y colores. los pintores se crean dinámicamente, recibiendo cada pintor diferentes parámetros y reglas que determinan su estilo de pintura y su prioridad para pintar. aunque todos los pintores estén activos en todo momento, solo uno de ellos pinta a la vez, dando 300 milisegundos entre cada pintor. todos los pintores ponen atención al último pintor que pintó, la posición donde pintó, el tamaño y el color que pintó, y esos 4 parámetros determinan el turno del siguiente pintor, la posición, el color y estilo que va a pintar el siguiente, y así sucesivamente. se busca que los pintores puedan generar diversidad de formas, colores y posiciones. el UI será una ventana de un tamaño fijo, donde los pintores irán dibujando en el Graphics de dicha ventana. diseñe e implemente una jerarquía de objetos que resuelva el problema de generación de pinturas abstractas haciendo uso estratégico de los patrones de diseño strategy, observer, iterator y factory. los pintores iran agregando elementos a la obra y terminarán hasta que todos hayan aportando X cantidad de elementos a la pintura, donde X es configurable.

enviar el link de git con el proyecto resuelto al asistente [fvsasistencia@gmail.com](fvsasistencia@gmail.com) vía email , subject: poo - abstract art, antes de la media noche del viernes 10 de noviembre.
