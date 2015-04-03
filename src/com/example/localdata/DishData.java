package com.example.localdata;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.entity.Constant;
import com.example.kuai.R;

public class DishData {
	//封装数据用于本地显示
	public ArrayList<HashMap<String, Object>> getLocalData(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		map = new HashMap<String, Object>();

		map.put(Constant.KEY_DISHNAME, "鱼香肉丝炒饭");
		map.put(Constant.KEY_BUSINESSNAME, "食尚中式快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥12");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "已售121份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.yuxiaoyousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "土豆盖浇饭");
		map.put(Constant.KEY_BUSINESSNAME, "曹操外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"86%");
		map.put(Constant.KEY_FENSHU, "已售46份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.tudougaijiao);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "北京烤鸭");
		map.put(Constant.KEY_BUSINESSNAME, "佳香快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"67%");
		map.put(Constant.KEY_FENSHU, "已售130份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.beijingkaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "什锦蛋炒饭");
		map.put(Constant.KEY_BUSINESSNAME, "营养快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥13");
		map.put(Constant.KEY_HAOPING,"87%");
		map.put(Constant.KEY_FENSHU, "已售230份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shijinchaofan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "金针菇肉丝");
		map.put(Constant.KEY_BUSINESSNAME, "香香外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "已售213份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.jinzhengurousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "蒜泥白肉");
		map.put(Constant.KEY_BUSINESSNAME, "曹操外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥11");
		map.put(Constant.KEY_HAOPING,"55%");
		map.put(Constant.KEY_FENSHU, "已售148份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.suannibairou);
		list.add(map);
		
		return list;
	} 
	
	/**
	 * 封装所有菜品中的显示分类
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getLocalDataAllcaiping(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		map = new HashMap<String, Object>();
		
		map.put(Constant.KEY_DISHNAME, "鱼香肉丝炒饭");
		map.put(Constant.KEY_BUSINESSNAME, "食尚中式快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥12");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "已售121份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.yuxiaoyousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "土豆盖浇饭");
		map.put(Constant.KEY_BUSINESSNAME, "曹操外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"86%");
		map.put(Constant.KEY_FENSHU, "已售46份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.tudougaijiao);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "北京烤鸭");
		map.put(Constant.KEY_BUSINESSNAME, "佳香快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"67%");
		map.put(Constant.KEY_FENSHU, "已售130份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.beijingkaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "什锦蛋炒饭");
		map.put(Constant.KEY_BUSINESSNAME, "营养快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥13");
		map.put(Constant.KEY_HAOPING,"87%");
		map.put(Constant.KEY_FENSHU, "已售230份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shijinchaofan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "金针菇肉丝");
		map.put(Constant.KEY_BUSINESSNAME, "香香外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥10");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "已售213份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.jinzhengurousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "蒜泥白肉");
		map.put(Constant.KEY_BUSINESSNAME, "曹操外卖");
		map.put(Constant.KEY_DISH_PRICE,"￥11");
		map.put(Constant.KEY_HAOPING,"55%");
		map.put(Constant.KEY_FENSHU, "已售148份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.suannibairou);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "卤肉饭");
		map.put(Constant.KEY_BUSINESSNAME, "同学快餐");
		map.put(Constant.KEY_DISH_PRICE,"￥20");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "已售76份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.luroufan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "烤鸭");
		map.put(Constant.KEY_BUSINESSNAME, "曹氏鸭脖");
		map.put(Constant.KEY_DISH_PRICE,"￥35");
		map.put(Constant.KEY_HAOPING,"90%");
		map.put(Constant.KEY_FENSHU, "已售21份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.kaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "水煮肉片");
		map.put(Constant.KEY_BUSINESSNAME, "雨天饭店");
		map.put(Constant.KEY_DISH_PRICE,"￥18");
		map.put(Constant.KEY_HAOPING,"97%");
		map.put(Constant.KEY_FENSHU, "已售46份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shuizhuroupian);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "夫妻肺片");
		map.put(Constant.KEY_BUSINESSNAME, "催香基");
		map.put(Constant.KEY_DISH_PRICE,"￥17");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "已售72份");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.fuqifeipian);
		list.add(map);
		
		return list;
	} 
	/**
	 * 存储所有用户
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getLocalDataAlluser(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "OutMan");
		map.put(Constant.KEY_USERJIFEN, "积分：1420");
		map.put(Constant.KEY_USERPAIMING,"排名：1");
		map.put(Constant.KEY_HASNUMBER,"已完成314笔");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man1);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "韩梅梅");
		map.put(Constant.KEY_USERJIFEN, "积分：1025");
		map.put(Constant.KEY_USERPAIMING,"排名：2");
		map.put(Constant.KEY_HASNUMBER,"已完成311笔");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "ChenQQ");
		map.put(Constant.KEY_USERJIFEN, "积分：950");
		map.put(Constant.KEY_USERPAIMING,"排名：3");
		map.put(Constant.KEY_HASNUMBER,"已完成300笔");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man3);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "李雪");
		map.put(Constant.KEY_USERJIFEN, "积分：920");
		map.put(Constant.KEY_USERPAIMING,"排名：4");
		map.put(Constant.KEY_HASNUMBER,"已完成267笔");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man4);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "张露");
		map.put(Constant.KEY_USERJIFEN, "积分：900");
		map.put(Constant.KEY_USERPAIMING,"排名：5");
		map.put(Constant.KEY_HASNUMBER,"已完成252笔");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man5);
		list.add(map);
		
		return list;
	}
}
