package com.soldesk.spring.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNS {
	private BigDecimal sns_number;
	private String sns_user; // 기존 number_id
	private String sns_text;
	private Date sns_date;
	private List<SNSReply> sns_replys;

	public SNS() {
		// TODO Auto-generated constructor stub
	}

	
	
	public SNS(BigDecimal sns_number, String sns_user, String sns_text, Date sns_date) {
		super();
		this.sns_number = sns_number;
		this.sns_user = sns_user;
		this.sns_text = sns_text;
		this.sns_date = sns_date;
	}



	public BigDecimal getSns_number() {
		return sns_number;
	}



	public void setSns_number(BigDecimal sns_number) {
		this.sns_number = sns_number;
	}



	public String getSns_user() {
		return sns_user;
	}



	public void setSns_user(String sns_user) {
		this.sns_user = sns_user;
	}



	public String getSns_text() {
		return sns_text;
	}



	public void setSns_text(String sns_text) {
		this.sns_text = sns_text;
	}



	public Date getSns_date() {
		return sns_date;
	}



	public void setSns_date(Date sns_date) {
		this.sns_date = sns_date;
	}



	public List<SNSReply> getSns_replys() {
		return sns_replys;
	}
	
	public void setSns_replys(List<SNSReply> sns_replys) {
		this.sns_replys = sns_replys;
	}
	
}
