# Resultado de shares — Dynamic Programming and Greedy Algorithms

## Resumen

| Nombre completo | Nickname | Shares totales | Shares sin tope |
|---|---|---|---|
| OBANDO MORALES SANTIAGO LEONEL | LunaBrilla | 90 | 90 |
| AGUILAR SEGURA LUIS ALBERTO | SolBrilla | 50 | 50 |

Ningún estudiante superó el tope de 100 shares, por lo que no se aplicó recorte a ninguno.

---

## Detalle por estudiante

### OBANDO MORALES SANTIAGO LEONEL (LunaBrilla) — 90 shares

| Criterio | Shares máximos | Grado cumplimiento | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Más de un ejemplo por tipo | 20 | 0.25 | 5 | Trajo exactamente un caso por tipo (git diff para PD, token bucket del kernel de Linux para voraz), ambos con mucha profundidad, pero el criterio pide "más de un ejemplo" por tipo y no aportó un segundo caso en ninguno de los dos. |
| 2. Claridad PD (etapas, memoization, N) | 40 | 1.0 | 40 | Explicó con precisión el paso de una etapa a otra (diagonales del grafo 2D), identificó explícitamente dónde ocurre la memoization ("memoriza los cambios que hizo en cada iteración de este grafo") y definió con claridad N (longitud del archivo), D (cantidad de cambios) y la complejidad (D*N, peor caso N²). |
| 3. Claridad voraz (criterio selección, función evaluación, óptimos) | 40 | 0.75 | 30 | Identificó el criterio de selección (comparación binaria de tokens) y contrastó explícitamente la falta de óptimo global ("sin tener una percepción global del entorno de la red") con la decisión local por paquete; no formalizó una "función de evaluación" explícita más allá del cálculo de tokens por timestamp. |
| 4. Explicación de código | 30 | 0.0 | 0 | Describe la lógica interna con detalle (grafo, iteración de D) pero nunca hace referencia a líneas o fragmentos de código reales ni señala dónde en el código se evidencia la estrategia. |
| 5. Dominio de N y etapas | 15 | 1.0 | 15 | Define N explícitamente como la longitud del archivo, relaciona las etapas (incremento de D) con ese N, y calcula la complejidad resultante. |

**Total preliminar:** 90 shares (sin tope necesario).

---

### AGUILAR SEGURA LUIS ALBERTO (SolBrilla) — 50 shares

| Criterio | Shares máximos | Grado cumplimiento | Shares obtenidos | Justificación |
|---|---|---|---|---|
| 1. Más de un ejemplo por tipo | 20 | 0.5 | 10 | Para voraz aplicó Dijkstra a dos dominios distintos (GPS e instalaciones eléctricas), acercándose a "más de un caso"; pero para PD solo trajo un único caso (similitud de palabras / corrector ortográfico). |
| 2. Claridad PD (etapas, memoization, N) | 40 | 0.25 | 10 | Menciona vagamente la reutilización de "el código de cada carácter" (indicio de memoization) y las tres operaciones de edición, pero él mismo admite que "me costó un poco más entenderlo" y no define el tamaño N ni explica con precisión el paso de resultados entre etapas. |
| 3. Claridad voraz (criterio selección, función evaluación, óptimos) | 40 | 0.75 | 30 | Identificó con claridad el criterio de selección (vértice/arista de menor distancia) y el óptimo local frente al global ("el óptimo local también podría ser de A a B... sin tener que llegar a C"), aplicándolo a dos dominios; no formalizó explícitamente una "función de evaluación". |
| 4. Explicación de código | 30 | 0.0 | 0 | No se hace referencia en ningún momento a código fuente real de Dijkstra ni del algoritmo de distancia de edición; la explicación se mantiene a nivel conceptual. |
| 5. Dominio de N y etapas | 15 | 0.0 | 0 | En ninguno de los dos casos define o discute explícitamente el tamaño N del problema ni cómo las etapas escalan con N. |

**Total preliminar:** 50 shares (sin tope necesario).

---

## Estudiantes marcados para revisión manual

Ninguno. Ambos estudiantes presentaron `contenido_unificado` completo y no vacío.
