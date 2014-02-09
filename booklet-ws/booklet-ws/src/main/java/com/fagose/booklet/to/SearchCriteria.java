package com.fagose.booklet.to;

import java.util.List;

public class SearchCriteria {
	
	private Long bookId;
	private String name;
	private Long adderId;
	private String writer;
	private String tag;
	private List<Long> bookIdList;
	
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
	
	
}
