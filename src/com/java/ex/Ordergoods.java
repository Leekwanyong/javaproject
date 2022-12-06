package com.java.ex;

public class Ordergoods {
	private long orderid;
	private String userid;
	private long personcount;
	private String screeningplace;
	private String movietitle;
	private long saleprice;
	
	public Ordergoods() {
		
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
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

	public long getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(long saleprice) {
		this.saleprice = saleprice;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	
}
