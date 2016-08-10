package model;

public class notification {

private	int id;
private	String type;
private	String name;
private	String content;
private	String date;
	




public notification(String type, String name, String content) {
	super();
	this.type = type;
	this.name = name;
	this.content = content;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
