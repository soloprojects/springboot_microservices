package com.solomon.department.iservice;

import com.solomon.department.client.UsersClient;
import com.solomon.department.dto.DepartmentDto;
import com.solomon.department.entity.Department;
import com.solomon.department.repository.DepartmentRepository;
import com.solomon.department.response.DepartmentResponse;
import com.solomon.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IDepartmentService implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UsersClient usersClient;

    @Override
    public Department save(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<DepartmentResponse> findAllWithUsers() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponse> responseList = new ArrayList<>();
        for(Department department :departments){
            DepartmentResponse response = new DepartmentResponse();
            response.setUsers(usersClient.findByDepartment(department.getId()));
            response.setId(department.getId());
            response.setName(department.getName());
            responseList.add(response);
        }
        return responseList;
    }
}
