package com.intellect.crm;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellect.crm.dto.AdminDto;
import com.intellect.crm.dto.LeadDTO;
import com.intellect.crm.dto.MessageDTO;
import com.intellect.crm.dto.TicketDTO;
import com.intellect.crm.dto.UserDto;
import com.intellect.crm.exception.AdminNotFoundException;
import com.intellect.crm.exception.UserNotFoundException;
import com.intellect.crm.models.Lead;
import com.intellect.crm.repo.LeadRepo;
import com.intellect.crm.service.AdminServiceImplementation;
import com.intellect.crm.service.UserServiceImplementation;
import com.intellect.crm.service.inter.AdminService;
import com.intellect.crm.service.inter.LeadService;
import com.intellect.crm.service.inter.MessageService;
import com.intellect.crm.service.inter.TicketService;

@SpringBootTest
@AutoConfigureMockMvc	
class CrmApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

//------------------------------------------------------------------------------------------------------------------------------

	@Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepo leadRepo;


    // @Test
    void testGetLeadByUserIdSuccess() throws Exception {
        long userId = 1L;
        Lead expectedLead = new Lead(34,890,0);
		expectedLead.setUserId(userId);
		leadRepo.deleteAll();
        leadRepo.save( new Lead(34,890,0));
        LeadDTO actualLeadDto = leadService.getLeadByUser(userId);

        // Assert that the returned LeadDTO matches the expected lead
        assertEquals(expectedLead.getUserId(), actualLeadDto.getUserId());
		leadRepo.delete(expectedLead);
        // You can add further assertions based on your LeadDTO properties
    }


	// @Test
	// void testGetLeadByUserIdNotFound() throws Exception {
	// 	long userId = 999L; // Assuming no lead with this userId exists

	// 	assertThrows(Exception.class, () -> leadService.getLeadByUser(userId));

	// 	// You can also use a more specific exception like a custom "LeadNotFoundException" if defined
	// }


// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	

	@ParameterizedTest
	@MethodSource("provideTestData")
	void testLoginUserWithVariousData(String userName, String password, int expectedStatus) throws Exception {
		UserDto userDto = new UserDto(0, userName, 0, null, null, null, password, null);
		final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user/login")
				.content(objectMapper.writeValueAsString(userDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(builder)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(expectedStatus));
	}

	private static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of("null", "null", 200),
            Arguments.of("Theere", "theerej", 200),
            Arguments.of("abbdd", "theeej", 200),
            Arguments.of("abbdd", "teerej", 200)
        );
    }

	

	






// ---------------------------------------------------------------------------------------------------------------------------
@Autowired	
TicketService ticketService;
	
@Test
	void testGetTicketsByUserIdNoTickets() throws Exception {
		long userId = 999L; // Assuming no tickets for this user

		List<TicketDTO> tickets = ticketService.getTicketsByUserId(userId);

			// Assert that an empty list is returned
		assertEquals(0, tickets.size());
	}

@Test
     void testLeadDTO() {
        long leadId = 1L;
        long userId = 2L;
        long numberOfPackages = 3L;

        LeadDTO leadDto = new LeadDTO(leadId, userId, numberOfPackages);

        assertEquals(leadId, leadDto.getLeadId());
        assertEquals(userId, leadDto.getUserId());
        assertEquals(numberOfPackages, leadDto.getNumberOfPackages());
    }








@Test
    void testCreateAdmin() throws Exception {
        AdminDto adminDto = new AdminDto(2, "bello", "pota", "admin"+Math.random()+"@example.com","morning",1234567L);
        // when(adminService.createAdmin(adminDto)).thenReturn(adminDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


	@Test
    void testGetAllAdmins() throws Exception {
        // List<AdminDto> admins = new ArrayList<>();
        // admins.add(new AdminDto(1L, "admin1", "password123", "admin1@example.com"));
        // admins.add(new AdminDto(2L, "admin2", "password456", "admin2@example.com"));

        // when(adminService.getAllDataAdmin()).thenReturn(admins);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").isArray());
                // .andExpect(jsonPath("$[0].email").value("admin1@example.com"))
                // .andExpect(jsonPath("$[1].email").value("admin2@example.com"));
    }

	@Test
    void nottestGetAllAdmins() throws Exception {
        // List<AdminDto> admins = new ArrayList<>();
        // admins.add(new AdminDto(1L, "admin1", "password123", "admin1@example.com"));
        // admins.add(new AdminDto(2L, "admin2", "password456", "admin2@example.com"));

        // when(adminService.getAllDataAdmin()).thenReturn(admins);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
                // .andExpect(jsonPath("$[0].email").value("admin1@example.com"))
                // .andExpect(jsonPath("$[1].email").value("admin2@example.com"));
    }

	@Test
      void testGetAdminByEmail() throws Exception {
        String email = "theerej@gmail.comasdf";
        AdminDto adminDto = new AdminDto();
        adminDto.setEmail(email+Math.random());
        AdminDto admin = adminService.createAdmin(adminDto);
        // when(adminService.getAdminByEmail(email)).thenReturn(adminDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/{email}", admin.getEmail()))
                .andExpect(MockMvcResultMatchers.status().isOk());
                
    }

	@Test
      void nottestGetAdminByEmail() throws Exception {
        String email = "vinit.singh@inte.com";
        // AdminDto adminDto = new AdminDto(1L, "admin1", "password123", email);

        // when(adminService.getAdminByEmail(email)).thenReturn(adminDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/{email}", email))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
                
    }

	@Autowired
	AdminServiceImplementation adminServiceImplementation;

	@Test
     void testUpdateAdmin() throws Exception {
        AdminDto adminDto = new AdminDto(1, "belo", "goaa", "admin0.4935236816759063@example.com","morning",1234567L);
        adminService.createAdmin(adminDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/admin/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

	@Autowired
    private AdminService adminService;

	@Test
     void testUpdateAdminNotFound() throws Exception {
        AdminDto adminDto = new AdminDto(); // Any data can be provided here
		adminDto.setId(12345676);
        assertThrows(AdminNotFoundException.class, () -> adminService.upadateAdmin(adminDto));
    }

	@Test
     void nulltestUpdateAdmin() throws Exception {
        AdminDto adminDto = new AdminDto(1, "belo", "goaa", "admin0.4935236816759063@example.com","morning",1234567L);
       

        mockMvc.perform(MockMvcRequestBuilders.put("/admin/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


	@Test
     void nullemailandphonetestUpdateAdmin() throws Exception {
        AdminDto adminDto = new AdminDto();
		adminDto.setEmail("bello"+Math.random());
		adminDto.setPhoneNumber(0L);
    adminService.createAdmin(adminDto);
    int l = adminService.getAllDataAdmin().get(0).getId();
    adminDto.setId(l);
    adminDto.setEmail(null);

        mockMvc.perform(MockMvcRequestBuilders.put("/admin/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }





// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Test
      void testCreateTicket() throws Exception {
        TicketDTO ticketDto = new TicketDTO(1L, "Test Subject", "Test Description", new Date(22), "OPEN", 1L, 2L);
        
		//when(ticketService.createTicket(ticketDto)).thenReturn(ticketDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/tickets/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ticketDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


	@Test
      void testGetTicketsByUserId() throws Exception {
        List<TicketDTO> tickets = new ArrayList<>();
        tickets.add(new TicketDTO(1L, "Test Subject", "Test Description", new Date(2022-03-12), "OPEN", 1L, 2L));
        mockMvc.perform(MockMvcRequestBuilders.get("/tickets/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


	@Test
  void testGetAllTicketsYash() throws Exception {
    
    mockMvc.perform(MockMvcRequestBuilders.get("/tickets/all"))
            .andExpect(MockMvcResultMatchers.status().isOk());
		
}

@Test
  void testGetTicketsBySenderId() throws Exception {
    Long senderId = 1L;
    
    mockMvc.perform(MockMvcRequestBuilders.get("/tickets/user/{senderId}", senderId))
            .andExpect(MockMvcResultMatchers.status().isOk());
          
}

@Test
  void notFoundtestGetTicketsBySenderId() throws Exception {
    Long senderId = 1234567890L;
    mockMvc.perform(MockMvcRequestBuilders.get("/tickets/user/{senderId}", senderId))
            .andExpect(MockMvcResultMatchers.status().isOk());
          
}

@Test
  void testGetTicketsByRecieverId() throws Exception {
    Long receiverId = 2L;
    
    mockMvc.perform(MockMvcRequestBuilders.get("/tickets/recieve/{recieverId}", receiverId))
            .andExpect(MockMvcResultMatchers.status().isOk());
}





@Test
  void testGetTicketsByReceiverId() throws Exception {
    Long recieverId = 24536784392L;
    
    mockMvc.perform(MockMvcRequestBuilders.get("/tickets/recieve/{recieverId}", recieverId))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
          
}

@Test
     void testUpdateTicketStatusSuccess() throws Exception {
        Long ticketId= 161L;
        String newStatus = "Done";
		
        mockMvc.perform(MockMvcRequestBuilders.get("/tickets/update/{ticketId}/{status}", ticketId, newStatus)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

	@Test
     void nottestUpdateTicketStatusSuccess() throws Exception {
        Long ticketId= 15671L;
        String newStatus = "Done";
		
        mockMvc.perform(MockMvcRequestBuilders.get("/tickets/update/{ticketId}/{status}", ticketId, newStatus)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

	@Test
     void gottestGetTicketsByUserId() throws Exception {
        Long userId = 1L;
       
        mockMvc.perform(MockMvcRequestBuilders.get("/tickets/user/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


// ---------------------------------------------------------------------------------------------------------------------------------------
	



	
// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@Autowired
UserServiceImplementation userServiceImplementation;


@Test
 void testUpdateUserfound() throws Exception {
  UserDto userDto = new UserDto();
  userDto.setUserName("rttfug"+Math.random());
  
	
	UserDto upD = userService.createUser(userDto);
	upD.setAge(97);
    

    mockMvc.perform(MockMvcRequestBuilders.put("/user/update/{id}",upD.getUserId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(upD)))
        .andExpect(status().isOk());
}


@Test
 void testUpdateUserNotFound() throws Exception {
    Long userId = 3456789L;
    UserDto userDto = new UserDto(3456789L,"John Doe",60,"tvwud ", "doe@example.com",45678765456L, "password","Hunter");
    mockMvc.perform(MockMvcRequestBuilders.put("/user/update/{id}", userId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userDto)))
        .andExpect(status().isNotFound());
}


@Test
 void testDeleteUser() throws Exception {
  UserDto userDto = new UserDto();
  userDto.setUserName("rttfug"+Math.random());
  UserDto user =  userService.createUser(userDto);
	
    mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", user.getUserId()))
        .andExpect(status().isOk());
}

@Test
 void testDeleteUsernotFound() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", 7897L))
        .andExpect(status().isNotFound());
}

// @Test
//  void testRegisterUserSuccess() throws Exception {
//     UserDto userDto = new UserDto(1L,"John"+Math.random()+" Doe",60,"tyggdvwud ", "johndoe@example.com",45678765456L, "password","Hunter");

//     mockMvc.perform(MockMvcRequestBuilders.post("/user")
//             .contentType(MediaType.APPLICATION_JSON)
//             .content(objectMapper.writeValueAsString(userDto)))
//         .andExpect(MockMvcResultMatchers.status().isOk());
// }

@Autowired
    private UserServiceImplementation userService;

   
    // @Test
    // void testGetUserByIdSuccess() {
    //     long userId = 1L;
    //     Users user = new Users();

    //     user.setUserId(userId);
    //     userRepository.save(user);

    //     UserDto result = userService.getUserById(userId);

    //     assertEquals(user.getUserId(), result.getUserId());
    // }

    @Test
    void testGetUserByIdNotFound() {
        long userId = 999L; // Assuming no user with this ID exists

        assertThrows(UserNotFoundException.class, () -> userService.getUserById(userId));
    }

	// @Test
    //   void testRegisterUser() throws Exception {
    //     UserDto userDto = new UserDto(0, "abbdd", 0, null, null, null, "teerej", null);
    //     final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user")
	// 	.content(objectMapper.writeValueAsString(userDto))
	// 	.contentType(MediaType.APPLICATION_JSON)
	// 	.accept(MediaType.APPLICATION_JSON);

	
	// 	mockMvc.perform(builder)
	// 	.andDo(MockMvcResultHandlers.print())
	// 	.andExpect(MockMvcResultMatchers.status().isOk());
		
    // }

	@Test
      void testGetAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray()); // Assuming a list of users is returned
    }

	

	// @Test
    //   void testUpdateUser() throws Exception {
    //     // Assuming a user with id 21 exists
    //     UserDto updatedUser = new UserDto(3, "updatedName", 0, null, null, null, "updatedName", null);
    //     mockMvc.perform(MockMvcRequestBuilders.put("/user/update/3")
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .content(objectMapper.writeValueAsString(updatedUser)))
    //         .andExpect(MockMvcResultMatchers.status().isNotFound());
    // }

	
	// @Test
    //   void testDeleteUser() throws Exception {
	// 	// Assuming a user with id 1 exists
    //     mockMvc.perform(MockMvcRequestBuilders.delete("/user/61"))
	// 	.andExpect(MockMvcResultMatchers.status().isNotFound());
    // }
	
	
	// @Test
	//   void testUpdateUser1() throws Exception {
	// 	// Assuming a user with id 21 exists
	// 	UserDto updatedUser = new UserDto(125, "Theerej", 0, null, "45678", null, "1234567890", null);
	// 	mockMvc.perform(MockMvcRequestBuilders.put("/user/update/121")
	// 	.contentType(MediaType.APPLICATION_JSON)
	// 	.content(objectMapper.writeValueAsString(updatedUser)))
	// 	.andExpect(MockMvcResultMatchers.status().isOk());
	// }
	
	// @Test
	//   void testDeleteUser1() throws Exception {
	// 	// Assuming a user with id 1 exists
	// 	mockMvc.perform(MockMvcRequestBuilders.delete("/user/124"))
	// 	.andExpect(MockMvcResultMatchers.status().isOk());
	// }


	// MessageController tests
	
    // Mock data
    private MessageDTO messageDto;

    // ... other test methods

    @Test
      void testAddTicketControl() throws Exception {
		messageDto = new MessageDTO(1L, 1L,1L, "2023-11-11", "Open", "High", "Test Message");
		final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/messages")
		.content(objectMapper.writeValueAsString(messageDto))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder)
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
      void testGetAllTicketsControl() throws Exception {
        List<MessageDTO> messages = new ArrayList<>();
       
		final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/messages")
		.content(objectMapper.writeValueAsString(messages))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder)
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
    }

	

	// @Test
	//   void testDeleteTicket() throws Exception {
	// 	Long id = 25L; // Replace with a valid ticket ID

	// 	mockMvc.perform(MockMvcRequestBuilders.delete("/api/messages/delete/{id}", id))
	// 		.andExpect(MockMvcResultMatchers.status().isOk());
	// }

	@Test
	  void testDeleteTicket_NotFound() throws Exception {
		Long id = 999L; // Replace with a non-existent ticket ID

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/messages/delete/{id}", id))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}


	@Test
     void testDeleteTicket() throws Exception {
        List<MessageDTO> delete = messageService.getAllTickets(); 
		messageService.addTicket(delete.get(delete.size()-1));
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/messages/delete/{id}", delete.get(delete.size()-1).getId()))
                .andExpect(status().isOk());
				
    }
	


	@Test
	  void testDeleteTicket_MethodNotAllowed() throws Exception {
		Long id = 56789L; // Replace with a valid ticket ID

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/messages/delete/{id}", id))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}


	@Test
	  void testGetMessagesBycustId() throws Exception {
      MessageDTO messageDTO = new MessageDTO();
        messageDTO.setStatus("Hello");
        messageDTO.setCustomerId(23L);
        Long i = messageService.addTicket(messageDTO).getCustomerId();
    
		mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/cust/{custId}", i))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	@Test
	  void nottestGetMessagesBycustId() throws Exception {
		Long custId = 45678L;

		mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/cust/{custId}", custId))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}







	@Test
      void testGetTicketsById() throws Exception {
        
        Long i = messageService.getAllTickets().get(0).getId();


        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/"+i))
              .andExpect(MockMvcResultMatchers.status().isOk());
              
    }

    @Test
      void testGetTicketById_NotFound() throws Exception {
        Long id = 999L; // Replace with a non-existent ticket ID

        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/{id}", id))
              .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

	@Test
     void testUpdateTicketNotFound() throws Exception {
        Long id = 567890L;
        MessageDTO updatedTicket = new MessageDTO(id, id, id, null, null, null, null);
        // when(messageService.updateTicket(id, updatedTicket)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/messages/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedTicket)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }




	// --------------------------------------------------------------------------------------------------------------------





	@Autowired
        MessageService messageService;


	@Test
      void testAddTicket() {
        MessageDTO ticketDTO = new MessageDTO();
		ticketDTO.setMessage(""+Math.random());
        ticketDTO = messageService.addTicket(ticketDTO);
        assertNotNull(ticketDTO);
    }

	@Test
      void testGetAllTickets() {
        List<MessageDTO> tickets = messageService.getAllTickets();
        assertNotNull(tickets);
    }

	@Test
      void testGetTicketById() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(3L);
        messageDTO.setStatus("Hello");
        messageDTO.setMessage("styghhgft");
        MessageDTO msd = messageService.addTicket(messageDTO);
        Long i = msd.getId();
        MessageDTO messsage = messageService.getAllTickets().get(0);
        messsage.setMessage("Updated message");
        MessageDTO ticket = messageService.getTicketById(messsage.getId());
        assertNotNull(ticket);
    }

	@Test
      void testUpdateTicket() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(3L);
        messageDTO.setStatus("Hello");
        messageDTO.setMessage("styghhgft");
        MessageDTO msd = messageService.addTicket(messageDTO);
        MessageDTO messsage = messageService.getAllTickets().get(0);
        messsage.setMessage("Updated message");
        MessageDTO updatedTicket = messageService.updateTicket(messsage.getId(), messsage);
        assertNotNull(updatedTicket);
    }

	// @Test
    //   void testDeleteTicket() {
    //     Long ticketId = 1L; // Replace with a valid ticket ID
    //     messageService.deleteTicket(ticketId);
    //     MessageDTO deletedTicket = messageService.getTicketById(ticketId);
    //     assertNull(deletedTicket);
    // }


		@Test
		  void testServiceUpdateTicket() throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(3L);
        messageDTO.setStatus("Hello");
        messageDTO.setMessage("styghhgft");
        MessageDTO msd = messageService.addTicket(messageDTO);
        MessageDTO i = messageService.getAllTickets().get(0);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/messages/update/{id}", i.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(i)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				;
		}

		@Test
		  void testUpdateTicket_NotFound() throws Exception {
		Long id = 999L; // Replace with a non-existent ticket ID
		MessageDTO ticketDTO = new MessageDTO(); // Create a valid MessageDTO object
        String status = "Ok";
		mockMvc.perform(MockMvcRequestBuilders.put("/api/messages/update/{id}/{status}", id,status)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(ticketDTO)))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
		}

		@Test
		  void testUpdateTicket_MethodNotAllowed() throws Exception {
		Long id = 1L; // Replace with a valid ticket ID
		MessageDTO ticketDTO = new MessageDTO(); // Create a valid MessageDTO object

		mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/update/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(ticketDTO)))
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
		}

		@Test
		  void nottestGetMessageByReceiverId() throws Exception {
			Long custId = 24536784392L;
			// List<TicketDTO> tickets = new ArrayList<>();
			// tickets.add(new TicketDTO(1L, senderId, "Subject", "Description", "2023-11-11", "Open", "High"));
			// tickets.add(new TicketDTO(2L, senderId, "Subject2", "Description2", "2023-11-12", "In Progress", "Medium"));

			// when(ticketService.getBySenderId(senderId)).thenReturn(tickets);

			mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/cust/{custId}", custId))
					.andExpect(MockMvcResultMatchers.status().isNotFound());
				
		}

		@Test
		  void testGetMessageByReceiverId() throws Exception {
			Long custId = 1L;
			// List<TicketDTO> tickets = new ArrayList<>();
			// tickets.add(new TicketDTO(1L, senderId, "Subject", "Description", "2023-11-11", "Open", "High"));
			// tickets.add(new TicketDTO(2L, senderId, "Subject2", "Description2", "2023-11-12", "In Progress", "Medium"));

			// when(ticketService.getBySenderId(senderId)).thenReturn(tickets);

			mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/cust/{custId}", custId))
					.andExpect(MockMvcResultMatchers.status().isOk());
				
		}


		@Test
		  void nottestGetMessageByadminId() throws Exception {
			Long adminId = 24536784392L;
			// List<TicketDTO> tickets = new ArrayList<>();
			// tickets.add(new TicketDTO(1L, senderId, "Subject", "Description", "2023-11-11", "Open", "High"));
			// tickets.add(new TicketDTO(2L, senderId, "Subject2", "Description2", "2023-11-12", "In Progress", "Medium"));

			// when(ticketService.getBySenderId(senderId)).thenReturn(tickets);

			mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/admin/{adminId}", adminId))
					.andExpect(MockMvcResultMatchers.status().isNotFound());
				
		}

		@Test
		  void testGetMessageByadminId() throws Exception {
        MessageDTO messageDTO = new MessageDTO();
        // ticketDTO.setId(id);
        messageDTO.setStatus("Hello");
        messageDTO.setMessage("styghhgft");
        messageDTO.setAdminId(1L);
        Long i = messageService.addTicket(messageDTO).getAdminId();


        // Long adminId = messageService.getAllTickets().get(0).getAdminId();
			
			mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/admin/{adminId}", i))
					.andExpect(MockMvcResultMatchers.status().isOk());
				
		}


		// ------------------------------------------------------getMessagesByAdmin---------------------------------------------------------
	@Test
      void testGetLeadId() {
        // Given
        Lead lead = new Lead();
        lead.setLeadId(1L);

        // When
        long leadId = lead.getLeadId();

        // Then
        assertEquals(1L, leadId);
    }

    @Test
      void testGetUserId() {
        // Given
        Lead lead = new Lead();
        lead.setUserId(1L);

        // When
        long userId = lead.getUserId();

        // Then
        assertEquals(1L, userId);
    }

    @Test
      void testGetNumberOfPackages() {
        // Given
        Lead lead = new Lead();
        lead.setNumberOfPackages(5L);

        // When
        long numberOfPackages = lead.getNumberOfPackages();

        // Then
        assertEquals(5L, numberOfPackages);
    }

    @Test
      void testSetLeadId() {
        // Given
        Lead lead = new Lead();

        // When
        lead.setLeadId(1L);

        // Then
        assertEquals(1L, lead.getLeadId());
    }

    @Test
      void testSetUserId() {
        // Given
        Lead lead = new Lead();

        // When
        lead.setUserId(1L);

        // Then
        assertEquals(1L, lead.getUserId());
    }

    @Test
      void testSetNumberOfPackages() {
        // Given
        Lead lead = new Lead();

        // When
        lead.setNumberOfPackages(5L);

        // Then
        assertEquals(5L, lead.getNumberOfPackages());
    }


	// ---------------------------------------------------------------------------------------------------------------------------------------------


	

		
	

}
