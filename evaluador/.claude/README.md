# Kit: evaluación automática de exposiciones de estudiantes (Claude Code)

## Qué contiene

```
.claude/
  agents/
    transcriptor.md   # Task 1: audio -> texto
    unificador.md      # Task 2: texto + notas del profesor -> por estudiante
    evaluador.md        # Task 3: contenido -> shares según criterios
  commands/
    evaluar-estudiantes.md   # Coordinador: orquesta los 3 subagentes en orden
```

## Instalación

1. Copia la carpeta `.claude/` a la raíz de tu proyecto en Claude Code (o combínala si ya
   tienes una `.claude/` con otros agentes/comandos).
2. Asegúrate de tener `ffmpeg` instalado (`ffmpeg -y` se usa para convertir m4a -> wav).
   El subagente `transcriptor` instala `faster-whisper` automáticamente con pip si no está.
3. (Opcional) Si prefieres usar la API de OpenAI Whisper en vez de whisper local, exporta
   `OPENAI_API_KEY` en tu entorno antes de correr el comando — el subagente la detecta y
   puede usarla en lugar de whisper local si lo indicas explícitamente en el prompt.

## Uso

Desde Claude Code, corre:

```
/evaluar-estudiantes
<audios>./grabaciones</audios>

<tema>
Arquitectura de microservicios: cuándo usarla, trade-offs frente a monolitos, patrones de comunicación entre servicios.
</tema>

<criterios>
1. El estudiante dio más que definiciones teóricas de los conceptos, habló de casos concretos de uso, correlacionó el concepto con otros existentes para ampliar la comprensión. 20 shares.
2. El estudiante mencionó al menos una desventaja o riesgo del enfoque. 10 shares.
</criterios>

<estudiantes>
COREA HERRERA STEVEN FERNANDO,OdinVerde
CUNIO LOPEZ PIERO ANTONIO,RaDorado
</estudiantes>

<notas del profesor>
Steven: explicó bien el concepto de service mesh, dio ejemplo de Netflix.
Piero: se quedó en definiciones, no dio ejemplos concretos.
</notas del profesor>
```

El comando parsea las etiquetas, crea una carpeta `.eval_run/` para los artefactos
intermedios, y llama a los 3 subagentes en orden (esperando a que cada uno termine antes de
lanzar el siguiente). Al final te muestra la tabla de resultados y te dice dónde quedaron
guardados los archivos intermedios para que puedas auditar cualquier decisión.

## Notas de diseño

- **Por qué archivos y no solo el contexto del Task**: cada invocación de `Task` es un
  subagente con su propio contexto; no comparten memoria entre sí. Por eso cada uno escribe
  su salida a un JSON en `.eval_run/`, y el coordinador le pasa la ruta de ese archivo al
  siguiente subagente.
- **Transcripción**: `faster-whisper` corre localmente (CPU), no requiere API key ni cuesta
  dinero por uso, y da buena calidad en español. Si necesitas más precisión (audios con
  ruido, acentos fuertes, mucha gente hablando encima) puedes cambiar el modelo a
  `large-v3` en `transcriptor.md`, o usar la API de OpenAI Whisper si tienes la key.
- **Coincidencia de nombres**: el `unificador` hace matching flexible (nombre, apellido,
  nickname, variantes fonéticas de la transcripción) porque ni el audio ni las notas del
  profesor necesariamente usan el nombre completo tal cual aparece en `<estudiantes>`.
- **Auditabilidad**: cada decisión de shares queda justificada en `resultado_shares.md`/`.json`
  para que el profesor pueda revisar por qué se otorgó o no cada criterio.
- **Cumplimiento parcial**: cada criterio no es todo-o-nada. El `evaluador` asigna un
  `grado_cumplimiento` (1.0, 0.75, 0.5, 0.25 o 0.0) según cuánto de lo que pide el criterio
  realmente demostró el estudiante, y los shares obtenidos son
  `shares_del_criterio * grado_cumplimiento`.
- **Tope de 100 shares**: si la suma de todos los criterios supera 100, el total del
  estudiante se limita a 100. El valor real sin límite queda registrado como
  `shares_totales_sin_tope` para trazabilidad.
