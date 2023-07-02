package com.solomon.service;

import com.solomon.dto.UserCreateDto;
import com.solomon.entity.Users;
import com.solomon.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users save(UserCreateDto userCreateDto);
    List<Users> findAll();
    Optional<Users> findById(Long  id);
    UserResponse findByIdWithDepartment(Long id);
    List<UserResponse> findAllWithDepartment();
}
