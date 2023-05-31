package com.example.dinedrop.Service;

import com.example.dinedrop.Model.User;
import com.example.dinedrop.dto.UserDto;


public interface IUserService {
    User registerNewUserAccount(UserDto userDto);
}
