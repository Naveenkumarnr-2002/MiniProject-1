package com.example.Employee.management.Service;

import com.example.Employee.management.Entity.Employee;
import com.example.Employee.management.Repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Tag(name = "Handling full database operations like save, find,update , and delete for employees")
@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee>getAllEmployees(){

        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }


    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }
}
