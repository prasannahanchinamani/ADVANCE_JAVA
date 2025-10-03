package jdbc_demo.libray_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibratyDb dao = new LibratyDb();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Issue a Book");
            System.out.println("2. View Student Issue History");
            System.out.print("3, Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    dao.issueBook(studentId, bookId);
                }
                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    dao.studentHistory(studentId);
                }
                case 3 -> {
                    System.out.println("Return Book");
                    System.out.println("Issued Id");
                    int id = sc.nextInt();
                    dao.returnBook(id);
                }
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
