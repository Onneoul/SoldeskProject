package com.soldesk.spring.member;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	// 회원가입
	public void join(Member m, HttpServletRequest req, HttpServletResponse res) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			return;
		}
		try {
			
			String member_id = mr.getParameter("member_id");
			System.out.println(member_id);
			String member_pw = mr.getParameter("member_pw");
			String member_name = mr.getParameter("member_name");
			String member_addr1 = mr.getParameter("member_addr1");
			String member_addr2 = mr.getParameter("member_addr2");
			String member_addr3 = mr.getParameter("member_addr3");
			String member_addr = member_addr1 + "!" + member_addr2 + "!" + member_addr3;
			System.out.println(member_addr);
			String member_photo = mr.getFilesystemName("member_photo");
			member_photo = URLEncoder.encode(member_photo, "utf-8");
			member_photo = member_photo.replace("+", " ");
			System.out.println(member_photo);
			
			m.setMember_id(member_id);
			m.setMember_pw(member_pw);
			m.setMember_name(member_name);
			m.setMember_addr(member_addr);
			m.setMember_photo(member_photo);
			
			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("member_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "가입실패");
			System.out.println("오류3");
		}
		
	}

	// 로그인
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			System.out.println(dbMember);
			if (dbMember != null) {
				if (m.getMember_pw().equals(dbMember.getMember_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
				} else {
					req.setAttribute("result", "비번이 맞지않습니다.");
				}
			} else {
				req.setAttribute("result", "없는 아이디 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인실패");
		}
	}

	// 로그인 확인
	public boolean loginCheck(HttpServletRequest req, HttpServletResponse res) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
}
