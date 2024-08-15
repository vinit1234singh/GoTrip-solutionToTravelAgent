package com.intellect.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.crm.models.UserTourPackage;
import com.intellect.crm.repo.UserPackageRepo;

@RestController
@RequestMapping("/user_package")
@CrossOrigin("http://localhost:4200")
public class UserTourPackageController {
	@Autowired
	UserPackageRepo userPackageRepo;
	@GetMapping("/{userId}")
	public List<UserTourPackage> getUserTourPackages(@PathVariable long userId){
		List<UserTourPackage> userTourPackages = userPackageRepo.findAllByUserId(userId);
		return userTourPackages;
	}
	@PostMapping
	public UserTourPackage setUserTourPackage(@RequestBody UserTourPackage userTourPackage) {
		UserTourPackage userTourPackage2 = userPackageRepo.save(userTourPackage);
		return userTourPackage2;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserPackage(@PathVariable int id){
		userPackageRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
}
