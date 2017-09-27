package jp.co.ws.training.util;

public class StringUtils {


	/**
	 * 文字列比較
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1,String str2){

		if(str1 == null || str2 == null){
			return false;
		}
		if(!str1.equals(str2)){
			return false;

		}
		return true;
	}



}
