package com.example.practice.controller;

import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;
import com.example.practice.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> create(
            @Valid @RequestBody ProfileCreateRequest request
    ){
        return new ResponseEntity<>(
                service.createProfile(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getProfile(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> update(
            @PathVariable Long id,
            @RequestBody ProfileUpdateRequest request
            ){
        return ResponseEntity.ok(service.updateProfile(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfileResponse> delete(@PathVariable Long id){
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAll(){
        return ResponseEntity.ok(service.getAllProfiles());
    }


}
