package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class XiangchishenmeActivity extends Activity implements OnClickListener{
	private Button first;
	private TextView fabu;
	private EditText name,jiage,fenshu,fujiashuoming;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xiangchishenme);
		init();
	}
	public void init(){
		first=(Button)findViewById(R.id.first);
		fabu=(TextView)findViewById(R.id.fabu);
		
		//注册所有控件点击事件
		fabu.setOnClickListener(this);
		first.setOnClickListener(this);
		
	}
	public boolean shifouweikong(){
		name=(EditText)findViewById(R.id.name);
		jiage=(EditText)findViewById(R.id.jiage);
		fenshu=(EditText)findViewById(R.id.fenshu);
		fujiashuoming=(EditText)findViewById(R.id.fujiaqingqiu);
		
		if(name.getText().toString()==null||name.getText().toString().equals("")||
				jiage.getText().toString()==null||jiage.getText().toString().equals("")||
				fenshu.getText().toString()==null||fenshu.getText().toString().equals(""))
		return false;
		else
			return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.first:
			startActivity(new Intent(XiangchishenmeActivity.this,Main.class));
			finish();
			break;
		case R.id.fabu:
			if(shifouweikong())
			new AlertDialog.Builder(this)
			.setTitle("温馨提示")
			.setMessage("订单发布成功，等待商家响应！")
			.setPositiveButton("确定",new DialogInterface.OnClickListener() 
  			{
  				public void onClick(DialogInterface dialog, int whichButton)
  				{
  					startActivity(new Intent(XiangchishenmeActivity.this, Main.class));
  				}
  			})
			.show();
			else
			new AlertDialog.Builder(this)
			.setTitle("温馨提示")
			.setMessage("请完善订单后再提交")
			.setPositiveButton("确定",null)
			.show();
			break;
		
		}
		
	}

}
