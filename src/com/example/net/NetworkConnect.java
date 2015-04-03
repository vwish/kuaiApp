package com.example.net;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.entity.Constant;

public class NetworkConnect {
	String hostIp = Constant.HOST_IP;
	String result;

	public String postConnect(String urlString, List<NameValuePair> params) {
		// 第一步，创建HttpPost对象
		hostIp = hostIp + urlString;
		HttpPost httpPost = new HttpPost(hostIp);
		HttpResponse httpResponse = null;
		try {
			// 设置httpPost请求参数
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			httpResponse = new DefaultHttpClient().execute(httpPost);
			if (200 == httpResponse.getStatusLine().getStatusCode()) {
				result = EntityUtils.toString(httpResponse.getEntity());
			}
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "linkederror";
		}
		catch (IOException e) {
			e.printStackTrace();
			result = "linkederror";
		}
		return result;
	}

	public String getConnect(String url) {
		String getURL = hostIp + url;
		HttpGet httpGet = new HttpGet(getURL);
		HttpResponse httpResponse = null;
		try {
			httpResponse = new DefaultHttpClient().execute(httpGet);
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			try {
				result = EntityUtils.toString(httpResponse.getEntity());
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
