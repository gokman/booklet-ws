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

	private Integer commentId;
	private Integer commenterId;
	private String commentText;
	private Integer commentedBookId;
	private Integer commentedBookAdderId;
	private Date creationDate;

	public Comment() {
	}

	public Comment(Integer commenterId, String commentText,
			Integer commentedBookId, Integer commentedBookAdderId,
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
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Column(name = "CommenterID")
	public Integer getCommenterId() {
		return this.commenterId;
	}

	public void setCommenterId(Integer commenterId) {
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
	public Integer getCommentedBookId() {
		return this.commentedBookId;
	}

	public void setCommentedBookId(Integer commentedBookId) {
		this.commentedBookId = commentedBookId;
	}

	@Column(name = "CommentedBookAdderID")
	public Integer getCommentedBookAdderId() {
		return this.commentedBookAdderId;
	}

	public void setCommentedBookAdderId(Integer commentedBookAdderId) {
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
