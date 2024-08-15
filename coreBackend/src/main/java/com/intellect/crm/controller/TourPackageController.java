package com.intellect.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.intellect.crm.models.TourPackage;
import com.intellect.crm.repo.TourPackageRepo;

@RestController
@RequestMapping("/tour")
@CrossOrigin("http://localhost:4200")
public class TourPackageController {
	@Autowired
	TourPackageRepo tourPackageRepo;
	
	@PostMapping
	public TourPackage seTourPackage(@RequestBody TourPackage tourPackage) {
		TourPackage tourPackage2Package = tourPackageRepo.save(tourPackage);
		return tourPackage2Package;
	}
	@GetMapping()
	public List<TourPackage> getTour(){
		List<TourPackage> tourPackages = tourPackageRepo.findAll();
		return tourPackages;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletEntity(@PathVariable int id){
		tourPackageRepo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatusCode.valueOf(200));
	}
}
