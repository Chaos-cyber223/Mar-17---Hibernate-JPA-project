package com.example.demo.service.repository;

import com.example.demo.pojo.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentRepoService {
    List<DepartmentEntity> findAll();
    DepartmentEntity findById(Long id);
    DepartmentEntity save(DepartmentEntity department);
    void delete(Long id);
}

