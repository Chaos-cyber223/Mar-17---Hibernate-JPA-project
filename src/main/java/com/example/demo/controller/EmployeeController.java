package com.example.demo.controller;

import com.example.demo.pojo.dto.EmployeeDTO;
import com.example.demo.pojo.dto.EmployeeNameUpdateDTO;
import com.example.demo.pojo.entity.EmployeeEntity;
import com.example.demo.service.repository.EmployeeRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepoService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepoService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
        EmployeeEntity employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Long> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity savedEmployee = employeeService.save(employeeDTO);
        return new ResponseEntity<>(savedEmployee.getId(), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ageGreaterThan/{age}")
    public ResponseEntity<List<EmployeeEntity>> findByAgeGreaterThan(@PathVariable Integer age) {
        List<EmployeeEntity> employees = employeeService.findByAgeGreaterThan(age);
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("/{id}/updateName")
    public ResponseEntity<Void> updateEmployeeName(@PathVariable Long id, @RequestBody EmployeeNameUpdateDTO updateDTO) {
        employeeService.updateEmployeeName(id, updateDTO.getName());
        return ResponseEntity.ok().build();
    }

}

