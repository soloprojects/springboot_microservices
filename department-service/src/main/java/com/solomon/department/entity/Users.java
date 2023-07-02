package com.solomon.department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    private long id;

    private String firstname;

    private String lastname;

    private String email;

}
