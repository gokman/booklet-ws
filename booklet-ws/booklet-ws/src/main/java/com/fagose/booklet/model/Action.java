package com.fagose.booklet.model;
// default package
// Generated Jan 13, 2014 10:33:06 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fagose.booklet.util.CustomDateSerializer;
import com.fagose.booklet.util.CustomJsonDateDeserializer;

/**
 * Action generated by hbm2java
 */
@Entity
@Table(name = "Action", catalog = "booklet")
public class Action implements java.io.Serializable {

	private int actionType;
	private Long userId;
	private Long actionId;
	private Date actionDate;
	private Long actionDateinMS;
	private Long actionDetailId;
	
	public Action() {
	}


	public Action(
			int actionType,
			Long userId, Long actionId) {
		this.actionType = actionType;
		this.userId = userId;
		this.actionId = actionId;
	}

	@Column(name = "ActionType")
	public int getActionType() {
		return actionType;
	}


	public void setActionType(int actionType) {
		this.actionType = actionType;
	}


	@Column(name = "UserID")
	public Long  getUserId() {
		return this.userId;
	}

	public void setUserId(Long  userId) {
		this.userId = userId;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ActionID")
	public Long  getActionId() {
		return this.actionId;
	}

	public void setActionId(Long  actionId) {
		this.actionId = actionId;
	}

	@JsonSerialize(using=CustomDateSerializer.class)
	@JsonProperty("actionDate")
	@Column(name="ActionDate")
	public Date getActionDate() {
		return actionDate;
	}

	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	@JsonProperty("actionDate")
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Column(name="ActionDetailID")
	public Long getActionDetailId() {
		return actionDetailId;
	}


	public void setActionDetailId(Long actionDetailId) {
		this.actionDetailId = actionDetailId;
	}

	@Transient
	public Long getActionDateinMS() {
		return actionDateinMS;
	}


	public void setActionDateinMS(Long actionDateinMS) {
		this.actionDateinMS = actionDateinMS;
	}

}