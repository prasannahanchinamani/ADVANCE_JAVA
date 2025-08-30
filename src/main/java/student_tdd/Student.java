package student_tdd;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        isValidateAge(age);
        isValidGrade(grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public boolean hasPassed() {
        return grade >= 35;
    }

    public void isValidateAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be > 1");
    }

    public void isValidGrade(double grade) {
        if (grade < 0 || grade > 100) throw new
                IllegalArgumentException("Grade must be between 0 and 100");
    }
}
