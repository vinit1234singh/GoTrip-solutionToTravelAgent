package com.intellect.crm.service.inter;

import com.intellect.crm.dto.LeadDTO;

public interface LeadService {
    LeadDTO setLeadByUserId(long userId);
    LeadDTO saveLeadForUser(LeadDTO lead);
    LeadDTO getLeadByUser(long userId);
}
