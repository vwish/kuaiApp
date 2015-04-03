package com.example.tool;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class MyApplication {
	public static MyApplication instance;
	private List<Activity> list=new LinkedList<Activity>();
	public MyApplication(){
	}
	//单例模式获取唯一的myapplication实例
	public static MyApplication instance(){
		if(null==instance)
			instance=new MyApplication();
		return instance;
	}
	//将activity添加到容器中
	public void addActivity(Activity activity){
		list.add(activity);
	}
	//遍历所有的activity并且finish掉
	public void exit(){
		for(Activity activity :list ){
			activity.finish();
		}
		System.exit(0);
	}
}
