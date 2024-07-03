package com.inn.comparator;

import com.inn.comparator.compartors.StudentCompByMarks;

import java.util.*;

public class ComparatorMain {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1,1,"Pooja",26, Map.of("Hindi",67,"Maths",76),"Patna");
        Student s2 = new Student(2,2,"Runuji",22, Map.of("Hindi",52,"Maths",98),"Muzaffarpur");
        Student s3 = new Student(3,3,"Ankit",28, Map.of("Hindi",34,"Maths",21),"Pune");
        Student s4 = new Student(4,4,"Ankit",22, Map.of("Hindi",94,"Maths",99),"Gobarsahi");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        Collections.sort(students);

        for(Student s : students){
            System.out.println(s);
        }
        System.out.println("=========================");
        Comparator<Student> studentComparator = new StudentCompByMarks();

        Comparator<Student> studentComparator1 = (student1, student2) ->  {
            int student1TotalMarks = student1.getSubjectMarks().entrySet()
                    .stream()
                    .mapToInt(marks -> marks.getValue())
                    .sum();

            int student2TotalMarks = student2.getSubjectMarks().entrySet()
                    .stream()
                    .mapToInt(marks -> marks.getValue())
                    .sum();

            if(student1TotalMarks < student2TotalMarks){
                return 1;
            }else if(student1TotalMarks == student2TotalMarks){
                return 0;
            }else{
                return -1;
            }
        };

        Collections.sort(students, studentComparator1);
        for(Student s : students){
            System.out.println(s);
        }
    }
}
