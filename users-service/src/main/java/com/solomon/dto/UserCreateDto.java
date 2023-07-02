package com.solomon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreateDto {

    public String firstname;
    public String lastname;
    public String email;
    public long department_id;

}
