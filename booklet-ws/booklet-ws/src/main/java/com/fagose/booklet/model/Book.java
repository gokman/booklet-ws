package com.fagose.booklet.model;
// default package
// Generated Jan 13, 2014 10:33:06 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "Book", catalog = "booklet")
public class Book{

	private Long bookId;
	private String name;
	private String description;
	private Long adderId;
	private String writer;
	private String coverPhoto;
	public Book() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BookID", unique = true, nullable = false)
	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "Name", length = 450)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description", length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "AdderID")
	public Long getAdderId() {
		return this.adderId;
	}

	public void setAdderId(Long adderId) {
		this.adderId = adderId;
	}

	@Column(name = "Writer", length = 450)
	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Column(name = "CoverPhoto", length = 450)
	public String getCoverPhoto() {
		return this.coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}
	
}
