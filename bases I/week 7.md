1. revisar los diseños hechos para el ejercicio #5 de week 6. 

2. estudiar sobre el diseño documentar en mongodb https://www.mongodb.com/docs/manual/data-modeling/ 

usando la imagen de mongo
```sh
docker run -d -v c:\dev\mongodata:/data/db -p 27017:27017 --name mrkdb  mongo mongod --port 27017 --dbpath /data/db

docker exec -it mrkdb mongosh
```

Hacer un diseño para recetas de cocina.

Cómo va ser usada la información de las recetas?

Va ser una página web, donde yo ingreso y puedo, hacer búsquedas textuales para encontrar
recetas por el título o nombre de la receta. Pero también, existen categorías como por ejemplo: entradas frias, entradas calientes, arroces, carnes rojas, mariscos, postres, bebidas, cocteles...
y cuando entro a una categoría puedo ver las recetas listadas en orden alfabético o puedo hacer búsqueda por nombre. Cuando escojo una receta, puedo ver el titulo una foto y una breve descripción, cuando ya quiero ver la receta en detalle puedo ver los ingredientes y los pasos. 



```json
{
    "titulo" : "camarones con arroz",
    "categoria" : "mariscos",
    "pictureURL" : "https://picts.com/camaronesarroz.png",
    "descripcion" : "delicioso arroz con camarones con especies para 2 personas",
    "ingredientes" : ["200 gramos de arroz", "300 gramos de camaron pelado", "1/2 cebolla"],
    "pasos" : ["1. pique la cebolla", "2. mezcle el arroz", "3. agregue camarones", "4. sirva"]
}
```

```mongodb
db.recetas.insertOne({"titulo" : "camarones con arroz", "categoria" : "mariscos", "pictureURL" : "https://picts.com/camaronesarroz.png", "descripcion" : "delicioso arroz con camarones con especies para 2 personas", "ingredientes" : ["200 gramos de arroz", "300 gramos de camaron pelado", "1/2 cebolla"], "pasos" : ["1. pique la cebolla", "2. mezcle el arroz", "3. agregue camarones", "4. sirva"] });

db.recetas.insertOne({"titulo" : "camarones jumbo", "categoria" : "mariscos", "pictureURL" : "https://picts.com/camaronesjumbo.png", "descripcion" : "coctel de 6 grandes camarones", "ingredientes" : ["200 gramos de camaron jumbo", "2 limones", "galleta soda"], "pasos" : ["mezcle todo y se lo come"] });

db.recetas.insertOne({"titulo" : "piña colada", "pictureURL" : "https://picts.com/ronconpina.png"});

// esto es como hacer un where
db.recetas.find({categoria: "mariscos"});

// hacer un project (escoger las columnas o campos que quiero)
db.recetas.find({}, { titulo: 1, categoria: 1, ingredientes: 1 });

// un where con project
db.recetas.find({categoria: "mariscos"}, { titulo: 1, categoria: 1, ingredientes: 1 });


```

Ya este diseño cumple todo lo que se necesita PEEERO:
1. puedo buscar por título, SI
2. listar las categorías, SI pero a qué costo? porque tengo que recorrer todas las recetas para sacar todas las categorías distintas, esto sugiere que es necesario otra coleccion con las categorías.





3. ejercicio #6 

utilizando un editor de json en linea, cada grupo del caso #2, proceda a escribir un json ejemplo de alguno de los siguientes contextos que el profesor les va a asignar, recuerde que se menciona que estos contextos van a ser implementados en el sitio web de soltura: 

- paquetes informativos, mercadeo y media
- servicio al cliente, atención de casos, resolución de quejas
- reviews

defienda ante al profesor, con información soporte investigada, y con atributos positivos de escalabilidad y rendimiento; el diseño seleccionado para solucionar el contexto asignado. 

Entrega al canal general de discord , contexto asignado,  integrantes del equipo y el diseño en json hecho. Entreguemos a las 11:10am en el canal general. 

Grupos:

patty, - paquetes informativos, mercadeo y media
Santiago Calderón Zúñiga, Adrián Josué Barquero Sánchez, Christopher Daniel Vargas Villalta 

rice and beans, - paquetes informativos, mercadeo y media
Priscilla Romero, Carol Araya, Joshua Corrales, Carlos Abarca

rondon, servicio al cliente, atención de casos, resolución de quejas
Juan Pablo Cambronero, Luis Arrieta, Bryan Marin, Miguel Agüero

plantita, servicio al cliente, atención de casos, resolución de quejas
José Daniel Monterrosa Quirós, José Julián Monge Brenes, Carlos José Avalos Mendieta, Rodrigo Sebastián Donoso Chave

patacones, - reviews
Natalia Orozco Delgado,  Daniel Arce Campos, Isaac Villalobos Bonilla, Allan Bolaños Barrientos

galleta de gengibre, - reviews
Elías Ramírez Hernández, Julián Castro Barrantes, Andrés Rodríguez Brizuela, Lindsay Marín Sánchez

agua eh sapo, servicio al cliente, atención de casos, resolución de quejas
Efraim Cuevas Aguilar, Carlos Andrés García Molina, Beatriz Rebeca Díaz Gómez, Rachel Leiva

flor de jamaica, paquetes informativos, mercadeo y media
Victor Fung, Giovanni Esquivel , Andres Baldi , Brendan Ramirez


