## actividades fuera de clase

1. conocer el CLI de su sistema operativo y el de linux principalmente
   https://ubuntu.com/tutorials/command-line-for-beginners#1-overview

2. estudiar github y crearse una cuenta en github. Para los que usen windows revisar en este repositorio en la raíz el archivo onwindows_readme.txt

   Video tutorial
   https://www.youtube.com/watch?v=VdGzPZ31ts8

   Teoría
   https://docs.github.com/en/get-started/using-git/about-git

   cheat sheet

   <img src="media/cheat sheet github.png" width=65% height=65%>

3. estudiar los siguientes dos links completos

https://cplusplus.com/doc/tutorial/program_structure/

https://cplusplus.com/doc/tutorial/variables/

## actividades en clase

1. Ejercicio evaluado, el profesor va a resolver el primer ejercicio

- https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true

  luego en parejas proceda a escoger uno de los dos algoritmos siguientes, proceda a resolverlo en papel o en un editor en su teléfono usando lo más similar a sintáxis de C++, llamar al profesor para obtener una nota tan pronto terminen. No es necesario ejecutarlo.

- https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true
- https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true

2. Ejercicio de gitub, prueba evaluada

- hacer grupos de 4 personas
- una persona va a crear un repositorio en su cuenta de github llamado "estructuras_gitintro"
- en los settings del repositorio, agregue como colaboradores a los otros 3 compañeros para que puedan hacer commit
- agregue a su repo el o los archivos cpp hechos en el punto #1
- una vez que el archivo este agregado todos los integrantes deberan en sus computadores crear un folder para la práctica, y en ese folder hacer un git clone del repositorio
- luego deberan crear un branch con el nombre o un nickname distintivo de cada persona, git branch
- luego deberán pasarse al branch creado con un git checkout
- ahora abra el cpp del ejercicio 1 y dentro del main agregue un cout al final con su nombre completo: cout << "mi nombre completo" << endl; , salve el archivo
- proceda a pasar los archivos modificados a stagging con git add
- haga commit con git commit
- pasese al main branch con git checkout
- haga merge en el main con lo que tiene en el branch de su nickname
- todos deben tratar de subir su cambio al main en el github en la nube por medio de git push, para algunos, no se los va a permitir pues la versión arriba va a ser más nueva que la que tienen local, por lo que tendrán que hacer un git pull y un merge desde su branch, y así sucesivamente, hasta que en esa competencia logren todos los integrantes subir su cambio en la nube
- el profesor revisará el repo en github debidamente actualizado, y revisará los branches locales de cada quien para confirmar que su branch personal solo tiene su nombre, y en su branch main lo que tiene es el contenido al punto en que logró efectivamente hacer push de sus cambios

3. Proceda en forma individual en conjunto con el profesor a resolver los siguientes problemas algoritmicos:

   a. Dada una string, encontrar la substring con repetición continua, asumiendo que la string es circular. Haga uso de arreglos. Ejemplo de inputs:

   "este es un hola hola no un adios" => " hola hola"

   "ine viene mañana voy al cine mañana voy al c" => "mañana voy al cine mañana voy al cine"

   "estoy programando en C++" => ""

   b. dado una lista de palabras en un arreglo, genere una sopa de letras e imprímila en pantalla. El tamaño de la cuadrícula será dado por parámetro, hasta un máximo de 10x10 y todas las palabras deben tener un largo menor o igual a dicho tamaño. haga que su programa acomode las palabras en la cuadrícula de la sopa ya sea de forma vertical, horizontal y diagonal, decidiendo eso de forma pseudo aleatoria, y proceda después a imprimir en pantalla la sopa de letras resultante. Haga uso de matrices o bien llamados arreglos multidimensionales.
