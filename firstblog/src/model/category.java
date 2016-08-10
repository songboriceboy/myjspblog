package model;

public class category {
	
	
	private int id;
	private String name;
	private String date;
	private int blogSum;
	
	
	
	public category(String name, int blogSum) {
		super();
		this.name = name;
		this.blogSum = blogSum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBlogSum() {
		return blogSum;
	}
	public void setBlogSum(int blogSum) {
		this.blogSum = blogSum;
	}
	
}
