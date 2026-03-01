package com.example.practice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class ProfileUpdateRequest {

    private String name;

    @Email
    private String email;

    @Min(1)
    @Max(120)
    private Integer age;

    public String getName(){return name;}
    public String getEmail(){return email;}
    public Integer getAge(){return age;}
}
