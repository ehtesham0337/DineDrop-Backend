package com.example.dinedrop.Service;


import com.example.dinedrop.Error.UserAlreadyExistException;

import com.example.dinedrop.Model.User;
import com.example.dinedrop.Repository.UserRepository;
import com.example.dinedrop.dto.UserDto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        User user = new User();

        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        //user.setRoles(Arrays.asList("ROLE_USER"));

        return repository.save(user);
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}