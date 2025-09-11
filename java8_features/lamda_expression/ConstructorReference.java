package java8_features.lamda_expression;

import org.apache.commons.lang3.function.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ConstructorReference {
    public static void main(String[] args) {
        BiFunction<String, Integer, Person> personObject = Person::new;
        //creating object
        Person object = personObject.apply("Prasanna",22);
        // Print the object
        System.out.println(object);
    }
}
