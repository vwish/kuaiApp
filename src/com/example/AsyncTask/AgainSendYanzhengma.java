package com.example.AsyncTask;

import java.util.List;

import org.apache.http.NameValuePair;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class AgainSendYanzhengma extends AsyncTask<String, Integer, String> {
	
	String phone;
	
	List<NameValuePair> param;
	public AgainSendYanzhengma(List<NameValuePair> params){
		param=params;
	}
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
