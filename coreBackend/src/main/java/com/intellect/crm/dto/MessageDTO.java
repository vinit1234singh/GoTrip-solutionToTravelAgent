package com.intellect.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Data Transfer Object (DTO) for Message entities.
 * 
 * @author vishal and tanmay
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDTO {

    /**
     * Unique identifier for the Message entity.
     */
    private Long id;

    /**
     * ID of the Admin associated with the Message.
     */
    private Long adminId;

    /**
     * ID of the Customer associated with the Message.
     */
    private Long customerId;

    /**
     * Date when the issue was raised.
     */
    private String issueDate;

    /**
     * Current status of the Message.
     */
    private String status;

    /**
     * Priority level of the Message.
     */
    private String priority;

    /**
     * Actual message content.
     */
    private String message;
}
