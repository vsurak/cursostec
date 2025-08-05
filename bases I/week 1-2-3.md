## Introducción a las bases de datos

### ¿Qué es un sistema administrador de base de datos - SABD?

Los programas informáticos utilizan estructuras de datos como listas, mapas, árboles y grafos para organizar y manejar información en memoria mientras el programa se está ejecutando. Sin embargo, toda esa información se pierde al cerrar el programa, ya que solo vive en memoria RAM.

Para resolver esto nacen las bases de datos, que pueden considerarse como estructuras de datos persistentes, es decir, que se almacenan en memorias físicas como discos duros, SSDDs, server farms, etc, y permanecen disponibles incluso después de apagar el sistema.


**¿Qué hacen las bases de datos además de almacenar?** 

Una base de datos no es solo un archivo con datos; es un conjunto de algoritmos y mecanismos especializados que permiten:

| Capacidad                | Descripción                                                          |
| ------------------------ | -------------------------------------------------------------------- |
| Escrituras rápidas       | Inserción eficiente de nuevos datos.                                 |
| Lecturas rápidas         | Búsqueda rápida entre millones de registros.                         |
| Persistencia             | Almacena más allá de la RAM.                                         |
| Seguridad                | Control de acceso, encriptación.                                     |
| Caché                    | Minimiza lecturas en disco, acelera consultas.                       |
| Bitácora (log)           | Guarda lo que sucede para recuperación o auditoría.                  |
| Control transaccional    | Garantiza que los cambios se hagan o se cancelen por completo.       |
| Recuperación ante fallos | Restaura el estado anterior en caso de error.                        |
| Concurrencia             | Permite que muchos usuarios trabajen al mismo tiempo sin conflictos. |


Existen diferentes tipos de bases de datos, y cada tipo puede ofrecer ventajas y desventajas dependiendo del caso de uso que se le de: 

| Tipo                 | Característica Principal                                            |
| -------------------- | ------------------------------------------------------------------- |
| Relacionales         | Datos organizados en tablas con relaciones.                         |
| Documentales         | Almacenan documentos JSON o BSON (ej: MongoDB).                     |
| Orientadas a objetos | Modelan datos como objetos del mundo real.                          |
| De grafos            | Ideal para representar relaciones complejas como redes sociales.    |
| De indexación        | Optimizadas para búsquedas y filtrados rápidos (ej: ElasticSearch). |
| Data warehouse       | Almacenamiento masivo para análisis histórico de datos.             |
| Data lake            | Almacén de datos crudos estructurados y no estructurados.           |


### Bases de datos relacionales

Nos enfocaremos en las bases de datos relacionales, llamadas así porque establecen relaciones entre tablas mediante llaves primarias (PK) y llaves foráneas (FK).


Suponga las siguientes colecciones de datos que podrían almacenarse en una base de datos cuando estas no poseen relaciones solo llaves primarias o PK. Además note que existe la definición de: tabla, registro, campo y tipo de dato. 

_Estudiantes_ 

| idestudiante | nombre      | edad |
| -------------- | ----------- | ---- |
| 1              | Laura Soto  | 20   |
| 2              | Andrés León | 22   |
| 3              | Carla Rojas | 21   |

_Cursos_ 

| idcurso | nombrecurso  | creditos |
| --------- | -------------- | -------- |
| 101       | Bases de Datos | 4        |
| 102       | Programación I | 3        |
| 103       | Redes          | 3        |

_Canciones_ 

| idcancion | titulo              | artista    |
| ----------- | ------------------- | ---------- |
| 1           | Yellow              | Coldplay   |
| 2           | Shape of You        | Ed Sheeran |
| 3           | Rolling in the Deep | Adele      |



### ¿Qué es SQL? 

SQL (Structured Query Language) es el lenguaje estándar para interactuar con bases de datos relacionales. Permite realizar operaciones como:

* `SELECT`: Leer datos
* `INSERT`: Agregar datos
* `UPDATE`: Modificar datos
* `DELETE`: Eliminar datos
* `JOIN`: Relacionar tablas de datos


**Pensemos en selects básicos**

```sql
-- Todos los estudiantes
SELECT * FROM estudiantes;

-- Estudiantes mayores de 21
SELECT * FROM estudiantes WHERE edad > 21;

-- Solo nombre y edad
SELECT nombre, edad FROM estudiantes;

-- Canciones de Coldplay
SELECT * FROM canciones WHERE artista = 'Coldplay';
```

**Retomando la idea de relacional** 

Se le llama modelo relacional porque es posible establecer relaciones entre tablas para crear información compuesta entre las diferentes entidades que se modelan. 

_Canciones y géneros :_  


| idgenero | nombre      |
| ---------- | ----------- |
| 1          | Pop         |
| 2          | Rock        |
| 3          | Electrónica |


| idcancion | titulo                  | idgenero |
| ----------- | ----------------------- | ---------- |
| 1           | Yellow                  | 2          |
| 2           | Shape of You            | 1          |
| 3           | Blinding Lights         | 3          |
| 4           | Adventure of a Lifetime | 2          |
| 5           | Levitating              | 1          |
| 6           | Bad Guy                 | 1          |
| 7           | Paradise                | 2          |


Adelantándonos un poco al SQL, de la siguiente forma obtendría todas las canciones con su respectivo nombre de genero: 

```sql
-- Mostrar canción con su género
SELECT titulo, nombre 
FROM canciones 
JOIN generos ON generos.idgenero = canciones.idgenero;
```

_Relación compuesta: Dispositivos móviles_ 

marcas: 


| idmarca | nombre  |
| --------- | ------- |
| 1         | Samsung |
| 2         | Apple   |

modelos: 

| idmodelo | nombre     | idmarca |
| ---------- | ---------- | --------- |
| 1          | Galaxy S21 | 1         |
| 2          | iPhone 13  | 2         |


dispositivo: 

| iddispositivo | idmodelo | serial       |
| --------------- | ---------- | ------------ |
| 1               | 1          | SMG123456789 |
| 2               | 2          | APL987654321 |


Periféricos: 

| idperiferico | iddispositivo | tipo   | descripcion        |
| -------------- | --------------- | ------ | ------------------ |
| 1              | 1               | Cámara | 108MP ultra wide   |
| 2              | 1               | Sensor | Huella en pantalla |
| 3              | 2               | Cámara | 12MP doble lente   |







### actividades fuera de clase

1. conocer el CLI de su sistema operativo y el de linux principalmente 
https://ubuntu.com/tutorials/command-line-for-beginners#1-overview 

2. estudiar github

Teoría 

https://docs.github.com/en/get-started/quickstart/hello-world 

https://docs.github.com/en/get-started/using-git/about-git 


Video tutorials 

https://www.youtube.com/watch?v=VdGzPZ31ts8 


3. estudiar docker

https://docs.docker.com/get-started/ 

https://docker-curriculum.com/ 

La documentación y ejemplos es amplia, por el momento se requiere que el estudiante sea capaz de: 
- instalar docker en su computadora
- bajar una imagen del docker hub
- cargar la imagen en un contenedor activo y que este se ejecute en background
- hacer uso del contenedor activo desde la computadora host
- acceder al contenedor y recorrer la estructura de archivos

video tutorials 

https://www.youtube.com/watch?v=4Dko5W96WHg 

https://www.youtube.com/watch?v=CV_Uf3Dq-EU 

https://www.youtube.com/watch?v=pTFZFxd4hOI 


5. bajar la imagen docker de mysql y tenerla local 

6. instalar workbench para mysql 

*tip _running and accesing mysql via docker*

```s
docker run -d -p 3306:3306 --name mysqlserver -v <mifolderpathlocal>:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 mysql
```

_access the container_

```s
docker exec -it mysqlserver bash

mysql -u root -p  // ingresando a la consola de mysql con el usuario root y me va a pedir el password 

show databases; // mysql trabaja con lo que se llama un delimitador de instrucción que es por default el ; , pero se puede cambiar

create database ejemplodeclase;

use ejemplodeclase;

show tables;

```
