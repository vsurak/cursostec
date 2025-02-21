

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

Para los ejemplos se usará de base los siguientes requerimientos:

Ejercicio de diseño de UX, el profesor propone la siguiente aplicación:

### **App Summary:**
The purpose of the app is to connect pet owners with trusted pet care hosts in their local area. Pet owners can find reliable hosts who provide a safe and comfortable environment for their pets (cats and dogs) while they are away. Hosts can showcase their skills, living conditions, and availability, while pet owners can search, compare, and book services based on proximity, availability, and reviews. The app ensures secure payments, holds funds until the service is completed, and facilitates communication and feedback between both parties.


### **Functional Requirements:**

1. **User Roles:**
   - **Pet Owners:** Can search for hosts, book services, and manage their pet’s care.
   - **Pet Care Hosts:** Can create profiles, set availability, and offer pet care services.

2. **Registration and Profiles:**
   - Users can sign up as either a pet owner or a pet care host.
   - Hosts must provide:
     - Photos and videos of their home and pet care space.
     - Description of their skills, experience, and practices.
     - Details about the space where pets will stay and sleep (e.g., size, safety measures).
     - Availability (date range, hours, and flexibility).
     - Hourly fee for pet care services.
   - Pet owners can create profiles for their pets, including:
     - Photos, name, age, breed, and special needs.
     - Behavioral notes (e.g., friendly, shy, requires medication).

3. **Search and Filters:**
   - Search for hosts by:
     - Proximity (e.g., within 5, 10, 20 miles).
     - Date range and hours of availability.
     - Type of pet (cat or dog).
     - Hourly fee range.
     - Host ratings and reviews.
   - View host profiles with photos, videos, descriptions, and reviews.

4. **Booking and Payments:**
   - Pet owners can request bookings with hosts.
   - Hosts can accept or decline requests.
   - Secure in-app payment system:
     - Pet owners pay upfront, and funds are held by the app.
     - Funds are released to the host after the service is completed and both parties confirm satisfaction.
   - Cancellation and refund policies.

5. **Ratings and Reviews:**
   - Pet owners can rate and review hosts after the service.
   - Hosts can rate and review pet owners and their pets.
   - Display average ratings and comments on profiles.

6. **Communication:**
   - In-app messaging system for pet owners and hosts to communicate.
   - Notifications for booking confirmations, reminders, and updates.

7. **Safety and Verification:**
   - Hosts must undergo a verification process (e.g., ID verification, home inspection).
   - Option for hosts to provide references or certifications (e.g., pet first aid training).
   - Emergency contact information for both parties.

8. **Admin Dashboard:**
   - Admin can manage users, resolve disputes, and monitor transactions.
   - Ability to remove inappropriate content or suspend accounts.

9. **Additional Features:**
   - Option for hosts to offer additional services (e.g., grooming, walking).
   - Calendar integration for hosts to manage availability.
   - Push notifications for new bookings, messages, and reminders.


---