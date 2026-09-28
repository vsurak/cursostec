# Resultado de shares — Conversatorio #2 POO

## Tabla resumen (ordenada de mayor a menor)

| Nombre completo | Nickname | Shares totales | Shares sin tope |
|---|---|---|---|
| MADRIGAL CAMPOS ANDRES | PoseidonNaranja | 64 | 64 |
| FERNANDEZ CASTRO ANTHONY | HeraNegro | 62 | 62 |
| HERNANDEZ CAMACHO IGNACIO | AteneaBlanco | 60 | 60 |
| COREA HERRERA STEVEN FERNANDO | OdinVerde | 36 | 36 |
| ROJAS BARRIOS MARTIN FRANCISCO | LokiRosa | 34 | 34 |
| SANCHEZ POVEDA DANIEL | IsisBeige | 28 | 28 |
| VARGAS VARGAS GABRIEL | VulcanoBronce | 27 | 27 |
| ZUNIGA ARROYO PATRICK SEBASTIAN | MartePerla | 23 | 23 |
| ZUNIGA PICADO DAVID | NeptunoJade | 8 | 8 |

Ningún estudiante superó los 100 shares, por lo que el tope no se aplicó en ningún caso.

Nota de contexto: en la grabación se identifican dos bloques temáticos distintos. El
"Audio 2" (Patrick, David, Andrés, Anthony, Ignacio) se centró en polimorfismo, herencia,
clases/métodos abstractos e interfaces en general (criterios 1–3), mientras que el
"Audio 1" (Steven, Gabriel, Daniel, Martín) se centró en la crítica del diagrama de
facturación (criterio 4). Por eso varios estudiantes obtienen 0 en criterios cuyo tema
simplemente no fue abordado en su intervención, no porque se haya evaluado negativamente
algo que sí dijeron.

Corrección: Martín Rojas Barrios (LokiRosa) había sido inicialmente excluido por
identificarse erróneamente como una persona ajena a la lista de estudiantes; se confirmó
que sí es un estudiante evaluable y se agregó su evaluación. Es, de hecho, el único
estudiante que detectó por cuenta propia ambos errores marcados por el profesor en el
diagrama (colección de invoices + herencia invertida).

---

## Detalle por estudiante

### MADRIGAL CAMPOS ANDRES (PoseidonNaranja) — 64 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.75 | 23 | Jerarquía de Cuenta con `actualizar()` sobreescrito distinto por subtipo; muestra bien el poder polimórfico de la herencia, pero no menciona encapsulamiento. |
| 2. Herencia vs interfaces | 35 | 1.0 | 35 | Regla explícita: mismo linaje → herencia, comportamientos distintos → interfaces (ejemplo transporte/moverse), además de la ventaja de implementar varias interfaces a la vez. Cobertura completa del criterio. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.25 | 6 | Menciona flexibilidad para combinar comportamientos diversos, pero no limitaciones ni razón de ser de interfaces del Java API. |
| 4. Detección de problemas de diseño | 25 | 0.0 | 0 | No aborda el diagrama de facturación (tema de otro segmento de audio). |

### FERNANDEZ CASTRO ANTHONY (HeraNegro) — 62 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.75 | 23 | Lista de tipo padre con objetos de cualquier subclase (polimorfismo) + obligación de implementar métodos abstractos en las hijas; sin vínculo explícito con encapsulamiento. |
| 2. Herencia vs interfaces | 35 | 0.75 | 26 | Señala explícitamente que las interfaces sirven para clases "sin relación directa de herencia" que necesitan nombres comunes (ejemplo tienda: reparar/garantía); no desarrolla igual el lado de cuándo conviene la herencia. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.5 | 13 | Buen ejemplo de flexibilidad (estandarizar nombres, facilitar expansión de inventario), pero sin mencionar limitaciones ni Java API directamente. |
| 4. Detección de problemas de diseño | 25 | 0.0 | 0 | No aborda el diagrama de facturación. |

### HERNANDEZ CAMACHO IGNACIO (AteneaBlanco) — 60 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.75 | 23 | Advierte que alterar la clase padre puede afectar sin intención a las hijas, y da ejemplo de polimorfismo con `calcularArea` en Figura/Círculo; el vínculo con encapsulamiento queda solo insinuado. |
| 2. Herencia vs interfaces | 35 | 0.5 | 18 | Explica que la ausencia de herencia múltiple en Java fuerza a usar interfaces o combinar extends+implements (Thread/Runnable); caso válido pero acotado, no una comparación amplia de ventajas. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.75 | 19 | Ejemplo correcto y concreto del Java API (Thread/Runnable) explicando el porqué de su existencia; falta profundizar en limitaciones propias de las interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.0 | 0 | No aborda el diagrama de facturación. |

### COREA HERRERA STEVEN FERNANDO (OdinVerde) — 36 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.75 | 23 | Ejemplo del carro: la clase padre concentra información vital y compleja (protegida/encapsulada), la hija solo expone lo superficial; no menciona polimorfismo. |
| 2. Herencia vs interfaces | 35 | 0.0 | 0 | No menciona interfaces; la sugerencia de interfaz en esa sección fue de "Martín Rojas", quien no es estudiante de la lista y se excluye de su evaluación. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No aborda interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.5 | 13 | Detecta que la relación Persona/TransaccionDinero está mal planteada y propone una alternativa, pero la solución sigue usando herencia de forma cuestionable y no detecta el error de que Invoice debería ser una colección (ese hallazgo corresponde al participante externo, no a él). |

### ROJAS BARRIOS MARTIN FRANCISCO (LokiRosa) — 34 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.0 | 0 | Su crítica a la herencia se centra en la corrección semántica de la relación "es-un" (Transacción no debería heredar de Persona porque "la persona no hace la transacción de dinero"), válido pero sin vínculo con encapsulamiento ni polimorfismo. |
| 2. Herencia vs interfaces | 35 | 0.25 | 9 | Sugiere una interfaz para unificar A,B,C,D y que todas se accedan desde un mismo punto (indicio de facade), pero no compara explícitamente ventajas/desventajas frente a herencia. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No discute limitaciones de interfaces, flexibilidad ni Java API. |
| 4. Detección de problemas de diseño | 25 | 1.0 | 25 | Único estudiante que detecta, desde la primera intervención y por cuenta propia, ambos errores marcados por el profesor: Invoice debería ser colección/vector, y la herencia Persona→TransaccionDinero está invertida. |

### SANCHEZ POVEDA DANIEL (IsisBeige) — 28 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.5 | 15 | Identifica que TransaccionDinero e Invoice comparten atributos (monto, fecha) que podrían sobreescribirse de forma inconsistente, y propone encapsulamiento como mitigación; no menciona polimorfismo. |
| 2. Herencia vs interfaces | 35 | 0.0 | 0 | No menciona interfaces. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No aborda interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.5 | 13 | Detecta problemas reales (tipo de cambio modificable desde Persona, duplicación de atributos Invoice/TransaccionDinero) y propone encapsulamiento como solución, pero no identifica ninguno de los dos errores específicamente marcados por el profesor. |

### VARGAS VARGAS GABRIEL (VulcanoBronce) — 27 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.25 | 8 | Su argumento principal es "heredar fácilmente cédula o dirección" (herencia de atributos), justo lo que el criterio pide superar; el punto de la clase abstracta como molde roza el tema pero sin vínculo explícito. |
| 2. Herencia vs interfaces | 35 | 0.0 | 0 | No menciona interfaces, solo clases abstractas. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No aborda interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.75 | 19 | Detecta directamente el error de herencia marcado ("Persona debería ser el padre... y no al revés") con buena justificación (una persona puede tener varias transacciones); no detecta el error de Invoice como colección. |

### ZUNIGA ARROYO PATRICK SEBASTIAN (MartePerla) — 23 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.75 | 23 | Explica con detalle listas de Animal con perro/gato/loro y ejemplo de orquesta, mostrando cómo la herencia habilita polimorfismo (override + dinamismo) y extensibilidad; sin vínculo con encapsulamiento. |
| 2. Herencia vs interfaces | 35 | 0.0 | 0 | No menciona interfaces; compara herencia rígida contra composición, una comparación distinta a la pedida. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No hay mención de interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.0 | 0 | No analiza el diagrama de facturación. |

### ZUNIGA PICADO DAVID (NeptunoJade) — 8 shares

| Criterio | Shares máx. | Grado | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Herencia → encapsulamiento/polimorfismo | 30 | 0.25 | 8 | Solo un ejemplo breve y superficial (override/extend en camión/barco); sin profundidad en el mecanismo de polimorfismo ni mención de encapsulamiento. |
| 2. Herencia vs interfaces | 35 | 0.0 | 0 | No menciona interfaces. |
| 3. Limitaciones/flexibilidad de interfaces y Java API | 25 | 0.0 | 0 | No aborda interfaces. |
| 4. Detección de problemas de diseño | 25 | 0.0 | 0 | No aborda el diagrama de facturación. |

---

## Estudiantes marcados para revisión manual del profesor

Ninguno. Todos los estudiantes presentaron `contenido_unificado` con información sustantiva
(ninguno quedó vacío o nulo).
