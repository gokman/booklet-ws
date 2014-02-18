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

/**
 * Action generated by hbm2java
 */
@Entity
@Table(name = "Action", catalog = "booklet")
public class Action implements java.io.Serializable {

	private ActionType actionType;
	private Long userId;
	private Long actionId;
	private Date actionDate;
	
	public Action() {
	}


	public Action(ActionType actionType, Long userId, Long actionId) {
		this.actionType = actionType;
		this.userId = userId;
		this.actionId = actionId;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ActionType")
	public ActionType getActionType() {
		return actionType;
	}


	public void setActionType(ActionType actionType) {
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

	@Column(name="ActionDate")
	public Date getActionDate() {
		return actionDate;
	}


	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

}