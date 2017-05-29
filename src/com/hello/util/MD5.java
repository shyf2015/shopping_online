package com.hello.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5(String data) {
		byte[] hash = null;
		String result = "";
		byte[] bytes = data.getBytes();
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(bytes);
			hash = digest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		for (byte b : hash) {
			result += b;

		}
		return result;
	}
}
