# Caso #1, 25%

Groups of 3. 

## Description
20minCoach is a real-time coaching platform that connects people with experts across multiple fields—such as health, psychology, law, mechanics, programming, cloud services, arts, agriculture, and more—through on-demand 20-minute video sessions. Users can describe their need by text or voice, review available coaches’ profiles, ratings, and specialties, and instantly connect once the coach accepts the request. Coaches manage their availability directly in the app, while ratings influence both their reputation and earnings. The business model is based on flexible packages that allow users to purchase a set number of coaching sessions, making expert guidance affordable, accessible, and time-efficient.

**20minCoach: A Day in the Life of Users and Coaches**

Imagine waking up on a Monday morning and facing a challenge: your car makes a strange sound, and you’re not sure what it means. Instead of spending hours searching online, you open **20minCoach**, an app designed to instantly connect people with professional coaches across dozens of areas—mechanics, psychology, art, law, cloud services, agriculture, and more.

As a **user**, you simply type or record a quick voice note explaining what you need: *“I think my car is making a noise from the engine, can someone help me understand what it could be?”* In seconds, the system searches for available coaches, prioritizing those closest to you. You see a mechanic’s profile: photo, professional background, customer reviews, and areas of expertise. Everything looks good, so you hit *Connect.* The mechanic receives a notification, confirms availability, and a **20-minute video call** starts right away. During this call, you show the noise on camera, describe what you hear, and the mechanic guides you on what to check and whether a repair shop visit is urgent.

The session ends after exactly 20 minutes, giving you focused, personalized advice without overcommitting your time or money. You rate the coach, leaving a short review. That rating directly contributes to the coach’s earnings and reputation within the platform.

From the **coach’s perspective**, the day looks different. Take Maria, a professional painter who uses her mornings to update her profile on 20minCoach, uploading new images of her work and writing about her teaching style. She sets herself as *Available* before starting her day. Later, while having coffee, she receives a notification: someone nearby is looking for help with watercolor techniques. She reviews the request, accepts, and within moments is in a video call. For 20 minutes, she provides guidance, tips, and even small live demonstrations. When the session ends, Maria checks her earnings, notes her updated rating, and toggles her availability off before moving on with her day.

**The Business Model**
20minCoach works with prepaid packages, making access to expert help affordable and flexible. For example:

* *Starter Package*: \$19.99 per month for 2 coaching sessions.
* *Pro Package*: \$59.99 per month for 8 coaching sessions.

This model allows users to plan ahead while giving coaches a consistent flow of opportunities to earn, all within a simple and structured 20-minute framework.


## Case resolution overview
Your task is to design the frontend architecture for the 20minCoach platform. This is a comprehensive software design project that will require research, decision-making, and detailed documentation. You will work on creating a scalable, maintainable, and efficient frontend system.

## Core Tasks to Perform

### 1. Proof of concepts to develop, required to refine the design

#### Source code
- include in the repository the src folder with the project structure
- such structure must match the designed frontend architecture
- all PoC must be store in this folder in the proper folders

#### Testing
- Design testing strategy and technology
- Implement a few unit testing class for any of the coded classes, place such classes in the project structure

#### UX & security

1. Generate a prototype screen using AI for the search and result of coaches. This must match all the technologies selected.

   * Use a AI tool liketo generate an initial layout.

2. Select a UX testing tool to evaluate your screen designed.

   * Examples: Maze, Useberry, Lookback, Optimal Workshop, make your the tool provides heat maps.
   * Upload your prototype to the tool.
   * Define at least 2 tasks for users to complete (e.g., "search for a coach specialized in fitness", "accept the suggested coach").

3. Run the test using people out of the course, demonstrate with evidence that you actually performed this with real people.

   * Recruit 3–5 participants not enrolled in the course.
   * Share the test URL with the participants and record your evidence.
   * Gather metrics like task completion rate, time on task, or error rate depending on what the tool offer
   * Deliver screenshots or session recordings as evidence.

4. Add authentication screen to the prototype.

   * Create a simple login screen with email, password, and a "Sign in" button. ( this screen is automatically created by some security providers)

5. Select two actions in the screens to be assigned to specific role permissions.

6. Using the security provider dashboard create a users, roles, and permission hierarchy.

   * Create two roles: (role names are just placeholders)

     * BasicUser: can perform only Action A.
     * PremiumUser: can perform both Action A and Action B.

   * In the provider dashboard (auth0 steps):

     * Go to Applications → APIs → Permissions.
     * Define permissions "permission\:A" and "permission\:B". this is just a placeholder do not use such names. 
     * Assign permissions to roles.
     * Create test users and assign them to roles.

7. Integrate your prototype app within the platform and make it work.

   * In Auth0 console:

     * Register your app under Applications → Applications → Create Application.
     * Select "Single Page Application".
     * Configure allowed callback URLs.
     * Enable the Authentication API.

   * In your prototype app code:

     * Install Auth0 SDK:

       ```bash
       npm install @auth0/auth0-spa-js
       ```
     * Initialize Auth0 client:

       ```javascript
       import createAuth0Client from "@auth0/auth0-spa-js";

       const auth0 = await createAuth0Client({
         domain: "YOUR_DOMAIN",
         client_id: "YOUR_CLIENT_ID",
         audience: "YOUR_API_IDENTIFIER",
         redirect_uri: window.location.origin + "/callback"
       });
       ```
     * Handle login:

       ```javascript
       await auth0.loginWithRedirect();
       ```
     * Handle logout:

       ```javascript
       auth0.logout({
         returnTo: window.location.origin
       });
       ```
     * Get authorization token and user roles:

       ```javascript
       const token = await auth0.getTokenSilently();
       const user = await auth0.getUser();

       // Roles and permissions come from namespaced claims
       const permissions = user["https://yourdomain.com/permissions"];

       if (permissions.includes("view:contact")) {
         renderContactDetails();
       }

       if (permissions.includes("schedule:session")) {
         renderScheduleButton();
       }
       ```
   * Test with both roles (BasicUser and PremiumUser).
   * Verify that the UI renders only the actions the logged user is authorized for.

--
## Design document main goal

### 1. Technology Research and Selection
- Research modern frontend frameworks and libraries
- Compare technologies such as React, TailWind, Vue, Angular and similar for this specific use case
- Evaluate state management solutions such as Redux or Mutex
- Research real-time communication technologies (WebRockets, WebRTC, Notification Services)
- Select testing frameworks and tools
- Choose styling methodologies and tools
- Document your technology choices with justification

### 2. N-Layer Architecture Design
- Design a layered architecture for the frontend application, layers are specify below 
- Define clear responsibilities for each layer
- Establish communication patterns between layers
- Ensure separation of concerns and maintainability

### 3. Visual Components Strategy
- Develop a component organization strategy, this might be lead by the technology choose
- Design how to achive a reusable component library structure
- Create a component development workflow based on the technology selected
- Establish component testing methodology

## Detailed Layer Design Requirements

### Visual components
- Design a component hierarchy based on the selected technology
- Specify how reusable UI components will work
- Decide accessibility standards
- Design the responsive guidelines within code examples of the practices that the dev team must to follow 

### Controllers
- Design controllers for business logic mediation
- Do not forget clarify the hook-based connectors in the controllers
- Handle user input validation and processing

### Model
- Design some model classes, specially for those required for the design patterns
- Design normalizated state shape for efficient updates
- Implement model validation documenting with an example what validator are you going to use

### Middleware
- Implement request/response interceptors
- Create middleware for permissions validation
- Design and implement an error handling middleware

### Business
- Design the classes holding the business logic 
- Create reusable business logic services
- Implement domain-specific rules and validation
- Design business logic testing strategy

### Proxy/Client/Services
- Design API client abstraction layer
- Create a client for the security section

### Background/Jobs/Listeners
- Design listeners for real-time updates
- Design periodic data refresh mechanisms

### Validators
- Correlate this section with the model design
- Provide at least one example of the validator 

### DTOs
- Design Data Transfer Object interfaces if need it
- Create transformation layer between API and frontend models
- Design the strategy to validate DTOs transformations using the validator layer

### State management
- Select and design the state management solution

### Styles
- Choose and design how CSS or styles are going to be manage
- Design the responsive rules of the design
- Design an strategy for dark/light mode support

### Utilities
- Desing the utilities layers modeling a few example clases 

### Exception Handling
- Design and implement in code an standard way to handle exceptions
- Make sure the exception handling use the logging layer
- Make sure pure errors are not raise to upper levels of the code and produce a friendly message 

### Logging
- Design structured logging system using strategy pattern to allow multiple logging providers 
- Implement a general Logger class 

### Security
- Design authentication and authorization layers

### Linter Configuration
- Select a linting tool 
- Define code style rules and conventions
- Include the linter in the project and document guidelines of how to use id

### Build and Deployment Pipeline
- Design build process for different environments
- Create development, staging, and production builds in the configuration files
- Create deployment documentation guidelines in the readme.md

## Deliverables

### 1. Repository Structure
- Create a GitHub/GitLab repository 
- Initialize with proper readme.md
- Include all the design of the previous tasks in the readme.md
- Add diagrams folder for architecture visuals, embedding such images into the readme.md
- Include code examples where appropriate
- Add the complete project structure into the src folder and including the proof of concepts made

### 2. Documentation
- Create comprehensive readme.md document
- Include all sections outlined in this project brief
- Provide clear explanations and justifications
- Use diagrams and visual aids where helpful
- Include code snippets and examples

### 3. Architecture Diagrams
- Create N-Layer architecture diagram
- Include object design with design patterns applied
- Clearly label all components and their relationships
- Document design pattern usage in the diagram 
- Specify class responsibilities and interactions mostly when interacting with specific patterns
- The full architecture diagram must be a pdf perfect readable 


- Last date for questions to the professor: Monday 22nd, september
- Last date to commit: Saturday 27th, September
- Commits are going to review to validate every group member participation along the 3 work weeks, penalties might apply

---

**Class Activities:**

1. Research which AI tool would be most convenient for generating the prototype and that provides access to the source code for further development.

2. Create a paper prototype of the screen for searching a coach and the screen for reviewing the selected coach.

3. Determine the following:
   a) AI provider to generate the prototype
   b) Technology stack to be used for developing the frontend
   c) Security provider for the integration

Present the three points above along with the prototype screens at the end of the class.

---

In case #1, in the section "Detailed Layer Design Requirements", detail how your group is going to document this, emphasis in what is going to be the output and the document structure. 

