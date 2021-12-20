package mybean.db;

public class basketVO {
		
	private int basketNumber;
	private int userNumber;
	private int noticeNumber;

	public basketVO(){ }
	
	public basketVO(int userNumber, int noticeNumber){
		this.userNumber = userNumber;
		this.noticeNumber = noticeNumber;
	}
	
	public basketVO(int basketNumber, int userNumber, int noticeNumber){
		this.basketNumber = basketNumber;
		this.userNumber = userNumber;
		this.noticeNumber = noticeNumber;
	}

	public int getBasketNumber() {
		return basketNumber;
	}

	public void setBasketNumber(int basketNumber) {
		this.basketNumber = basketNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}; 
	
	

}
