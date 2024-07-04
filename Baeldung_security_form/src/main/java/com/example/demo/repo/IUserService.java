package com.example.demo.repo;
import com.example.demo.model.Users;
import com.example.demo.Dto.UserDto;
public interface IUserService {
    Users registerNewUserAccount(UserDto userDto);
}
