package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class ResultSearchActivity extends Activity implements OnClickListener{
	private ImageView back;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.resultserch);
		init();
		
	}
	public void init(){
		back=(ImageView)findViewById(R.id.back);
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.back:
			startActivity(new Intent(ResultSearchActivity.this,Main.class));
			finish();
			break;
		}
	}

}
