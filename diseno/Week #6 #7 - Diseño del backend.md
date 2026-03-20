# Backend design

## Technology stack

Al diseñar el backend debes **decidir explícitamente** protocolo de transporte/aplicación, estilo de API, paradigma de la lógica de negocio y dónde se ejecuta (hosting). No hay una “mejor” opción universal: depende de clientes, latencia, consistencia, equipo y presupuesto.

### Protocolo de aplicación y de transporte

| Decisión | Opciones típicas | Cuándo inclinar la balanza |
|----------|------------------|----------------------------|
| Transporte | **TLS sobre TCP (HTTPS)**, **HTTP/2**, **HTTP/3 (QUIC)** | Internet público → HTTPS obligatorio; muchas peticiones pequeñas en paralelo → HTTP/2 o HTTP/3; IoT/restricciones → a veces MQTT sobre TLS. |
| Estilo de API sobre HTTP | **REST** (recursos + verbos), **OpenAPI** como contrato | Integraciones amplias, caching HTTP, simplicidad; estándar de facto. |
| Consultas flexibles | **GraphQL** | Clientes muy distintos que necesitan distintos “shapes” de datos; cuidado con N+1 y complejidad operativa. |
| RPC de alto rendimiento | **gRPC** (HTTP/2, Protobuf) | Microservicios internos, baja latencia, contratos fuertes; menos natural para navegador puro (aunque hay grpc-web). |
| Tiempo real | **WebSockets**, **SSE** (Server-Sent Events) | Chat, dashboards en vivo, notificaciones push desde servidor. |
| Mensajería / eventos | **AMQP** (RabbitMQ), **Kafka protocol**, **cloud-native** (SQS, Pub/Sub, Event Grid) | Desacoplar productores/consumidores, picos de carga, sagas, procesamiento asíncrono. |

**Paradigma de la lógica de negocio (no es solo “REST o no”):**

- **Sincrónico request/response** (HTTP/RPC): simple de razonar; acopla disponibilidad entre servicios.
- **Asíncrono por eventos/colas**: mejor absorción de picos; exige idempotencia, compensaciones y trazabilidad.
- **Batch / ETL** para reporting o reconciliación, separado del camino online.

### API service (capa de exposición)

Patrones y piezas que sueles elegir:

- **API Gateway / Management**: enrutamiento, throttling, autenticación en borde, versionado, documentación (OpenAPI), WAF asociado.
- **BFF (Backend for Frontend)**: un backend por familia de clientes (web vs móvil) cuando los modelos de datos divergen mucho.
- **GraphQL gateway / federación** vs un solo monolito de API: gobierno del esquema y límites de profundidad/query cost.

**Referencias cloud (elegir según ecosistema ya adoptado):**

| Rol | AWS | GCP | Azure |
|-----|-----|-----|--------|
| Gateway / gestión API | **API Gateway**, **AppSync** (GraphQL) | **API Gateway**, **Apigee** (empresa) | **API Management** |
| Balanceo + TLS en borde | **ALB**, **NLB**, **CloudFront** | **Cloud Load Balancing**, **Cloud CDN** | **Application Gateway**, **Front Door** |
| Autenticación / identidad | **Cognito**, **IAM** | **Identity Platform**, **IAP** | **Entra ID** (Azure AD), **API Management + OAuth** |

### Hosting service (dónde corre el código)

| Modelo | Qué decides | Ejemplos cloud |
|--------|-------------|----------------|
| **IaaS** (VMs) | Máximo control; tú parches SO y runtime | **EC2**, **Compute Engine**, **Virtual Machines** |
| **PaaS / contenedores gestionados** | Menos ops; escalado y despliegue simplificados | **Elastic Beanstalk**, **App Runner**, **ECS Fargate** / **EKS** · **Cloud Run**, **GKE** · **App Service**, **Container Apps**, **AKS** |
| **Serverless (funciones)** | Escala a cero; límites de tiempo y cold starts | **Lambda** · **Cloud Functions** · **Azure Functions** |
| **Serverless de contenedores** | Híbrido: imagen + escala automática | **App Runner**, **Cloud Run**, **Container Apps** |

**Lenguajes y frameworks (elección habitual por ecosistema y rendimiento):**

- **JVM**: Spring Boot, Quarkus, Micronaut — equipos enterprise, ecosistema maduro.
- **Node.js**: Express/Fastify/Nest — I/O intensivo, mismo lenguaje que frontend.
- **Python**: Django, FastAPI — productividad, ML cercano al API.
- **Go**: stdlib + Gin/Echo/Fiber — binarios pequeños, concurrencia clara.
- **.NET**: ASP.NET Core — integración fuerte con Azure.
- **Rust**: Actix/Axum — latencia y seguridad de memoria cuando el costo de complejidad se justifica.

## Servicios, microservicios, repos y DDD

Hay **tres ejes distintos** que suelen mezclarse: (1) **cómo despliegas** (un artefacto vs varios), (2) **cómo versionas el código** (un repo vs muchos), (3) **cómo modelas el dominio** (DDD es enfoque de diseño, no “tamaño del repo”). Puedes usar DDD en un monolito modular o en microservicios; un monorepo puede contener un solo deployable o docenas.

### Qué es cada cosa (en una frase)

| Concepto | Idea central |
|----------|----------------|
| **Servicio / capa de servicio** | Unidad lógica de capacidad de negocio expuesta (API, cola, batch). En un monolito suele ser un **módulo** o paquete; en microservicios, un **proceso desplegable** propio. |
| **Microservicios** | Varios despliegues **independientes**, límites de equipo/dominio fuertes, comunicación por red (HTTP, gRPC, eventos). Coste: operación, consistencia distribuida y trazabilidad. |
| **Repos separados (multirepo)** | Un repositorio Git por producto, equipo o servicio. Límites claros de permisos y ciclo de vida; más fricción para cambios que cruzan muchos repos. |
| **Monorepo** | Un solo repositorio con **varios proyectos/paquetes** (apps, librerías compartidas). Facilita refactors transversales y una sola política de CI; exige disciplina en límites y herramientas de build. |
| **Domain-Driven Design (DDD)** | Alineación del modelo de software con el **lenguaje y procesos del negocio**: **contextos delimitados (bounded contexts)**, **agregados**, **dominio vs infraestructura**. Define *qué* partes existen y cómo se relacionan; no impone solo microservicios ni solo monolito. |

### Comparación rápida (cuándo inclinar la balanza)

| Dimensión | Monolito modular / “servicios internos” | Microservicios |
|-----------|----------------------------------------|----------------|
| Despliegue | Un solo pipeline; rollback simple | Varios pipelines; versionado y compatibilidad entre servicios |
| Consistencia transaccional | Más fácil (misma BD / misma app) | Sagas, eventos, eventual consistency |
| Equipo | Equipo pequeño–medio, producto en evolución | Varios equipos autónomos, escalado independiente por carga |
| Complejidad operativa | Baja–media | Alta (red, observabilidad, contratos) |

| Dimensión | Multirepo | Monorepo |
|-----------|----------|----------|
| Propiedad | Repo = dueño claro (equipo/servicio) | Límites por carpetas/herramientas, no por repo |
| Cambios cruzados | Varios PRs, versionado de librerías entre repos | Un PR puede tocar API + clientes + libs compartidas |
| CI | Pipeline por repo (simple mentalmente) | **Build/test afectados** (solo lo que cambió) para no explotar tiempos |
| Seguridad / acceso | Permisos granulares por repositorio | Permisos por paths o subproyectos (más trabajo de gobierno) |

**DDD y arquitectura:** un **bounded context** suele mapearse a un **módulo** (monolito) o a un **servicio** (microservicios), pero la regla es de **cohesión del dominio**, no de moda tecnológica. **Tactical patterns** (entidades, value objects, repositorios) aplican dentro de cada contexto.

### Tecnologías y herramientas de referencia (para comparar en diseño)

| Ámbito | Para qué sirve en la comparación | Ejemplos habituales |
|--------|----------------------------------|---------------------|
| **Monorepo / build** | Orquestar muchos paquetes, caching, “solo build lo tocado” | **Nx**, **Turborepo**, **Bazel**, **Rush**, **Gradle** (multi-project), **Cargo workspaces** |
| **Contratos entre servicios** | Evolución de APIs sin romper consumidores | **OpenAPI**, **AsyncAPI**, **Protobuf** / **gRPC**, **JSON Schema** |
| **Orquestación de microservicios** | Despliegue, escalado, redes entre servicios | **Kubernetes** (**EKS**, **GKE**, **AKS**), **Nomad** |
| **Service mesh** (opcional) | mTLS, retries, observabilidad L7 entre pods | **Istio**, **Linkerd**, **Consul Connect** |
| **Plataforma de desarrollo** | Abstracción común sobre K8s (golden paths) | **Backstage**, **Dapr** (building blocks portables) |
| **Eventos entre contextos** | Acoplamiento débil, integración asíncrona | **Kafka**, **RabbitMQ**, **NATS**, colas cloud (**SQS**, **Pub/Sub**, **Service Bus**) |
| **CI en monorepo** | Detectar proyectos afectados por cambio | **Nx affected**, **Turborepo** `--filter`, **Bazel** query, **path filters** en GitHub Actions |

En el documento de diseño conviene dejar **explícito**: límites de dominio (DDD), **cuántos artefactos desplegables** hay, **dónde vive el código** (mono vs multi-repo) y **cómo versionan contratos** entre partes — antes de profundizar en seguridad y observabilidad.

## Security

Decisiones que el diseñador debe dejar **explícitas en el diseño**, no solo “implementar después”:

- **Autenticación vs autorización**: OAuth2/OIDC para delegación; **JWT** con cuidado de expiración, rotación y tamaño; **mTLS** entre servicios en Zero Trust.
- **Secretos**: nunca en repo; **AWS Secrets Manager / Parameter Store**, **GCP Secret Manager**, **Azure Key Vault**.
- **Cifrado**: TLS en tránsito; en reposo según regulación (**KMS** en cada nube, CMK si aplica).
- **Superficie de API**: rate limiting, validación de entrada, tamaño de payload, protección **OWASP API Top 10**.
- **Red**: VPC/VNet, subredes privadas para bases de datos, **Security Groups** / firewall rules, **PrivateLink** / **VPC endpoints** / **Private Service Connect** para no exponer servicios a Internet.
- **Cumplimiento**: retención de logs, residencia de datos (regiones), DPIA si hay datos personales.


## Observability

Tres pilares; el diseño debe indicar **qué instrumentar y dónde se centraliza**:

- **Logs**: estructurados (JSON), correlación con **request-id/trace-id**; destinos típicos: **CloudWatch**, **Cloud Logging**, **Azure Monitor / Log Analytics**.
- **Métricas**: latencia p95/p99, tasas de error, saturación (CPU, colas); **Prometheus + Grafana**, o managed: **CloudWatch**, **Cloud Monitoring**, **Azure Monitor**.
- **Trazas distribuidas**: **OpenTelemetry** → **AWS X-Ray**, **Cloud Trace**, **Application Insights**.

Patrones de aplicación: **health checks** (liveness/readiness), **correlation IDs** en todos los servicios, **SLIs** definidos desde el diseño (disponibilidad, latencia).

## Infraestructure (devops)

Qué fijar al diseñar el backend “como sistema”:

- **IaC**: **Terraform**, **Pulumi**, **CloudFormation** (AWS), **Bicep** (Azure), **Deployment Manager** (GCP, menos común que Terraform).
- **CI/CD**: **GitHub Actions**, **GitLab CI**, **CodePipeline**, **Cloud Build**, **Azure DevOps**; estrategias **blue/green** o **canary** para APIs críticas.
- **Entornos**: dev / staging / prod con **paridad razonable**; datos sintéticos o anonimizados en no prod.
- **Contenedores**: imágenes inmutables, escaneo de vulnerabilidades, políticas en **ECR**, **Artifact Registry**, **ACR**.

## Availability

Trade-offs entre costo y continuidad del servicio:

- **SLA del proveedor** vs **SLA que prometes al negocio**; diseño multi-AZ como mínimo en producción seria.
- **Multi-región**: activo-pasivo (failover) vs activo-activo (más complejo en datos).
- **Base de datos**: réplicas de lectura, failover automático (**RDS Multi-AZ**, **Cloud SQL HA**, **Azure SQL** opciones HA).
- **Patrones**: **circuit breaker**, **timeouts + retries con backoff**, **bulkhead** para no tumbar todo el API por un dependiente lento.
- **Degradación controlada**: feature flags, respuestas parciales, colas de absorción.

## Scalability

**Escalar** puede ser horizontal (más instancias) o vertical (más CPU/RAM); el diseño debe decir **qué cuello de botella esperas**:

- **Stateless** en la capa de aplicación: sesión externa (**Redis**, **ElastiCache**, **Memorystore**) o JWT stateless con trade-offs.
- **Colas y workers** para trabajo pesado (**SQS + Lambda**, **Pub/Sub + Cloud Run**, **Service Bus + Functions**).
- **Particionamiento / sharding** de datos cuando el monolito de BD deja de bastar.
- **Caching**: **ElastiCache**, **Memorystore**, **Azure Cache for Redis**; **CDN** para estáticos y a veces **edge caching** de GETs seguros.
- **Auto-scaling**: métricas (CPU, RPS, longitud de cola, latencia); límites máximos para control de costos.

