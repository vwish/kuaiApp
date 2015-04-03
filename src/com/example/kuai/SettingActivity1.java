package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SettingActivity1 extends Activity implements OnClickListener {
	private Button first;
	private TextView xiayigedingdan;
	private RadioButton dingdanzhuangtai, chakanxiangqing;
	private RadioGroup zhuangtai;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.setting);
		init();
	}
	public void init(){
		first=(Button)findViewById(R.id.first);
		xiayigedingdan=(TextView)findViewById(R.id.xiayigedingdan);
		zhuangtai = (RadioGroup) findViewById(R.id.zhuangtai);
		dingdanzhuangtai = (RadioButton) findViewById(R.id.dingdanzhuangtai);
		chakanxiangqing = (RadioButton) findViewById(R.id.chakanxiangqing);

		//动态增加显示效果
		final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout lin = (LinearLayout) findViewById(R.id.Linear1);
		LinearLayout layout = (LinearLayout) inflater.inflate(
				R.layout.adddingdangzhuangtai, null).findViewById(R.id.adddingdang);
		lin.removeAllViews();
		lin.addView(layout);
		
		first.setOnClickListener(this);
		xiayigedingdan.setOnClickListener(this);
		
		//为单选按钮框添加按钮点击事件
		//当用户点击订单状态的时候订单状态为红色，查看详情为灰色，反之则显示效果相反
		zhuangtai.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (R.id.dingdanzhuangtai == checkedId) {
					dingdanzhuangtai.setText(Html
							.fromHtml("<font color = red>订单状态</font>"));
					chakanxiangqing.setText(Html
							.fromHtml("<font color = #C7C7C7>查看详情</font>"));
					LinearLayout layout = (LinearLayout) inflater.inflate(
							R.layout.adddingdangzhuangtai, null).findViewById(R.id.adddingdang);
					lin.removeAllViews();
					lin.addView(layout);
				} else {
					dingdanzhuangtai.setText(Html
						.fromHtml("<font color = #C7C7C7>订单状态</font>"));
				chakanxiangqing.setText(Html
						.fromHtml("<font color = red>查看详情</font>"));
				LinearLayout layout = (LinearLayout) inflater.inflate(
						R.layout.addditu, null).findViewById(R.id.ditu);
				lin.removeAllViews();
				lin.addView(layout);

				}

			}

		});
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.first:
			startActivity(new Intent(SettingActivity1.this, Main.class));
			finish();
			break;
		case R.id.xiayigedingdan:
			new AlertDialog.Builder(this)
			.setTitle("操作提示")
			.setMessage("只有一个订单！")
			.setPositiveButton("确定",null)
			.show();
			break;
		}
		
	}
}
