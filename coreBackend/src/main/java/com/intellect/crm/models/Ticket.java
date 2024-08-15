package com.intellect.crm.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Ticket")
public class Ticket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String subject;
    
    private String description;
    
    private Date createdDate;
    
    private String status; // e.g., "OPEN", "CLOSED", "IN_PROGRESS"
    
    private Long senderId;
    private Long recieverId;
    
}
