package com.solomon.department.response;

import com.solomon.department.entity.Users;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentResponse {

    private long id;

    private String name;

    private List<Users> users;

}
