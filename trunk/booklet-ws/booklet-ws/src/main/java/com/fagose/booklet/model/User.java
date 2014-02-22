package com.fagose.booklet.model;
// default package
// Generated Jan 13, 2014 10:33:06 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User", catalog = "booklet")
public class User{

	private Long userId;
	private String userEmail;
	private String userName;
	private String activationToken;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserID", unique = true, nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "UserEmail", length = 50)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Column(name = "ActivationToken", length = 50)
	public String getactivationToken() {
		return activationToken;
	}

	public void setactivationToken(String activationToken) {
		this.activationToken = activationToken;
	}

	private String password;
	private String about;
	private Date creationDate;
	private Date lastUpdateDate;
	private Integer enabled;

	public User() {
	}
	
	public User(String userName,String email,String password){
		this.userName=userName;
		this.userEmail=email;
		this.password=password;
	}

	public User(Long id) {
		this.userId = id;
	}

	public User(Long id, String userName, String password, String about,
			Date creationDate, Date lastUpdateDate,String userEmail) {
		this.userId = id;
		this.userEmail=userEmail;
		this.userName = userName;
		this.password = password;
		this.about = about;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}


	@Column(name = "UserName", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "About", length = 1000)
	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreationDate", length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdateDate", length = 19)
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@Column(name = "Enabled")
	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
