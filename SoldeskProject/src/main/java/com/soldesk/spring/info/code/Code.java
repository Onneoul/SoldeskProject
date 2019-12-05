package com.soldesk.spring.info.code;

import java.math.BigDecimal;

public class Code {
	private String code_name;
	private String comment;
	private BigDecimal code;
	
	public Code() {
		// TODO Auto-generated constructor stub
	}

	public Code(String code_name, String comment, BigDecimal code) {
		super();
		this.code_name = code_name;
		this.comment = comment;
		this.code = code;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}
	
}
