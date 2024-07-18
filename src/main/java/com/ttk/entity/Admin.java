package com.ttk.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "User Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String aemail;
	
	@Column(length=12, nullable = false)
	@NotBlank(message = "password cannot be blank")
	private String apassword;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<BookShelf> book;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Category> category;
	
//	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonManagedReference
//	private List<VideosFeed> video;

}
