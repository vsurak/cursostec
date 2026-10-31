# Caso #3 - 15% — Portal Seguro de Análisis de Taxis

## Descripción del problema

El estudiante debe construir un portal web para analizar un conjunto de datos de taxis de gran tamaño. Un usuario inicia sesión con su usuario y su contraseña. Si la autenticación es correcta, el usuario recibe una credencial que delimita los `LocationID` en los que puede ver información y también limita las columnas que puede consultar.

En un área de entrada de filtro de búsqueda, el usuario puede solicitar filtrar la información escribiendo el nombre del campo y el valor que quiere ver en ese campo. También puede usar los operadores `>`, `<`, `>=`, `<=` o `==`. Cada campo filtrado se separa por coma.

Con esto, la consulta se envía al servidor cifrada, junto con el token cifrado. El token se vuelve a validar en el servidor, se descifra y, por medio de los `LocationID` autorizados y de los campos filtrados en la consulta, el servidor hace la búsqueda en el conjunto de datos. Conserva únicamente los registros que cumplen los criterios filtrados y los `LocationID` permitidos. El tier del usuario también filtra las columnas que puede ver. Habrá tres tiers: **public**, **analyst** y **owner**. El estudiante debe asignar columnas a discreción a cada tier; ese mapeo queda en el archivo de configuración del programa.

En el despliegue deben verse solo los registros y las columnas que el usuario puede ver, con un estilo visual de color intercalado en las filas y los títulos de las columnas con otro color.

El conjunto de datos a utilizar es [anandshaw2001/taxi-dataset](https://www.kaggle.com/datasets/anandshaw2001/taxi-dataset). Debe usarse el **total** del conjunto de datos: las **18 columnas** y los **11 916 667** registros.

Un aspecto importante de este programa es que la respuesta del servidor no puede tardar más de **1,3 segundos** en aparecer en el navegador.


## Lo que el estudiante debe hacer

1. Construir una aplicación web en React / Next.js (Node.js) que permita a un usuario autenticado iniciar sesión, enviar una consulta de filtro y recorrer el conjunto de resultados autorizado, con colores intercalados en las filas y un color distinto para los títulos de las columnas.

2. Construir un backend en **Python o Java** que autentique al usuario, valide tokens, descifre la consulta, aplique la autorización de filas y columnas, y devuelva los registros coincidentes.

3. Ejecutar el frontend y el backend como **dos contenedores Docker separados**.

4. Cargar y buscar en el conjunto de datos de taxis **completo** (las 18 columnas y los 11 916 667 registros) **sin usar una base de datos**.

5. Diseñar e implementar un **algoritmo paralelo** para el filtrado de filas y columnas. Complementar ese algoritmo paralelo con al menos otra técnica algorítmica estudiada en el semestre en el curso.

6. Implementar la autenticación, la autorización, la creación de tokens, los claims, el cifrado y la validación de tokens **en los endpoints del servidor**. No usar un servidor de tokens existente.

7. Implementar PGP con algoritmos de cifrado ya existentes (no inventar un cifrado nuevo). Enviar el usuario y la contraseña con **cifrado asimétrico**. Tras un inicio de sesión correcto, continuar la comunicación bajo el protocolo **Pretty Good Privacy (PGP)**. Todo el intercambio entre la página web y el servidor es vía **JSON sobre HTTP**.

8. Mantener la lista de usuarios, contraseñas, roles o tiers y los `LocationID` autorizados en un archivo de usuarios. Mantener las columnas permitidas para cada tier (**public**, **analyst**, **owner**) en un archivo de configuración.

9. En el frontend se permite paginación o lazy loading. En el servidor, cada consulta debe extraer **todos** los registros que coincidan con la solicitud y guardarlos en una caché (o una estructura equivalente en memoria), de modo que la paginación o lazy loading lea de esa caché y **no** vuelva a ejecutar la búsqueda completa.

10. La consulta es **solo filtrado**. Se asume que el usuario escribe los parámetros, los operadores y los nombres de campo en el formato correcto.

11. Implementar todos los algoritmos especializados de la solución con los **comandos de spec-driven development** proporcionados por el profesor. 

12. En la evaluación se considerará la estrategia usada para navegar todo el conjunto de datos, el acomodo elegido para la búsqueda algorítmica y la capacidad de responder dentro del tiempo límite.

---

## Autorización y autenticación

- El usuario debe iniciar sesión con usuario y contraseña.
- El backend comprueba ese usuario y esa contraseña contra un archivo de usuarios. Ese archivo almacena las contraseñas, el rol o tier asociado y los `LocationID` que ese usuario puede consultar.
- Cada tier determina la lista de columnas que un usuario puede ver.
- El usuario y la contraseña deben enviarse mediante **cifrado asimétrico**.
- Si el usuario y la contraseña son válidos, se pasa al protocolo **Pretty Good Privacy (PGP)** para continuar la comunicación.
- Todo el intercambio entre la página web y el servidor es vía JSON y HTTP.
- Si el usuario es válido, la sesión y los tiers, en forma de claims, se meten en el access token, el cual se cifra con la misma llave privada del PGP y se retorna al cliente. En el cliente se descifra y se aplican las restricciones de tier del usuario, así como la lista de `LocationID`.

---

## Otros aspectos

- La aplicación web será una app React.js con Next.js y Node.js, ejecutada como un contenedor de Docker.
- No se puede hacer uso de base de datos.
- Deberá diseñar un algoritmo paralelo para el procedimiento de filtrado de filas y columnas.
- Debe implementar el PGP con algoritmos de cifrado ya existentes.
- No usar un servidor de tokens; programe usted la creación de tokens, claims, cifrado y validación de los tokens en los endpoints del servidor.
- Complemente el algoritmo paralelo con alguna de las otras técnicas de algoritmos vistas en clase.
- Se evaluará la estrategia que siga para poder navegar toda la información del conjunto de datos, el acomodo que haya hecho para búsqueda algorítmica y para dar respuesta en menos del tiempo límite.
- En el frontend puede usar paginación o lazy loading. Sin importar la técnica, el servidor sí debe extraer toda la información solicitada en la consulta y ponerla en caché o similar, de forma que el paginado opere sobre la caché o memoria y no tenga que volver a hacer la consulta.
- La consulta es solo filtrado, y se asume que el usuario va a hacer el input de los parámetros, operadores y filtros con el formato correcto y los nombres correctos.
- El servidor puede hacerse en Python o Java, funcionando como backend, y debe correrse en otro contenedor de Docker.
- Todo lo que sea algoritmos especializados de la solución deberá hacerse con los comandos de spec-driven development proporcionados por el profesor.
- Todo el proyecto debe estar en **GitHub**, con un `README.md` adecuado que explique las técnicas algorítmicas usadas, enlace a los archivos clave e incluya una guía de cómo ejecutar la solución (incluyendo ambos contenedores).
- Se revisan los commits hechos por los integrantes del grupo de trabajo. Se espera que cada integrante tenga contribuciones visibles en el repositorio.
- Se puede usar inteligencia artificial para construir la solución. Sin embargo, si el estudiante no puede explicar la **estrategia**, el **algoritmo** y el **código**, puede perder de **20 a 60 puntos** de la nota.
- Último commit: **miércoles 18 de noviembre de 2026**.
- Revisión con el profesor con cita previa.
