package com.example.kuai;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.AsyncTask.TianxieshoujiTask;
import com.example.tool.Checknumber;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TianxieshoujihaoActivity extends Activity implements
		OnClickListener {
	private Button back,next;
	private EditText shoujihao;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.tianxieshoujihao);
		init();
	}
	public void init(){
		back=(Button)findViewById(R.id.back);
		shoujihao=(EditText)findViewById(R.id.shoujihao);
		next=(Button)findViewById(R.id.next);
		
		next.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.back:
			int state=2;
			Intent intent1=new Intent(TianxieshoujihaoActivity.this,Main.class);
			intent1.putExtra("state", state);
			startActivity(intent1);
			//startActivity(new Intent(TianxieshoujihaoActivity.this,WodeActivity.class));
			finish();
			break;
		case R.id.next:
			String shouji=shoujihao.getText().toString();
			Intent intent=new Intent(TianxieshoujihaoActivity.this,TianxieyanzhengmaActivity.class);
			Intent intent2=new Intent(TianxieshoujihaoActivity.this,JingduActivity.class);
			intent2.putExtra("tishitext", "验证码已发送，请稍后......");
			intent.putExtra("shouji", shouji);
			Checknumber ck=new Checknumber();
			if(!(ck.isMobile(shouji)))
				Toast.makeText(getApplicationContext(), "手机号码不正确，请重新输入", Toast.LENGTH_LONG).show();
			else{
				List<NameValuePair> param = new ArrayList<NameValuePair>(); 
			     param.add(new BasicNameValuePair("phonenumber",shouji));
				TianxieshoujiTask tianxietask=new TianxieshoujiTask(TianxieshoujihaoActivity.this,intent,param,intent2);
				tianxietask.execute("getyanzhengma.action",shouji);
			}
		}
	}
}
