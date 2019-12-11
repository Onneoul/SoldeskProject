package com.soldesk.spring.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.TokenMaker;
import com.soldesk.spring.member.MemberDAO;

@Controller
public class NoticeController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private NoticeDAO nDAO;

	// Notice 메인
	@RequestMapping(value = "notice.view", method = RequestMethod.GET)
	public String noticeView(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		nDAO.noticeView(1, req, res);
		req.setAttribute("content", "notice/notice.jsp");
		return "index";
	}

	// notice 글쓰기 페이지로 이동
	@RequestMapping(value = "notice.write.go", method = RequestMethod.GET)
	public String noticeWriteGo(HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "notice/write.jsp");
		return "index";
	}
	
	// notice 글쓰기 완료
	@RequestMapping(value="notice.write", method = RequestMethod.POST)
	public String noticeWrite(Notice n, HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		nDAO.noticeWrite(n, req, res);
		nDAO.noticeView(1, req, res);
		System.out.println("성공");
		req.setAttribute("content", "notice/notice.jsp");
		return "index";
	}
	
	// 페이지 바꾸는 메소드
	@RequestMapping(value = "notice.page.change", method = RequestMethod.GET)
	public String snsPageChange(HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		int p = Integer.parseInt(req.getParameter("p"));
		mDAO.memberLoginCheck(req, res);
		nDAO.noticeView(p, req, res);
		req.setAttribute("content", "notice/notice.jsp");	
		return "index";
	}
	
}
