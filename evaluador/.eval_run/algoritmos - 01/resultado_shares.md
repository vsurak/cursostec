# Resultado de evaluación — Shares por estudiante

Tema evaluado: estrategias/estructuras que afectan o mejoran el rendimiento, papel de vendors/plataformas/librerías en problemas de rendimiento, y qué tan común es que un ingeniero enfrente problemas de optimización de algoritmos.

Criterios (shares máximos):
1. Múltiples fuentes cruzadas organizadamente, con origen claro de hipótesis/casos — 25
2. Dominio y análisis claro de la complejidad algorítmica (qué pasó y cómo se aborda) — 30
3. Verificación de veracidad del caso en varios medios oficiales — 20
4. Análisis con más de una dimensión (complejidad, tamaño, monitoreo, mediciones antes/después) — 20
5. Pruebas programadas o medición analítica propia que simule el problema — 20

Nota general: 5 de los 11 estudiantes (ARAYA MAYORGA JOSE DAMIAN / SolAmarillo, CARBALLO MARTINEZ JOSE ADRIAN / RioFluye, FAJARDO DIAZ GENESIS VALERIA / FuegoArde, GUZMAN PORTUGUEZ BIANCA DE LOS ANGELES / VientoVa, MEZA MARIN DYLAN JOSE / MarNada) no tienen ninguna intervención registrada en las transcripciones de audio ni notas del profesor. No se les asignó puntaje por suposición; obtienen 0 shares en todos los criterios y quedan marcados para revisión manual del profesor.

## Tabla resumen (ordenada de mayor a menor)

| Nombre completo | Nickname | Shares totales | Shares sin tope |
|---|---|---|---|
| OBANDO MORALES SANTIAGO LEONEL | LunaBrilla | 74 | 74 |
| ARROYO ORIAS PABLO JESUS | CerroCanta | 62 | 62 |
| AGUILAR SOTO MARIANNE SOFIA | LoboCorre | 57 | 57 |
| BARRANTES VILLALOBOS GABRIEL | AlaVuela | 52 | 52 |
| AGUILAR SEGURA LUIS ALBERTO | SolBrilla | 39 | 39 |
| ALFARO GARCIA ISAAC GERMAN | TigreSalta | 31 | 31 |
| ARAYA MAYORGA JOSE DAMIAN | SolAmarillo | 0 | 0 |
| CARBALLO MARTINEZ JOSE ADRIAN | RioFluye | 0 | 0 |
| FAJARDO DIAZ GENESIS VALERIA | FuegoArde | 0 | 0 |
| GUZMAN PORTUGUEZ BIANCA DE LOS ANGELES | VientoVa | 0 | 0 |
| MEZA MARIN DYLAN JOSE | MarNada | 0 | 0 |

Ningún estudiante superó el tope de 100 shares, por lo que no se aplicó recorte en ningún caso.

---

## Detalle por estudiante

### OBANDO MORALES SANTIAGO LEONEL (LunaBrilla) — 74 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.75 | 19/25 | Cita explícitamente su fuente ("todo lo que investigué fue mediante los blogs de Discord") y descarta un segundo caso (GTA Online) por simple; buena trazabilidad pero fuente única (oficial de la empresa), no varias fuentes cruzadas. |
| 2. Complejidad algorítmica | 1.0 | 30/30 | Migración MongoDB→Cassandra→Scylla por concurrencia y volumen, métrica P99 de latencia (hasta 10 s), y middleware en Rust que pasa de O(N) consultas a una consulta agregada: el análisis más completo del grupo. |
| 3. Verificación en medios oficiales | 0.25 | 5/20 | Usa blogs oficiales de Discord como fuente, pero no describe contraste entre varios medios oficiales independientes. |
| 4. Múltiples dimensiones | 1.0 | 20/20 | Cubre complejidad, tamaño (billón/trillón de mensajes), monitoreo (P99) y medición antes/después (latencias concretas). |
| 5. Pruebas propias | 0.0 | 0/20 | Las métricas descritas son del monitoreo interno de Discord, no de una simulación propia del estudiante. |

Nota de auditoría: en `contenido_unificado` se registra una discrepancia entre audio y notas del profesor sobre si el caso Discord fue "un problema de arquitectura" o "no un problema específico de la plataforma"; no afectó la calificación pero se recomienda que el profesor la revise.

### ARROYO ORIAS PABLO JESUS (CerroCanta) — 62 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.75 | 19/25 | Tres casos (Amazon, Twitter, LinkedIn) más un caso personal (app del MEP), con datos concretos (LinkedIn de ~5 a 40-60 millones de usuarios); no cita fuentes puntuales explícitas. |
| 2. Complejidad algorítmica | 0.75 | 23/30 | Explica que la matriz M×N de Amazon "en la práctica terminaba siendo algo cuadrático" por la desproporción usuarios/productos; buen análisis crítico, sin profundizar en la solución final. |
| 3. Verificación en medios oficiales | 0.0 | 0/20 | No menciona verificación cruzada de fuentes oficiales. |
| 4. Múltiples dimensiones | 0.75 | 15/20 | Complejidad, tamaño (crecimiento de usuarios) y monitoreo (pruebas de estrés DDoS); sin cifras concretas de antes/después. |
| 5. Pruebas propias | 0.25 | 5/20 | Menciona pruebas de estrés tipo DDoS como experiencia general propia, pero no como simulación programada específica del caso estudiado. |

### AGUILAR SOTO MARIANNE SOFIA (LoboCorre) — 57 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.75 | 19/25 | Dos casos detallados (Cloudflare 2019, AWS/Amazon) con nivel técnico alto; no cita explícitamente artículos/fuentes. |
| 2. Complejidad algorítmica | 0.75 | 23/30 | Explica con precisión el bug de regex que llevó el Big O a 2^N en Cloudflare; el caso AWS se explica más como falla de sistema que de complejidad algorítmica. |
| 3. Verificación en medios oficiales | 0.0 | 0/20 | No se menciona verificación cruzada de fuentes. |
| 4. Múltiples dimensiones | 0.75 | 15/20 | Complejidad (2^N), monitoreo/detección (fases de testing Dog/PIC/Canary) y tamaño (impacto, CPU al 100%); sin cifras de medición antes/después del fix. |
| 5. Pruebas propias | 0.0 | 0/20 | Describe el testing que hace Cloudflare como empresa, no una prueba propia de la estudiante. |

Nota de auditoría: discrepancia menor entre audio ("sistema E2 de Google") y notas del profesor ("sistema R2 de Google"); no afecta la calificación.

### BARRANTES VILLALOBOS GABRIEL (AlaVuela) — 52 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.75 | 19/25 | Tres líneas de investigación (patrón Facebook, Cloudflare 2020, librerías/Copilot), con honestidad sobre limitaciones de su búsqueda; sin citar fuentes por nombre. |
| 2. Complejidad algorítmica | 0.75 | 23/30 | Explica cómo una regex mal escrita generó un árbol de verificación con backtracking, volviéndose "estúpidamente exponencial" en casos extremos; no cuantifica el Big O exacto. |
| 3. Verificación en medios oficiales | 0.0 | 0/20 | No se menciona verificación cruzada de fuentes. |
| 4. Múltiples dimensiones | 0.5 | 10/20 | Complejidad y tamaño ("con el tamaño ya no se vuelve tan correcto"); sin monitoreo/detección ni mediciones concretas. |
| 5. Pruebas propias | 0.0 | 0/20 | No hay evidencia de pruebas o simulaciones propias. |

### AGUILAR SEGURA LUIS ALBERTO (SolBrilla) — 39 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.25 | 6/25 | Un solo caso (Netflix/Cinematch), sin mencionar fuentes ni cruzarlas. |
| 2. Complejidad algorítmica | 0.75 | 23/30 | Explica con claridad el paso de O(N×M) a O(K×N+M) por descomposición de matrices y extiende con reinforcement learning y DNN; falta profundizar el porqué matemático. |
| 3. Verificación en medios oficiales | 0.0 | 0/20 | No se menciona verificación de fuentes. |
| 4. Múltiples dimensiones | 0.5 | 10/20 | Complejidad y tamaño (crecimiento de usuarios); sin monitoreo/detección ni mediciones concretas. |
| 5. Pruebas propias | 0.0 | 0/20 | No hay evidencia de pruebas propias. |

### ALFARO GARCIA ISAAC GERMAN (TigreSalta) — 31 shares

| Criterio | Grado | Shares | Justificación |
|---|---|---|---|
| 1. Fuentes cruzadas | 0.25 | 6/25 | Menciona varias empresas pero admite superficialidad ("yo no he vivido tan profundo un caso en específico"), sin fuentes concretas. |
| 2. Complejidad algorítmica | 0.5 | 15/30 | Explica el paso de comparación M×N a comparación por producto en Amazon de forma correcta pero básica, sin cuantificar el Big O resultante. |
| 3. Verificación en medios oficiales | 0.0 | 0/20 | No se menciona verificación de fuentes. |
| 4. Múltiples dimensiones | 0.5 | 10/20 | Complejidad (M×N) y tamaño (subestimación de usuarios); sin monitoreo ni mediciones. |
| 5. Pruebas propias | 0.0 | 0/20 | No hay evidencia de pruebas propias. |

---

## Estudiantes marcados para revisión manual (`necesita_revision_manual: true`)

Sin ninguna intervención registrada (ni en audio ni en notas del profesor); 0 shares en todos los criterios, sin evaluación por suposición:

- ARAYA MAYORGA JOSE DAMIAN (SolAmarillo)
- CARBALLO MARTINEZ JOSE ADRIAN (RioFluye)
- FAJARDO DIAZ GENESIS VALERIA (FuegoArde)
- GUZMAN PORTUGUEZ BIANCA DE LOS ANGELES (VientoVa)
- MEZA MARIN DYLAN JOSE (MarNada)

Se recomienda al profesor verificar si estos estudiantes participaron en algún audio no incluido en el manifest o si su participación no fue registrada, antes de finalizar la calificación.
