package com.intellect.crm;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.intellect.crm.dto.TicketDTO;
import java.sql.Date;

import org.junit.jupiter.api.Test;

 class TicketDTOTest {

    @Test
     void testGetSetId() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        Long id = 1L;

        // When
        ticketDTO.setId(id);

        // Then
        assertEquals(id, ticketDTO.getId());
    }

    @Test
     void testGetSetSubject() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        String subject = "Test Subject";

        // When
        ticketDTO.setSubject(subject);

        // Then
        assertEquals(subject, ticketDTO.getSubject());
    }

    @Test
     void testGetSetDescription() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        String description = "Test Description";

        // When
        ticketDTO.setDescription(description);

        // Then
        assertEquals(description, ticketDTO.getDescription());
    }

    @Test
     void testGetSetCreatedDate() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        Date createdDate = new Date(System.currentTimeMillis());

        // When
        ticketDTO.setCreatedDate(createdDate);

        // Then
        assertEquals(createdDate, ticketDTO.getCreatedDate());
    }

    @Test
     void testGetSetStatus() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        String status = "Open";

        // When
        ticketDTO.setStatus(status);

        // Then
        assertEquals(status, ticketDTO.getStatus());
    }

    @Test
     void testGetSetSenderId() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        Long senderId = 1L;

        // When
        ticketDTO.setSenderId(senderId);

        // Then
        assertEquals(senderId, ticketDTO.getSenderId());
    }

    @Test
     void testGetSetRecieverId() {
        // Given
        TicketDTO ticketDTO = new TicketDTO();
        Long recieverId = 2L;

        // When
        ticketDTO.setRecieverId(recieverId);

        // Then
        assertEquals(recieverId, ticketDTO.getRecieverId());
    }

    @Test
     void testToString() {
        // Given
        TicketDTO ticketDTO = new TicketDTO(1L, "Test Subject", "Test Description", new Date(System.currentTimeMillis()), "Open", 1L, 2L);

        // When
        String toString = ticketDTO.toString();

        // Then
        assertNotNull(toString);
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("subject=Test Subject"));
        assertTrue(toString.contains("description=Test Description"));
        assertTrue(toString.contains("createdDate="));
        assertTrue(toString.contains("status=Open"));
        assertTrue(toString.contains("senderId=1"));
        assertTrue(toString.contains("recieverId=2"));
    }
}