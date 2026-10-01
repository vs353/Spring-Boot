package com.vaish.practice;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
//        boolean delete =
        Employee deleted = helloService.deleteEmployee(id);
//        if(!delete){
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(deleted);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee( @PathVariable int id, @Valid @RequestBody Employee employee){
        return helloService.updateEmployee(id,employee);
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@Valid  @RequestBody Employee employee){
        Employee savedEmployee = helloService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Employee employee = helloService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees/high-salary")
    public List<Employee> getHighSalaryEmployees(@RequestParam long salary){
        return helloService.getHighSalaryEmployees(salary);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = helloService.getEmployees();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employee")
    public Employee getEmployee(){
        return new Employee(1,"vaish",400000);
    }
    @GetMapping("/")
    public String hello(){
        return helloService.getMessage();
//        return "Hello Vaish !!! Spring Boot Application is Working";
    }
}
