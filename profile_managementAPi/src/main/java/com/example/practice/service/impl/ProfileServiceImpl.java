package com.example.practice.service.impl;

import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;
import com.example.practice.entity.Profile;
import com.example.practice.repository.ProfileRepository;
import com.example.practice.service.ProfileService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileRepository repository){
        this.repository = repository;
    }
    @Override
    public ProfileResponse createProfile(ProfileCreateRequest request) {

        if (repository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        Profile profile = new Profile();
        profile.setName(request.getName());
        profile.setEmail(request.getEmail());
        profile.setAge(request.getAge());

        Profile saved = repository.save(profile);

        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileResponse getProfile(Long id) {
        Profile profile = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Profile Not found"));
        return mapToResponse(profile);
    }

    @Override
    public ProfileResponse updateProfile(Long id, ProfileUpdateRequest request) {
        Profile profile = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile Not Found"));

        if (request.getName() != null){
            profile.setName(request.getName());
        }

        if (request.getAge() !=null){
            profile.setAge(request.getAge());
        }
        return mapToResponse(profile);
    }

    @Override
    public void deleteProfile(Long id) {

        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Profile Not Found");
        }
        repository.deleteById(id);
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ProfileResponse mapToResponse(Profile profile){
        ProfileResponse response = new ProfileResponse();
        response.setId(profile.getId());
        response.setName(profile.getName());
        response.setEmail(profile.getEmail());
        response.setAge(profile.getAge());

        return response;
    }
}
