package com.example.practice.dto;

public class ProfileResponse {

    private Long id;
    private String name;
    private String email;
    private Integer age;

    public ProfileResponse(Long id,String name,String email,Integer age){
        this.age=age;
        this.id=id;
        this.email=email;
        this.name=name;
    }

    public String getName(){return name;}
    public String getEmail(){return email;}
    public Long getId(){return id;}
    public Integer getAge(){return age;}
}
