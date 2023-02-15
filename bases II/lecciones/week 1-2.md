# weeks from february 6th to 17th

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

teoría
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


4. Instalar sql server developer edition, edition free
https://www.microsoft.com/en-us/sql-server/sql-server-downloads 


## actividades dentro de clase

1. Se hace un repaso del curso de bases de datos I, diseño, patrones y operaciones

2. se crean 4 grupos de trabajo, cada grupo corresponde a uno de los 4 requisitos del diseño del caso #1. internamente el grupo se divide en dos equipos

_equipo de control de calidad:_ este equipo va definir un checklist de la información, validaciones y reglas de negocio que debe cumplir el modelo asignado 

_equipo de diseño:_ implementa un diseño en sql server de las tablas asignadas segun el requisito asignado del caso #1

posteriormente el equipo de control de calidad valida el diseño de sus compañeros basado en las reglas que definió. Todo el grupo procede hacer las mejoras al diseño. Posteriormente se presentan a toda la clase los diseños y se comparten vía script. 

3. Quiz práctico de git/github

4. Quiz práctico de docker

Other tasks 

_running and accesing mysql via docker_

```s
docker run -d -p 3306:3306 --name mysqlserver -v c:\dev\mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 mysql
```

_access the container_

```s
docker exec -it mysqlserver bash
```