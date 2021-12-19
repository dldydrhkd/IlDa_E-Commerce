package mybean.db;

import java.sql.Date;

public class noticeVO {
	int noticeNumber;
	String noticeTitle;
	String noticeInfo;
	String noticeState;
	String noticeClassification;
	Date noticeRegistrationDate;
	int userNumber;
	public noticeVO(int noticeNumber, String noticeTitle, String noticeInfo, String noticeState,
			String noticeClassification, Date noticeRegistrationDate, int userNumber) {
		super();
		this.noticeNumber = noticeNumber;
		this.noticeTitle = noticeTitle;
		this.noticeInfo = noticeInfo;
		this.noticeState = noticeState;
		this.noticeClassification = noticeClassification;
		this.noticeRegistrationDate = noticeRegistrationDate;
		this.userNumber = userNumber;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeInfo() {
		return noticeInfo;
	}
	public void setNoticeInfo(String noticeInfo) {
		this.noticeInfo = noticeInfo;
	}
	public String getNoticeState() {
		return noticeState;
	}
	public void setNoticeState(String noticeState) {
		this.noticeState = noticeState;
	}
	public String getNoticeClassification() {
		return noticeClassification;
	}
	public void setNoticeClassification(String noticeClassification) {
		this.noticeClassification = noticeClassification;
	}
	public Date getNoticeRegistrationDate() {
		return noticeRegistrationDate;
	}
	public void setNoticeRegistrationDate(Date noticeRegistrationDate) {
		this.noticeRegistrationDate = noticeRegistrationDate;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	
}
