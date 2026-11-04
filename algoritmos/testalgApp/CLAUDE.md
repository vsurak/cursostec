Description
El sistema consiste en un portal web para analizar grandes volúmenes de datos de taxis, donde los usuarios acceden mediante autenticación y reciben una credencial que restringe los LocationID y las columnas de información que pueden consultar. A través de filtros de búsqueda definidos por campo, valor y operadores de comparación (>, <, >=, <=, ==), los usuarios realizan consultas que se envían cifradas al servidor junto con su token. El servidor valida y descifra la credencial, aplica las restricciones de acceso según los LocationID autorizados, los criterios de filtrado y el nivel de usuario, y devuelve únicamente los registros y columnas permitidos. El sistema contempla tres niveles de acceso: public, analyst y owner, con una asignación configurable de columnas visible para cada nivel mediante un archivo de configuración.


Tech stack
- .net C++  
- java 26.0.2 2026-07-21

Folder structure:

1. root
1.1 data: archivos bajados de la info de taxis
1.2 model: clases para guardar informacion
1.3 logs: clases para registrar logs en consola del flujo y errores del programa
1.4 utils: algoritmos de ordeamiento, busqueda y seleccion, hashtables, randoms
1.5 engine: algoritmos del programa
- en el root estará el taxi.cpp que será el programa de entrada y el make file para la ejecucióm
- en el root va estar el task y settings de vscode para ejecutar el programa desde el IDE de vscode


