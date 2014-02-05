package com.fagose.booklet.model;
// default package
// Generated Jan 13, 2014 10:33:06 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ActionTypes generated by hbm2java
 */
@Entity
@Table(name = "ActionTypes", catalog = "booklet")
public class ActionTypes implements java.io.Serializable {

	private Integer actionId;
	private String actionDesc;

	public ActionTypes() {
	}

	public ActionTypes(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ActionID", unique = true, nullable = false)
	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	@Column(name = "ActionDesc", length = 450)
	public String getActionDesc() {
		return this.actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

}