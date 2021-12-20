package mybean.db;

public class basketListVO {
	private int userNumber;
	private int basketNumber;
	private String noticeTitle;
	
	public basketListVO(int userNumber, int basketNumber, String noticeTitle) {
		super();
		this.userNumber = userNumber;
		this.basketNumber = basketNumber;
		this.noticeTitle = noticeTitle;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getBasketNumber() {
		return basketNumber;
	}

	public void setBasketNumber(int basketNumber) {
		this.basketNumber = basketNumber;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
}
