package com.soldesk.spring.member;

public interface MemberMapper {
	public abstract int memberJoin(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract int memberUpdate(Member m);
	public abstract int memberDelete(Member m);
}
