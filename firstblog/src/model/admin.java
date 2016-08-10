package model;

public class admin {
	private int id;
	private String account;
	private String password;
	private String question;
	private String answer;
	
		
	
	
	
	
	public admin(String account, String password, String question, String answer) {
		super();
		this.account = account;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}


	public admin(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
