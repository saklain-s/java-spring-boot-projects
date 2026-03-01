package com.example.practice.service;

import com.example.practice.dto.ProfileCreateRequest;
import com.example.practice.dto.ProfileResponse;
import com.example.practice.dto.ProfileUpdateRequest;
import com.example.practice.model.Profile;
import com.example.practice.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository repo;

    public ProfileService(ProfileRepository repo) {
        this.repo = repo;
    }

    public ProfileResponse create(ProfileCreateRequest request) {
        Profile profile = new Profile(
                request.getName(),
                request.getEmail(),
                request.getAge()
        );

        Profile saved = repo.save(profile);
        return toResponse(saved);
    }

    public List<ProfileResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public ProfileResponse patch(Long id, ProfileUpdateRequest request) {
        Profile profile = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        if (request.getName() != null) {
            profile.setName(request.getName());
        }
        if (request.getEmail() != null) {
            profile.setEmail(request.getEmail());
        }
        if (request.getAge() != null) {
            profile.setAge(request.getAge());
        }

        // No save() needed – JPA dirty checking
        return toResponse(profile);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private ProfileResponse toResponse(Profile profile) {
        return new ProfileResponse(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getAge()
        );
    }
}
