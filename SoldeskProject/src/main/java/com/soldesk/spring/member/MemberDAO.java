package com.soldesk.spring.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.soldesk.spring.sns.SNSDAO;
import com.soldesk.spring.sns.SNSMapper;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SNSDAO sDAO;
	
	// 회원가입
	public void memberJoin(Member m, HttpServletRequest req, HttpServletResponse res) {
		
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
			String member_pw = mr.getParameter("member_pw");
			String member_name = mr.getParameter("member_name");
			String member_addr1 = mr.getParameter("member_addr1");
			String member_addr2 = mr.getParameter("member_addr2");
			String member_addr3 = mr.getParameter("member_addr3");
			String member_addr = member_addr1 + " " + member_addr2 + " " + member_addr3;
			String member_photo = mr.getFilesystemName("member_photo");
			member_photo = URLEncoder.encode(member_photo, "utf-8");
			member_photo = member_photo.replace("+", " ");
			BigDecimal member_level = BigDecimal.ONE;
			
			m.setMember_id(member_id);
			m.setMember_pw(member_pw);
			m.setMember_name(member_name);
			m.setMember_addr(member_addr);
			m.setMember_photo(member_photo);
			m.setMember_level(member_level);
			
			if (ss.getMapper(MemberMapper.class).memberJoin(m) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("member_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "가입실패");
		}
		
	}

	// 로그인
	public void memberLogin(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
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
	public boolean memberLoginCheck(HttpServletRequest req, HttpServletResponse res) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	// 로그아웃
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("loginMember", null);
	}
	
	// 회원정보 수정
	public void memberUpdate(Member m, HttpServletRequest req, HttpServletResponse res) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = loginMember.getMember_photo();
		String newFile = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("member_photo");
			if (newFile == null) {
				newFile = oldFile;
			} else { 
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			System.out.println("11");
			return;
		}
		try {
			String member_id = mr.getParameter("member_id");
			String member_pw = mr.getParameter("member_pw");
			String member_name = mr.getParameter("member_name");
			String member_addr1 = mr.getParameter("member_addr1");
			String member_addr2 = mr.getParameter("member_addr2");
			String member_addr3 = mr.getParameter("member_addr3");
			String member_addr = member_addr1 + " " + member_addr2 + " " + member_addr3;
			String member_photo = mr.getFilesystemName("member_photo");
			member_photo = newFile;
			BigDecimal member_level = BigDecimal.ONE;
			
			m.setMember_id(member_id);
			m.setMember_pw(member_pw);
			m.setMember_name(member_name);
			m.setMember_addr(member_addr);
			m.setMember_photo(member_photo);
			m.setMember_level(member_level);
			
			if (ss.getMapper(MemberMapper.class).memberUpdate(m) == 1) {
				req.setAttribute("result", "회원정보가 수정되었습니다.");
				req.getSession().setAttribute("loginMember", m);
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
				req.setAttribute("result", "요청중 오류가 발생했습니다.");
				System.out.println("22");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			System.out.println("33");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					e.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}
		
	}

	// 회원정보 수정시 필요한 주소분리 메소드
	public void splitAddr(HttpServletRequest request, HttpServletResponse response) {
		Member m = (Member) request.getSession().getAttribute("loginMember");

		String member_addr = m.getMember_addr();
		String[] member_addr2 = member_addr.split(" ");
		request.setAttribute("addr", member_addr2);
	}

	// 회원탈퇴
	public void memberDelete(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");		
			int msgCount = ss.getMapper(SNSMapper.class).getSNSCountById(m);
			
			// 회원탈퇴할 때 총 게시글개수 가져와서
			int allSNSCount = sDAO.getAllSNSCount();
			System.out.println(allSNSCount);
			
			if (ss.getMapper(MemberMapper.class).memberDelete(m) == 1) {
				req.setAttribute("result", "회원탈퇴완료");
				
				// 회원탈퇴가 성공하면 총 게시글에서 탈퇴한사람이 쓴 게시글개수만큼 빼기
				sDAO.setAllSNSCount(allSNSCount - msgCount);
				System.out.println(sDAO.getAllSNSCount());
				
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				String member_photo = m.getMember_photo();
				member_photo = URLDecoder.decode(member_photo, "euc-kr");
				new File(path + "/" + member_photo).delete();

				logout(req, res);
				memberLoginCheck(req, res);
			} else {
				req.setAttribute("result", "회원탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "회원탈퇴실패");
		}
	}
	

	public Members getMember(Member m, HttpServletRequest req) {		
		List<Member> members 
			= ss.getMapper(MemberMapper.class).getMemberByID2(m);		
		Members ms = new Members(members);		
		return ms;
	}

}
