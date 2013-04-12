/**
 * 
 */
package com.akiumi.common.util;

import java.util.Random;

/**
 * @author Onakaumi
 * @Date 2013-3-20
 * @Description
 */
public class RandomUtil {

	/**
	 * 随机产生指定长度的字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(63);
			buf.append(str.charAt(num));
		}
		return buf.toString();
	}

}
