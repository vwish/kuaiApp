package com.example.AsyncTask;

import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.data.DatabaseHelper;
import com.example.kuai.JingduActivity;
import com.example.net.NetworkConnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class TianxieshoujiTask extends AsyncTask<String, Integer, String> {
	Context context;
	String phone;
	Intent intent,intent2;//intent2Ϊ�û��ȴ�����
	List<NameValuePair> param;
	public TianxieshoujiTask(Context context,Intent intent,List<NameValuePair> params,Intent intent2){
		this.context=context;
		this.intent=intent;
		this.intent2=intent2;
		param=params;
	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		phone=params[1];
		//����post��ʽ�ύ����
		NetworkConnect connpost=new NetworkConnect();
		String result=null;
		result=connpost.postConnect(params[0],param);
		return result;
	}
	@Override
	protected void onPostExecute(String result) {
		//super.onPostExecute(result);
		try {
			JSONObject jsonObject = new JSONObject(result);
			String message=jsonObject.getString("message");
			intent.putExtra("phone", phone);
			
			if(message!=null&&!(message.equals("hasregist")))
			{
			intent.putExtra("yanzhengma", message);
			context.startActivity(intent);
			}
			else
				Toast.makeText(context, "���û��Ѿ�ע�ᣬ��������ע��",Toast.LENGTH_LONG).show();
		} catch (JSONException e) {
			Toast.makeText(context, "���������쳣",Toast.LENGTH_LONG).show();
			JingduActivity.ActivityA.finish();
		}
	}
	@Override
	protected void onPreExecute() {
		//�����ȴ�����
		context.startActivity(intent2);
	}
}
