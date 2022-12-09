package com.cst.citizenservice.util;

import lombok.*;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 *
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
class Employee implements Externalizable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private String city;
    private Department department;

    public Employee(String name, Integer age, String city, Department department) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.department = department;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

@Getter
@Setter
@NoArgsConstructor
@ToString
class Department {
    private String departmentName;

    private Integer noOfEmployees;

    public Department(String departmentName, Integer noOfEmployees) {
        this.departmentName = departmentName;
        this.noOfEmployees = noOfEmployees;
    }

}

public class Strem8 {

    public static void main(String[] args) {

        Department account = new Department("Account", 75);
        Department hr = new Department("HR", 50);
        Department ops = new Department("OP", 25);
        Department tech = new Department("Tech", 150);

        List<Employee> employeeList = Arrays.asList(
                new Employee("David", 32, "Matara", account),
                new Employee("Brayan", 25, "Galle", hr),
                new Employee("JoAnne", 45, "Negombo", ops),
                new Employee("Jake", 65, "Galle", hr),
                new Employee("Brent", 55, "Matara", hr),
                new Employee("Allice", 23, "Matara", ops),
                new Employee("Austin", 30, "Negombo", tech),
                new Employee("Gerry", 29, "Matara", tech),
                new Employee("Scote", 20, "Negombo", ops),
                new Employee("Branden", 32, "Matara", account),
                new Employee("Iflias", 31, "Galle", hr));

        //Find all employees who lives in ‘Matara’ city, sort them by their name and print the names of employees.
        employeeList.stream().filter(employee -> employee.getCity().equalsIgnoreCase("Matara"))
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println(e));

        System.out.println("**********************************************");
        //Find distinct department names that employees work for.
        employeeList.stream().map(employee -> employee.getDepartment().getDepartmentName())
                .distinct()
                .forEach(e -> System.out.println(e));

        System.out.println("**********************************************");
        //Find the department names that these employees work for, where the number of employees in the department is over 50.
        employeeList.stream().map(employee -> employee.getDepartment())
                .filter(department -> department.getNoOfEmployees() > 50)
                .distinct().forEach(department -> System.out.println(department.getDepartmentName()));


        employeeList.stream().map(employee -> employee.getDepartment())
                .filter(e -> e.getNoOfEmployees() > 50)
                .distinct()
                .forEach(department -> System.out.println(department.getDepartmentName()));

        System.out.println("**********************************************");
        //Find the total number of employees in all the departments.
        employeeList.stream().map(employee -> employee.getDepartment().getNoOfEmployees())
                .distinct()
                .reduce(Integer::sum)
                .ifPresent(e -> System.out.println(e));
        System.out.println("**********************************************");
        //Find the department which has the highest number of employees.
        employeeList.stream().map(employee -> employee.getDepartment().getNoOfEmployees())
                .distinct()
                .max((e1, e2) -> e1.compareTo(e2)).ifPresent(e -> System.out.println(e));
        employeeList.stream()
                .map(Employee::getDepartment)
                .reduce((d1, d2) -> d1.getNoOfEmployees() > d2.getNoOfEmployees() ? d1 : d2)
                .ifPresent(d -> System.out.println(d.getDepartmentName()));

        System.out.println("**********************************************");
        //Are there any employees from HR Department?
        employeeList.stream()
                .filter(employee -> employee.getDepartment().getDepartmentName().equalsIgnoreCase("HR"))
                .forEach(e -> System.out.println(e));

        String s = employeeList.stream().map(employee -> employee.getDepartment().getDepartmentName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> (a + "," + b));
        System.out.println(s);
    }
}


