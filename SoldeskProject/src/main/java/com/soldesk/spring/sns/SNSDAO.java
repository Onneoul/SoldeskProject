package com.soldesk.spring.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk.spring.SiteOption;
import com.soldesk.spring.member.Member;

@Service
public class SNSDAO {
	private int allSNSCount;

	@Autowired
	private SqlSession ss;
	@Autowired
	private SiteOption so;

	// SNS글쓰기 기능
	public void snsWrite(SNS s, HttpServletRequest req, HttpServletResponse res) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (successToken != null && token.equals(successToken)) {
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			// s.setMember_id(m.getMember_id());
			s.setSns_user(m.getMember_id());
			
			String sns_text = s.getSns_text();
			s.setSns_text(sns_text.replace("\r\n", "<br>"));

			if (ss.getMapper(SNSMapper.class).snsWrite(s) == 1) {
				req.setAttribute("result", "등록완료");
				System.out.println("성공");
				// allSNSCount++;
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
	}

	// SNS메인 창
	public void snsView(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
		int count = so.getSnsCountPerPage();
		
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		SNSSelector search = (SNSSelector) req.getSession().getAttribute("search");
		int snsCount = 0;
		
		if(search==null) {
			search= new SNSSelector("", new BigDecimal(start), new BigDecimal(end));
			snsCount = allSNSCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			snsCount = ss.getMapper(SNSMapper.class).getSNSCount(search);
		}
		
		List<SNS> snss = ss.getMapper(SNSMapper.class).snsView(search);
		
		for (SNS sns : snss) {
			sns.setSns_replys(
					ss.getMapper(SNSMapper.class).getReply(sns));
		}
		
		req.setAttribute("snss", snss);
		req.setAttribute("curPage", pageNo);
		int pageCount = (int) Math.ceil(snsCount/ (double)count);
		req.setAttribute("pageCount", pageCount);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시판 검색할때 쓴 글자 저장
	public void searchMsg(SNSSelector sSel, HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("search", sSel);
	}
	
	
}
