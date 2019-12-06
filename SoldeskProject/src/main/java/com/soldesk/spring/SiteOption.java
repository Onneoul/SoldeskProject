package com.soldesk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
// 게시판의 보이게 할 개수 지정해 줄 클래스 만들음
public class SiteOption {
	private int snsCountPerPage; //sns게시판 보여줄 개수
	// 다른 게시판도 여기를 사용할 때마다 추가해서 사용
	
	public SiteOption() {
		// TODO Auto-generated constructor stub
	}

	public SiteOption(int snsCountPerPage) {
		super();
		this.snsCountPerPage = snsCountPerPage;
	}
	
	public int getSnsCountPerPage() {
		return snsCountPerPage;
	}

	public void setSnsCountPerPage(int snsCountPerPage) {
		this.snsCountPerPage = snsCountPerPage;
	}
	
	// 현재 검색되어있는 search목록들을 가져와서 null로 바꿈(검색되어있는 목록clear시킬용도)
	public static void clesrSearch(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", null);
	}
=======
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

>>>>>>> refs/remotes/origin/master
}
