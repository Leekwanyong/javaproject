package com.java.ex;



public class Member {	// DTO
	private String userid;
	private String userpw;
	private String userhp;
	private int role;
	
	public Member() {
		
	}
	public Member(String userid, String userpw, String userhp) {
		this.userid = userid;
		this.userpw = userpw;
		this.userhp = userhp;
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUserhp() {
		return userhp;
	}
	public void setUserhp(String userhp) {
		this.userhp = userhp;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
