package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ShangjiafenleiActivity extends Activity implements OnClickListener{
	private RadioGroup allshangjia;
	private RadioButton shangjiafenleiButton,zhinengpaixuButton; 
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.shangjiafenlei);
		init();
	}
	public void init(){
		allshangjia=(RadioGroup)findViewById(R.id.allshangjia);
		allshangjia.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}
}
