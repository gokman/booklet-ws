package com.fagose.booklet.object;
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

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fagose.booklet.model.Comment;
import com.fagose.booklet.util.CustomDateSerializer;
import com.fagose.booklet.util.CustomJsonDateDeserializer;

public class CustomComment {

	private Long commentId;
	private Long commenterId;
	private String commentText;
	private Long commentedBookId;
	private Long commentedBookAdderId;
	private Date creationDate;
	private String commenterName;

	public CustomComment() {
	}

	public CustomComment(Long commenterId, String commentText,
			Long commentedBookId, Long commentedBookAdderId,
			Date creationDate) {
		this.commenterId = commenterId;
		this.commentText = commentText;
		this.commentedBookId = commentedBookId;
		this.commentedBookAdderId = commentedBookAdderId;
		this.creationDate = creationDate;
	}
	
	public CustomComment(Comment comment,String commenterName){
		this.commentedBookAdderId=comment.getCommentedBookAdderId();
		this.commentedBookId=comment.getCommentedBookId();
		this.commenterId=comment.getCommenterId();
		this.commentId=comment.getCommentId();
		this.commentText=comment.getCommentText();
		this.creationDate=comment.getCreationDate();
		this.commenterName=commenterName;
	}

	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public Long getCommenterId() {
		return this.commenterId;
	}

	public void setCommenterId(Long commenterId) {
		this.commenterId = commenterId;
	}

	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Long getCommentedBookId() {
		return this.commentedBookId;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public void setCommentedBookId(Long commentedBookId) {
		this.commentedBookId = commentedBookId;
	}

	public Long getCommentedBookAdderId() {
		return this.commentedBookAdderId;
	}

	public void setCommentedBookAdderId(Long commentedBookAdderId) {
		this.commentedBookAdderId = commentedBookAdderId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
