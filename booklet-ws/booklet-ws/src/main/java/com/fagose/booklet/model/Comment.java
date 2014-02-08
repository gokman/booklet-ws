package com.fagose.booklet.model;
// default package
// Generated Jan 13, 2014 10:33:06 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "Comment", catalog = "booklet")
public class Comment implements java.io.Serializable {

	private Long commentId;
	private Long commenterId;
	private String commentText;
	private Long commentedBookId;
	private Long commentedBookAdderId;
	private Date creationDate;

	public Comment() {
	}

	public Comment(Long commenterId, String commentText,
			Long commentedBookId, Long commentedBookAdderId,
			Date creationDate) {
		this.commenterId = commenterId;
		this.commentText = commentText;
		this.commentedBookId = commentedBookId;
		this.commentedBookAdderId = commentedBookAdderId;
		this.creationDate = creationDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CommentID", unique = true, nullable = false)
	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@Column(name = "CommenterID")
	public Long getCommenterId() {
		return this.commenterId;
	}

	public void setCommenterId(Long commenterId) {
		this.commenterId = commenterId;
	}

	@Column(name = "CommentText", length = 1000)
	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Column(name = "CommentedBookID")
	public Long getCommentedBookId() {
		return this.commentedBookId;
	}

	public void setCommentedBookId(Long commentedBookId) {
		this.commentedBookId = commentedBookId;
	}

	@Column(name = "CommentedBookAdderID")
	public Long getCommentedBookAdderId() {
		return this.commentedBookAdderId;
	}

	public void setCommentedBookAdderId(Long commentedBookAdderId) {
		this.commentedBookAdderId = commentedBookAdderId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreationDate", length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}