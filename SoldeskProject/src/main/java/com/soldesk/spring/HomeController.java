package com.soldesk.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req, res);
		req.setAttribute("SiteMain", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req, HttpServletResponse res) {	
		return home(req,res);
	}
	
}
