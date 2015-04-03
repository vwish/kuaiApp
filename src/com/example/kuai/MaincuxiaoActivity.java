package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MaincuxiaoActivity extends Activity implements OnClickListener{
	private Button first; 
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        MyApplication.instance().addActivity(this);
	        setContentView(R.layout.maincuxiao);
	        init();
	 }
	 public void init(){
		 first=(Button)findViewById(R.id.first);
		 first.setOnClickListener(this);
		 
	 }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.first:
			startActivity(new Intent(MaincuxiaoActivity.this,Main.class));
			finish();
			break;
			}
		
	}

}
