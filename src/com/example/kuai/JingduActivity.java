package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JingduActivity extends Activity{
	public static Activity ActivityA;
	private TextView tishitext;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.jindu);
		Intent intent=this.getIntent();
		tishitext=(TextView)findViewById(R.id.tishitext);
		if(intent!=null)
		{
			tishitext.setText(intent.getStringExtra("tishitext"));
		}
		ActivityA=this;
	}
}
