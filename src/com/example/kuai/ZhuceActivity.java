package com.example.kuai;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.AsyncTask.HttpAsyncTask;
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

public class ZhuceActivity  extends Activity implements
OnClickListener {
	private Button back,submit;
	private EditText name,password,repassword;
	private String phone;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.zhuce);
		//����ǰ�洫�ݹ����ĵ绰����
		Intent intent1 = this.getIntent();  
		phone= intent1.getStringExtra("shouji");
		init();
	}
	public void init(){
		back=(Button)findViewById(R.id.back);
		submit=(Button)findViewById(R.id.submit);
		password=(EditText)findViewById(R.id.password);
		repassword=(EditText)findViewById(R.id.repassword);
		name=(EditText)findViewById(R.id.name);
		
		submit.setOnClickListener(this);
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.back:
			startActivity(new Intent(ZhuceActivity.this,TianxieyanzhengmaActivity.class));
			finish();
			break;
		case R.id.submit:
			String pw=password.getText().toString();
			String rpw=repassword.getText().toString();
			String username=name.getText().toString();

			Intent myintent=new Intent(ZhuceActivity.this,Main.class);
			Intent myintent2=new Intent(ZhuceActivity.this,JingduActivity.class);

			if(!pw.equals(rpw))
				Toast.makeText(getApplicationContext(), "�����������벻һ������������", Toast.LENGTH_LONG).show();
			else
				//�����������ע����Ϣ
			{
				//post��ʽ��Ҫ���ݵĲ���
				List<NameValuePair> param = new ArrayList<NameValuePair>(); 
			     param.add(new BasicNameValuePair("user.user_name",username)); 
			     param.add(new BasicNameValuePair("user.user_phonenumber",phone)); 
			     param.add(new BasicNameValuePair("user.user_password",pw)); 
				HttpAsyncTask httptask=new HttpAsyncTask(ZhuceActivity.this,myintent,myintent2,"regist",param);
				httptask.execute("KBD/User/register",phone,pw);
		}
			break;
		}
		
	}

}
