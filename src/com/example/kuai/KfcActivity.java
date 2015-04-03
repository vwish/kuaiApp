package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class KfcActivity extends Activity implements OnClickListener {
	private ImageView first;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.kfc);

		init();

	}

	public void init() {
		first = (ImageView) findViewById(R.id.first);
		first.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.first:
			startActivity(new Intent(KfcActivity.this, Main.class));
			finish();
			break;
		}

	}

}
