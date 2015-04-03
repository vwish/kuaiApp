package com.example.kuai;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Allcaiping extends Activity implements OnClickListener {
	private Button back;
	private RadioGroup allcaiping;
	private ListView list;
	private LazyAdapter adapter;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//����activity��ӵ�������ȥ
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.allcaiping);
		init();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.first:
			startActivity(new Intent(Allcaiping.this,Main.class));
			finish();
			break;
		}
	}
	public void init() {
		back=(Button)findViewById(R.id.first);
		allcaiping=(RadioGroup)findViewById(R.id.allcaiping);
		

		//��ʼ��listview��ͼ
		list = (ListView) findViewById(R.id.list);
		DishData dishdata=new DishData();
		adapter = new LazyAdapter(Allcaiping.this,dishdata.getLocalDataAllcaiping());
		list.setAdapter(adapter);
		//Ϊ��һ�б�����ӵ����¼�
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				switch(position){
				case 0: 
					Intent intent=new Intent(Allcaiping.this,DishDetail.class);
					intent.putExtra("price", "12");
					startActivity(intent);
				break;
				}
			}
		});

		allcaiping.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(group.getCheckedRadioButtonId())
				{
				case 0:
					
					break;
				case 1:
					break;
				case 2:
					break;
				}
				
			}
		});
		
		back.setOnClickListener(this);
	}

}
