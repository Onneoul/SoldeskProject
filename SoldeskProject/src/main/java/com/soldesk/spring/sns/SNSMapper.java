package com.soldesk.spring.sns;

import java.util.List;

import com.soldesk.spring.member.Member;


public interface SNSMapper {
	public abstract int snsWrite(SNS s);
	public abstract int replyWrite(SNSReply sr);
	public abstract Integer getSNSCount(SNSSelector sSel);
	public abstract Integer getSNSCountById(Member m);
	public abstract List<SNS> snsView(SNSSelector sSel);
	public abstract List<SNSReply> getReply(SNS s);
	public abstract int replyDelete(SNSReply sr);
	public abstract int snsDelete(SNS s);
	public abstract int snsUpdate(SNS s);
}
