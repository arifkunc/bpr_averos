package net.plaut.common.util;

public class StringUtil {
	public static boolean isEmpty(String str){
		if(str == null || str.length() == 0)
			return true;
		else
			return false;
	}
	
	public static boolean isAllCharacterDigit(String str){
		if(StringUtil.isEmpty(str))
			return false;
		
		char[] chars = str.toCharArray();
		for(char c:chars){
			if(!Character.isDigit(c))
				return false;
		}
		return true;
	}
}
