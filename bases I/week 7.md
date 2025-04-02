1. revisar los diseños hechos para el ejercicio #5 de week 6. 

2. estudiar sobre el diseño documentar en mongodb https://www.mongodb.com/docs/manual/data-modeling/ 

usando la imagen de mongo
```sh
docker run -d -v c:\dev\mongodata:/data/db -p 27017:27017 --name MarketingDBServer  mongo mongod --port 27017 --dbpath /data/db

docker exec -it MarketingDBServer mongosh
```

3. ejercicio #6 

utilizando un editor de json en linea, cada grupo del caso #2, proceda a escribir json ejemplo de alguno de los siguientes contextos que el profesor les va a asignar, recuerde que se menciona que estos contextos van a ser implementados en el sitio web de soltura: 

- paquetes informativos, mercadeo y media
- servicio al cliente, atención de casos, resolución de quejas
- reviews

defienda ante al profesor, con información soporte investigada, y con atributos positivos de escalabilidad y rendimiento; el diseño seleccionado para solucionar el contexto asignado. 

Entrega al canal general de discord , contexto asignado,  integrantes del equipo y el diseño en json hecho.  



