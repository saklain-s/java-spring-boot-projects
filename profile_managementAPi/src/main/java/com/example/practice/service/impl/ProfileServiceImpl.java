package com.example.practice.service.impl;

import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;
import com.example.practice.repository.ProfileRepository;
import com.example.practice.service.ProfileService;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileRepository repository){
        this.repository = repository;
    }
    @Override
    public ProfileResponse createProfile(ProfileCreateRequest request) {
        return null;
    }

    @Override
    public ProfileResponse getProfile(Long id) {
        return null;
    }

    @Override
    public ProfileResponse updateProfile(Long id, ProfileUpdateRequest request) {
        return null;
    }

    @Override
    public void deleteProfile(Long id) {

    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return List.of();
    }
}
