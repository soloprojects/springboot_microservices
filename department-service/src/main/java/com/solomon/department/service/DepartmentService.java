package com.solomon.department.service;

import com.solomon.department.dto.DepartmentDto;
import com.solomon.department.entity.Department;
import com.solomon.department.response.DepartmentResponse;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department save(DepartmentDto departmentDto);
    Optional<Department> findById(long id);

    List<Department> findAll();

    List<DepartmentResponse> findAllWithUsers();
}
