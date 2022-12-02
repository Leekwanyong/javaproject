package com.java.ex;

public class Ordergoods {
	private long orderid;
	private String users;
	private long personcount;
	private String screeningplace;
	private String movietitle;
	
	public Ordergoods() {
		
	}
	
	public Ordergoods(long orderid, String users, long personcount, String screeningplace, String movietitle) {
	this.orderid = orderid;
	this.users = users;
	this.personcount = personcount;
	this.screeningplace = screeningplace;
	this.movietitle = movietitle;
		
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public long getPersoncount() {
		return personcount;
	}

	public void setPersoncount(long personcount) {
		this.personcount = personcount;
	}

	public String getScreeningplace() {
		return screeningplace;
	}

	public void setScreeningplace(String screeningplace) {
		this.screeningplace = screeningplace;
	}

	public String getMovietitle() {
		return movietitle;
	}

	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}
	
}
