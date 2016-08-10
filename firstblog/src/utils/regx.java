package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class regx {
	
	
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
		}
	
	
	public static boolean isEmail(String str) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, str);
		}
	
	
	public static boolean isUsername(String userName) {
		String regex = "([a-z]|[A-Z]|[0-9]|[\\u4e00-\\u9fa5])+";
		return match(regex, userName);
		}
	

	public static boolean IsPassword(String password) {
		String regex = "[A-Za-z]+[0-9]";
		return match(regex, password);
		}
	
}
