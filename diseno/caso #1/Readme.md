# Dua streamliner design 


**Author**: rodrigo nunez 

The current process of preparing the DUA is highly manual, time-consuming, and error-prone for importers and exporters. Information required to complete the document is typically scattered across multiple files such as Excel sheets, Word documents, PDFs, and scanned invoices. These documents often follow different structures and formats, making data extraction complex and heavily dependent on human interpretation. As a result, customs specialists spend significant time consolidating, validating, and transcribing information into the official template.

To address this challenge, the proposed solution is an automated system that requires only a folder path containing all relevant documents. The system will intelligently read multiple formats, extract both structured and unstructured data—including OCR from scanned images—and apply AI-driven semantic interpretation tailored to customs terminology. It will then automatically map the extracted information to the official DUA template defined by the Ministerio de Hacienda, validate basic consistency rules, and flag ambiguous or low-confidence fields for review.

The expected result is a fully pre-filled Word DUA document with visual confidence indicators that guide expert validation. This approach does not eliminate the customs specialist’s role but transforms it into a strategic review function, significantly reducing manual operational workload. Ultimately, the system aims to increase efficiency, reduce errors, accelerate processing times, and improve compliance accuracy in international trade operations.


# 1. Frontend design

## 1.1 Technology stack 

- Application type: server side rendering web app
- Web framework: reactjs version 19.2
- NodeJs version 21
- TypeScript 5.9.3
- Unit testing: Jest 30.2.0
- Zod 4.3.6 to data validation 
- Prettier 3.8.1
- eslint 10.0.2 
- Integration testing: Playwright version 1.58.2
- Cloud service: Azure cloud services
- Hosted by Azure App Service
- Code respositories by Azure DevOps
- Automated code tasks by Husky 9.1.7
- CI CD by Azure DevOps Pipelines
- Environments: development, stage and production
- Environment deployments Azure DevOps Environments
- Observability by Azure Application Insights SDK


## 1.2 UX UI analysis 

### Core business process
Describir paso a paso lo que sucede en cada pantalla en términos de acciones (no hablen de botones, ni listas ni de ningún componente visual, solo acciones de usuario y el resultado de cada acción)

#### Login
1. El usuario ingresa su login, password y el one time token
2. Al intentar loguearse si falla, se le presenta un mensaje de user and pass invalido
3. Si es succed ....

#### Configurar el generador

#### Monitoreo del avance

#### Obtención del resultado / exportar

#### Logout 

### Wireframes
Con esos pasos anteriores le pido a una AI que me genere los screens y los pego aqui con un titulo, descripción y la imagen empotrada.

Login screen
The user can login into his account using the microsoft authentication screen
![Login](/media/login.jpg)

- Seleccionar el folder 
- Seleccionar la plantilla de DUA
- Cómo monitoreo el avance del proceso 
- Cómo se ve el resultado final


### UX test results
- escoger alguna app para ejecutar el UX test usando esos wireframes
- el test se lo van a aplicar en forma remota compartiendo un URL a 3 estudiantes o amigos
- eso va  generar un reporte de resultados

- crear un markdown table con los resultados
- Evidencias
![Juan mi amigo de mante](/media/testdejuan.jpg)
![Ana la de mante](/media/ana.jpg)
![Tio de johel](/media/tio.jpg)

- Heatmap
![Dua steamliner heatmap](/media/heatmap.jpg)


## 1.3 Component design strategy

Los frameworks de desarrollo o lenguajes de programación por ejemplo para mobile apps poseen paradigmas para desarrollar sus componentes visuales. Esos métodos buscan lograr por ejemplo:

- Que el diseño sea uniforme, es decir, que las etiquetas se vean igual en todas las pantallas, que los botones sigan el mismo estilo, que los colores sean los de la marca y así sucesivamente.
- Reutilización, es decir, que el componente boton se crea solo una vez, el componente de seleccionar archivo solo una vez, que una caja de diálogo se programe solo una vez, y esto se reutilice en todas las ventanas. 
- Que sea uniforme aplicar el branding del sistema
- Detalles de forma se ajusten en un solo lugar y no mezclado con la lógica de negocios
- Si el sistema soporta múltiples idiomas o monedas, eso se haga a nivel visual en un lugar centralizado
- Que el sistema sea responsivo, es decir que se ajuste bien al tamaño de los distintos smartphones, tabletas, computadoras y browsers.
- Adecuar la accesibilidad, en caso de que el sistema requiera ser accesible en alguno de los niveles y estandards, aplicar los ajustes de accesibilidad a nivel de componentes únicamente, y así se propagan al resto del sistema 

Para crear la definición de esta sección entonces proceda con la AI:

1. Dado las tecnologías de desarrollo de frontend [listar las seccionadas], qué frameworks o estrategias de diseño por componentes ofrece, comparelas en una matriz por año de aparición y características de reutilización, internacionalización y responsividad, ventajas y desventajas.  

Esto les va a arrojar varias opciones con sus cualidades, ventajas y desventajas. Use esa información para seleccionar una de las opciones y documente en este apartado.

- name of the strategy
- reutilization by:
- internacionalization by:
- responsiveness by: 


## 1.4 Security 
Tecnologías, técnicas y classes con su respectiva ubicación en la estructura del proyecto responsables de la autenticación y la autorización de permisos y sesiones. 

- Si es MFA
- Qué medios de MFA soporta
- Si es single sign on o no
- Service de authentication , depende de la plataforma
- Definir si soporta google and or facebook authentication
- Si es RBAC, dar la lista de roles: rolename, description
- Para cada role, lista de permisos: codigo de permiso, descripcion
- Si tiene algun tipo de ACL y el nombre del servicio de ACL
- Si tiene PBAC, definir las políticas 
- Servicio de secure store para env variables, api keys, sensitive data
- authenticator server name

## 1.5 Layered design
diseño y explicación de las diversas capas de la aplicación en el frontend. 

## 1.6  Design patterns 
Diseño de classes con su respectiva ubicación en la estructura del proyecto, donde sea necesario aplicar patrones de diseño orientado a objetos, como por ejemplo: seguridad, refrescado de UI, recepción de notificaciones, almacenamiento de estados, llamadas a api, operaciones asíncronas, invalidación de sesiones, programación por eventos, creación de objetos. 

## 1.7 un folder en /src

que contiene el scaffold del proyecto, el cual se genera a partir de toda la especificación de los puntos del 1.1 al 1.6. 




# Backend design

# Data design