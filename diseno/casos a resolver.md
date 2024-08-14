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

#### To carry out the previous steps, a high-level guide is provided below

1. Access the FGA of Auth0 by Okta and create your free trial account.
2. Create your first authorization store.
3. Log in to the FGA dashboard.
4. Follow the getting started guide, design the model, and create the rule tuples.
5. Test the model and rules: ask if a group has a certain permission in a specific application, if a user has access permission in a particular application, or if a user has a certain permission in an application inherited from belonging to a specific group; both for failed and successful cases.
6. Once your model and rules are working, finalize the proof of concept by making the API calls from Postman.
7. Follow the steps in the dashboard to create a client. This client will only perform security checks and will not modify any authorization settings.
8. Once the client is created, you will have a model ID, client ID, and client secret.
9. Obtain an access token through the /oauth/token API, as described in the FGA API help instructions, always using Postman.
10. With the access token, proceed to make the checks, simulating the same tests from step 5 but through the API using Postman, /stores/{{store_id}}/check.

**Other reference links**

Okta Developer REST API Reference: https://developer.okta.com/docs/reference/rest/

**Final instructions**
Review dates: August 19, 20, and 21.
The professor will assign review appointments.

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
Fecha de entrega: viernes 30 de agosto, 8pm 
Email: vsurak@gmail.com 
Subject: Caso #2 - LightSoul
Contenido: link al repositorio de git con el readme.md, lista de integrantes 

