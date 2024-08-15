package com.intellect.crm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.crm.dto.AdminDto;
import com.intellect.crm.models.Admin;
import com.intellect.crm.service.AdminServiceImplementation;

/**
 * AdminController is a RESTful controller that handles CRUD operations for Admin entities.
 * 
 * @author Vinit
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

    /**
     * Autowired instance of AdminServiceImplementation, which provides the business logic for Admin operations.
     */
    @Autowired
    private AdminServiceImplementation adminServiceImpl;

    /**
     * Creates a new Admin entity based on the provided AdminDto.
     * 
     * @param adminDto the AdminDto object containing the data to be saved
     * @return a ResponseEntity containing the created AdminDto, with a HTTP status of 200 (OK)
     */
    @PostMapping("/create")
    public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto adminDto) {
        AdminDto adminDto2 = adminServiceImpl.createAdmin(adminDto);
        return ResponseEntity.ok(adminDto2);
    }

    /**
     * Updates an existing Admin entity based on the provided AdminDto.
     * 
     * @param adminDto the AdminDto object containing the updated data
     * @return a ResponseEntity containing the updated AdminDto, with a HTTP status of 200 (OK)
     */
    @PutMapping("/update")
    public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto) {
        AdminDto adminDto2 = adminServiceImpl.upadateAdmin(adminDto);
        return ResponseEntity.ok(adminDto2);
    }

    /**
     * Retrieves a list of all Admin entities.
     * 
     * @return a ResponseEntity containing a list of AdminDto objects, with a HTTP status of 200 (OK)
     */
    @GetMapping()
    public ResponseEntity<List<AdminDto>> getallAdmin(){
        return ResponseEntity.ok(adminServiceImpl.getAllDataAdmin());
    }

    /**
     * Retrieves an Admin entity by email.
     * 
     * @param email the email address of the Admin to be retrieved
     * @return a ResponseEntity containing the Admin entity, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @GetMapping("/{email}")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        Admin admin = adminServiceImpl.getAdminByEmail(email);
        if(admin == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(admin,HttpStatus.OK);
    }
}