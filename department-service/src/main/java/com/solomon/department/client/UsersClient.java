package com.solomon.department.client;

import com.solomon.department.entity.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface UsersClient {

    @GetExchange("/api/v1/users/department/{departmentId}")
    public List<Users> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
