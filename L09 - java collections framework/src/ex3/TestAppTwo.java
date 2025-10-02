package ex3;


import java.util.HashSet;
import java.util.Set;

// brug ArrayList<>(List.copyOf(college.getStudents.values())); næste gang
public class TestAppTwo {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Alice");
        s1.addGrade(12);
        Student s2 = new Student(2, "Bob");
        s2.addGrade(10);
        Student s3 = new Student(2, "Bob Double"); // s2 duplikat
        s3.addGrade(2);
        Student s4 = new Student(3, "Charlie");
        s4.addGrade(7);

        // equals()
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // false
        System.out.println("s2.equals(s3): " + s2.equals(s3)); // true -- samme nr.
        System.out.println("s2.equals(s4): " + s2.equals(s4)); // false

        // hashCode()
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());

        // Set adfærd (duplikater er forbudt)
        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println("Set size: " + students.size()); // skal være 3
        System.out.println("Set contents:\n " + students);
    }
}
