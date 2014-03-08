package com.fagose.booklet.to;

import java.util.List;

public class SearchCriteria {
	
	private Long bookId;
	private String name;
	private Long adderId;
	private String writer;
	private String tag;
	private List<Long> bookIdList;
	private int pageSize;
	private int pageNumber;
	private String orderByCrit;
	private String orderByDrc;
	private Long userId;
	private String userName;
	private Long followerId;
	private Long followingId;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAdderId() {
		return adderId;
	}
	public void setAdderId(Long adderId) {
		this.adderId = adderId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public List<Long> getBookIdList() {
		return bookIdList;
	}
	public void setBookIdList(List<Long> bookIdList) {
		this.bookIdList = bookIdList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getOrderByCrit() {
		return orderByCrit;
	}
	public void setOrderByCrit(String orderByCrit) {
		this.orderByCrit = orderByCrit;
	}
	public String getOrderByDrc() {
		return orderByDrc;
	}
	public void setOrderByDrc(String orderByDrc) {
		this.orderByDrc = orderByDrc;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public Long getFollowingId() {
		return followingId;
	}
	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}
	
}
