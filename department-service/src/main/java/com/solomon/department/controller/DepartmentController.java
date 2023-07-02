package com.solomon.department.controller;

import com.solomon.department.client.UsersClient;
import com.solomon.department.dto.DepartmentDto;
import com.solomon.department.entity.Department;
import com.solomon.department.iservice.IDepartmentService;
import com.solomon.department.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RefreshScope
@RequestMapping("api/v1/department")
public class DepartmentController {

    private final IDepartmentService departmentService;
    private final UsersClient usersClient;

    @GetMapping("/get_all/with_users")
    public ResponseEntity<List<DepartmentResponse>> departmentsWithUsers(){
        return ResponseEntity.ok(departmentService.findAllWithUsers());
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<Department>> departments(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Department>> departments(@PathVariable("id") long id){
        return ResponseEntity.ok(departmentService.findById(id));

    }

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody DepartmentDto department){
        return ResponseEntity.created(URI.create("")).body(departmentService.save(department));
    }

}
