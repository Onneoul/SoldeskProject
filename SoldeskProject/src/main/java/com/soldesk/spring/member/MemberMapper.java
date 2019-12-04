package com.soldesk.spring.member;

public interface MemberMapper {
	public abstract int join(Member m);
	public abstract Member getMemberByID(Member m);
}
