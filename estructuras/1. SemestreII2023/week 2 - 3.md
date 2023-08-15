## actividades fuera de clase

1. Instalar [vscode](https://code.visualstudio.com/download) para su sistema operativo, ya sea windows, linux o mac

2. En el caso de utilizar windows pro, proceda a instalar [Docker desktop](https://docs.docker.com/get-docker/) . Si usted posee windows home entonces proceda a instalar [cygwin](https://www.cygwin.com/install.html) . Cygwin es únicamente en el caso de que no pueda instalar Docker desktop.

3. según su sistema operativo ambiente usado en el paso anterior, investigue como instalar para ese ambiente (linux nativo o mac o cygwin) el compilador g++ e instalelo. para el caso de docker haga download de la imagen gcc con el siguiente comando:

```sh
docker pull gcc
```

para saber que su instalación quedó correcta, ejecute en la terminal del ambiente en cuestion (mac, linux o cygwin) g++ y g++ --version , ambos deben poder responder. En el caso de docker con tener la imagen bajada es suficiente.

no se va a utilizar clion ni visual studio c++.

4. compilar y ejecutar en su computadora los programas hechos en clase por el profesor que van a estar subidos en github, resueltos en el punto 2, 3, 4 de las actividades en clase.

## actividades en clase

### reto #2 de arreglos

1. un sistema de ventas de tiquetes va a ofrecer la otra semana los tiquetes para el concierto de bad bunny. En total se van a vender 70000 entradas, los ingenieros saben que el sistema es capaz de atender un máximo de 200 personas simultáneamente, más de eso todo el sistema se queda pegado y ya nadie logra comprar nada. Si sabemos que aproximadamente 350000 personas van a intentar comprar su boleto, como podríamos crear una estrategia por medio de una abstracción basada en arreglos, para compensar la poca capacidad del sistema y así lograr atender a todas las personas sin que se caiga el sistema.

2. Estructura de un programa en C, C++. Pasos básicos, cómo compilar, ejecutar y simplificar con un cmake

3. Hacer un programa en C++, para medir el rendimiento al buscar un item en un arreglo bajo el principio de LRU y sin dicho principio.
