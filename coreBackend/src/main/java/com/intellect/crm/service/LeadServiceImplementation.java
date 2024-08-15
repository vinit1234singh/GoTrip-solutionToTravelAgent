package com.intellect.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.crm.dto.LeadDTO;
import com.intellect.crm.mapper.LeadMapper;
import com.intellect.crm.models.Lead;
import com.intellect.crm.repo.LeadRepo;
import com.intellect.crm.service.inter.LeadService;
/**
 * Implementation of the {@link LeadService} interface.
 * 
 * @author theerej
 */
@Service
public class LeadServiceImplementation implements LeadService {
    
    /**
     * Autowired instance of the {@link LeadRepo} interface.
     */
    @Autowired
    private LeadRepo leadRepo;

    /**
     * Retrieve the lead for the given user ID.
     * 
     * @param userId the user ID to search for
     * @return the lead for the given user ID, or null if not found
     */
    @Override
    public LeadDTO getLeadByUser(long userId) {
        Lead lead = leadRepo.findByUserId(userId);
        if (lead != null) {
            return LeadMapper.modelToDto(lead);
        } else {
            return null;
        }
    }

    /**
     * Increment the number of packages for the lead with the given user ID.
     * 
     * @param userId the user ID to search for
     * @return the updated lead
     * @throws Exception if the lead is not found
     */
    @Override
    public LeadDTO setLeadByUserId(long userId) {
        Lead lead = leadRepo.findByUserId(userId);
        long packages = lead.getNumberOfPackages();
        lead.setNumberOfPackages(packages + 1);
        Lead updatedLead = leadRepo.save(lead);
        return LeadMapper.modelToDto(updatedLead);
    }

    /**
     * Save a new lead for the given user.
     * 
     * @param leadDTO the lead data to save
     * @return the saved lead
     */
    @Override
    public LeadDTO saveLeadForUser(LeadDTO leadDTO) {
        Lead lead = leadRepo.save(LeadMapper.dtoToModel(leadDTO));
        return LeadMapper.modelToDto(lead);
    }
}