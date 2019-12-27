package com.soldesk.spring.info.theater;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soldesk.spring.TokenMaker;
import com.soldesk.spring.info.person.PersonDAO;
import com.soldesk.spring.member.MemberDAO;

@Controller
public class InfoController {

	private boolean firstConnect;
	
	@Autowired
	TheaterDAO idao;
	
	@Autowired
	MemberDAO mdao;
	
	@Autowired
	PersonDAO pdao;
	
	@RequestMapping(value = "TheaterInfo.com.theater", method = RequestMethod.GET)
	public String getTheaterInfo(HttpServletRequest req, HttpServletResponse rep) {
		mdao.memberLoginCheck(req, rep);
		idao.getInfo(1, req, rep);
		req.setAttribute("content", "info/theater.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.Basic", method = RequestMethod.GET)
	public String getTheaterDetail(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		req.setAttribute("DetailInfo", "theaterDetail/Basic.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.ViewTime", method = RequestMethod.GET)
	public String getTheaterViewTime(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		req.setAttribute("DetailInfo", "theaterDetail/ViewTime.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.ViewReview", method = RequestMethod.GET)
	public String getTheaterViewReview(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		req.setAttribute("DetailInfo", "theaterDetail/ViewReview.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDetail.ViewPerson", method = RequestMethod.GET)
	public String getTheaterViewPerson(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		req.setAttribute("DetailInfo", "theaterDetail/ViewPerson.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.genreDetail.Basic", method = RequestMethod.GET)
	public String getGenre(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("genre_number"));
		idao.getTheaterByGenre(t, req, res);
		req.setAttribute("content", "info/genre_info.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.groupDetail.Basic", method = RequestMethod.GET)
	public String getOrganization(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("group_number"));
		idao.getTheaterByGroup(t, req, res);
		req.setAttribute("content", "info/ViewDetail/GroupDetail.jsp");
		req.setAttribute("GroupDetailInfo", "groupDetail/GroupBasic.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.groupDetail.Person", method = RequestMethod.GET)
	public String getOrganizationPerson(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("group_number"));
		idao.getTheaterByGroup(t, req, res);
		req.setAttribute("content", "info/ViewDetail/GroupDetail.jsp");
		req.setAttribute("GroupDetailInfo", "groupDetail/GroupPerson.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.groupDetail.Theater", method = RequestMethod.GET)
	public String getOrganizationTheater(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		int t = Integer.parseInt(req.getParameter("group_number"));
		idao.getTheaterByGroup(t, req, res);
		req.setAttribute("content", "info/ViewDetail/GroupDetail.jsp");
		req.setAttribute("GroupDetailInfo", "groupDetail/GroupTheater.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.stageDetail.Basic", method = RequestMethod.GET)
	public String getStage(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getStageDetail(req, res);
		req.setAttribute("content", "info/ViewDetail/StageDetail.jsp");
		req.setAttribute("StageDetailInfo", "stageDetail/StageBasic.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.stageDetail.Detail", method = RequestMethod.GET)
	public String getStageDetail(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getStageDetail(req, res);
		req.setAttribute("content", "info/ViewDetail/StageDetail.jsp");
		req.setAttribute("StageDetailInfo", "stageDetail/StageMoreInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.stageDetail.Theater", method = RequestMethod.GET)
	public String getStageTheater(HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getStageDetail(req, res);
		req.setAttribute("content", "info/ViewDetail/StageDetail.jsp");
		req.setAttribute("StageDetailInfo", "stageDetail/StageTheater.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterReg", method = RequestMethod.GET)
	public String theaterWrite(HttpServletRequest req, HttpServletResponse res) {
		TokenMaker.make(req, res);
		mdao.memberLoginCheck(req, res);
		req.setAttribute("content", "info/Write/theaterWrite.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterRegist", method = RequestMethod.POST)
	public String theaterResist(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.theaterWrite(ti, req, res);
		req.setAttribute("content", "info/Write/detailWrite.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterRegisted", method = RequestMethod.GET)
	public String theaterRegDetail(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		ti.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/Write/detailWrite.jsp");
		return "index";
	}

	@RequestMapping(value = "TheaterInfo.com.theaterUpdate", method = RequestMethod.GET)
	public String toTheaterUpdate(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/Update/theaterUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.searchGenre", method = RequestMethod.GET)
	public String toGenreSearch(TheaterSelector ts, HttpServletRequest req, HttpServletResponse res) {
		idao.genreSearch(1, req, res);
		return "info/Write/genre/genreSearch";
	}
	
	@RequestMapping(value = "TheaterInfo.com.searchGenre.move", method = RequestMethod.GET)
	public String genreSearchPage(HttpServletRequest req, HttpServletResponse res) {
		int p = Integer.parseInt(req.getParameter("p"));
		idao.genreSearch(p, req, res);
		req.setAttribute("content", "info/Update/theaterUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.insertGenre", method = RequestMethod.GET)
	public String insertGenre(HttpServletRequest req, HttpServletResponse res) {
		idao.insertGenre(req, res);
		return "info/Write/genre/genreSearch";
	}
	
	@RequestMapping(value = "TheaterInfo.com.writeGenre", method = RequestMethod.GET)
	public String toGenreWrite(HttpServletRequest req, HttpServletResponse res) {
		return "info/Write/genre/genreWrite";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterUpdate.value", method = RequestMethod.POST)
	public String theaterUpdate(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		idao.theaterUpdate(ti, req, res);
		idao.getTheaterDetail(ti, req, res);
		req.setAttribute("content", "info/ViewDetail/TheaterDetail.jsp");
		req.setAttribute("DetailInfo", "theaterDetail/Basic.jsp");
		return "index";
	}
	
	@RequestMapping(value = "TheaterInfo.com.theaterDelete", method = RequestMethod.GET)
	public String theaterDelete(TheaterInfo ti, HttpServletRequest req, HttpServletResponse res) {
		mdao.memberLoginCheck(req, res);
		ti.setTheater_number(new BigDecimal(req.getParameter("theater_number")));
		idao.theaterDelete(ti, req, res);
		idao.getInfo(1, req, res);
		req.setAttribute("content", "info/theater.jsp");
		return "index";
	}
	
	
}
