package com.soldesk.spring.info.person;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO {
	
	@Autowired
	SqlSession ss;
}
