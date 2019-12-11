package com.soldesk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 게시판의 보이게 할 개수 지정해 줄 클래스 만들음
public class SiteOption {
	private int CountPerPage; // sns게시판 보여줄 개수
	// 다른 게시판도 여기를 사용할 때마다 추가해서 사용

	public SiteOption() {
		// TODO Auto-generated constructor stub
	}


	public int getCountPerPage() {
		return CountPerPage;
	}



	public void setCountPerPage(int countPerPage) {
		CountPerPage = countPerPage;
	}



	public SiteOption(int countPerPage) {
		super();
		CountPerPage = countPerPage;
	}



	// 현재 검색되어있는 search목록들을 가져와서 null로 바꿈(검색되어있는 목록clear시킬용도)
	public static void clesrSearch(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", null);
	}

}
