package com.example.tool;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Toast;

public class BaseActivity extends Activity {
	private boolean isExit = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isExit == false) {
				isExit = true;
				Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_LONG).show();
				handler.sendEmptyMessageDelayed(0, 2000);
				return false;
			}
			else {
				MyApplication.instance().exit();
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			isExit = false; // 取消退出标志位
		};
	};
}
