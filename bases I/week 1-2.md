

## actividades fuera de clase

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

***tip _running and accesing mysql via docker***

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


## actividades dentro de clase

1. abordaje del caso #1, clarificación de requerimientos e introducción a los diseños de datos.

2. se desarrollaran ejemplos de diseño de datos usando patrones tales como 
- perfil 
- user/role/permissions
- media
- transactions
- master detail
- addresses
- metadata/corpuses
- scheduling
- subscriptions
- hierarchy 

