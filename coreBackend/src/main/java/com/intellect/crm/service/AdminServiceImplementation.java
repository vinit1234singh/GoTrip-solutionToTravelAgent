package com.intellect.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.crm.dto.AdminDto;
import com.intellect.crm.exception.AdminNotFoundException;
import com.intellect.crm.mapper.AdminMapper;
import com.intellect.crm.models.Admin;
import com.intellect.crm.repo.AdminRepository;
import com.intellect.crm.service.inter.AdminService;

/**
 * Implementation of the {@link AdminService} interface.
 * 
 * @author vinit
 */
@Service
public class AdminServiceImplementation implements AdminService {
    
    /**
     * Autowired instance of the {@link AdminRepository} interface.
     */
    @Autowired
    private AdminRepository adminRepo;

    /**
     * Retrieve an admin by their email address.
     * 
     * @param email the email address to search for
     * @return the admin with the given email address, or null if not found
     */
    public Admin getAdminByEmail(String email) {
        Optional<Admin> optionalAdmin = adminRepo.findByEmail(email);
        if (optionalAdmin.isPresent()) {
            return optionalAdmin.get();
        }
        return null;
    }

    /**
     * Create a new admin.
     * 
     * @param adminDto the admin data to create
     * @return the created admin
     */
    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = AdminMapper.dtoToModel(adminDto);
        return AdminMapper.modelToDto(adminRepo.save(admin));
    }

    /**
     * Update an existing admin.
     * 
     * @param adminDto the updated admin data
     * @return the updated admin
     * @throws AdminNotFoundException if the admin is not found
     */
    @Override
    public AdminDto upadateAdmin(AdminDto adminDto) {
        Integer adminId = adminDto.getId();
        Admin admin = adminRepo.findById(adminId).orElseThrow(() -> new AdminNotFoundException("The Specified admin not found"));
        if (adminDto.getFirstName() != null) {
            admin.setFirstName(adminDto.getFirstName());
        }
        if (adminDto.getLastName() != null) {
            admin.setLastName(adminDto.getLastName());
        }
        if (adminDto.getEmail() != null) {
            admin.setEmail(adminDto.getEmail());
        }
        if (adminDto.getPassword() != null) {
            admin.setPassword(adminDto.getPassword());
        }
        if (adminDto.getPhoneNumber() != 0) {
            admin.setPhoneNumber(adminDto.getPhoneNumber());
        }
        adminRepo.save(admin);
        return AdminMapper.modelToDto(admin);
    }

    /**
     * Retrieve a list of all admins.
     * 
     * @return a list of all admins
     */
    @Override
    public List<AdminDto> getAllDataAdmin() {
        List<Admin> admin = adminRepo.findAll();
        return AdminMapper.modelListToDtoList(admin);
    }
}