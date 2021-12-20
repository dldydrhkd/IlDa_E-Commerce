package mybean.db;

import java.sql.Date;

public class commentVO {
	private int commentNumber;
	private String commentInfo;
	private Date commentRegistrationDate;
	private int noticeNumber;
	private String userId;
	private boolean commentCondition;
	
	public commentVO() {};
	
	public commentVO(String commentInfo, Date commentRegistrationDate, String userId) {
		this.commentInfo = commentInfo;
		this.userId = userId;
		this.commentRegistrationDate = commentRegistrationDate;
	}
	
	public commentVO(String commentInfo, int noticeNumber, String userId) {
		this.commentInfo = commentInfo;
		this.noticeNumber = noticeNumber;
		this.userId = userId;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	public Date getCommentRegistrationDate() {
		return commentRegistrationDate;
	}

	public void setCommentRegistrationDate(Date commentRegistrationDate) {
		this.commentRegistrationDate = commentRegistrationDate;
	}

	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isCommentCondition() {
		return commentCondition;
	}

	public void setCommentCondition(boolean commentCondition) {
		this.commentCondition = commentCondition;
	}


}
