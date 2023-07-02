package com.solomon.response;

import com.solomon.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class UserResponse {

    private String firstname;

    private String lastname;

    private String email;

    private Department department;

}
