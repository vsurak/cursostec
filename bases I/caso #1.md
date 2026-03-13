# Guardian Check-In

**Caso #1 - Bases de datos I - 10%** 

**Prof. Rodrigo Núñez** 

## Descripción

La startup de seguridad tecnológica "SafePath Costa Rica" requiere el desarrollo de una infraestructura de datos robusta para su nueva plataforma de verificación de confianza en tiempo real. El sistema busca garantizar que los usuarios en un entorno físico específico puedan conocer la densidad de personas a su alrededor que cuentan con una certificación de antecedentes penales limpia y vigente.

El flujo inicia con un proceso de **Onboarding Biométrico** (vía OCR de cédula y pruebas de vida), seguido de una integración con el API del **Poder Judicial** para la extracción de la hoja de delincuencia. Una vez validado el perfil mediante IA, el sistema entra en un ciclo de monitoreo constante: actualiza los antecedentes cada 3 días y envía reportes geográficos con el estado de la hoja de delincuencia cada 3 minutos.

El desafío para el ingeniero es diseñar una base de datos  para este sistema y probarla, que permita realizar consultas geoespaciales eficientes para determinar cuántos usuarios "limpios" se encuentran en radios de 100m, 500m y 1km.

---
## 1. Modelado de Datos

* Crear un modelo de datos para postgreSQL que contemple usuarios, registros de validación biométrica, historial de antecedentes penales y logs de posicionamiento global.
* Es de suma importancia el uso de extensiones espaciales (como **PostGIS**) para el manejo de coordenadas `GEOGRAPHY` o `GEOMETRY`.
* Utilizar las reglas de verificación de diseños vistas en clase para evaluar la pertinencia y calidad del diseño hecho.
* Realizar los afinamientos del dise;o

## 2. Infraestructura y Despliegue

* El sistema debe ejecutarse sobre una imagen oficial de **PostgreSQL** (versión 15 o superior) utilizando **Docker**. Se debe entregar un archivo `docker-compose.yml` que levante el servicio.

## 3. Pruebas de Carga y Simulación (Scripts)

* Crear scripts de SQL para insertar **3,000 usuarios** ficticios.
* Los usuarios deben hacer reportes en un tiempo cercano en en **3 zonas geográficas distintas** de Costa Rica (ej. San José Centro, La Fortuna y Puerto Viejo).
* Simular al menos 3 registros de posición por usuario para demostrar la capacidad de historial de la tabla de geolocalización.

## 4. Consultas de Negocio (Query Geoespacial)

Debe entregar un procedimiento almacenado o una consulta SQL optimizada que reciba dos parámetros:

1. Punto de Origen: (Latitud, Longitud).
2. Radio de Búsqueda: Distancia en metros (100, 500, 1000).

**Resultado esperado:** El conteo exacto de personas cuyo estado actual sea "Limpio" y cuya última posición reportada esté dentro del radio definido.

## 5. Entregables 
1. **Script SQL de Creación:** Definición de tablas, índices espaciales y restricciones.
2. **Diagrama entidad relacion:** PDF del modelo de datos, el cual debe corrresponder 100% al script de creación. 
3. **Archivo Docker Compose:** Para replicar el entorno exacto de base de datos.
4. **Scripts:** Set de datos con los 3,000 registros y posiciones aleatorias en las zonas designadas, así como el query para demostrar que se puede obtener la información solicitada. 

