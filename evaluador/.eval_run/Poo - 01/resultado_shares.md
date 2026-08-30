# Resultado de evaluación de shares

Tema evaluado: paquetes `java.lang.Math` / `java.math`, primitivas vs. clases wrapper,
control de procesos/threads en `java.lang`, `java.time` en sistemas multinacionales, y
utilidades de `java.util`.

**Contexto de las fuentes de evidencia**: solo se contó con 2 audios grupales de exposición
(sin diarización real por hablante). De los 23 estudiantes:
- 8 tienen contenido de audio + notas del profesor.
- 4 tienen únicamente notas del profesor (el tema de su intervención — threads/procesos —
  no aparece en los 2 audios entregados).
- 11 no tienen ni audio ni notas del profesor; se reportan con 0 shares y quedan marcados
  para revisión manual del profesor, sin inventar evaluación alguna.

Ningún estudiante superó los 100 shares totales, por lo que no fue necesario aplicar el
tope en ningún caso (`shares_totales` = `shares_totales_sin_tope` para todos).

## Tabla resumen (ordenada de mayor a menor shares_totales)

| Nombre completo | Nickname | Shares totales | Fuente de evidencia |
|---|---|---|---|
| HERNANDEZ CAMACHO IGNACIO | AteneaBlanco | 68 | solo notas del profesor |
| MOYA AGUILAR JOSE JULIAN | ErosCoral | 68 | solo notas del profesor |
| SANCHEZ POVEDA DANIEL | IsisBeige | 67 | audio + notas |
| MADRIGAL CAMPOS ANDRES | PoseidonNaranja | 49 | audio + notas |
| ROJAS BARRIOS MARTIN FRANCISCO | LokiRosa | 49 | audio + notas |
| MONTERO VALVERDE ELIAN ESTEBAN | AresTurquesa | 44 | solo notas del profesor |
| ZUNIGA PICADO DAVID | NeptunoJade | 28 | audio + notas |
| LEIVA VILLALOBOS BRYAN JOSUE | DianaIndigo | 23 | audio + notas |
| FERNANDEZ CASTRO ANTHONY | HeraNegro | 18 | audio + notas |
| HIDALGO TORRES JOSELYN MELISSA | HadesVioleta | 6 | audio + notas |
| ZUNIGA ARROYO PATRICK SEBASTIAN | MartePerla | 5 | solo notas del profesor |
| COREA HERRERA STEVEN FERNANDO | OdinVerde | 0 | audio + notas (contenido mínimo) |
| AGUILAR FONSECA HILARY | ZeusRojo | 0 | sin información |
| BARRANTES AZOFEIFA EDIER ISAAC | ThorAzul | 0 | sin información |
| CUNIO LOPEZ PIERO ANTONIO | RaDorado | 0 | sin información |
| ESPINOZA ORTEGA MARIA JOSE | ApoloPlata | 0 | sin información |
| OBANDO ARIAS YUNIER STEVEN | FreyaGris | 0 | sin información |
| SEAS ALVAREZ JORDAN LEONARDO | OsirisCian | 0 | sin información |
| SEGURA QUESADA KEYZEL ESTRELLA | AnubisAmbar | 0 | sin información |
| TARASOVA ARINA | BacoMarfil | 0 | sin información |
| TORRES ORELLANA ALEXIS | JanoCobre | 0 | sin información |
| VARGAS VARGAS GABRIEL | VulcanoBronce | 0 | sin información |
| VEGA HIDALGO EIMY GUADALUPE | VenusEscarlata | 0 | sin información |

(Ningún estudiante requirió tope de 100 shares; la columna "Shares sin tope" se omite
porque en todos los casos coincide con el total.)

## Detalle por estudiante

### HERNANDEZ CAMACHO IGNACIO (AteneaBlanco) — 68 shares — fuente: solo notas del profesor
No hay transcripción de audio que cubra su intervención (tema threads/procesos, ausente
en los audios entregados); evaluado solo con las notas del profesor.

| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1. Casos concretos / correlación | 20 | 1.0 | 20 | Casos concretos (servidor web con pool de hilos; descarga en segundo plano) y correlación primitivos/objetos-rendimiento, proceso-hilo. |
| 2. Código Java de ejemplo | 30 | 0.0 | 0 | No se registra código en las notas. |
| 3. Deducciones/teorías propias | 20 | 0.5 | 10 | Síntesis organizada de varios conceptos, sin llegar a una teoría claramente original. |
| 4. Correlación con el mundo real | 25 | 1.0 | 25 | Dos ejemplos reales concretos: servidor web con pool de hilos, descarga de archivo en segundo plano. |
| 5. Coherencia técnica ante lo no sabido | 15 | 0.0 | 0 | No hay evidencia de responder algo fuera de su dominio. |
| 6. Evidencia deficiencias, no solo glorifica | 25 | 0.5 | 13 | Señala el riesgo de "explotar el programa" si se crean demasiados hilos manualmente. |

### MOYA AGUILAR JOSE JULIAN (ErosCoral) — 68 shares — fuente: solo notas del profesor
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.75 | 15 | Ejemplifica con ArrayList, necesidad de null en listas, boxing/unboxing. |
| 2 | 30 | 0.0 | 0 | Sin código Java. |
| 3 | 20 | 0.75 | 15 | Reflexión propia: "es una sintaxis que confunde"; evalúa si conviene o no el multitasking/pools. |
| 4 | 25 | 0.75 | 19 | Casos reales concretos: ArrayList con objetos, listas con null, decisión práctica sobre pools de hilos. |
| 5 | 15 | 0.0 | 0 | No hay evidencia de responder algo fuera de su dominio. |
| 6 | 25 | 0.75 | 19 | Crítica explícita: sintaxis confusa de primitivos/wrappers; manejo manual de estados/prioridades de hilos "puede ser complejo". |

### SANCHEZ POVEDA DANIEL (IsisBeige) — 67 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 1.0 | 20 | Diferenció Math vs java.math con BigInteger/BigDecimal, correlacionado con clases genéricas. |
| 2 | 30 | 0.0 | 0 | Solo explicaciones conceptuales, sin código. |
| 3 | 20 | 0.75 | 15 | Síntesis propia conectando ensamblador, memoria y reutilización de código. |
| 4 | 25 | 0.75 | 19 | Ligó BigDecimal/BigInteger a cálculos financieros/monetarios reales. |
| 5 | 15 | 0.0 | 0 | Respondió con seguridad; no hubo intento de "adivinar". |
| 6 | 25 | 0.5 | 13 | Explicó la limitación del punto flotante binario que motiva java.math (deficiencia real de Math/primitivos). |

### MADRIGAL CAMPOS ANDRES (PoseidonNaranja) — 49 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 1.0 | 20 | Ejemplos concretos de ZoneId (NYC, Costa Rica, Madrid) y estructuras de java.util correlacionadas con Locale. |
| 2 | 30 | 0.0 | 0 | Sin código Java. |
| 3 | 20 | 0.5 | 10 | Propone su propia lógica de ordenamiento (N/S, estructura de árbol). |
| 4 | 25 | 0.75 | 19 | Lugares reales concretos (NYC, Costa Rica, Madrid, estados de EE.UU.). |
| 5 | 15 | 0.0 | 0 | Sin señales de incertidumbre. |
| 6 | 25 | 0.0 | 0 | Glorifica ("no va a haber errores... bastante eficiente") sin señalar deficiencias. |

### ROJAS BARRIOS MARTIN FRANCISCO (LokiRosa) — 49 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 1.0 | 20 | Explica normalización de hora entre países distantes y correlaciona java.util (listas, hashmap, tree, sort) con Locale. |
| 2 | 30 | 0.0 | 0 | Menciona "TimSort" pero no muestra código. |
| 3 | 20 | 0.5 | 10 | Justifica con lógica propia por qué convienen las estructuras predefinidas (espacio y legibilidad). |
| 4 | 25 | 0.75 | 19 | Ejemplo concreto: sincronizar un evento entre "dos países bastante lejados entre sí". |
| 5 | 15 | 0.0 | 0 | Sin señales de incertidumbre. |
| 6 | 25 | 0.0 | 0 | Usa el argumento de "implementar a mano" para elogiar java.util, no para criticarlo. |

### MONTERO VALVERDE ELIAN ESTEBAN (AresTurquesa) — 44 shares — fuente: solo notas del profesor
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.75 | 15 | Correlaciona primitivos sin null, colecciones, proceso/hilo, y clases ProcessBuilder/Process/Runtime/Thread/Runnable. |
| 2 | 30 | 0.0 | 0 | Sin código Java. |
| 3 | 20 | 0.5 | 10 | Síntesis propia de capas JVM/OS ("Java no controla directamente el procesador..."). |
| 4 | 25 | 0.25 | 6 | Sin escenario/aplicación concreta; solo consecuencia general. |
| 5 | 15 | 0.0 | 0 | Sin evidencia de responder algo fuera de su dominio. |
| 6 | 25 | 0.5 | 13 | Riesgo real identificado: demasiados threads pueden hacer que la computadora no corra el programa. |

### ZUNIGA PICADO DAVID (NeptunoJade) — 28 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.75 | 15 | Explica memoria (primitivos) vs POO/genéricos (wrappers), con ejemplo concreto List<Integer>. |
| 2 | 30 | 0.0 | 0 | Nombra List<Integer> pero no escribe código. |
| 3 | 20 | 0.0 | 0 | Sin deducción propia adicional. |
| 4 | 25 | 0.5 | 13 | List<Integer> como ejemplo concreto de collections en Java. |
| 5 | 15 | 0.0 | 0 | Sin señales de incertidumbre. |
| 6 | 25 | 0.0 | 0 | Sin mención de limitaciones. |

### LEIVA VILLALOBOS BRYAN JOSUE (DianaIndigo) — 23 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.5 | 10 | ZonedDateTime + idea de programa de zonas horarias; lista capacidades de java.util sin profundizar. |
| 2 | 30 | 0.0 | 0 | Sin código. |
| 3 | 20 | 0.0 | 0 | Nivel descriptivo, sin teoría propia. |
| 4 | 25 | 0.5 | 13 | Propuesta concreta de "programa que analice zonas horarias". |
| 5 | 15 | 0.0 | 0 | Sin señales de incertidumbre. |
| 6 | 25 | 0.0 | 0 | Sin mención de limitaciones. |

### FERNANDEZ CASTRO ANTHONY (HeraNegro) — 18 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.25 | 5 | Razón general de "facilidad de uso", sin caso concreto ni correlación profunda. |
| 2 | 30 | 0.0 | 0 | Sin código. |
| 3 | 20 | 0.25 | 5 | Interpretación propia básica ("según lo que yo puedo entender"). |
| 4 | 25 | 0.0 | 0 | Sin escenario real. |
| 5 | 15 | 0.5 | 8 | Marca su respuesta como interpretación personal ante una pregunta que no domina del todo, con coherencia parcial. |
| 6 | 25 | 0.0 | 0 | Sin mención de limitaciones. |

### HIDALGO TORRES JOSELYN MELISSA (HadesVioleta) — 6 shares — fuente: audio + notas
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.0 | 0 | Afirmación general calcada de la nota del profesor, sin caso concreto. |
| 2 | 30 | 0.0 | 0 | Sin código. |
| 3 | 20 | 0.0 | 0 | Sin elaboración propia. |
| 4 | 25 | 0.25 | 6 | Mención general de "uso diario por todos los programadores". |
| 5 | 15 | 0.0 | 0 | Sin señales de incertidumbre. |
| 6 | 25 | 0.0 | 0 | Sin mención de limitaciones. |

### ZUNIGA ARROYO PATRICK SEBASTIAN (MartePerla) — 5 shares — fuente: solo notas del profesor
| Criterio | Shares máx. | Grado | Shares obt. | Justificación |
|---|---|---|---|---|
| 1 | 20 | 0.25 | 5 | Afirmaciones muy generales, sin caso concreto ni correlación detallada. |
| 2 | 30 | 0.0 | 0 | Sin código. |
| 3 | 20 | 0.0 | 0 | Sin deducción propia. |
| 4 | 25 | 0.0 | 0 | Sin escenario real mencionado. |
| 5 | 15 | 0.0 | 0 | Sin evidencia de responder algo fuera de su dominio. |
| 6 | 25 | 0.0 | 0 | Elogia a Java en vez de señalar deficiencias. |

### COREA HERRERA STEVEN FERNANDO (OdinVerde) — 0 shares — fuente: audio + notas (contenido mínimo)
Su intervención es una sola frase que repite casi textualmente la nota del profesor
("las primitivas son para operaciones fundamentales... muy muy básicas"), sin desarrollar
ningún criterio: no da casos concretos, no correlaciona, no da código, no aporta
deducciones propias, no conecta con el mundo real, no muestra incertidumbre ni evidencia
deficiencias. Los 6 criterios obtienen grado 0.0 (0 shares). No se marca para revisión
manual porque sí existe evidencia (aunque mínima), a diferencia de los estudiantes sin
ningún contenido.

## Estudiantes marcados para revisión manual del profesor (`necesita_revision_manual: true`)

Los siguientes 11 estudiantes no cuentan con transcripción de audio ni con notas del
profesor, por lo que se les asignaron 0 shares en todos los criterios sin inventar
evaluación alguna. Requieren que el profesor determine manualmente su nota, ya sea porque
participaron y no quedó registrado, o porque no participaron:

- AGUILAR FONSECA HILARY (ZeusRojo)
- BARRANTES AZOFEIFA EDIER ISAAC (ThorAzul)
- CUNIO LOPEZ PIERO ANTONIO (RaDorado)
- ESPINOZA ORTEGA MARIA JOSE (ApoloPlata)
- OBANDO ARIAS YUNIER STEVEN (FreyaGris)
- SEAS ALVAREZ JORDAN LEONARDO (OsirisCian)
- SEGURA QUESADA KEYZEL ESTRELLA (AnubisAmbar)
- TARASOVA ARINA (BacoMarfil)
- TORRES ORELLANA ALEXIS (JanoCobre)
- VARGAS VARGAS GABRIEL (VulcanoBronce)
- VEGA HIDALGO EIMY GUADALUPE (VenusEscarlata)
