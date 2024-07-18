package com.ttk.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class FoodPhotos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int photoid;
	
	//userid
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "User Name cannot be blank")
	private String ptitle;

	@Column(length=25)
	@NotBlank(message = "User Last Name cannot be blank")
	private String pdescription;

	@CreatedDate
	private Date uploadedat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "uid")
	@JsonBackReference
	private User user;

	public int getPhotoid() {
		return photoid;
	}

	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public Date getUploadedat() {
		return uploadedat;
	}

	public void setUploadedat(Date uploadedat) {
		this.uploadedat = uploadedat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}

