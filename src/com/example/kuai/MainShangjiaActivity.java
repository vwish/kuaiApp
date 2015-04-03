package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainShangjiaActivity extends Activity implements OnClickListener{
	private Button back;
	private LinearLayout shangjiafenleibt,zhinengpaixubt;
	private LinearLayout kfc,shishang,CaoCao,jiaxiang,zhengongfu,meishijia;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        MyApplication.instance().addActivity(this);
	        setContentView(R.layout.main_shangjia);
	        init();
	 }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.first:
			startActivity(new Intent(MainShangjiaActivity.this,Main.class));
			finish();
			break;
		case R.id.shangjiafenleibt:
			startActivity(new Intent(MainShangjiaActivity.this,ShangjiafenleiActivity.class));
			break;
		case R.id.zhinengpaixubt:
			startActivity(new Intent(MainShangjiaActivity.this,ShangjiazhinengpaixuActivity.class));
			break;
		case R.id.kfc:
			startActivity(new Intent(MainShangjiaActivity.this,KfcActivity.class));
			break;
		case R.id.shishang:
			startActivity(new Intent(MainShangjiaActivity.this,ShiShangActivity.class));
			break;
		case R.id.CaoCao:
			startActivity(new Intent(MainShangjiaActivity.this,CaoCaoActivity.class));
			break;
		case R.id.jiaxiang:
			startActivity(new Intent(MainShangjiaActivity.this,JiaXiangActivity.class));
			break;
		case R.id.zhengongfu:
			startActivity(new Intent(MainShangjiaActivity.this,ZhenGongFuActivity.class));
			break;
		case R.id.meishijia:
			startActivity(new Intent(MainShangjiaActivity.this,MeiShiJiaActivity.class));
			break;
			default :
				Toast.makeText(getApplicationContext(), "无法连接服务器", Toast.LENGTH_LONG).show();
		}
	}
	public void init(){
		back=(Button)findViewById(R.id.first);
		shangjiafenleibt=(LinearLayout)findViewById(R.id.shangjiafenleibt);
		zhinengpaixubt=(LinearLayout)findViewById(R.id.zhinengpaixubt);
		kfc=(LinearLayout)findViewById(R.id.kfc);
		shishang=(LinearLayout)findViewById(R.id.shishang);
		CaoCao=(LinearLayout)findViewById(R.id.CaoCao);
		jiaxiang=(LinearLayout)findViewById(R.id.jiaxiang);
		zhengongfu=(LinearLayout)findViewById(R.id.zhengongfu);
		meishijia=(LinearLayout)findViewById(R.id.meishijia);
		
		kfc.setOnClickListener(this);
		shangjiafenleibt.setOnClickListener(this);
		zhinengpaixubt.setOnClickListener(this);
		back.setOnClickListener(this);
		shishang.setOnClickListener(this);
		CaoCao.setOnClickListener(this);
		jiaxiang.setOnClickListener(this);
		zhengongfu.setOnClickListener(this);
		meishijia.setOnClickListener(this);
		
	}
}
