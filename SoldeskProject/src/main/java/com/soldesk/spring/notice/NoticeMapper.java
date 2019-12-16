package com.soldesk.spring.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NoticeMapper {
	public abstract List<Notice> noticeView(NoticeSelector nSel);
	public abstract List<Notice> noticeGetCategory(NoticeCategory n);
	public abstract List<Notice> noticeGetCategory2(NoticeCategory n);
	public abstract int noticeWrite(Notice n);
	public abstract Notice noticeContent(Notice n);
	public abstract int noticeUpdate(Notice n);
}
