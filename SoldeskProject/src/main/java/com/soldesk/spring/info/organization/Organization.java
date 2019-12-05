package com.soldesk.spring.info.organization;

import java.math.BigDecimal;

public class Organization {
	private BigDecimal group_number;
	private String group_name;

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public Organization(BigDecimal group_number, String group_name) {
		super();
		this.group_number = group_number;
		this.group_name = group_name;
	}

	public BigDecimal getGroup_number() {
		return group_number;
	}

	public void setGroup_number(BigDecimal group_number) {
		this.group_number = group_number;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
}
