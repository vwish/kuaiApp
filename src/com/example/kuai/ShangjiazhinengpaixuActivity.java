package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ShangjiazhinengpaixuActivity extends Activity {
	private RadioGroup zhinengpaixu;

	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.shangjiazhinengpaixu);
		init();
	}

	public void init() {
		zhinengpaixu = (RadioGroup) findViewById(R.id.zhinengpaixu);
		zhinengpaixu.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				finish();

			}

		});

	}

	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

}
