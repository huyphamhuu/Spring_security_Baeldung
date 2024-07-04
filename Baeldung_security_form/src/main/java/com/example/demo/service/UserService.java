package com.example.demo.service;
import com.example.demo.repo.IUserService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.model.Role;
import com.example.demo.repo.UserRepository;
import com.example.demo.exception.UserAlreadyExistException;
import java.util.Set;
import java.util.HashSet;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;
    @Override
    public Users registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        Users user = new Users();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER")); // Create Role object and add it to the set
        user.setRoles(roles); // Set the roles to the user


        return repository.save(user);
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}
