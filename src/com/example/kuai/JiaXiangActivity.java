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

public class JiaXiangActivity extends Activity implements OnClickListener{

	private ImageView fourth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.activity_jia_xiang);
		init();
	}

	public void init(){
		fourth=(ImageView)findViewById(R.id.fourth);
		fourth.setOnClickListener((OnClickListener) this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.fourth:
			startActivity(new Intent(JiaXiangActivity.this,Main.class));
			finish();
			break;
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jia_xiang, menu);
		return true;
	}

}
