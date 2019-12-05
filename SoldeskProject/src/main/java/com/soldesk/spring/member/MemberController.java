package com.soldesk.spring.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	
	// 회원가입창 이동
	@RequestMapping(value = "member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "member/join.jsp");	
		return "index";
	}
	
	// 회원가입 결과
	@RequestMapping(value = "member.join", method = RequestMethod.POST)
	public String memberJoin(Member m,
			HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		mDAO.memberJoin(m, req, res);
		req.setAttribute("content", "home.jsp");	
		return "index";
	}
	
	// 로그인창 이동
	@RequestMapping(value = "member.login.go", method = RequestMethod.GET)
	public String memberLoginGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "member/loginForm.jsp");	
		return "index";
	}
	
	// 로그인 결과
	@RequestMapping(value = "member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLogin(m, req, res);
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "home.jsp");	
		return "index";
	}
	
	// 로그아웃
	@RequestMapping(value = "member.logout", method = RequestMethod.GET)
	public String memberLogout(Member m,
			HttpServletRequest req, HttpServletResponse res) {
		mDAO.logout(req, res);
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "home.jsp");	
		return "index";
	}
	
	// 회원정보창 이동
	@RequestMapping(value = "member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "member/info.jsp");	
		return "index";
	}
	
	// 회원정보수정창 이동
	@RequestMapping(value = "member.update.go", method = RequestMethod.GET)
	public String memberInsertGo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.memberLoginCheck(req, res);
		req.setAttribute("content", "member/update.jsp");	
		return "index";
	}
	
	// 회원정보수정 결과
	@RequestMapping(value = "member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m,
			HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.memberLoginCheck(req, res)) {
			mDAO.memberUpdate(m, req, res);
			mDAO.splitAddr(req, res);
			req.setAttribute("content", "member/info.jsp");
		} else {
			req.setAttribute("content", "home.jsp");
		}
		return "index";
	}
	
	// 회원탈퇴12343422
	@RequestMapping(value = "member.delete.go", method = RequestMethod.GET)
	public String memberDelete(HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.memberLoginCheck(req, res)) {
			mDAO.memberDelete(req, res);
		}
		req.setAttribute("content", "home.jsp");	
		return "index";
	}
}
