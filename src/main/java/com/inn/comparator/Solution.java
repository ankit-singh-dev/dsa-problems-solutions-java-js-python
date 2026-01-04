package com.inn.comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee{
    private String name;
    private Address address;
    private Double salary;
}

public class Solution {

    public static void main(String[] args) {

        Employee e1 = new Employee("Dilip", new Address("Indore",423456),70000.0);
        Employee e2 = new Employee("Ankit", new Address("Hyderabad",500049),600.0);
        Employee e3 = new Employee("Pranya", new Address("Patna",845426),60000.0);

        List<Employee> emps = List.of(e1, e2, e3);

        Function<Employee, String> func = city -> city.getAddress().getCity();

    }
}
