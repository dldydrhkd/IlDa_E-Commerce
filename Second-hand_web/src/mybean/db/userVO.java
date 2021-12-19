package mybean.db;

import java.sql.Date;

public class userVO {
		private int userNumber;
		private String userId;
		private String userPwd;
		private String userName;
		private int userAge;
		private String userPhoneNumber;
		private String userAddr;
		private String userEmail;
		private String userGender;
		private Date userRegistrationDate;
		private String userCondition;
		
		public userVO(){ }

		public userVO(int userNumber, String userId, String userPwd, String userName, int userAge,
				String userPhoneNumber, String userAddr, String userEmail, String userGender, Date userRegistrationDate,
				String userCondition) {
			super();
			this.userNumber = userNumber;
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			this.userAge = userAge;
			this.userPhoneNumber = userPhoneNumber;
			this.userAddr = userAddr;
			this.userEmail = userEmail;
			this.userGender = userGender;
			this.userRegistrationDate = userRegistrationDate;
			this.userCondition = userCondition;
		}

		public int getUserNumber() {
			return userNumber;
		}

		public void setUserNumber(int userNumber) {
			this.userNumber = userNumber;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserPwd() {
			return userPwd;
		}

		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getUserAge() {
			return userAge;
		}

		public void setUserAge(int userAge) {
			this.userAge = userAge;
		}

		public String getUserPhoneNumber() {
			return userPhoneNumber;
		}

		public void setUserPhoneNumber(String userPhoneNumber) {
			this.userPhoneNumber = userPhoneNumber;
		}

		public String getUserAddr() {
			return userAddr;
		}

		public void setUserAddr(String userAddr) {
			this.userAddr = userAddr;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getUserGender() {
			return userGender;
		}

		public void setUserGender(String userGender) {
			this.userGender = userGender;
		}

		public Date getUserRegistrationDate() {
			return userRegistrationDate;
		}

		public void setUserRegistrationDate(Date userRegistrationDate) {
			this.userRegistrationDate = userRegistrationDate;
		}

		public String getUserCondition() {
			return userCondition;
		}

		public void setUserCondition(String userCondition) {
			this.userCondition = userCondition;
		}; 
		
		
			
}