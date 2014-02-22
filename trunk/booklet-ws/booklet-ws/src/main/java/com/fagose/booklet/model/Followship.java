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

/**
 * FollowShip generated by hbm2java
 */
@Entity
@Table(name = "Followship", catalog = "booklet")
public class Followship implements java.io.Serializable {

	private Long followshipId;
	private Long followerUserId;
	private Long followedUserId;
	private Date creationDate;

	public Followship() {
	}

	public Followship(Long followerUserId) {
		this.followerUserId = followerUserId;
	}

	public Followship(Long followerUserId, Long followedUserId,
			Date creationDate) {
		this.followerUserId = followerUserId;
		this.followedUserId = followedUserId;
		this.creationDate = creationDate;
	}

	@Column(name = "FollowerUserID", nullable = false)
	public Long getFollowerUserId() {
		return this.followerUserId;
	}

	public void setFollowerUserId(Long followerUserId) {
		this.followerUserId = followerUserId;
	}

	@Column(name = "FollowedUserID")
	public Long getFollowedUserId() {
		return this.followedUserId;
	}

	public void setFollowedUserId(Long followedUserId) {
		this.followedUserId = followedUserId;
	}

	@Column(name = "CreationDate", length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="FollowshipID")
	public Long getFollowshipId() {
		return followshipId;
	}

	public void setFollowshipId(Long followshipId) {
		this.followshipId = followshipId;
	}

}
