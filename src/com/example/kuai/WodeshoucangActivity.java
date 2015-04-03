package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class WodeshoucangActivity extends Activity implements OnClickListener {
	private Button first;
	private RadioGroup shoucang;
	private TextView guanliwodeshoucang;
	private RadioButton caipingshoucang, shangjiashoucang;

	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		this.setContentView(R.layout.wodeshoucang);
		init();

	}

	public void init() {
		shoucang = (RadioGroup) findViewById(R.id.shoucang);
		caipingshoucang = (RadioButton) findViewById(R.id.caipingshoucai);
		shangjiashoucang = (RadioButton) findViewById(R.id.shangjiashoucang);
		final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout lin = (LinearLayout) findViewById(R.id.LinearLayout01);
		guanliwodeshoucang = (TextView) findViewById(R.id.guanliwodeshoucang);

		guanliwodeshoucang.setOnClickListener(this);
		// ��̬������ʾЧ��
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.addcaiping, null).findViewById(R.id.addcaiping);
		lin.removeAllViews();
		lin.addView(layout);

		shoucang.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (R.id.shangjiashoucang == checkedId) {
					caipingshoucang.setText(Html.fromHtml("<font color = #C7C7C7>�ղصĲ�Ʒ</font>"));
					shangjiashoucang.setText(Html.fromHtml("<font color = red>�ղص��̼�</font>"));
					LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.addshangjia, null).findViewById(R.id.addshangjia);
					lin.removeAllViews();
					lin.addView(layout);
				}
				else {
					caipingshoucang.setText(Html.fromHtml("<font color = red>�ղصĲ�Ʒ</font>"));
					shangjiashoucang.setText(Html.fromHtml("<font color = #C7C7C7>�ղص��̼�</font>"));
					LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.addcaiping, null).findViewById(R.id.addcaiping);
					lin.removeAllViews();
					lin.addView(layout);

				}

			}

		});

		first = (Button) findViewById(R.id.first);
		first.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {

		case R.id.first:
			startActivity(new Intent(WodeshoucangActivity.this, Main.class));
			finish();
			break;
		case R.id.guanliwodeshoucang:

			new AlertDialog.Builder(this).setTitle("������ʾ").setMessage("�����ҵ��ղػ�û��������").setPositiveButton("ȷ��", null).show();
			break;

		}

	}
}
