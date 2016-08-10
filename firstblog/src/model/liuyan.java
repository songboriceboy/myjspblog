package model;

public class liuyan {
	private int id;
	private String userName;  
	private String userEmail;
    private String message;  
    private String date;
    private String picSrc;
    
    
    
    
	
	public liuyan(String userName, String userEmail, String message,
			String picSrc) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.message = message;
		this.picSrc = picSrc;
	}
	
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	 public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
