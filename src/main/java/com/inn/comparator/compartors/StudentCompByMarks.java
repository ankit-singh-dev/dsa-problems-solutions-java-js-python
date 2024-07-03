package com.inn.comparator.compartors;

import com.inn.comparator.Student;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class StudentCompByMarks implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {

        Set<Map.Entry<String,Integer>> marksEntry1 = student1.getSubjectMarks().entrySet();
        int student1TotalMarks = 0;
        for(Map.Entry<String,Integer> marks : marksEntry1){
            student1TotalMarks += marks.getValue();
        }

        Set<Map.Entry<String,Integer>> marksEntry2 = student2.getSubjectMarks().entrySet();
        int student2TotalMarks = 0;
        for(Map.Entry<String,Integer> marks : marksEntry2){
            student2TotalMarks += marks.getValue();
        }

        if(student1TotalMarks < student2TotalMarks){
            return 1;
        }else if(student1TotalMarks == student2TotalMarks){
            return 0;
        }else{
            return -1;
        }
    }
}
