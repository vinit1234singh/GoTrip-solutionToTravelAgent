package com.intellect.crm.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Data Transfer Object (DTO) for Ticket entities.
 * 
 * @author renisha and yash
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class TicketDTO {

    /**
     * Unique identifier for the Ticket entity.
     */
    private Long id;

    /**
     * Subject of the Ticket.
     */
    private String subject;

    /**
     * Detailed description of the Ticket.
     */
    private String description;

    /**
     * Date when the Ticket was created.
     */
    private Date createdDate;

    /**
     * Current status of the Ticket.
     */
    private String status;

    /**
     * ID of the sender who created the Ticket.
     */
    private Long senderId;

    /**
     * ID of the receiver who is assigned to the Ticket.
     */
    private Long recieverId;
}
