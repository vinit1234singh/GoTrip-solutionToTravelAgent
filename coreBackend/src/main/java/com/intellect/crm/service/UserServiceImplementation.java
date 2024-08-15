package com.intellect.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.crm.mapper.UserMapper;
import com.intellect.crm.dto.UserDto;
import com.intellect.crm.exception.UserNotFoundException;
import com.intellect.crm.models.Users;
import com.intellect.crm.repo.UserRepository;
import com.intellect.crm.service.inter.UserService;

/**
 * Implementation of the UserService interface, providing CRUD operations for users.
 */
@Service
public class UserServiceImplementation implements UserService {

    /**
     * Autowired instance of the UserRepository, used for database operations.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of all users from the database.
     * 
     * @return a list of UserDto objects, representing all users in the database.
     */
    @Override
    public List<UserDto> getAllUser() {
        List<Users> users = userRepository.findAll();
        return UserMapper.modelListToDtoList(users);
    }

    /**
     * Creates a new user in the database.
     * 
     * @param userDto the UserDto object to be created.
     * @return the created UserDto object.
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        Users users = UserMapper.dtoToModel(userDto);
        return UserMapper.modelToDto(userRepository.save(users));
    }
    @Override
    public UserDto userLogin(long id,String userName,String password){
        Users users = userRepository.findByUserName(userName);
        if(users==null){
            return null;
        }
        if(password.equals(users.getPassword())){
            return UserMapper.modelToDto(users);
        }
        return null;
    }
    /**
     * Retrieves a user by their ID from the database.
     * 
     * @param userId the ID of the user to be retrieved.
     * @return the UserDto object representing the user, or null if not found.
     */
    @Override
    public UserDto getUserById(long userId) {
        Users optional = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("The user not found"));
        return UserMapper.modelToDto(optional);
    }

    /**
     * Deletes a user by their ID from the database.
     * 
     * @param userId the ID of the user to be deleted.
     */
    @Override
    public UserDto deleteUserById(long userId) {
        Optional<Users> user = Optional.of(userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("The user is not found")));
        userRepository.deleteById(userId);
        return UserMapper.modelToDto(user.get());
    }

    /**
     * Updates an existing user in the database.
     * 
     * @param userDto the UserDto object with updated values.
     * @return the updated UserDto object, or null if not found.
     */
    @Override
    public UserDto updateUserById(UserDto userDto) {
        long userId = userDto.getUserId();
        Users user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("The Specified user not found"));
        if (userDto.getUserName() != null) {
            user.setUserName(userDto.getUserName());
        }
        if (userDto.getAge() != 0) {
            user.setAge(userDto.getAge());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getOccupation() != null) {
            user.setOccupation(userDto.getOccupation());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getMobileNo() != null) {
            user.setMobileNo(userDto.getMobileNo());
        }
        userRepository.save(user);
        return UserMapper.modelToDto(user);
    }
    
    
    
}