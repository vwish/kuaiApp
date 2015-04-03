package com.example.kuai;


import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuanbudingdanActivity extends Activity implements OnClickListener{
	private Button first;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.quanbudingdan);
		
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
			startActivity(new Intent(QuanbudingdanActivity.this,Main.class));
			finish();
			break;
		}
		
	}

}
