# Week #11 Activity: Spot it, then direct the AI

**Patterns:** Adapter · Decorator · Facade  **Duration:** 50 minutes  **Format:** pairs, one computer and one AI coding assistant per pair

> **Core idea:** if you can describe a structure precisely enough for an AI to build it, you understand the pattern. In this activity **you** find where a pattern belongs, and **you** decide the structure. The AI only types the code.

---

## Part 1 – Student handout

### The rules

1. **Work in pairs.** The **driver** writes the prompts. The **navigator** reviews each AI answer against the checks for that round. Swap roles every round.
2. **Banned words in your prompts:** `adapter`, `decorator`, `facade`, `wrapper`, `pattern`, `design pattern`, `refactor this using…`, `what pattern…`, `improve this code`, `clean this up`.
   A prompt that uses any of them **does not count**. (`gift wrap` is fine because it's a product feature.)
3. **Don't ask the AI where the problems are.** Detection is your job (Step 1).
4. **One step per prompt.** No "do everything at once" prompts.
5. **The baseline is your test.** After every change, `Main` must print **exactly** the baseline output below.
6. **Keep a prompt log** in `prompts.md`: copy every prompt you send, and add one line on what the AI got right or wrong. This log is what gets graded.

### The starter project: TecShop checkout

Folder: `src/patterns/tecshop/` (package `tecshop`)

| Class | What it does |
|---|---|
| `Main` | Builds two carts and checks out one on the web and one at the kiosk |
| `WebCheckout`, `KioskCheckout` | Run a purchase from start to finish |
| `Cart`, `CartItem` | Products and their extras (gift wrap, insurance, express) |
| `Inventory`, `TaxCalculator`, `PaymentGateway`, `InvoicePrinter`, `Money` | Store services |
| `ShippingService` | Picks a shipping provider and gets a quote |
| `ShippingProvider`, `LocalCourier` | **Our** shipping interface and our in-house courier |
| `CorreosApi` | **Third-party** SDK from Correos de Costa Rica. **You may not modify it.** |

Run it:

```bash
cd src/patterns/tecshop
javac -encoding UTF-8 -d out *.java
java -cp out tecshop.Main
```

**Baseline output** (it must stay identical):

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

### Step 1 – Detection (no AI): fill in the Smell Map

Read the code. There are **three** design problems. Use the Detection Card to find them.

| # | Where (class.method) | Symptom: what will hurt when the code changes? | Who knows too much? | Which existing class(es) would you keep untouched? |
|---|---|---|---|---|
| S1 | | | | |
| S2 | | | | |
| S3 | | | | |

### Detection Card

| If you see… | Ask yourself… | Structural move |
|---|---|---|
| Client code that **converts** units, types or names before calling a class it **can't change** | "Could my code talk only to **my** interface?" | A new class **implements my interface**, **holds the foreign object** in a field, and **translates** each call. |
| **Boolean flags** or `if` chains that add cost or behavior, or **one subclass per combination** | "Could each extra be its own object that I add **at runtime**?" | Objects that **share the item's interface**, **hold another item**, and **add to its result**. They can be stacked. |
| The **same multi-step sequence** over several subsystem classes, **copied** in several clients | "Could the clients call **one method** instead?" | One class **owns the sequence** and offers a simple method. The subsystem classes stay as they are. |

### The technical directive template

Every prompt you write should have these five parts:

```
CONTEXT:   Which files/classes are involved (paste only what the AI needs).
TASK:      ONE step: one new class, or one change to one class.
STRUCTURE: Type name; implements/extends what; fields (private? final?);
           constructor parameters; method signatures; which object each
           method delegates to, and what it does before/after delegating.
RULES:     What must NOT change (e.g. "do not modify CorreosApi");
           no new libraries; keep package tecshop; don't touch other files.
DONE WHEN: It compiles; Main prints exactly the baseline;
           show me only the changed/new file.
```

**Weak prompts vs. a strong prompt**

| ❌ Weak | Why it's weak |
|---|---|
| "Fix the shipping code, it's messy." | No structure or constraints. The AI decides everything. |
| "Apply the adapter pattern to Correos." | Uses a banned word. You learn nothing about the structure. |
| "Refactor the whole project so it's easy to extend." | Too much in one step. You can't check it. |

✅ Strong:

> CONTEXT: `ShippingProvider.java` and `CorreosApi.java` (pasted below).
> TASK: Create a new class `CorreosShipping` in package `tecshop`.
> STRUCTURE: It implements `ShippingProvider`. It has one field `private final CorreosApi api` that it receives in its constructor. For now, leave `quote` throwing `UnsupportedOperationException`.
> RULES: Do not modify `CorreosApi`, `ShippingProvider` or any other file.
> DONE WHEN: It compiles. Show only the new file.

### Rounds

For every round, write your **own** prompt sequence with the template, log it, and run the baseline check after each step.

**Round 1 – S1 (10 min).** Navigator checks:
- [ ] Does `ShippingService` still mention `CorreosApi`, grams, postal codes or `₡`?
- [ ] Was `CorreosApi` left untouched?
- [ ] Does the output match the baseline?

**Round 2 – S2 (12 min).** Swap roles. Navigator checks:
- [ ] Can I add a 4th extra (e.g. *engraving*, +CRC 3,000) **without editing any existing class**? Try it.
- [ ] Can I choose the extras for each item **at runtime** in `Main`?
- [ ] Does the output match the baseline? (Hint: think about the **order** of the extras for the keyboard.)

**Round 3 – S3 (9 min).** Swap roles. Navigator checks:
- [ ] Do `WebCheckout` and `KioskCheckout` each reduce to **one call**?
- [ ] Do the checkout classes still create `Inventory`, `TaxCalculator`, etc.?
- [ ] Were the store service classes left unchanged?
- [ ] Does the output match the baseline?

### Exit ticket (individual, last 2 minutes)

Write **one** prompt, without any banned words, that would make an AI create the structure you built in Round 2 from scratch.

---

## Part 2 – Teacher guide

### Timeline (50 min)

| Min | Phase | What happens | Teacher's role |
|---|---|---|---|
| 0–5 | **Hook and rules** | Project the weak vs. strong prompts. Explain the banned words, roles, baseline and prompt log. | Say it plainly: *"Today the AI is your keyboard, not your architect."* |
| 5–12 | **Detection (no AI)** | Pairs read the code and fill in the Smell Map with the Detection Card. | At minute 11, do a quick 1-minute plenary: confirm the **locations** of S1–S3. **Don't say the pattern names.** |
| 12–22 | **Round 1 – S1** | Prompt, run, compare, log. | Walk around. If a pair is stuck, ask: *"Which interface does `ShippingService` wish Correos had?"* |
| 22–34 | **Round 2 – S2** | Roles swap. | Ask: *"Where does the extra get its price from, if not from flags?"* |
| 34–43 | **Round 3 – S3** | Roles swap. | Ask: *"If a third checkout (mobile app) appears tomorrow, how many lines would it copy?"* |
| 43–50 | **Debrief** | **Reveal the names** (S1 = Adapter, S2 = Decorator, S3 = Facade). Pairs label their classes with the actor names from [Week #11](Week%20%2311.md) (Target, Adaptee, Component, Base Decorator, Subsystem…). One pair projects its best and worst prompt. The class says which part of the template the worst prompt was missing. Exit ticket. | Show the "Proxy vs Decorator" note as a teaser for next class. |

### Grading rubric for the prompt log (0–2 points per criterion, 8 total)

| Criterion | 0 | 1 | 2 |
|---|---|---|---|
| **Specific structure** | "Make it better" | Names classes, but not fields or delegation | Names type, implements/extends, fields, constructor parameters and delegation |
| **Incremental** | One huge prompt | 2 steps per round | 3+ small, checkable steps per round |
| **Constraints** | None | Some | Says explicitly what must not change, every time |
| **Verification** | Never ran it | Ran it | Ran the baseline after each step **and** logged at least one AI mistake they caught |

A banned word sets that prompt to 0.

### What to watch for (common AI mistakes students should catch)

- **S1:** the AI changes `CorreosApi` to make it fit, or keeps the `if ("correos")` branch and only moves the conversion into a helper method. That's a static helper, not an object that implements our interface.
- **S2:** the AI creates subclasses like `GiftWrapExpressItem` (class explosion again). Or it forgets that `Cart` and `InvoicePrinter` must now use the **interface** type, not `CartItem`. Or it reorders the extras, which changes the keyboard's price (insurance is 5% of whatever it wraps). That's a good debrief moment: **with stackable extras, order matters**.
- **S3:** the AI "simplifies" by merging `TaxCalculator` into the new class, or deletes the subsystem classes. The subsystem must stay intact and unaware of the new class.

<details>
<summary><strong>Answer key: reference prompt sequences and resulting structure (teacher only)</strong></summary>

This key was checked: applying it produces output identical to the baseline.

#### S1 → Adapter
1. Create `CorreosShipping implements ShippingProvider` with a `private final CorreosApi api` constructor field. `quote` throws for now.
2. Implement `quote(kg, city)`: convert kg to `int` grams (`Math.round(kg * 1000)`), look up the postal code in a `Map<String,String>` field (San Jose 10101, Alajuela 20101, Cartago 30101, Limon 70101), call `api.calcularTarifa`, remove `₡` and parse to `double`. Unknown city → `IllegalArgumentException`.
3. In `ShippingService`, replace both fields and the `if/else` with a `Map<String, ShippingProvider>`: `"local"` → `new LocalCourier()`, `"correos"` → `new CorreosShipping(new CorreosApi())`. `quote` looks up and delegates.
4. Run and compare with the baseline.

Actors: **Target** `ShippingProvider` · **Adaptee** `CorreosApi` · **Adapter** `CorreosShipping` · **Client** `ShippingService`.

#### S2 → Decorator
1. Create interface `Item { double getPrice(); String describe(); }`. `CartItem` implements it, its 3 booleans are removed, and its constructor becomes `(String name, double basePrice)`. `Cart` and `InvoicePrinter` use `Item` instead of `CartItem`.
2. Create `abstract class ItemExtra implements Item` with `protected final Item inner` received in the constructor. Both methods delegate to `inner`.
3. Create `GiftWrap` (+1500, `" + gift wrap"`), `Insurance` (+5% of `inner.getPrice()`, `" + insurance"`) and `Express` (+2500, `" + express"`), each extending `ItemExtra`, calling `inner` first and then adding.
4. In `Main`: `new Express(new GiftWrap(new CartItem("Laptop stand", 25000)))`, `new Insurance(new CartItem("USB-C hub", 18000))`, `new Insurance(new GiftWrap(new CartItem("Mechanical keyboard", 42000)))`.
5. Bonus: add `Engraving` without touching any existing class.

Actors: **Component** `Item` · **Concrete Component** `CartItem` · **Base Decorator** `ItemExtra` · **Concrete Decorators** `GiftWrap`, `Insurance`, `Express` · **Client** `Main`.

#### S3 → Facade
1. Create `OrderProcess` with private fields for `Inventory`, `TaxCalculator`, `ShippingService`, `PaymentGateway` and `InvoicePrinter`, and a method `placeOrder(Cart cart, String customer, String city, String shippingProvider, String paymentMethod)` that runs the 5 steps in the current order.
2. Rewrite `WebCheckout.buy` and `KioskCheckout.buy` so each holds an `OrderProcess` and makes **one** call (`"correos"/"credit card"` and `"local"/"SINPE Movil"`).
3. Check that neither checkout class refers to any subsystem class, and compare with the baseline.

Actors: **Facade** `OrderProcess` · **Subsystem** `Inventory`, `TaxCalculator`, `ShippingService`, `PaymentGateway`, `InvoicePrinter` · **Clients** `WebCheckout`, `KioskCheckout`.

```mermaid
classDiagram
    class ShippingProvider { <<interface>> +quote(kg, city) }
    class CorreosShipping { -api: CorreosApi +quote(kg, city) }
    class CorreosApi { +calcularTarifa(gramos, codigoPostal) }
    ShippingProvider <|.. LocalCourier
    ShippingProvider <|.. CorreosShipping
    CorreosShipping --> CorreosApi : adaptee

    class Item { <<interface>> +getPrice() +describe() }
    class ItemExtra { <<abstract>> #inner: Item }
    Item <|.. CartItem
    Item <|.. ItemExtra
    ItemExtra o--> Item : inner
    ItemExtra <|-- GiftWrap
    ItemExtra <|-- Insurance
    ItemExtra <|-- Express

    class OrderProcess { +placeOrder(cart, customer, city, provider, payment) }
    WebCheckout --> OrderProcess
    KioskCheckout --> OrderProcess
    OrderProcess ..> Inventory
    OrderProcess ..> TaxCalculator
    OrderProcess ..> ShippingService
    OrderProcess ..> PaymentGateway
    OrderProcess ..> InvoicePrinter
```

</details>
