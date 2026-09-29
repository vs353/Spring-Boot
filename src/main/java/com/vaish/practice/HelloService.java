package com.vaish.practice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloService {
    public boolean deleteEmployee(int id){
        return employees.removeIf(e-> e.getId()==id);
    }
    public  Employee updateEmployee(int id, Employee updateEmployee){
        Employee existingEmployee= getEmployees().stream().filter(e ->e.getId() == id ).findFirst().orElse(null);
        if(existingEmployee != null){
            existingEmployee.setName(updateEmployee.getName());
            existingEmployee.setSalary(updateEmployee.getSalary());
        }
        return existingEmployee;
    }
    public String getMessage(){
        return "Hello From Service Layer";
    }
    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;

    }
    public List<Employee> getEmployees(){
        return employees;
    }

    public Employee getEmployeeById(int id){

        return getEmployees().stream().filter(e -> e.getId()==id).findFirst().orElse(null);
    }
    public List<Employee> getHighSalaryEmployees(long salary){
        return getEmployees().stream().filter(e ->e.getSalary()>=salary).toList();
    }

    public final List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "vaish", 40000),
                    new Employee(2, "shiro", 50000),
                    new Employee(3 , "jelly", 600000),
                    new Employee(4, "rue", 700000)
            )

    );
}
