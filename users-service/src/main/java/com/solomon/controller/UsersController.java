package com.solomon.controller;

import com.solomon.client.DepartmentClient;
import com.solomon.dto.UserCreateDto;
import com.solomon.entity.Users;
import com.solomon.iservice.IUsersService;
import com.solomon.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UsersController {

    private final IUsersService usersService;

    @GetMapping("/get_all/with_department")
    public ResponseEntity<List<UserResponse>> departmentsWithUsers(){
        return ResponseEntity.ok(usersService.findAllWithDepartment());
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<Users>> users(){
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Users>> user(@PathVariable("id") Long id){
        return ResponseEntity.ok(usersService.findById(id));

    }

    @GetMapping("/get/with_department/{id}")
    public ResponseEntity<UserResponse> userWithDepartment(@PathVariable("id") Long id){
        return ResponseEntity.ok(usersService.findByIdWithDepartment(id));

    }

    @PostMapping("/add")
    public ResponseEntity<Users> add_user(@RequestBody UserCreateDto user){
        return ResponseEntity.created(URI.create("")).body(usersService.save(user));
    }

}
