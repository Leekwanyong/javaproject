package com.java.ex;

public class Store {
	private long storeid;
	private long storecount;
	private String storepeyment;
	private String storepaymentconfirm;
	private long storetotalprice;
	private String storetitle;

	public Store() {
		// TODO Auto-generated constructor stub
	}
	
	public Store(long storeid, long storecount, String storepeyment, String storepaymentconfirm, long storetotalprice, String storetitle) {
		this.storeid = storeid;
		this.storecount = storecount;
		this.storepeyment = storepeyment;
		this.storepaymentconfirm = storepaymentconfirm;
		this.storetotalprice = storetotalprice;
		this.storetitle = storetitle;
	}

	public long getStoreid() {
		return storeid;
	}

	public String getStoretitle() {
		return storetitle;
	}

	public void setStoretitle(String storetitle) {
		this.storetitle = storetitle;
	}

	public void setStoreid(long storeid) {
		this.storeid = storeid;
	}

	public long getStorecount() {
		return storecount;
	}

	public void setStorecount(long storecount) {
		this.storecount = storecount;
	}

	public String getStorepeyment() {
		return storepeyment;
	}

	public void setStorepeyment(String storepeyment) {
		this.storepeyment = storepeyment;
	}

	public String getStorepaymentconfirm() {
		return storepaymentconfirm;
	}

	public void setStorepaymentconfirm(String storepaymentconfirm) {
		this.storepaymentconfirm = storepaymentconfirm;
	}

	public long getStoretotalprice() {
		return storetotalprice;
	}

	public void setStoretotalprice(long storetotalprice) {
		this.storetotalprice = storetotalprice;
	}
	
	
}
