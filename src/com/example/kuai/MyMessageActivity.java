package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.os.Bundle;

public class MyMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.mymessage);
	}
}
