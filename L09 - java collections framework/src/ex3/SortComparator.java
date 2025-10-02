package ex3;

import java.util.Comparator;

public class SortComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        String n1 = a.getName() == null ? "" : a.getName();
        String n2 = b.getName() == null ? "" : b.getName();
        int byName = n1.compareToIgnoreCase(n2);
        return (byName != 0) ? byName : Integer.compare(a.getStudentNo(), b.getStudentNo());
    }
}