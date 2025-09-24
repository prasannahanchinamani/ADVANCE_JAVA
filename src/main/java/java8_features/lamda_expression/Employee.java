package java8_features.lamda_expression;

public class Employee {
    private int id;
    private String name;

    //constuctor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //tostring

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
