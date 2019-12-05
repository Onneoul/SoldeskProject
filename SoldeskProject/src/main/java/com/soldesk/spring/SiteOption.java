package com.soldesk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteOption {
	private int noticePageCount; // noticePage의 한페이지당 들어갈 게시물 수
	// ...

	public static void clearSearch(HttpServletRequest req, HttpServletResponse rep) {
		req.getSession().setAttribute("Search", null);
	}
	
	public SiteOption() {
		// TODO Auto-generated constructor stub
	}

	public SiteOption(int noticePageCount) {
		super();
		this.noticePageCount = noticePageCount;
	}

	public int getNoticePageCount() {
		return noticePageCount;
	}

	public void setNoticePageCount(int noticePageCount) {
		this.noticePageCount = noticePageCount;
	}

}
