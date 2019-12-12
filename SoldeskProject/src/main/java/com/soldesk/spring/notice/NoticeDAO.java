package com.soldesk.spring.notice;

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
public class NoticeDAO {
	
	private int allNoticeCount;
	
	public int getAllNoticeCount() {
		return allNoticeCount;
	}

	public void setAllNoticeCount(int allNoticeCount) {
		this.allNoticeCount = allNoticeCount;
	}

	@Autowired
	private SqlSession ss;
	@Autowired
	private SiteOption so;
	
	// Notice 메인 창
	public void noticeView(int pageNo, HttpServletRequest req, HttpServletResponse res) {
		
		try {
		int count = so.getCountPerPage();
		
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		NoticeSelector search = (NoticeSelector) req.getSession().getAttribute("search");
		int noticeCount = 0;
		
		if(search==null) {
			search= new NoticeSelector("", new BigDecimal(start), new BigDecimal(end));
			noticeCount = allNoticeCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
		// noticeCount = ss.getMapper(NoticeMapper.class).getCount(search);
		}
		
		List<Notice> notices = ss.getMapper(NoticeMapper.class).noticeView(search);
	
		
		req.setAttribute("notices", notices);
		req.setAttribute("curPage", pageNo);
		int pageCount = (int) Math.ceil(noticeCount/ (double)count);
		req.setAttribute("pageCount", pageCount);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Notice 작성하기
	public void noticeWrite(Notice n, HttpServletRequest req, HttpServletResponse res) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");

			if (successToken != null && token.equals(successToken)) {
				return;
			}
			Member m = (Member) req.getSession().getAttribute("loginMember");
			n.setNotice_id(m.getMember_id());
			String notice_text = n.getNotice_text();
			n.setNotice_text(notice_text.replace("\r\n", "<br>"));
			
			if (ss.getMapper(NoticeMapper.class).noticeWrite(n) == 1) {
				req.setAttribute("result", "등록완료");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "등록실패");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
	}
	
	// notice제목 클릭시 내용보기
	public void noticeContent(int t, HttpServletRequest req, HttpServletResponse res) {
			
			Notice n = new Notice();
			n.setNotice_number(new BigDecimal(t));
			
			req.setAttribute("noticeContent" ,ss.getMapper(NoticeMapper.class).noticeContent(n));
		}
	
	// notice업데이트(수정)
	public void noticeUpdate(Notice n, HttpServletRequest req, HttpServletResponse res) {
		try {			
			
			if (ss.getMapper(NoticeMapper.class).noticeUpdate(n) == 1) {
				req.setAttribute("result", "글수정성공");
			} else {
				req.setAttribute("result", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글수정실패");
		}
	}
	}
	

