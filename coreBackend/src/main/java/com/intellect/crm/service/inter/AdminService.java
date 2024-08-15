package com.intellect.crm.service.inter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intellect.crm.dto.AdminDto;


@Service
public interface AdminService {
	AdminDto createAdmin(AdminDto adminDto);
	AdminDto upadateAdmin(AdminDto adminDto);
	List<AdminDto> getAllDataAdmin();

}
