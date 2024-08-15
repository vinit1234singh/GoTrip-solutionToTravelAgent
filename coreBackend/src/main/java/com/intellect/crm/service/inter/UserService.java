package com.intellect.crm.service.inter;

import java.util.List;

import com.intellect.crm.dto.UserDto;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto createUser(UserDto user);
    UserDto getUserById(long userId);
    UserDto deleteUserById(long userId);    
    UserDto updateUserById(UserDto userDto);
    UserDto userLogin(long id,String userName,String password);
}
