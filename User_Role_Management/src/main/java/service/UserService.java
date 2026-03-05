package service;


import dto.UserCreateRequest;
import entity.Role;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserService(UserRepository userRepo, RoleRepository roleRepo){
        this.roleRepo=roleRepo;
        this.userRepo=userRepo;
    }

    public void createUser(UserCreateRequest request){

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        Set<Role> roles = request.getRoles()
                .stream()
                .map(roleName ->
                        roleRepo.findByName(roleName)
                                .orElseThrow(() ->
                                new RuntimeException("Role Not Found")))
                .collect(Collectors.toSet());

        user.setRoles(roles);
        userRepo.save(user);
    }
}
