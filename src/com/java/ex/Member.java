package com.java.ex;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Member {	// DTO
	private String userid;
	private String userpw;
	private Timestamp userdateofbirth;
	private String userhp;
	
	public Member() {
		
	}
	public Member(String userid, String userpw, Timestamp userdateofbirth, String userhp) {
		this.userid = userid;
		this.userpw = userpw;
		this.userdateofbirth = userdateofbirth;
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
	public Timestamp getUserdateofbirth() {
		return userdateofbirth;
	}
	public void setUserdateofbirth(Timestamp userdateofbirth) {
		this.userdateofbirth = userdateofbirth;
	}
	public String getUserhp() {
		return userhp;
	}
	public void setUserhp(String userhp) {
		this.userhp = userhp;
	}
	
}
