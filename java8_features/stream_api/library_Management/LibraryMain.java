package java8_features.stream_api.library_Management;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryMain {
    // Find all books priced above 500 and sort them by price.
    public static Optional<Book> sortBook(List<Book> books) {
        Optional<Book> result = books.stream()
                .filter(n -> n.getPrice() > 500)
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .findFirst();

        result.ifPresentOrElse(
                n -> System.out.println(n),
                () -> new IllegalArgumentException("Book is Not Available in library"));

        return result;
    }

    // Collect unique authors into a Set.
    public static Set<Book> convertToSet(List<Book> books) {
        Set<Book> booksSet = books.stream().collect(Collectors.toSet());
        booksSet.forEach(book -> System.out.print(book + " "));
        return booksSet;
    }

    // Expensive book
    public static Optional<Book> expensiveBook(List<Book> books) {
        Optional<Book> expensive = books.stream()
                .max(Comparator.comparingDouble(Book::getPrice));

        expensive.ifPresentOrElse(
                book -> System.out.println("Most expensive book: " + book),
                () -> System.out.println("Not available")
        );
        return expensive;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1, "Java Basics", "James Gosling", 499.99),
                new Book(2, "Python basix", "Gudo Vancen", 799.00),
                new Book(3, "SQL", "Dont know", 650.50)
        );

        // sort based on price
        sortBook(books);

        // convert to set
        convertToSet(books);

        // expensive book
        System.out.println(expensiveBook(books));
    }
}
