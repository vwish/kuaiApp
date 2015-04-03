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

		// �����ʼ��
		tabHost = this.getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, SiteActivity.class);
		spec = tabHost.newTabSpec("��ҳ").setIndicator("��ҳ").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, MyExamActivity.class);
		spec = tabHost.newTabSpec("�ͳ�").setIndicator("�ͳ�").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ProfileActivity.class);
		spec = tabHost.newTabSpec("�ҵ�").setIndicator("�ҵ�").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, DinnerPositionActivity.class);
		spec = tabHost.newTabSpec("״̬").setIndicator("״̬").setContent(intent);
		tabHost.addTab(spec);

		// ��ȡ���ص�״̬��
		Intent intent1 = this.getIntent();
		int backstate = intent1.getIntExtra("state", 0);

		tabHost.setCurrentTab(backstate);
		RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.main_tab_group);

		if (backstate == 1) {
			radioGroup.check(R.id.main_tab_dinnerCart);
		}

		// ���û�ע�ᴦ���û���������������ҵ�Ϊѡ��״̬
		else if (backstate == 2) {
			radioGroup.check(R.id.main_tab_profile);
		}

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_tab_siteshow:
					tabHost.setCurrentTabByTag("��ҳ");
					break;

				case R.id.main_tab_dinnerCart:
					tabHost.setCurrentTabByTag("�ͳ�");
					break;

				case R.id.main_tab_profile:
					tabHost.setCurrentTabByTag("�ҵ�");
					break;

				case R.id.main_tab_settings:
					tabHost.setCurrentTabByTag("״̬");
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
