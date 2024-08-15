package com.intellect.crm.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) for Admin entities.
 * 
 * @author Vinit
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    /**
     * Unique identifier for the Admin entity.
     */
    private Integer id;

    /**
     * First name of the Admin.
     */
    private String firstName;

    /**
     * Last name of the Admin.
     */
    private String lastName;

    /**
     * Email address of the Admin.
     */
    private String email;

    /**
     * Password for the Admin.
     */
    private String password;

    /**
     * Phone number of the Admin.
     */
    private Long phoneNumber;
}
