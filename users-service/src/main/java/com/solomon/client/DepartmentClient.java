package com.solomon.client;

import com.solomon.entity.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface DepartmentClient {

    @GetExchange("/api/v1/department/get/{id}")
    public Department findByDepartment(@PathVariable("id") Long departmentId);

}
