package com.soldesk.spring.member;

import java.math.BigDecimal;

public class Member {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_addr;
	private String member_photo;
	private BigDecimal member_level;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String member_id, String member_pw, String member_name, String member_addr, String member_photo,
			BigDecimal member_level) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_addr = member_addr;
		this.member_photo = member_photo;
		this.member_level = member_level;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_photo() {
		return member_photo;
	}

	public void setMember_photo(String member_photo) {
		this.member_photo = member_photo;
	}

	public BigDecimal getMember_level() {
		return member_level;
	}

	public void setMember_level(BigDecimal member_level) {
		this.member_level = member_level;
	}

	
	
}
