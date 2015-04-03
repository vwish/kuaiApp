package com.example.kuai;

import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Search extends Activity implements OnClickListener{
	private Button search;
	private EditText keyword;
	private ImageView back;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.search);
		init();
	}
	public void init(){
		search=(Button)findViewById(R.id.search);
		back=(ImageView)findViewById(R.id.back);
		
		
		keyword=(EditText)findViewById(R.id.keyword);
		search.setOnClickListener(this);
		back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.search:
			if(keyword.getText().toString().equals("����"))
				startActivity(new Intent(Search.this,ResultSearchActivity.class));
				else
					new AlertDialog.Builder(this)
				.setTitle("������ʾ")
				.setMessage("Ŀǰϵͳֻ����������")
				.setPositiveButton("ȷ��",null)
				.show();
			break;
		case R.id.back:
			startActivity(new Intent(Search.this,Main.class));
			finish();
			break;
		}
		
	}
}
