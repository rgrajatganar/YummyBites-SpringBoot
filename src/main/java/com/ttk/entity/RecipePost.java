package com.ttk.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class RecipePost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeid;
	
	//private mp rvideo;
	
	//user id
	//categoryid
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "User Name cannot be blank")
	private String rtitle;
	
	@Column(length=25)
	@NotBlank(message = "User Last Name cannot be blank")
	private String rcontent;

	@CreationTimestamp
	private Date uploadedat;
	
	@UpdateTimestamp
	private Date updatedat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "uid")
	@JsonBackReference
	private User user;

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Date getUploadedat() {
		return uploadedat;
	}

	public void setUploadedat(Date uploadedat) {
		this.uploadedat = uploadedat;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

   