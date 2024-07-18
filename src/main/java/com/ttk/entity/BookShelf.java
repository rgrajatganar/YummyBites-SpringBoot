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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BookShelf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;

	@Column(length=25, nullable = false)
	@NotBlank(message = "Book title cannot be blank")
	private String btitle;

	@Column(length=25)
	@NotBlank(message = "Author cannot be blank")
	private String bauthor;

	@Column(length=25, nullable = false, unique = true)
	@NotNull(message = "isbn cannot be null")
	private long isbn;

	@Column(length=50, nullable = false)
	@NotBlank(message = "Publication date cannot be null")
	private Date publicationdate;

	@CreatedDate
	private Date createdat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "uid")
	@JsonBackReference
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "aid")
	@JsonBackReference
	private Admin admin;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "paymentId")
	@JsonBackReference
	private Payment paymentId;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public Date getPublicationdate() {
		return publicationdate;
	}

	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Payment getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	
	
}

