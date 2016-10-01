package com.msport.clientmaster.pay;

import java.util.Random;
/**
 * MD5加密
 * @author like
 * 2016-5-17
 */
public class MD5 {

	private MD5() {}
	
	public final static String getMessageDigest(int position) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f','H','I','J','K','L','M' };
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		int size = hexDigits.length;
		for (int i = 1; i <= position; i++) {
			int num = random.nextInt(size);
			char c = hexDigits[num];
			buffer.append(c);
		}
		String value = buffer.toString();
		return value;
	}
}
