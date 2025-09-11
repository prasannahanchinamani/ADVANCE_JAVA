package java8_features.lamda_expression;

class Printer {
    // Static method
    public static void staticPrint(String msg) {
        System.out.println("Static: " + msg);
    }

    // Instance method
    public void instancePrint(String msg) {
        System.out.println("Instance: " + msg);
    }
}

public class Lambda_FI {
    public static void main(String[] args) {
        // Circle using lambda
        Shape circle = () -> System.out.println("Drawing a Circle");

        // Rectangle using lambda
        Shape rectangle = () -> System.out.println("Drawing a Rectangle");

        // Call draw()
        circle.draw();
        rectangle.draw();

        //lambda
        MessagePrinter msg = (str) -> System.out.println(str);
        msg.print("Printing with lambda expression");
        // static method reference,
        MessagePrinter printer = Printer::staticPrint;
        printer.print("Hello using Static Method Reference!");

        //instance print
        Printer print = new Printer();
        MessagePrinter printer1 = print::instancePrint;
        printer1.print("Hello using Instance Method Reference!");
    }
}
