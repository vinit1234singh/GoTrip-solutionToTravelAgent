package com.intellect.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellect.crm.models.UserTourPackage;

public interface UserPackageRepo extends JpaRepository<UserTourPackage, Integer>{
	List<UserTourPackage> findAllByUserId(long userId);
}
