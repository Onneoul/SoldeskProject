package com.soldesk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.member.MemberDAO;
import com.soldesk.spring.notice.NoticeDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private NoticeDAO nDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		nDAO.noticeView(1, req, res);
		req.setAttribute("content", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req, HttpServletResponse res) {	
		return home(req,res);
	}
	
}
