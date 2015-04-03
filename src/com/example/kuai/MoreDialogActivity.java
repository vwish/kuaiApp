package com.example.kuai;

import com.example.data.DatabaseHelper;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MoreDialogActivity extends Activity implements OnClickListener{
	public static MoreDialogActivity instance = null;   
	private LinearLayout update, exit,quanbudingdanlay;
	private DatabaseHelper mOpenHelper;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.moreactivity);
		instance = this;
		mOpenHelper=new DatabaseHelper(this);
		init();

	}
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}
	public void init() {
		update = (LinearLayout) findViewById(R.id.update);
		exit = (LinearLayout) findViewById(R.id.exit);
		quanbudingdanlay=(LinearLayout) findViewById(R.id.quanbudingdanlay);
		quanbudingdanlay.setOnClickListener(this);
		update.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		exit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mOpenHelper.deleteItem();
				startActivity(new Intent(MoreDialogActivity.this,Main.class));
				MoreDialogActivity.this.finish();
				ProfileActivity.instance.finish();
			}
			
		});
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.quanbudingdanlay:
			startActivity(new Intent(MoreDialogActivity.this,QuanbudingdanActivity.class));
			finish();
		}
		
	}

}
