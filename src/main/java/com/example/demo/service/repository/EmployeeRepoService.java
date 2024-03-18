package com.example.demo.service.repository;

import com.example.demo.pojo.dto.EmployeeDTO;
import com.example.demo.pojo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepoService {

    List<EmployeeEntity> findAllWithDepartment();

    EmployeeEntity findById(Long id);

    EmployeeEntity save(EmployeeDTO employeeDTO);

    void delete(Long id);
    List<EmployeeEntity> findByAgeGreaterThan(Integer age);
    void updateEmployeeName(Long id, String name);

}
