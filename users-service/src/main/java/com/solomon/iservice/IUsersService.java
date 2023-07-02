package com.solomon.iservice;

import com.solomon.client.DepartmentClient;
import com.solomon.dto.UserCreateDto;
import com.solomon.entity.Users;
import com.solomon.exception.UserNotFoundException;
import com.solomon.repository.UsersRepository;
import com.solomon.response.UserResponse;
import com.solomon.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final DepartmentClient departmentClient;
    @Override
    public Users save(UserCreateDto userCreateDto) {
        Users user = new Users();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstname(userCreateDto.getFirstname());
        user.setLastname(userCreateDto.getLastname());
        user.setDepartment_id(userCreateDto.getDepartment_id());
        return usersRepository.save(user);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<UserResponse> findAllWithDepartment() {
        List<Users> allUsers = usersRepository.findAll();
        List<UserResponse> responseList = new ArrayList<>();
        for(Users user : allUsers){
            UserResponse response = new UserResponse();
            response.setFirstname(user.getFirstname());
            response.setLastname(user.getLastname());
            response.setEmail(user.getEmail());
            response.setDepartment(departmentClient.findByDepartment(user.getDepartment_id()));
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public UserResponse findByIdWithDepartment(Long id) {
        UserResponse response = new UserResponse();
        Optional<Users> user = usersRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("");
        }
        response.setFirstname(user.get().getFirstname());
        response.setLastname(user.get().getLastname());
        response.setEmail(user.get().getEmail());
        response.setDepartment(departmentClient.findByDepartment(user.get().getDepartment_id()));
        return response;
    }
}
