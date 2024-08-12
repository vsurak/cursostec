# caso #1, 10%, authorization and authentication

_instituto tecnológico de costa rica_, escuela de computación  
_diseño de software_  
_prof. rodrigo núñez_  
_tipo:_ individual

## descripción 
At the company GummyBears, there are several applications that are used both internally and externally. For years, they've used their own model for permissions per application/database. However, now they want to migrate everything to a cloud-based authentication/authorization service and are deciding which platform to use. For authentication, they are considering whether to use [Okta](https://www.okta.com/), [Auth0](https://auth0.com/), or [Firebase](https://firebase.google.com/). As for authorization, they are certain they will use [Okta Fine-Grained Authorization](https://auth0.com/fine-grained-authorization).

To evaluate which tool to use, you will conduct a proof of concept to familiarize yourself with the platform and understand the complexity involved in integrating these services' APIs into the existing applications. The proof of concept will be done using Postman to avoid programming, focusing solely on identifying the endpoints, requests, and responses that will need to be implemented in the future. Additionally, this will provide an understanding of what it takes to configure the chosen platform.


### Authentication
1. Investigate how authentication can be performed with pre-created users in the administrative console of the service among Okta, Auth0, and Firebase.

2. Choose a single service from those investigated to conduct the proof of concept. Create users with passwords, always using the resources provided by the service. It is not expected at any point that you will create a custom service with a tailor-made database.

3. Configure the selected cloud service for authentication and create at least four different users.

4. Using Postman, make a call to the respective endpoint to perform authentication via username, password, and client credentials. Keep in mind that for many of these services, Postman collections may already exist to facilitate this step. The response from this request should confirm that the login and password are correct, thereby confirming the receipt of the expected session token or access token. 

5. Once basic authentication is confirmed to be working, enable MFA or two-factor authentication, and make the respective API calls to log in and confirm the two-factor authentication.

### Authorization

Once the user is properly authenticated, authorization calls must be made. Configure your authorization rules as follows:

**User Groups:**
- **Marketing**: Can only access the CRM application.
- **Sales**: Can access both the CRM and Payments applications.
- **C-Level**: Can only access the CRM application.

**User Configuration:**
- There is at least one user who is only a member of Marketing.
- There are at least two users who are only members of Sales.
- There is one user who is only a member of C-Level.

Below are two screenshots corresponding to the two applications. They contain numbered markers indicating the permissions that need to be authorized within each app for the proof of concept.

### Screenshot of the GummyBears Payments Application
![Image](./images/paymentmethods.jpg)

- **#1**: A permission or permissions that determine which payment methods the user is entitled to use. The two Sales users should be configured with different payment methods.
- **#2**: Permission to determine whether the user can access and modify the contact info. A Sales user will not have this permission.

### Screenshot of the GummyBears CRM Application
![Image](./images/salesreport.jpg)

- **#3**: Permission to determine whether the user can see the two sales columns: *Sales Goals* and *Sales Amount*. Users in C-Level can see it, other groups cannot, but one specific Marketing user will have the right to see it. This permission is granted directly to the user, not to the group.
  
- **#4**: Permission to display the "Sales Target Progress" card. Only members of C-Level can see it.

#### para realizar los pasos anteriores se da a continuación una guía a alto nivel

1. Ingrese al FGA de auth0 de Okta y cree su cuenta free trial
2. Cree su primer store de autorización
3. Haga login en el dashboard de FGA
4. Siga la guía del getting started, diseñe el modelo, cree las tuplas de las reglas
5. Pruebe el modelo y las reglas: pregunte si un grupo tiene cierto permiso en cierta aplicación, si un usuario tiene permiso de ingreso en cierta aplicación, si un usuario tiene cierto permiso en cierta aplicación que fué heredado por pertenecer a cierto grupo; tanto para casos fallidos como correctos. 
6. Una vez que su modelo y reglas funciona, cierre la prueba de concepto haciendo las llamadas desde postman
7. Siga los pasos en el dashboard para crear un cliente, dicho cliente solo va a hacer security checks, no va a modificar ninguna configuración de la autorización.
8. Una vez creado el cliente ya cuenta con un modelid, client_id y client_secret
9. Obtenga un acecss token por medio del api /oauth/token que salen en las instrucciones en la ayuda del api de FGA, siempre todo por medio de postman
10. Con dicho access token proceda a hacer los checks, simulando lo mismo que probó en el paso 5 pero por medio del api llamandose desde postman, /stores/{{store_id}}/check


**otros links de referencia**

Okta developer REST api reference, https://developer.okta.com/docs/reference/rest/

**indicaciones finales**
Fecha de revisión contra cita:  19, 20 y 21 de agosto. 
El profesor asignará citas de revisión. 


# caso #2, 7%, UX test un caso de la vida real

_instituto tecnológico de costa rica_, escuela de computación  
_diseño de software_  
_prof. rodrigo núñez_  
_tipo:_ grupos de 4 personas, aleatorios


## descripción

LightSoul es una empresa que instala iluminación de alta gama con un estilo futurista. Normalmente realizan las ventas desde una sofisticada aplicación web. El director de innovación los ha convocado a una reunión donde les quiere explicar una nueva idea que tiene para la aplicación de ventas, esto para que diseñen una primer versión del UI para este nuevo módulo. 

Se va a realizar el ejercicio simulando una situación del mundo real. El profesor durante 10 minutos será el director de innovación que les ha convocado a la reunión ejecutiva donde explicará esta nueva idea. Usted deberá tomar anotaciones y hacer preguntas, buscando tener la mayor claridad posible de la idea, pués, deberá diseñar el UI para este módulo y esta va a ser la única oportunidad de recabar información. 

1. El profesor procederá a armar los grupos en discord. 
2. Cada grupo deberá investigar qué herramientas podrían usarse para crear mockups/wireframes para una propuesta UI del módulo.
3. Utilice como un criterio de suma importancia el cómo podría testear la usabilidad de la interfaz UI propuesta por medio de algún servicio digital, donde pueda realizar pruebas asistidas por humanos para obtener resultados sobre el comportamiento y uso del UI propuesto.
4. Investigue al mismo tiempo, que resultados y en que formato se podría estar obteniendo de las pruebas de usabilidad.
5. Antes de proceder con el diseño del UI y posterior a investigar los puntos anteriores, presente al profesor una propuesta de en qué se haría el UI, cómo harían las pruebas de usabilidad y qué resultados estarían obteniendo, obtenga del profesor el visto bueno final antes de iniciar. 
6. Diseñen los mockups/wireframes del UI del módulo solicitado 
7. Realice las pruebas de usabilidad usando los mockups creados en la herramienta de creación y apoyandose en la herrmienta de testing de usabilidad.
8. Documente los resultados, errores, tendencias, comportamientos que revele el estudio de usabilidad. Recuerde que encontrar errores y que el UI falle, significa que el ejercicio fué muy bueno y está correcto.
9. documente en un readme.md file el UI, el proceso que se seguió para el test de usabilidad, los sujetos de prueba, los resultados obtenidos de las pruebas de usabilidad y un listado de las correciones que le harían al UI para mejorar los problemas encontrados. Realice la investigación respectiva para ver ejemplos de como mostrar esta información. 

Suba el MD file a un repositorio de git y envíe ese link como su entregable final del caso.
Fecha de entrega: 
Email: vsurak@gmail.com 
Subject: Caso #2 - LightSoul
Contenido: link al repositorio de git con el readme.md, lista de integrantes 

