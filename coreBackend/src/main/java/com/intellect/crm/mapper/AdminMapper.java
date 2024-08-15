package com.intellect.crm.mapper;

import java.util.ArrayList;
import java.util.List;

import com.intellect.crm.dto.AdminDto;
import com.intellect.crm.models.Admin;

/**
 * Utility class for mapping between Admin entities and their corresponding Data Transfer Objects (DTOs).
 * 
 * @author vinit
 */
public class AdminMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private AdminMapper(){}

    /**
     * Maps an Admin DTO to an Admin model entity.
     * 
     * @param adminDto the Admin DTO to be mapped
     * @return the corresponding Admin model entity
     */
    public static Admin dtoToModel(AdminDto adminDto){
        return new Admin(adminDto.getId(), adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getPassword(), adminDto.getPhoneNumber());
    }

    /**
     * Maps an Admin model entity to an Admin DTO.
     * 
     * @param admin the Admin model entity to be mapped
     * @return the corresponding Admin DTO
     */
    public static AdminDto modelToDto(Admin admin){
        return new AdminDto(admin.getId(), admin.getFirstName(), admin.getLastName(), admin.getEmail(), admin.getPassword(), admin.getPhoneNumber());
    }

    /**
     * Maps a list of Admin model entities to a list of Admin DTOs.
     * 
     * @param adminDtoList the list of Admin model entities to be mapped
     * @return the corresponding list of Admin DTOs
     */
    public static List<AdminDto> modelListToDtoList(List<Admin> adminDtoList){
        List<AdminDto> list = new ArrayList<>();
        for(Admin adminDto: adminDtoList){
            list.add(modelToDto(adminDto));
        }
        return list;
    }
}