package utils;

public class option {

	private static String  weibourl="#";
	private static String  tweibourl="#";
	private static String  weixinpicsrc="images/03.jpg";
	private static String  logopicsrc="images/logo.png";	
	private static int  pageSize=5;
	private static String  blogname="关于青春的一些故事";
	private static String ICPLicensing="";
	
	
	
	
	public static String getICPLicensing() {
		return ICPLicensing;
	}
	public static void setICPLicensing(String iCPLicensing) {
		ICPLicensing = iCPLicensing;
	}
	public static String getWeibourl() {
		return weibourl;
	}
	public static void setWeibourl(String weibourl) {
		option.weibourl = weibourl;
	}
	public static String getTweibourl() {
		return tweibourl;
	}
	public static void setTweibourl(String tweibourl) {
		option.tweibourl = tweibourl;
	}
	public static String getWeixinpicsrc() {
		return weixinpicsrc;
	}
	public static void setWeixinpicsrc(String weixinpicsrc) {
		option.weixinpicsrc = weixinpicsrc;
	}
	public static String getLogopicsrc() {
		return logopicsrc;
	}
	public static void setLogopicsrc(String logopicsrc) {
		option.logopicsrc = logopicsrc;
	}
	public static int getPageSize() {
		return pageSize;
	}
	public static void setPageSize(int pageSize) {
		option.pageSize = pageSize;
	}
	public static String getBlogname() {
		return blogname;
	}
	public static void setBlogname(String blogname) {
		option.blogname = blogname;
	}
	
	
}
