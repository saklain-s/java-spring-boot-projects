package com.example.practice.controller;


import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;
import com.example.practice.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service){
        this.service=service;
    }


    @PostMapping
    public ProfileResponse create(@Valid @RequestBody ProfileCreateRequest request){
        return service.create(request);
    }

    @GetMapping
    public List<ProfileResponse> getAll(){
        return service.getAll();
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PatchMapping("/{id}")
    public ProfileResponse patch(
            @PathVariable Long id,
            @RequestBody ProfileUpdateRequest request
    ){
        return service.patch(id,request);
    }
}
