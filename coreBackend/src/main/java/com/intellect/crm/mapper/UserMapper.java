package com.intellect.crm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intellect.crm.dto.UserDto;
import com.intellect.crm.models.Users;
/**
 * Utility class for mapping between User entities and their corresponding Data Transfer Objects (DTOs).
 * 
 * @author theerej
 */
@Component
public class UserMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private UserMapper(){}

    /**
     * Maps a User DTO to a User entity.
     * 
     * @param userDto the User DTO to be mapped
     * @return the corresponding User entity
     */
    public static Users dtoToModel(UserDto userDto){
        return new Users(userDto.getUserId(), userDto.getUserName(), userDto.getAge(), userDto.getAddress(), userDto.getEmail(), userDto.getMobileNo(), userDto.getPassword(), userDto.getOccupation());
    }

    /**
     * Maps a User entity to a User DTO.
     * 
     * @param users the User entity to be mapped
     * @return the corresponding User DTO
     */
    public static UserDto modelToDto(Users users){
        return new UserDto(users.getUserId(), users.getUserName(), users.getAge(), users.getAddress(), users.getEmail(), users.getMobileNo(), users.getPassword(), users.getOccupation());
    }

    /**
     * Maps a list of User entities to a list of User DTOs.
     * 
     * @param userDtoList the list of User entities to be mapped
     * @return the corresponding list of User DTOs
     */
    public static List<UserDto> modelListToDtoList(List<Users> userDtoList){
        List<UserDto> list = new ArrayList<>();
        for(Users userDto: userDtoList){
            list.add(modelToDto(userDto));
        }
        return list;
    }
}