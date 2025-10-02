package ex2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int StudentNo;
    private String name;
    private List<Integer> grades = new ArrayList<>(); // kan også bruge LinkedList<>();

    public Student(int studentNo, String name) {
        StudentNo = studentNo;
        this.name = name;
      // this.grades = new ArrayList<>();
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student: " +
                "\n StudentNo: " + StudentNo +
                "\n name: " + name +
                "\n grades: " + grades;
    }
}
