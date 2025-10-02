package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private int StudentNo;
    private String name;
    private List<Integer> grades = new ArrayList<>();;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return this.StudentNo == other.StudentNo;
    }


    /* simple version
    @Override
    public boolean equals(Object o) {
        // If same object, they are equal
        if (this == o) {
            return true;
        }
        // If the other object is null or not a Student, they are not equal
        if (o == null || !(o instanceof Student)) {
            return false;
        }
        // Safe to cast now
        Student other = (Student) o;
        // Compare studentNo directly
        if (this.StudentNo == other.StudentNo) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public String toString() {
        return "\n Student: " +
                "\n StudentNo: " + StudentNo +
                "\n name: " + name +
                "\n grades: " + grades;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.StudentNo, other.StudentNo);
    }
}
