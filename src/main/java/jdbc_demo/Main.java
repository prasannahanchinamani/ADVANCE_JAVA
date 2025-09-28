package jdbc_demo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Crud_operation crud = new Crud_operation();
        crud.createTable();
        // INSERT
        crud.insertUser(1, "Aarav", 25000);
        crud.insertUser(2, "Priya", 30000);
        crud.insertUser(3, "Rohan", 35000);
        crud.insertUser(4, "Sneha", 28000);
        crud.insertUser(5, "Vikram", 40000);

        // READ
        crud.readUsers();

        // UPDATE
        crud.update(2, "Priya Sharma", 40000);
        crud.update(4, "Sneha Kapoor", 32000);

        // READ after update
        crud.readUsers();

        // DELETE
        crud.delete(3); // delete Rohan
        crud.delete(5); // delete Vikram

        // READ after delete
        crud.readUsers();
    }
}

