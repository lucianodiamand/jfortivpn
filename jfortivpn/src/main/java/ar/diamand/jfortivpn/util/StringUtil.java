package ar.diamand.jfortivpn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private StringUtil() {
		// Helper
	}

	public static String getNumber(String string) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(string);
		while (m.find()) {
			return m.group();
		}
		return "";
	}

}
