package com.example.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checknumber {
	//
	public boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
}
