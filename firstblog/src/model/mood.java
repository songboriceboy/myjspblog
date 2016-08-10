package model;

public class mood {

	private int id;
	private String content;  
    private String date;
    private String picSrc;
	
	      
    
    
    public mood(String content, String picSrc) {
		super();
		this.content = content;
		this.picSrc = picSrc;
	}
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	
	
	
	
	
	
}
