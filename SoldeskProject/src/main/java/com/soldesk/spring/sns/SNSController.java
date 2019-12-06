package com.soldesk.spring.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.TokenMaker;
import com.soldesk.spring.member.MemberDAO;

@Controller
public class SNSController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO sDAO;
	
	// sns메인뷰
	@RequestMapping(value = "sns.view", method = RequestMethod.GET)
	public String snsView(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		sDAO.snsView(1, req, res);
		req.setAttribute("content", "sns/sns.jsp");
		return "index";
	}
	
	// sns글 작성하기
	@RequestMapping(value = "sns.write", method = RequestMethod.POST)
	public String snsWrite(SNS s, HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		sDAO.snsWrite(s, req, res);
		sDAO.snsView(1, req, res);
		req.setAttribute("content", "sns/sns.jsp");
		return "index";
	}
	
	@RequestMapping(value = "sns.index", method = RequestMethod.POST)
	public String snsSearch(SNSSelector sSel, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		mDAO.memberLoginCheck(req, res);
		sDAO.searchMsg(sSel, req, res);
		sDAO.snsView(1, req, res);
		req.setAttribute("content", "sns/sns.jsp");	
		return "index";
	}
}
