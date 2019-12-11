package com.soldesk.spring.notice;

import java.util.List;

public interface NoticeMapper {
	public abstract List<Notice> noticeView(NoticeSelector nSel);
	public abstract int noticeWrite(Notice n);
}
