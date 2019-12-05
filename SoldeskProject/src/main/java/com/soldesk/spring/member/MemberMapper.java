package com.soldesk.spring.member;

import java.util.List;


public interface MemberMapper {
	public abstract int memberJoin(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract int memberUpdate(Member m);
	public abstract int memberDelete(Member m);
	public abstract List<Member> getMemberByID2(Member m);
}
