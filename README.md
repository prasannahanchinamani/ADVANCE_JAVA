# 📦 JUnit 5 Testing Framework Overview

JUnit is a widely used **Java testing framework** that helps developers write and run repeatable tests to ensure code reliability and consistency.

---

## ⚙️ JUnit 5 Architecture

JUnit 5 is composed of three key modules:

| Module          | Description                                                                 |
|-----------------|-----------------------------------------------------------------------------|
| **JUnit Platform** | Launches and runs tests on the JVM, supports multiple testing frameworks. |
| **JUnit Jupiter**  | Provides modern annotations and APIs for writing tests in JUnit 5.         |
| **JUnit Vintage**  | Enables backward compatibility with JUnit 3 and 4.                         |

---

## 🧪 Core Features

- **Annotations** for marking test methods
- **Test Lifecycle Hooks**: Setup and teardown logic
- **Assertions**: Validate expected vs actual results
- **Assumptions**: Conditionally skip tests
- **Parameterized Tests**: Run tests with multiple inputs
- **Dynamic Tests**: Generate tests at runtime
- **Tagging & Filtering**: Group and run selective tests
- **IDE & Build Tool Support**: IntelliJ, Eclipse, Maven, Gradle

---

## 🔖 Key Annotations

| Annotation       | Purpose                                      |
|------------------|----------------------------------------------|
| `@Test`          | Marks a method as a test                     |
| `@BeforeEach`    | Runs before each test method                 |
| `@AfterEach`     | Runs after each test method                  |
| `@BeforeAll`     | Runs once before all tests                   |
| `@AfterAll`      | Runs once after all tests                    |
| `@DisplayName`   | Custom name for test class or method         |
| `@Disabled`      | Temporarily disables a test                  |

---

## ✅ Assertions

Used to verify expected behavior:

```java
assertEquals(expected, actual);
assertTrue(condition);
assertFalse(condition);
assertNotNull(object);

FLOW----->
@BeforeAll → @BeforeEach → @Test → @AfterEach → @AfterAll
