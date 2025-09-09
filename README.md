# Functional Interfaces in Java

## What is a Functional Interface?
- An interface with **only one abstract method**.
- Used with **Lambda Expressions** and **Streams**.
- Can have `default` and `static` methods.
- Marked with `@FunctionalInterface` (optional).

---

## Common Functional Interfaces

### `Predicate<T>`
- Method: `boolean test(T t)`

### `BiPredicate<T, U>`
- Method: `boolean test(T t, U u)`

### `Consumer<T>`
- Method: `void accept(T t)`

### `BiConsumer<T, U>`
- Method: `void accept(T t, U u)`

### `Function<T, R>`
- Method: `R apply(T t)`

### `BiFunction<T, U, R>`
- Method: `R apply(T t, U u)`

### `Supplier<T>`
- Method: `T get()`

### `UnaryOperator<T>` (special case of Function)
- Method: `T apply(T t)`

### `BinaryOperator<T>` (special case of BiFunction)
- Method: `T apply(T t1, T t2)`

---

## Why use Functional Interfaces?
- Enable lambda expressions.
- Provide clean, concise code.
- Core to Java 8 Streams and functional programming.
