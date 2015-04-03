package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HuoyueyonghuActivity extends Activity implements OnClickListener{
	private TextView paiming,ziliao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.huoyueyonghudialog);
		init();
	}
	public void init(){
		paiming=(TextView)findViewById(R.id.paiming);
		ziliao=(TextView)findViewById(R.id.ziliao);
		
		paiming.setOnClickListener(this);
		ziliao.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
		
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}


}
