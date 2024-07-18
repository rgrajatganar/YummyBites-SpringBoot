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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VideosFeed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Video title cannot be blank")
	private String vtitle;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "video content cannot be blank")
	private String vcontent;
	
	@CreatedDate
	private Date uploadedat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "uid")
	@JsonBackReference
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "categoryid")
	@JsonBackReference
	private Category category;

	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}

	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	//user id 
	//category id
	
}
