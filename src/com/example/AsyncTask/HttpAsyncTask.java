package com.example.AsyncTask;

import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.data.DatabaseHelper;
import com.example.kuai.JingduActivity;
import com.example.kuai.ProfileActivity;
import com.example.net.NetworkConnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class HttpAsyncTask extends AsyncTask<String, Integer, String> {
	Context context;
	Intent intent;
	Intent intent2;
	String phon;
	String userpassword;
	String state;
	List<NameValuePair> param;
	private DatabaseHelper mOpenHelper;

	public HttpAsyncTask(Context context, Intent intent, Intent intent2, String state, List<NameValuePair> params) {
		this.context = context;
		this.intent = intent;
		this.intent2 = intent2;
		this.state = state;
		param = params;
	}

	// ��ȡ�������˵�����
	@Override
	protected String doInBackground(String... params) {
		phon = params[1];
		userpassword = params[2];
		// ����post��ʽ�ύ����
		NetworkConnect connpost = new NetworkConnect();
		String result = null;
		result = connpost.postConnect(params[0], param);
		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		// super.onPostExecute(result);
		try {
			JSONObject jsonObject = new JSONObject(result);
			String message = jsonObject.getString("status");
			if (message == null)
				Toast.makeText(context, "messageΪ��", Toast.LENGTH_LONG).show();
			mOpenHelper = new DatabaseHelper(context);
			if (message.equals("true") || message.equals("20005")) {
				if (state.equals("regist")) {
					Toast.makeText(context, "ע��ɹ�", Toast.LENGTH_LONG).show();
					JingduActivity.ActivityA.finish();
					((Activity) context).finish();
				}
				else if (state.equals("login")) {
					Toast.makeText(context, "��¼�ɹ�", Toast.LENGTH_LONG).show();
					// ��¼�ɹ������ݲ������ݿ�
					// mOpenHelper.insertUser(phon,userpassword);
					context.startActivity(intent);
					JingduActivity.ActivityA.finish();
					((Activity) context).finish();
				}
			}
			else if (message.equals("false") || message.equals("20007")) {
				if (state.equals("login")) {
					Toast.makeText(context, "�û��������벻��ȷ����������", Toast.LENGTH_LONG).show();
					JingduActivity.ActivityA.finish();
				}
				else if (state.equals("regist"))
					Toast.makeText(context, "���ֻ����ѱ�ע�ᣬ������ע��", Toast.LENGTH_LONG).show();
				JingduActivity.ActivityA.finish();
			}
			else {
				Toast.makeText(context, "���û�������", Toast.LENGTH_LONG).show();
				JingduActivity.ActivityA.finish();
			}
		}
		catch (JSONException e) {
			Toast.makeText(context, "���������쳣", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onPreExecute() {
		// �����ȴ�����
		context.startActivity(intent2);
	}
}
