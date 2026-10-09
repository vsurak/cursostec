# Actividad Semana #11: Detectalo y luego dirigí a la IA

**Patrones:** Adapter · Decorator · Facade  **Duración:** 50 minutos  **Formato:** parejas, una computadora y un asistente de programación con IA por pareja

> **Idea central:** si podés describir una estructura con suficiente precisión para que una IA la construya, entendés el patrón. En esta actividad **ustedes** encuentran dónde aplica un patrón y **ustedes** deciden la estructura. La IA solo escribe el código.

---

## Parte 1: Hoja para estudiantes

### Las reglas

1. **Trabajen en parejas.** El **driver** escribe los prompts. El **navigator** revisa cada respuesta de la IA contra los chequeos de esa ronda. Intercambien roles en cada ronda.
2. **Palabras prohibidas en los prompts:** `adapter`, `decorator`, `facade`, `wrapper`, `pattern`, `design pattern`, y sus equivalentes en español: `adaptador`, `decorador`, `fachada`, `envoltorio`, `patrón`, `patrón de diseño`. Tampoco frases como `refactorizá esto usando…`, `¿qué patrón…?`, `mejorá este código`, `limpiá esto`.
   Un prompt que use cualquiera de ellas **no cuenta**. (`gift wrap` sí se puede usar porque es una característica del producto.)
3. **No le pregunten a la IA dónde están los problemas.** Detectarlos es trabajo de ustedes (Paso 1).
4. **Un paso por prompt.** Nada de prompts de "hacé todo de una vez".
5. **La salida base es su prueba.** Después de cada cambio, el `Main` debe imprimir **exactamente** la salida base de abajo.
6. **Lleven una bitácora de prompts** en `prompts.md`: copien cada prompt que envían y agreguen una línea sobre qué hizo bien o mal la IA. Esta bitácora es lo que se califica.

### El proyecto inicial: TecShop checkout

Carpeta: `src/patterns/tecshop/` (paquete `tecshop`)

| Clase | Qué hace |
|---|---|
| `Main` | Arma dos carritos; uno se paga en la web y otro en el kiosco |
| `WebCheckout`, `KioskCheckout` | Ejecutan una compra de principio a fin |
| `Cart`, `CartItem` | Productos y sus extras (envoltura de regalo, seguro, envío exprés) |
| `Inventory`, `TaxCalculator`, `PaymentGateway`, `InvoicePrinter`, `Money` | Servicios de la tienda |
| `ShippingService` | Escoge un proveedor de envío y obtiene una cotización |
| `ShippingProvider`, `LocalCourier` | **Nuestra** interfaz de envío y nuestro mensajero propio |
| `CorreosApi` | SDK **de terceros** de Correos de Costa Rica. **No se puede modificar.** |

Para ejecutarlo:

```bash
cd src/patterns/tecshop
javac -encoding UTF-8 -d out *.java
java -cp out tecshop.Main
```

**Salida base** (debe mantenerse idéntica):

```
Inventory: reserved 3 items
Payment: charged CRC 61,832.00 via credit card
----- INVOICE: Ana -----
  Laptop stand + gift wrap + express  CRC 29,000.00
  USB-C hub + insurance  CRC 18,900.00
  Notebook  CRC 3,500.00
  Subtotal: CRC 51,400.00
  Tax:      CRC 6,682.00
  Shipping: CRC 3,750.00
  TOTAL:    CRC 61,832.00

Inventory: reserved 1 items
Payment: charged CRC 53,592.75 via SINPE Movil
----- INVOICE: Luis -----
  Mechanical keyboard + gift wrap + insurance  CRC 45,675.00
  Subtotal: CRC 45,675.00
  Tax:      CRC 5,937.75
  Shipping: CRC 1,980.00
  TOTAL:    CRC 53,592.75
```

### Paso 1: Detección (sin IA). Completen el Mapa de Problemas

Lean el código. Hay **tres** problemas de diseño. Usen la Tarjeta de Detección para encontrarlos.

| # | Dónde (clase.método) | Síntoma: ¿qué va a doler cuando el código cambie? | ¿Quién sabe demasiado? | ¿Qué clase(s) existente(s) dejarían intactas? |
|---|---|---|---|---|
| S1 | | | | |
| S2 | | | | |
| S3 | | | | |

### Tarjeta de Detección

| Si ves… | Preguntate… | Movimiento estructural |
|---|---|---|
| Código cliente que **convierte** unidades, tipos o nombres antes de llamar a una clase que **no puede cambiar** | "¿Podría mi código hablar solo con **mi** interfaz?" | Una clase nueva **implementa mi interfaz**, **guarda el objeto ajeno** en un atributo y **traduce** cada llamada de los métodos de la interfaz al objeto ajeno |
| **Banderas booleanas** o cadenas de `if` que suman costo o comportamiento, o **una subclase por cada combinación** | "¿Podría cada extra ser su propio objeto que agrego **en tiempo de ejecución**?" | Objetos que **comparten la interfaz del ítem**, **guardan otro ítem** y **le suman a su resultado**. Se pueden apilar. |
| La **misma secuencia de varios pasos** sobre varias clases de un subsistema, **copiada** en varios clientes | "¿Podrían los clientes llamar a **un solo método**?" | Una clase **es dueña de la secuencia** y ofrece un método simple. Las clases del subsistema quedan como están. |

### Plantilla de directiva técnica

Cada prompt que escriban debe tener estas cinco partes:

```
CONTEXTO:    Qué archivos/clases están involucrados (peguen solo lo que la IA necesita).
TAREA:       UN paso: una clase nueva, o un cambio en una clase.
ESTRUCTURA:  Nombre del tipo; qué implementa/extiende; atributos (¿private? ¿final?);
             parámetros del constructor; firmas de métodos; a qué objeto delega
             cada método y qué hace antes/después de delegar.
REGLAS:      Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
             sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO:   Compila; Main imprime exactamente la salida base;
             mostrame solo el archivo nuevo/modificado.
```

**Prompts débiles vs. un prompt fuerte**

| Débil | Por qué es débil |
|---|---|
| "Arreglá el código de envíos, está desordenado." | Sin estructura ni restricciones. La IA decide todo. |
| "Aplicá el patrón adapter a Correos." | Usa una palabra prohibida. No aprenden nada de la estructura. |
| "Refactorizá todo el proyecto para que sea fácil de extender." | Demasiado en un solo paso. No lo pueden verificar. |

Fuerte:

> CONTEXTO: `ShippingProvider.java` y `CorreosApi.java` (pegados abajo).
> TAREA: Creá una clase nueva `CorreosShipping` en el paquete `tecshop`.
> ESTRUCTURA: Implementa `ShippingProvider`. Tiene un único atributo `private final CorreosApi api` que recibe en su constructor. Por ahora, dejá que `quote` lance `UnsupportedOperationException`.
> REGLAS: No modifiques `CorreosApi`, `ShippingProvider` ni ningún otro archivo.
> TERMINADO: Compila. Mostrame solo el archivo nuevo.

### Rondas

En cada ronda escriban su **propia** secuencia de prompts con la plantilla, regístrenla y verifiquen la salida base después de cada paso.

**Ronda 1: S1 (10 min).** El navigator verifica:
- [ ] ¿`ShippingService` todavía menciona `CorreosApi`, gramos, códigos postales o `₡`?
- [ ] ¿`CorreosApi` quedó intacta?
- [ ] ¿La salida coincide con la salida base?

**Ronda 2: S2 (12 min).** Intercambien roles. El navigator verifica:
- [ ] ¿Puedo agregar un 4.º extra (p. ej. *grabado*, +CRC 3,000) **sin editar ninguna clase existente**? 
- [ ] ¿Puedo escoger los extras de cada ítem **en tiempo de ejecución** desde `Main`?
- [ ] ¿La salida coincide con la salida base? (Pista: piensen en el **orden** de los extras del teclado.)

**Ronda 3: S3 (9 min).** Intercambien roles. El navigator verifica:
- [ ] ¿`WebCheckout` y `KioskCheckout` quedan reducidos a **una sola llamada** cada uno?
- [ ] ¿Las clases de checkout todavía crean `Inventory`, `TaxCalculator`, etc.?
- [ ] ¿Las clases de servicios de la tienda quedaron sin cambios?
- [ ] ¿La salida coincide con la salida base?

