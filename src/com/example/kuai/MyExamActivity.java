package com.example.kuai;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.AsyncTask.HttpAsyncTask;
import com.example.data.DatabaseHelper;
import com.example.tool.BaseActivity;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyExamActivity extends BaseActivity implements OnClickListener{
	private DatabaseHelper mOpenHelper;
	private Button login,first;
	private EditText phonenumber, password,number;
	private TextView queren,price,regist;
	private String pricetext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		mOpenHelper = new DatabaseHelper(this);
		
		//获取AddExamActivity传递过来的值
		pricetext=this.getIntent().getStringExtra("price");
		if(pricetext==null)
		{
			pricetext="12";
		}
		if (mOpenHelper.query()!=0) {
			setContentView(R.layout.canche);
			initCanche();
		} else {
			setContentView(R.layout.login);
			initLogin();
		}
	}	
	public void initCanche(){
		queren=(TextView)findViewById(R.id.queren);
		first=(Button)findViewById(R.id.first);
		number=(EditText)findViewById(R.id.number);
		price=(TextView)findViewById(R.id.price);
		number.setText("1");
		
		first.setOnClickListener(this);
		queren.setOnClickListener(this);
	}
	
	public void initLogin() {
		login = (Button) findViewById(R.id.login);
		regist=(TextView)findViewById(R.id.regist);
		
		login.setOnClickListener(this);
		regist.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.shoucanglay:
			break;
		case R.id.login:
			phonenumber = (EditText) findViewById(R.id.name);
			password = (EditText) findViewById(R.id.password);
			String phon=phonenumber.getText().toString();
			String userpassword=password.getText().toString();
			if("".equals(phon)|"".equals(userpassword));
			
			//异步任务处理网络连接
			Intent myintent=new Intent(MyExamActivity.this,Main.class);
			Intent myintent2=new Intent(MyExamActivity.this,JingduActivity.class);
			List<NameValuePair> param = new ArrayList<NameValuePair>(); 
		     param.add(new BasicNameValuePair("user.user_phonenumber",phon)); 
		     param.add(new BasicNameValuePair("user.user_password",userpassword)); 
			HttpAsyncTask httptask=new HttpAsyncTask(MyExamActivity.this,myintent,myintent2,"login",param);
			httptask.execute("KBD/User/postOrder",phon,userpassword);
			break;
			
		case R.id.queren:
			Intent intent=new Intent(MyExamActivity.this,TijiaodingdaoActivity.class);
			if(Integer.parseInt(number.getText().toString())<1)
				new AlertDialog.Builder(this)
			.setTitle("温馨提示")
			.setMessage("请输入正确的份数")
			.setPositiveButton("确认",null)
			.show();
			else{
			intent.putExtra("price", pricetext);
			intent.putExtra("number", number.getText().toString());
			startActivity(intent);
			}
			break;
		case R.id.first:
			startActivity(new Intent(MyExamActivity.this,Main.class));
			finish();
			break;
		case R.id.regist:
			startActivity(new Intent(MyExamActivity.this,TianxieshoujihaoActivity.class));
			break;
		}
	}
}
