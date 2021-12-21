package mybean.db;

import java.sql.Date;

public class noticeVO {
	private int noticeNumber;
	private String noticeTitle;
	private String noticeInfo;
	private String noticeState;
	private String noticeClassification;
	private Date noticeRegistrationDate;
	private int userNumber;
	private String noticeImgfileRealName;
	private String noticeSource;
	private int noticeProductPrice;
	private boolean noticeCondition;
	
	public noticeVO(){};
	
	public noticeVO(int noticeNumber, String noticeTitle, String noticeInfo, String noticeState, String noticeClassification, Date noticeRegistrationDate, int userNumber, String noticeImgfileRealName, String noticeSource, int noticeProductPrice) {
		this.noticeNumber = noticeNumber;
		this.noticeTitle = noticeTitle;
		this.noticeInfo = noticeInfo;
		this.noticeState = noticeState;
		this.noticeClassification = noticeClassification;
		this.noticeRegistrationDate = noticeRegistrationDate;
		this.userNumber = userNumber;
		this.noticeImgfileRealName = noticeImgfileRealName;
		this.noticeSource = noticeSource;
		this.noticeProductPrice = noticeProductPrice;
	}
	
	public noticeVO(String noticeTitle, String noticeInfo, String noticeClassification, int userNumber, String noticeImgfileRealName, String noticeSource, int noticeProductPrice) {
		this.noticeTitle = noticeTitle;
		this.noticeInfo = noticeInfo;
		this.noticeClassification = noticeClassification;
		this.userNumber = userNumber;
		this.noticeImgfileRealName = noticeImgfileRealName;
		this.noticeSource = noticeSource;
		this.noticeProductPrice = noticeProductPrice;
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

	public String getNoticeImgfileRealName() {
		return noticeImgfileRealName;
	}

	public void setNoticeImgfileRealName(String noticeImgfileRealName) {
		this.noticeImgfileRealName = noticeImgfileRealName;
	}

	public String getNoticeSource() {
		return noticeSource;
	}

	public void setNoticeSource(String noticeSource) {
		this.noticeSource = noticeSource;
	}
	
	public int getNoticeProductPrice() {
		return noticeProductPrice;
	}

	public void setNoticeProductPrice(int noticeProductPrice) {
		this.noticeProductPrice = noticeProductPrice;
	}

	public boolean isNoticeCondition() {
		return noticeCondition;
	}

	public void setNoticeCondition(boolean noticeCondition) {
		this.noticeCondition = noticeCondition;
	}
	

	
}
