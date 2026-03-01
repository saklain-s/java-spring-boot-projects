package com.example.practice.service;

import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;

import java.util.List;

public interface ProfileService {

    ProfileResponse createProfile(ProfileCreateRequest request);

    ProfileResponse getProfile(Long id);

    ProfileResponse updateProfile(Long id, ProfileUpdateRequest request);

    void deleteProfile(Long id);
    List<ProfileResponse> getAllProfiles();
}
