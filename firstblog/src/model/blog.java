package model;

public class blog{
	
	
	private int id;
	private int userId;
	private int cateId;
	private int clickTimes;
	private int commentTimes;
	private String picSrc;
	private String author;
	private String cateName;
	private boolean isTj;
	private String title;
	private String content;
	private String date;
	
	
	
	
	
	
	
	
	
	
	public blog(int id, int cateId, String picSrc, String cateName,
			String title, String content) {
		super();
		this.id = id;
		this.cateId = cateId;
		this.picSrc = picSrc;
		this.cateName = cateName;
		this.title = title;
		this.content = content;
	}





	public blog(int cateId, String picSrc, String cateName, String title,
			String content, String date) {
		super();
		this.cateId = cateId;
		this.picSrc = picSrc;
		this.cateName = cateName;
		this.title = title;
		this.content = content;
		this.date = date;
	}





	public blog(int id, String picSrc, String cateName, String title,
			String content) {
		super();
		this.id = id;
		this.picSrc = picSrc;
		this.cateName = cateName;
		this.title = title;
		this.content = content;
	}





	public blog(int id, String picSrc, String title, String content) {
		super();
		this.id = id;
		this.picSrc = picSrc;
		this.title = title;
		this.content = content;
	}





	public blog(String picSrc, String cateName, String title, String content) {
		super();
		this.picSrc = picSrc;
		this.cateName = cateName;
		this.title = title;
		this.content = content;
	}





	public blog(String picSrc, String title, String content) {
		super();
		this.picSrc = picSrc;
		this.title = title;
		this.content = content;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public int getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(int clickTimes) {
		this.clickTimes = clickTimes;
	}
	public int getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}
	public String getPicSrc() {
		return picSrc;
	}
	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public boolean isTj() {
		return isTj;
	}
	public void setTj(boolean isTj) {
		this.isTj = isTj;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	

}
