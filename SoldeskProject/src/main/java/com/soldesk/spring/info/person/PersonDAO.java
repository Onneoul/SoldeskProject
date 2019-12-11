package com.soldesk.spring.info.person;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO {
	
	@Autowired
	SqlSession ss;
	
    
    public void getPersonDetail(int t, HttpServletRequest req, HttpServletResponse res) {
    	
    	try {
			
    		t = Integer.parseInt(req.getParameter("person_number"));
    		Person P = new Person();
    		P.setPerson_number(new BigDecimal(t));
    		
    		Person p = ss.getMapper(PersonMapper.class).getPersonInfo(P);
    		
    		req.setAttribute("p", p);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
