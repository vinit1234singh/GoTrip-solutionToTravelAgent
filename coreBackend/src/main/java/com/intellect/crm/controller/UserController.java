package com.intellect.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.crm.dto.LeadDTO;
import com.intellect.crm.dto.UserDto;
import com.intellect.crm.models.Users;
import com.intellect.crm.service.inter.LeadService;
import com.intellect.crm.service.inter.UserService;



/**
 * UserController is a RESTful controller that handles CRUD operations for User entities.
 * 
 * @author [Your Name]
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

    /**
     * Autowired instance of UserServiceImplementation, which provides the business logic for User operations.
     */
    @Autowired
    private UserService userServiceImplementation;

    /**
     * Autowired instance of LeadService, which provides the business logic for Lead operations.
     */
    @Autowired
    private LeadService leadService;

    /**
     * Retrieves a list of all User entities.
     * 
     * @return a ResponseEntity containing a list of UserDto objects, with a HTTP status of 200 (OK)
     */
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceImplementation.getAllUser());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getusersbyID(@PathVariable Long userId){
    	return new ResponseEntity<>(userServiceImplementation.getUserById(userId),HttpStatus.OK);
    }

    /**
     * Creates a new User entity based on the provided UserDto.
     * 
     * @param userDto the UserDto object containing the data to be saved
     * @return a ResponseEntity containing the created UserDto, with a HTTP status of 201 (CREATED)
     */
    @PostMapping()
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        UserDto user = userServiceImplementation.createUser(userDto);
        LeadDTO lead = new LeadDTO();
        lead.setUserId(user.getUserId());
        leadService.saveLeadForUser(lead);
        return new ResponseEntity<>(user,HttpStatus.OK);
    	
    }

    /**
     * Updates an existing User entity based on the provided UserDto.
     * 
     * @param userDto the UserDto object containing the updated data
     * @return a ResponseEntity containing the updated UserDto, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateEmployee(@RequestBody UserDto userDto) {
        try{
            UserDto user = userServiceImplementation.updateUserById(userDto);
            return ResponseEntity.ok(user);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a User entity by ID.
     * 
     * @param id the ID of the User to be deleted
     * @return a ResponseEntity with a HTTP status of 200 (OK) if deleted, or 404 (NOT_FOUND) if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
        try{
            userServiceImplementation.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles user login.
     * 
     * @param entity the Users object containing the login credentials
     * @return a ResponseEntity containing the UserDto, with a HTTP status of 200 (OK)
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> postMethodName(@RequestBody Users entity) {
        UserDto  user = userServiceImplementation.userLogin(entity.getUserId(),entity.getUserName(),entity.getPassword());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    /**
     * Increments the lead number for a user.
     * 
     * @param userId the ID of the user
     * @return a ResponseEntity containing the updated LeadDTO, with a HTTP status of 200 (OK)
     */
    @GetMapping("/increment/{userId}")
    public ResponseEntity<LeadDTO> incrementLeadNumber(@PathVariable int userId) throws Exception {
        LeadDTO lead = leadService.setLeadByUserId(userId);
        return new ResponseEntity<>(lead,HttpStatus.OK);
    }

    /**
     * Retrieves the lead for a user.
     * 
     * @param userId the ID of the user
     * @return a ResponseEntity containing the LeadDTO, with a HTTP status of 200 (OK)
     */
    @GetMapping("/lead/{userId}")
    public ResponseEntity<LeadDTO> getLeadByUserId(@PathVariable int userId){
        LeadDTO lead = leadService.getLeadByUser(userId);
        return new ResponseEntity<>(lead,HttpStatus.OK);
    }
}