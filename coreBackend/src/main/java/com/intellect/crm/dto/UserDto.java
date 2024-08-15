package com.intellect.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for User entities.
 * 
 * @author theerej
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    /**
     * Unique identifier for the User entity.
     */
    private long userId;

    /**
     * Username chosen by the User.
     */
    private String userName;

    /**
     * Age of the User.
     */
    private int age;

    /**
     * Residential address of the User.
     */
    private String address;

    /**
     * Email address of the User.
     */
    private String email;

    /**
     * Mobile phone number of the User.
     */
    private Long mobileNo;

    /**
     * Password chosen by the User for authentication.
     */
    private String password;

    /**
     * Occupation or profession of the User.
     */
    private String occupation;
}