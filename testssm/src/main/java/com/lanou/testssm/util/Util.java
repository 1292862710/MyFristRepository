package com.lanou.testssm.util;

import java.io.UnsupportedEncodingException;

public class Util {
	public static class ChinaeseEncoding {
		public static String changestr(String name) {
			try {
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return name;
		}
	}
}
