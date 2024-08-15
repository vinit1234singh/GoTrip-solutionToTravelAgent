package com.intellect.crm.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String firstName;
	String lastName;
	@Column(unique = true, nullable = false) 
	String email;
	String password;
	Long phoneNumber;

	
}
