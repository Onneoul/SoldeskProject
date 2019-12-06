package com.soldesk.spring.sns;

import java.util.List;

public interface SNSMapper {
	public abstract int snsWrite(SNS s);
	public abstract List<SNS> snsView(SNSSelector sSel);
	public abstract Integer getSNSCount(SNSSelector sSel);
	public abstract List<SNSReply> getReply(SNS s);
}
