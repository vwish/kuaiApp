package com.example.localdata;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.entity.Constant;
import com.example.kuai.R;

public class DishData {
	//��װ�������ڱ�����ʾ
	public ArrayList<HashMap<String, Object>> getLocalData(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		map = new HashMap<String, Object>();

		map.put(Constant.KEY_DISHNAME, "������˿����");
		map.put(Constant.KEY_BUSINESSNAME, "ʳ����ʽ���");
		map.put(Constant.KEY_DISH_PRICE,"��12");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "����121��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.yuxiaoyousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "�����ǽ���");
		map.put(Constant.KEY_BUSINESSNAME, "�ܲ�����");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"86%");
		map.put(Constant.KEY_FENSHU, "����46��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.tudougaijiao);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "������Ѽ");
		map.put(Constant.KEY_BUSINESSNAME, "������");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"67%");
		map.put(Constant.KEY_FENSHU, "����130��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.beijingkaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "ʲ��������");
		map.put(Constant.KEY_BUSINESSNAME, "Ӫ�����");
		map.put(Constant.KEY_DISH_PRICE,"��13");
		map.put(Constant.KEY_HAOPING,"87%");
		map.put(Constant.KEY_FENSHU, "����230��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shijinchaofan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "���빽��˿");
		map.put(Constant.KEY_BUSINESSNAME, "��������");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "����213��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.jinzhengurousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "�������");
		map.put(Constant.KEY_BUSINESSNAME, "�ܲ�����");
		map.put(Constant.KEY_DISH_PRICE,"��11");
		map.put(Constant.KEY_HAOPING,"55%");
		map.put(Constant.KEY_FENSHU, "����148��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.suannibairou);
		list.add(map);
		
		return list;
	} 
	
	/**
	 * ��װ���в�Ʒ�е���ʾ����
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getLocalDataAllcaiping(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		map = new HashMap<String, Object>();
		
		map.put(Constant.KEY_DISHNAME, "������˿����");
		map.put(Constant.KEY_BUSINESSNAME, "ʳ����ʽ���");
		map.put(Constant.KEY_DISH_PRICE,"��12");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "����121��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.yuxiaoyousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "�����ǽ���");
		map.put(Constant.KEY_BUSINESSNAME, "�ܲ�����");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"86%");
		map.put(Constant.KEY_FENSHU, "����46��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.tudougaijiao);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "������Ѽ");
		map.put(Constant.KEY_BUSINESSNAME, "������");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"67%");
		map.put(Constant.KEY_FENSHU, "����130��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.beijingkaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "ʲ��������");
		map.put(Constant.KEY_BUSINESSNAME, "Ӫ�����");
		map.put(Constant.KEY_DISH_PRICE,"��13");
		map.put(Constant.KEY_HAOPING,"87%");
		map.put(Constant.KEY_FENSHU, "����230��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shijinchaofan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "���빽��˿");
		map.put(Constant.KEY_BUSINESSNAME, "��������");
		map.put(Constant.KEY_DISH_PRICE,"��10");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "����213��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.jinzhengurousi);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "�������");
		map.put(Constant.KEY_BUSINESSNAME, "�ܲ�����");
		map.put(Constant.KEY_DISH_PRICE,"��11");
		map.put(Constant.KEY_HAOPING,"55%");
		map.put(Constant.KEY_FENSHU, "����148��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.suannibairou);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "±�ⷹ");
		map.put(Constant.KEY_BUSINESSNAME, "ͬѧ���");
		map.put(Constant.KEY_DISH_PRICE,"��20");
		map.put(Constant.KEY_HAOPING,"76%");
		map.put(Constant.KEY_FENSHU, "����76��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.luroufan);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "��Ѽ");
		map.put(Constant.KEY_BUSINESSNAME, "����Ѽ��");
		map.put(Constant.KEY_DISH_PRICE,"��35");
		map.put(Constant.KEY_HAOPING,"90%");
		map.put(Constant.KEY_FENSHU, "����21��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.kaoya);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "ˮ����Ƭ");
		map.put(Constant.KEY_BUSINESSNAME, "���췹��");
		map.put(Constant.KEY_DISH_PRICE,"��18");
		map.put(Constant.KEY_HAOPING,"97%");
		map.put(Constant.KEY_FENSHU, "����46��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.shuizhuroupian);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_DISHNAME, "���޷�Ƭ");
		map.put(Constant.KEY_BUSINESSNAME, "�����");
		map.put(Constant.KEY_DISH_PRICE,"��17");
		map.put(Constant.KEY_HAOPING,"93%");
		map.put(Constant.KEY_FENSHU, "����72��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.fuqifeipian);
		list.add(map);
		
		return list;
	} 
	/**
	 * �洢�����û�
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getLocalDataAlluser(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		
		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "OutMan");
		map.put(Constant.KEY_USERJIFEN, "���֣�1420");
		map.put(Constant.KEY_USERPAIMING,"������1");
		map.put(Constant.KEY_HASNUMBER,"�����314��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man1);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "��÷÷");
		map.put(Constant.KEY_USERJIFEN, "���֣�1025");
		map.put(Constant.KEY_USERPAIMING,"������2");
		map.put(Constant.KEY_HASNUMBER,"�����311��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "ChenQQ");
		map.put(Constant.KEY_USERJIFEN, "���֣�950");
		map.put(Constant.KEY_USERPAIMING,"������3");
		map.put(Constant.KEY_HASNUMBER,"�����300��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man3);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "��ѩ");
		map.put(Constant.KEY_USERJIFEN, "���֣�920");
		map.put(Constant.KEY_USERPAIMING,"������4");
		map.put(Constant.KEY_HASNUMBER,"�����267��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man4);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put(Constant.KEY_USERNAME, "��¶");
		map.put(Constant.KEY_USERJIFEN, "���֣�900");
		map.put(Constant.KEY_USERPAIMING,"������5");
		map.put(Constant.KEY_HASNUMBER,"�����252��");
		map.put(Constant.KEY_IMAGE_URL,R.drawable.man5);
		list.add(map);
		
		return list;
	}
}
