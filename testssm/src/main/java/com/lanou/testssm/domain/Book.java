package com.lanou.testssm.domain;


import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String bookid;
	private String bookname;
	private double bookprice;
	private String bookimg;
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookimg() {
		return bookimg;
	}
	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}
}
