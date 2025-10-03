package jdbc_demo.libray_management;

public class Student {
    private int studentId;
    private String name;
    private String branch;

    public Student(int studentId, String name, String branch) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return studentId + " | " + name + " | " + branch;
    }
}
