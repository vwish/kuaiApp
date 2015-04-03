package com.example.kuai;

import com.example.tool.MyApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class CaoCaoActivity extends Activity implements OnClickListener{

	private ImageView third;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.activity_cao_cao);
		init();
	}

	public void init(){
		third=(ImageView)findViewById(R.id.third);
		third.setOnClickListener((OnClickListener) this);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cao_cao, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.third:
			startActivity(new Intent(CaoCaoActivity.this,Main.class));
			finish();
			break;
		}
	}

}
