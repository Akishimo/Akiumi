package com.akiumi.common.util;

import java.util.regex.Pattern;

/**
 * @author Onakaumi
 * @Date 2013-3-19
 * @Description
 */
public class StringUtil {

	/**
	 * 给定的字符串不为空 就返回true
	 * 
	 * str = "123" return true;
	 * 
	 * @param str
	 * @return false 给定的字符串是null或者是""
	 */
	public static boolean isNotNullOrEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @param str
	 * @return
	 */
	public static String emptyOrTrim(String str) {
		return isNotNullOrEmpty(str) ? str.trim() : "";
	}

	/**
	 * @param string
	 * @param defaultStr
	 * @return
	 */
	public static String nullOr(String str, String defaultStr) {
		return isNotNullOrEmpty(str) ? str : defaultStr;
	}

	/**
	 * 将带有html标签的字符串 去掉其标签
	 * 
	 * @param htmlStr
	 * @return
	 */
	public static String html2Text(String htmlStr) {
		String textStr = "";
		try {
			// 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>}
			String regScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>}
			String regStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			// 定义HTML标签的正则表达式
			String regHtml = "<[^>]+>";

			htmlStr = replace(regScript, "");// 过滤script标签
			htmlStr = replace(regStyle, "");// 过滤script标签
			textStr = replace(regHtml, "");// 过滤script标签
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textStr;
	}

	/**
	 * @param regStr
	 * @param replaceStr
	 * @return
	 */
	public static String replace(String regStr, String replaceStr) {
		// regStr = nullOr(regStr, "");
		// replaceStr = nullOr(replaceStr, "");
		return Pattern.compile(regStr, Pattern.CASE_INSENSITIVE)
				.matcher(replaceStr).replaceAll("");
	}

	/**
	 * 截取指定长度的字符串，超出部分省略。
	 * 
	 * @param target
	 *            目标字符串
	 * @param length
	 *            长度
	 * @param omi
	 *            省略字符
	 * @return
	 */
	public static String omission(String target, int length) {
		target = emptyOrTrim(target);
		if (target.length() >= length) {
			return target.substring(0, length).concat("...");
		}
		return target;
	}
}
