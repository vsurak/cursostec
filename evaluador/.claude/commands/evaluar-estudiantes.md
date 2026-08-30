---
description: Coordina la transcripción, unificación y evaluación de exposiciones de estudiantes a partir de audios y notas del profesor.
---

# Coordinador: evaluar-estudiantes

Eres el **agente coordinador**. NO hagas tú mismo el trabajo de transcribir, unificar o evaluar:
para eso vas a invocar, EN ORDEN Y DE FORMA SECUENCIAL (esperando a que cada uno termine antes
de lanzar el siguiente), a tres subagentes con la herramienta `Task`:

1. `transcriptor`
2. `unificador`
3. `evaluador`

## 1. Parseo de parámetros

El usuario te pasó el comando junto con un bloque de texto que contiene estas etiquetas
(pueden venir en cualquier orden, y alguna podría faltar — si falta algo obligatorio, pide
al usuario que la complete antes de continuar):

```
<audios>ruta/a/carpeta/con/m4a</audios>

<tema>
descripción del tema que deben abordar los estudiantes
</tema>

<criterios>
1. <descripción del criterio 1>. <N> shares.
2. <descripción del criterio 2>. <N> shares.
...
</criterios>

<estudiantes>
NOMBRE COMPLETO 1,nickname1
NOMBRE COMPLETO 2,nickname2
...
</estudiantes>

<notas del profesor>
NOMBRE COMPLETO 1 (o como el profesor lo llame): notas...
NOMBRE COMPLETO 2: notas...
...
</notas del profesor>
```

Extrae el contenido de cada etiqueta de `$ARGUMENTS`.

## 2. Carpeta de trabajo

Crea una carpeta de trabajo para esta corrida, por ejemplo:

```bash
mkdir -p ./.eval_run/transcripciones
```

Todos los artefactos intermedios entre subagentes se guardan ahí como archivos, para que
cada subagente pueda leer lo que dejó el anterior sin necesidad de compartir contexto.

## 3. Task 1 — Transcripción

Invoca el subagente `transcriptor` con el `Task` tool, pasándole en el prompt:

- La ruta de la carpeta `<audios>`.
- La ruta de salida: `./.eval_run/transcripciones/manifest.json`.

Espera su resultado. Verifica que el archivo `manifest.json` se haya creado y contenga al
menos un registro por cada archivo `.m4a` de la carpeta. Si el subagente reporta errores
(por ejemplo, un audio corrupto), muéstraselos al usuario pero continúa con los audios que sí
se pudieron transcribir.

## 4. Task 2 — Unificación

Invoca el subagente `unificador` con el `Task` tool, pasándole en el prompt:

- La ruta de `./.eval_run/transcripciones/manifest.json` (salida de Task 1).
- El contenido completo de `<estudiantes>`.
- El contenido completo de `<notas del profesor>`.
- La ruta de salida: `./.eval_run/notas_unificadas.json`.

Espera su resultado. Verifica que exista una entrada por cada estudiante de `<estudiantes>`
en `notas_unificadas.json` (aunque algún estudiante no haya sido detectado en los audios,
debe aparecer igual con lo que sí se tenga, aunque sea solo las notas del profesor).

## 5. Task 3 — Evaluación

Invoca el subagente `evaluador` con el `Task` tool, pasándole en el prompt:

- La ruta de `./.eval_run/notas_unificadas.json` (salida de Task 2).
- El contenido completo de `<tema>`.
- El contenido completo de `<criterios>`.
- La ruta de salida: `./.eval_run/resultado_shares.json` y `./.eval_run/resultado_shares.md`.

## 6. Reporte final

Cuando el subagente `evaluador` termine, muestra al usuario la tabla final
(nombre completo, nickname, shares totales) leyendo `resultado_shares.md`, y menciona dónde
quedaron guardados todos los archivos intermedios (`./.eval_run/`) por si quiere auditarlos.

No inventes transcripciones, notas ni resultados: si un subagente falla o un dato no está
disponible, repórtalo explícitamente al usuario en vez de rellenar con suposiciones.
