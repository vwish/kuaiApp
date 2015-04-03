package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Main extends TabActivity {
	private TabHost tabHost;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.main);

		// 界面初始化
		tabHost = this.getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, SiteActivity.class);
		spec = tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, MyExamActivity.class);
		spec = tabHost.newTabSpec("餐车").setIndicator("餐车").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ProfileActivity.class);
		spec = tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, DinnerPositionActivity.class);
		spec = tabHost.newTabSpec("状态").setIndicator("状态").setContent(intent);
		tabHost.addTab(spec);

		// 获取返回的状态码
		Intent intent1 = this.getIntent();
		int backstate = intent1.getIntExtra("state", 0);

		tabHost.setCurrentTab(backstate);
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);

		if (backstate == 1) {
			radioGroup.check(R.id.main_tab_dinnerCart);
		}

		// 在用户注册处若用户点击返回则设置我的为选中状态
		else if (backstate == 2) {
			radioGroup.check(R.id.main_tab_profile);
		}

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_tab_siteshow:
					tabHost.setCurrentTabByTag("首页");
					break;

				case R.id.main_tab_dinnerCart:
					tabHost.setCurrentTabByTag("餐车");
					break;

				case R.id.main_tab_profile:
					tabHost.setCurrentTabByTag("我的");
					break;

				case R.id.main_tab_settings:
					tabHost.setCurrentTabByTag("状态");
					break;
				default:
					break;
				}
			}
		});
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}
}
