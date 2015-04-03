package com.example.kuai;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.data.DatabaseHelper;
import com.example.model.User;
import com.example.net.NetworkConnect;
import com.example.tool.BaseActivity;
import com.example.tool.MyApplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends BaseActivity implements OnClickListener {
	public static ProfileActivity instance = null;
	private Button login, firstPage;
	private ImageButton gengduo;
	private EditText phoneNumberEditText, passwordEditText;
	private TextView regist;
	private DatabaseHelper mOpenHelper;
	private LinearLayout shoucanglay, jifenlay, pingjialay, dizhilay, shezhilay, xiangchishenmelay;
	private String phoneNumber, password;
	private List<NameValuePair> param;
	private Intent mainActivityIntent, loadingIntent;// intent为登录成功后启动的界面，intent2为用户提示界面

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		mOpenHelper = new DatabaseHelper(this);

		// 判断当前用户是否登陆，若登陆则直接显示用户的其他信息，否则提示用户登录
		if (mOpenHelper.query() != 0) {
			setContentView(R.layout.self);
			instance = this;
			showUserProfile();
		}
		else {
			// 登陆成功后将账号和密码存入本地数据库中 mOpenHelper.insertItem("13551031965", "123");
			setContentView(R.layout.login);
			initLogin();
		}
	}

	public void showUserProfile() {
		shoucanglay = (LinearLayout) findViewById(R.id.shoucanglay);
		jifenlay = (LinearLayout) findViewById(R.id.jifenlay);
		pingjialay = (LinearLayout) findViewById(R.id.pingjialay);
		dizhilay = (LinearLayout) findViewById(R.id.dizhilay);
		shezhilay = (LinearLayout) findViewById(R.id.shezhilay);
		xiangchishenmelay = (LinearLayout) findViewById(R.id.xiangchishenmelay);

		firstPage = (Button) findViewById(R.id.shouyebt);
		gengduo = (ImageButton) findViewById(R.id.gengduo);

		gengduo.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				startActivity(new Intent(ProfileActivity.this, MoreDialogActivity.class));
			}
		});
		shoucanglay.setOnClickListener(this);
		jifenlay.setOnClickListener(this);
		pingjialay.setOnClickListener(this);
		dizhilay.setOnClickListener(this);
		shezhilay.setOnClickListener(this);
		firstPage.setOnClickListener(this);
		xiangchishenmelay.setOnClickListener(this);
	}

	public void initLogin() {
		login = (Button) findViewById(R.id.login);
		phoneNumberEditText = (EditText) findViewById(R.id.name);
		passwordEditText = (EditText) findViewById(R.id.password);
		regist = (TextView) findViewById(R.id.regist);

		login.setOnClickListener(this);
		regist.setOnClickListener(this);
	}

	// 处理各种点击事件
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shoucanglay:
			startActivity(new Intent(ProfileActivity.this, WodeshoucangActivity.class));
			break;

		case R.id.pingjialay:
			break;

		case R.id.dizhilay:
			break;

		case R.id.shezhilay:
			break;

		case R.id.shouyebt:
			Intent intent = new Intent(ProfileActivity.this, Main.class);
			startActivity(intent);
			break;

		case R.id.regist:
			startActivity(new Intent(ProfileActivity.this, TianxieshoujihaoActivity.class));
			break;

		case R.id.login:

			phoneNumberEditText = (EditText) findViewById(R.id.name);
			passwordEditText = (EditText) findViewById(R.id.password);

			phoneNumber = phoneNumberEditText.getText().toString();
			password = passwordEditText.getText().toString();

			mainActivityIntent = new Intent(ProfileActivity.this, Main.class);
			loadingIntent = new Intent(ProfileActivity.this, JingduActivity.class);

			param = new ArrayList<NameValuePair>();

			param.add(new BasicNameValuePair("user.user_phonenumber", phoneNumber));
			param.add(new BasicNameValuePair("user.user_password", password));

			// 开始执行异步任务
			HttpAsyncTask1 httptask = new HttpAsyncTask1();
			httptask.execute("KBD/User/login");
			break;

		case R.id.xiangchishenmelay:
			startActivity(new Intent(ProfileActivity.this, XiangchishenmeActivity.class));
			break;
		}
	}

	protected void onDestroy() {
		super.onDestroy();
		if (mOpenHelper != null) {
			mOpenHelper.close();
		}
	}

	public User getUser(JSONObject userJSON) throws JSONException {
		User user = new User();

		user.setUserId(userJSON.getString("user_id"));
		user.setUserAddress(userJSON.getString("user_address"));
		user.setUserImageUrl(userJSON.getString("user_image_url"));
		user.setUserName(userJSON.getString("user_name"));
		user.setUserpassword(userJSON.getString("user_password"));

		return user;
	}

	// 异步任务类处理用户登录事件
	public class HttpAsyncTask1 extends AsyncTask<String, Integer, String> {

		protected String doInBackground(String... params) {
			NetworkConnect connpost = new NetworkConnect();
			String result = null;
			result = connpost.postConnect(params[0], param);
			return result;
		}

		protected void onPostExecute(String result) {
			try {
				JSONObject jsonResponse = new JSONObject(result);

				String message = jsonResponse.getString("status");
				if (message.equals("20001")) {
					Toast.makeText(ProfileActivity.this, "登录成功", Toast.LENGTH_LONG).show();

					JSONObject userJson = new JSONObject(jsonResponse.getString("user"));
					mOpenHelper.insertUser(getUser(userJson));
					startActivity(mainActivityIntent);
					JingduActivity.ActivityA.finish();
					ProfileActivity.this.finish();
				}
				else if (message.equals("20003")) {
					Toast.makeText(ProfileActivity.this, "用户名或密码不正确请重新输入", Toast.LENGTH_LONG).show();
					JingduActivity.ActivityA.finish();
				}
				else if (message.equals("linkederror")) {
					Toast.makeText(ProfileActivity.this, "服务器连接错误", Toast.LENGTH_LONG).show();
					JingduActivity.ActivityA.finish();
				}
				else {
					Toast.makeText(ProfileActivity.this, "该用户被禁用", Toast.LENGTH_LONG).show();
					JingduActivity.ActivityA.finish();
				}
			}
			catch (JSONException e) {
				Toast.makeText(ProfileActivity.this, "网络连接异常", Toast.LENGTH_LONG).show();
			}
			finally {
				if (mOpenHelper != null) {
					mOpenHelper.close();
				}
			}
		}

		protected void onPreExecute() {
			startActivity(loadingIntent);
		}
	}
}
