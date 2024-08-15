package com.intellect.crm;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intellect.crm.dto.LeadDTO;
import com.intellect.crm.mapper.LeadMapper;
import com.intellect.crm.models.Lead;
import com.intellect.crm.models.Ticket;
import com.intellect.crm.service.LeadServiceImplementation;

 class TicketTest {

    @Test
     void testGetSetId() {
        // Given
        Ticket ticket = new Ticket();
        Long id = 1L;

        // When
        ticket.setId(id);

        // Then
        assertEquals(id, ticket.getId());
    }

    @Test
     void testGetSetSubject() {
        // Given
        Ticket ticket = new Ticket();
        String subject = "Test Subject";

        // When
        ticket.setSubject(subject);

        // Then
        assertEquals(subject, ticket.getSubject());
    }

    @Test
     void testGetSetDescription() {
        // Given
        Ticket ticket = new Ticket();
        String description = "Test Description";

        // When
        ticket.setDescription(description);

        // Then
        assertEquals(description, ticket.getDescription());
    }

    @Test
     void testGetSetCreatedDate() {
        // Given
        Ticket ticket = new Ticket();
        Date createdDate = new Date(System.currentTimeMillis());

        // When
        ticket.setCreatedDate(createdDate);

        // Then
        assertEquals(createdDate, ticket.getCreatedDate());
    }

    @Test
     void testGetSetStatus() {
        // Given
        Ticket ticket = new Ticket();
        String status = "OPEN";

        // When
        ticket.setStatus(status);

        // Then
        assertEquals(status, ticket.getStatus());
    }

    @Test
     void testGetSetSenderId() {
        // Given
        Ticket ticket = new Ticket();
        Long senderId = 1L;

        // When
        ticket.setSenderId(senderId);

        // Then
        assertEquals(senderId, ticket.getSenderId());
    }

    @Test
     void testGetSetRecieverId() {
        // Given
        Ticket ticket = new Ticket();
        Long recieverId = 2L;

        // When
        ticket.setRecieverId(recieverId);

        // Then
        assertEquals(recieverId, ticket.getRecieverId());
    }
    @Autowired
    LeadServiceImplementation leadService;
    Lead lead1 = new Lead(1,2,3);
    LeadDTO leadDto = new LeadDTO(1,2,3);
    @Test
    void leadMapper(){
        Lead lead = LeadMapper.dtoToModel(leadDto);
        LeadDTO leadDTO1 = LeadMapper.modelToDto(lead1);
        assertEquals(leadDto.getLeadId(), lead.getLeadId());
        assertEquals(leadDTO1.getLeadId(), lead.getLeadId());
    }
   
}