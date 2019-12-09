package com.soldesk.spring.sns;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.SiteOption;
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

	// sns 검색하기
	@RequestMapping(value = "sns.index", method = RequestMethod.POST)
	public String snsSearch(SNSSelector sSel, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		mDAO.memberLoginCheck(req, res);
		sDAO.searchMsg(sSel, req, res);
		sDAO.snsView(1, req, res);
		req.setAttribute("content", "sns/sns.jsp");
		return "index";
	}

	// sns리플 작성하기
	@RequestMapping(value = "sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		int p = Integer.parseInt(req.getParameter("p"));
		if (mDAO.memberLoginCheck(req, res)) {
			sDAO.replyWrite(sr, req, res);
		}
		sDAO.snsView(p, req, res);
		req.setAttribute("content", "sns/sns.jsp");
		return "index";
	}

	// sns리플 삭제하기
	@RequestMapping(value = "sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		int p = Integer.parseInt(req.getParameter("p"));
		SiteOption.clesrSearch(req, res);
		if (mDAO.memberLoginCheck(req, res)) {
			sDAO.replyDelete(sr, req, res);
		}
		sDAO.snsView(p, req, res);
		req.setAttribute("content", "sns/sns.jsp");
		return "index";
	}
	
	// sns 삭제하기
	@RequestMapping(value = "sns.delete", method = RequestMethod.GET)
	public String snsDelete(SNS s, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		SiteOption.clesrSearch(req, res);
		if (mDAO.memberLoginCheck(req, res)) {
			sDAO.snsDelete(s, req, res);
		}
		sDAO.snsView(1, req, res);
		req.setAttribute("content", "sns/sns.jsp");	
		return "index";
	}
	
	// sns 수정하기
	@RequestMapping(value = "sns.update", method = RequestMethod.GET)
	public String snsUpdate(SNS s, HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		int p = Integer.parseInt(req.getParameter("p"));
		if (mDAO.memberLoginCheck(req, res)) {
			sDAO.snsUpdate(s, req, res);
		}
		sDAO.snsView(p, req, res);
		req.setAttribute("content", "sns/sns.jsp");	
		return "index";
	}
}
