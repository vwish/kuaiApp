package com.example.tool;

import android.app.Activity;
import android.widget.Toast;

public class Common {
	public static void toast(Activity activity, String message) {
		Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
	}
}
