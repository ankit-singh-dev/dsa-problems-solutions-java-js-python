package com.inn.comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Comparable<Student> {

    private Integer id;

    private Integer rollNo;

    private String name;

    private Integer age;

    private Map<String, Integer> subjectMarks;

    private String city;

    @Override
    public int compareTo(Student anotherStudent) {
        // Ankit Ankit
        int compartorValue = this.getName().compareTo(anotherStudent.getName());
        if (compartorValue == 0) {
            return anotherStudent.getRollNo().compareTo(this.getRollNo());
        } else {
            return compartorValue;
        }
    }
}
