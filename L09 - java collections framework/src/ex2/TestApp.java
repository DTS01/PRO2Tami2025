package ex2;

public class TestApp {
    // create students
    public static void main(String[] args) {
        Student s1 = new Student(1, "Alice");
        s1.addGrade(10);
        s1.addGrade(12);
        // prøv at lave en metode addAllGrades næste gang

        Student s2 = new Student(2, "Tamila");
        s2.addGrade(12);
        s2.addGrade(12);

        Student s3 = new Student(3, "Charlie");
        s3.addGrade(4);
        s3.addGrade(4);

        College college = new College();
        college.addStudent(s1);
        college.addStudent(s2);
        college.addStudent(s3);

        // print average
        System.out.println("Average grade: " + college.calcAverage());

        //find student by nr.
        System.out.println("Student 2: " + college.findStudent(2));
        System.out.println("Student 22: " + college.findStudent(22));
    }
}
