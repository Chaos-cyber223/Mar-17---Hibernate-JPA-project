package com.example.demo.service.entityManager;

import com.example.demo.pojo.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> findAll();
    DepartmentEntity findById(Long id);
    DepartmentEntity save(DepartmentEntity department);
    void delete(Long id);
    Long update(Long id, DepartmentEntity department);
}

