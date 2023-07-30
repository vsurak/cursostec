## actividades fuera de clase

Del paso 1 al paso 5 deben estar listos para la clase del viernes 4 de agosto. El punto 6 se va a requerir para semana 3.

1. conocer el CLI de su sistema operativo y el de linux principalmente
   https://ubuntu.com/tutorials/command-line-for-beginners#1-overview

2. estudiar github y crearse una cuenta en github. Para los que usen windows revisar en este repositorio en la raíz el archivo onwindows_readme.txt

   Video tutorial
   https://www.youtube.com/watch?v=VdGzPZ31ts8

   Teoría
   https://docs.github.com/en/get-started/using-git/about-git

   cheat sheet

   <img src="media/cheat sheet github.png" width=65% height=65%>

3. Instalar [vscode](https://code.visualstudio.com/download) para su sistema operativo, ya sea windows, linux o mac

4. En el caso de utilizar windows pro, proceda a instalar [Docker desktop](https://docs.docker.com/get-docker/) . Si usted posee windows home entonces proceda a instalar [cygwin](https://www.cygwin.com/install.html) . Cygwin es únicamente en el caso de que no pueda instalar Docker desktop.

5. según su sistema operativo ambiente usado en el paso anterior, investigue como instalar para ese ambiente (linux nativo o mac o cygwin) el compilador g++ e instalelo. para el caso de docker haga download de la imagen gcc con el siguiente comando:

```sh
docker pull gcc
```

para saber que su instalación quedó correcta, ejecute en la terminal del ambiente en cuestion (mac, linux o cygwin) g++ y g++ --version , ambos deben poder responder. En el caso de docker con tener la imagen bajada es suficiente.

no se va a utilizar clion ni visual studio c++.

6. estudiar los siguientes dos links completos

https://cplusplus.com/doc/tutorial/program_structure/

https://cplusplus.com/doc/tutorial/variables/

## actividades en clase

### reto #2 de arreglos

1. un sistema de ventas de tiquetes va a ofrecer la otra semana los tiquetes para el concierto de bad bunny. En total se van a vender 70000 entradas, los ingenieros saben que el sistema es capaz de atender un máximo de 200 personas simultáneamente, más de eso todo el sistema se queda pegado y ya nadie logra comprar nada. Si sabemos que aproximadamente 350000 personas van a intentar comprar su boleto, como podríamos crear una estrategia por medio de una abstracción basada en arreglos, para compensar la poca capacidad del sistema y así lograr atender a todas las personas sin que se caiga el sistema.

2. Estructura de un programa en C, C++. Pasos básicos, cómo compilar, ejecutar y simplificar con un cmake

3. Ejercicio de gitub, prueba evaluada

- hacer grupos de 4 personas
- una persona va a crear un repositorio en su cuenta de github llamado "estructuras_gitintro"
- en los settings, agregue como colaboradores a los otros 3 compañeros para que puedan hacer commit
- agregue a su repo el archivo cpp que creo en el punto #2
- una vez que el archivo este agregado todos los integrantes deberan en sus computadores, crear un folder para la práctica, y en ese folder hacer un git pull del repositorio
- luego deberan crear un branch con el nombre o un nickname distintivo de cada persona, git branch
- luego deberán pasarse al branch creado con un git checkout
- ahora abra el cpp del ejercicio y dentro del main agregue un cout con su nombre completo: cout << "mi nombre completo" << endl; , salve el archivo
- pasese al main branch con git checkout
- haga merge en el main con lo que tiene en el branch de su nickname
- proceda a pasar los archivos modificados a stagging con git add
- haga commit con git commit
- todos deben tratar de subir su cambio al main en el github en la nube por medio de git push, para algunos, no se los va a permitir pues la versión arriba va a ser más nueva que la que tienen local, por lo que tendrán que hacer de nuevo un pull y un merge desde su branch, y así hasta que en esa competencia logren todos los integrantes subir su cambio en la nube
- el profesor revisará el repo en github debidamente actualizado, y revisará los branches locales de cada quien para confirmar que su branch personal solo tiene su nombre, y su branch main lo que tiene es el contenido al punto en que logró efectivamente hacer push de sus cambios
