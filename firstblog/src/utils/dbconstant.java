package utils;

public class dbconstant {
	
	private static  String driverClass="com.mysql.jdbc.Driver";
	
	private static  String  url="jdbc:mysql://127.0.0.1:3306/blog";

	private static  String dbUser = "root";   

	private static  String dbPwd = "yf123456";

	public static String getDriverclass() {
		return driverClass;
	}

	public static void setDriverclass(String driverClass) {
		dbconstant.driverClass = driverClass;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		dbconstant.url = url;
	}

	public static String getDbuser() {
		return dbUser;
	}

	public static void setDbuser(String dbUser) {
		dbconstant.dbUser = dbUser;
	}

	public static String getDbpwd() {
		return dbPwd;
	}

	public static void setDbpwd(String dbPwd) {
		dbconstant.dbPwd = dbPwd;
	}
	





}
