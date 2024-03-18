package com.example.demo.service.entityManager;

import com.example.demo.pojo.dto.EmployeeDTO;
import com.example.demo.pojo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> findAll();
    EmployeeEntity findById(Long id);
    EmployeeEntity save(EmployeeDTO employeeDTO);
    void delete(Long id);
    EmployeeEntity updateEmployeeName(Long id, String name);
    public List<EmployeeEntity> findEmployeesByAgeAndDepartmentName(Integer age, String departmentName);
}

