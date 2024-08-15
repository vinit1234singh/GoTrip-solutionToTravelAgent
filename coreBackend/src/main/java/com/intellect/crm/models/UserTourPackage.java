package com.intellect.crm.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserTourPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long userId;
	private int packageId;
	private String packageName;
	private Date travellingDate;
}
