Weeks from february 6th to 17th


## actividades fuera de clase

1. abordaje del caso #1, clarificación de requerimientos, buscar ejemplos ilustrativos en sitios o imágenes que sean similares aunque no se trate de RVs 

2. conocer el CLI de su sistema operativo y el de linux principalmente 
https://ubuntu.com/tutorials/command-line-for-beginners#1-overview 

3. estudiar github

Teoría
https://docs.github.com/en/get-started/quickstart/hello-world 

https://docs.github.com/en/get-started/using-git/about-git 


Video tutorials
https://www.youtube.com/watch?v=VdGzPZ31ts8 


4. estudiar docker

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


5. bajar la imagen docker de mysql y tenerla local 

6. instalar workbench para mysql 



## actividades dentro de clase

1. Ejercicio de diseño conceptual por parte del profesor
https://jamboard.google.com/d/1JPzkIX3QAV339LTrWnnN5Iw9vOOHW83XzLEYXOVxU3c/edit?usp=sharing 

2. Ejercicio colaborativo de diseño conceptual guiado por el profesor, grupos de 3, trabajo individual y unificación del resultado 

https://jamboard.google.com/d/1JPzkIX3QAV339LTrWnnN5Iw9vOOHW83XzLEYXOVxU3c/edit?usp=sharing 


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


5. Prácticas dentro de clase para resolver el primer preliminar caso #1

6. Prácticas dentro de clase para resolver el segundo preliminar caso #1

7. Ejercicio guiado de mi primer diseño en workbench 


