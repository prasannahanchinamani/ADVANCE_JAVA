✅ JUnit Testing in Java
JUnit is a Java unit testing framework used to write and execute automated tests. It helps developers ensure that their code functions correctly by verifying individual units (methods or classes) in an application.

📚 Repository Highlight
📁 Solutions	📌 Code solutions cover
🧪 Introduction to JUnit	What is JUnit and why testing is crucial in software development
🔖 JUnit Annotations	Understanding @Test, @BeforeEach, @AfterEach, @BeforeAll, @AfterAll
🧱 Structure of a Test Class	Best practices in organizing test classes and test methods
🧬 Writing Test Cases	Writing unit tests for methods and logic using JUnit
✔️ Assertions in JUnit	Using assertEquals, assertTrue, assertThrows, and more
🧰 Tech Stack
Java 17+
JUnit 5 (Jupiter API)
Maven as build automation tool
IDE: IntelliJ IDEA / Eclipse / VS Code
⚙️ JUnit Maven Dependency
To get started with JUnit in your Maven project, include the following in your pom.xml:

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
🧪 Sample Test Case
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAddition() {
        assertEquals(4, 2 + 2, "2 + 2 should equal 4");
    }
}


### 1. File Handling (Main Focus)
- Core file operations: create, read, write, and update files.  
- Includes extended examples of handling **JSON** and **CSV** data.  
- Covers different use-cases like task management, cab invoice, shopping cart, and insurance policy data.  

## Branches

- `feature/junit-basics` – JUnit testing examples (only testing branch).  
- `file_handling` – Core file operations + JSON & CSV handling.  
- `cab_invoice` – File handling applied to a cab invoice generator.  
- `shopping_cart` – File handling applied to a shopping cart system.  
- `insurance_policy_data_management` – File handling applied to policy data management.  

