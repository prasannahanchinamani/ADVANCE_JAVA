package java8_features.stream_api.Library_Management;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LibraryMain {
    //    Find all books priced above 500 and sort them by price.
    public static void sortBook(List<Book> books) {
        books.stream()
                .filter(n -> n.getPrice() > 500)
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .findFirst()
                .ifPresentOrElse((n) -> System.out.println(n.toString()),
                        () -> System.out.println("Book is Not Available in library"));
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1, "Java Basics", "James Gosling", 499.99),
                new Book(2, "Effective Java", "Joshua Bloch", 799.00),
                new Book(3, "Clean Code", "Robert C. Martin", 650.50)
        );
        //sort based on price
        sortBook(books);


    }
}
