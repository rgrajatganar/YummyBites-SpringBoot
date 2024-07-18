package com.ttk.entity;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@Column(length=25, nullable = false)
	@NotBlank(message = "User Name cannot be blank")
	private String ufname;
	//firstName
	
	@Column(length=25)
	@NotBlank(message = "User Last Name cannot be blank")
	private String ulname;

	@Column(length=10, nullable = false, unique = true)
	@NotNull(message = "User phone cannot be null")
	@Pattern(regexp = "[6789]{1}[0-9]{9}")
	private long uphone;//pattern for phone no

	@Column(length=25, nullable = false, unique = true)
	@NotBlank(message = "User Email cannot be blank")
	@Email(message = "Email is incorrect")
	private String uemail;

	@Column(length=50, nullable = false)
	@NotBlank(message = "User Address cannot be blank")
	private String uaddr;

	@CreatedDate
	private Date createdat;//createdAt
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<BookShelf> book;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<FoodPhotos> photo;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<RecipePost> recipe;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<VideosFeed> video;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Category> category;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Payment> payment;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Feedback> feedback;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUfname() {
		return ufname;
	}

	public void setUfname(String ufname) {
		this.ufname = ufname;
	}

	public String getUlname() {
		return ulname;
	}

	public void setUlname(String ulname) {
		this.ulname = ulname;
	}

	public long getUphone() {
		return uphone;
	}

	public void setUphone(long uphone) {
		this.uphone = uphone;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUaddr() {
		return uaddr;
	}

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public List<BookShelf> getBook() {
		return book;
	}

	public void setBook(List<BookShelf> book) {
		this.book = book;
	}

	public List<FoodPhotos> getPhoto() {
		return photo;
	}

	public void setPhoto(List<FoodPhotos> photo) {
		this.photo = photo;
	}

	public List<RecipePost> getRecipe() {
		return recipe;
	}

	public void setRecipe(List<RecipePost> recipe) {
		this.recipe = recipe;
	}

	public List<VideosFeed> getVideo() {
		return video;
	}

	public void setVideo(List<VideosFeed> video) {
		this.video = video;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	
	
}
