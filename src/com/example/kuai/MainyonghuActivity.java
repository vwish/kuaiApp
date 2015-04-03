package com.example.kuai;

import com.example.listviewimage.AllUserAdapter;
import com.example.listviewimage.LazyAdapter;
import com.example.localdata.DishData;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainyonghuActivity extends Activity implements OnClickListener{
	private Button first;
	private ImageView gengduo;
	private ListView list;
	private AllUserAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.main_yonghu);
		init();
	}
	public void init(){
		//初始化listview视图
		list = (ListView) findViewById(R.id.list);
		DishData dishdata=new DishData();
		adapter = new AllUserAdapter(MainyonghuActivity.this,dishdata.getLocalDataAlluser());
		list.setAdapter(adapter);
		//为单一列表行添加单击事件
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(getApplicationContext(), "无法连接服务器", Toast.LENGTH_LONG).show();
			}
		});

		first=(Button)findViewById(R.id.first);
		gengduo=(ImageView)findViewById(R.id.gengduo);
		
		first.setOnClickListener(this);
		gengduo.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.first:
			startActivity(new Intent(MainyonghuActivity.this,Main.class));
			break;
		case R.id.gengduo:
			startActivity(new Intent(MainyonghuActivity.this,HuoyueyonghuActivity.class));
			break;
		}
		
	}

}
