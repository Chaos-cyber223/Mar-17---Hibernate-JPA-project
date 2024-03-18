package com.example.demo.service.repository;

import com.example.demo.pojo.dto.EmployeeDTO;
import com.example.demo.pojo.entity.DepartmentEntity;
import com.example.demo.pojo.entity.EmployeeEntity;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepoServiceImpl implements EmployeeRepoService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeRepoServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }


    @Override
    public EmployeeEntity save(EmployeeDTO employeeDTO) {
        DepartmentEntity department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }


    
    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeEntity> findByAgeGreaterThan(Integer age) {
        return employeeRepository.findByAgeGreaterThan(age);
    }

    @Override
    public void updateEmployeeName(Long id, String name) {
        employeeRepository.updateEmployeeName(id, name);
    }

}

