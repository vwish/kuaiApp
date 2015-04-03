package com.example.tool;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class MyApplication {
	public static MyApplication instance;
	private List<Activity> list=new LinkedList<Activity>();
	public MyApplication(){
	}
	//����ģʽ��ȡΨһ��myapplicationʵ��
	public static MyApplication instance(){
		if(null==instance)
			instance=new MyApplication();
		return instance;
	}
	//��activity��ӵ�������
	public void addActivity(Activity activity){
		list.add(activity);
	}
	//�������е�activity����finish��
	public void exit(){
		for(Activity activity :list ){
			activity.finish();
		}
		System.exit(0);
	}
}
