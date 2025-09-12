package java8_features.stream_api.library_Management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LibraryMainTest {
    private List<Book> books;

    @BeforeEach
    public void list() {
        books = Arrays.asList(
                new Book(1, "Java Basics", "James Gosling", 499.99),
                new Book(2, "Python basix", "Gudo Vancen", 799.00),
                new Book(3, "SQL", "Dont know", 650.50)
        );
    }

    @DisplayName("Most Expensive Book")
    @Test
    public void expensive() {
        Optional<Book> result = LibraryMain.expensiveBook(books);
        assertTrue(result.isPresent());
        assertEquals("Python basix", result.get().getTitle());
        assertEquals(799.00, result.get().getPrice());
    }

    @DisplayName("Unique Authors")
    @Test
    public void uniqueAuthors() {
        Set<Book> set = LibraryMain.convertToSet(books);
        assertEquals(3, set.size());
    }

    @DisplayName("Sort Testing")
    @Test
    public void sortOrNot() {
        Optional<Book> result = LibraryMain.sortBook(books);
        assertTrue(result.isPresent());
        assertEquals(3, result.get().getId()); // SQL book has id 3

        // negative case: empty list should return empty Optional
        List<Book> emptyBooks = Arrays.asList();
        Optional<Book> emptyResult = LibraryMain.sortBook(emptyBooks);
        assertFalse(emptyResult.isPresent());
    }
}
