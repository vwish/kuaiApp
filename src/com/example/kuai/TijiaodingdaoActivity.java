package com.example.kuai;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.data.DatabaseHelper;
import com.example.net.NetworkConnect;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TijiaodingdaoActivity extends Activity implements OnClickListener {
	private TextView queren, name, address, phonenumber, total, dishname, info, num;
	private Button back;
	private List<NameValuePair> orderdata;
	private DatabaseHelper mOpenHelper;
	private Intent intent1;
	private String number, pricetext;

	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.tijiaodingdan);
		// ��ȡ��һ��Activity���ݹ���������
		intent1 = this.getIntent();
		number = intent1.getStringExtra("number");
		pricetext = intent1.getStringExtra("price");
		mOpenHelper = new DatabaseHelper(this);
		initview();
	}

	public void initview() {
		queren = (TextView) findViewById(R.id.queren);
		back = (Button) findViewById(R.id.back);

		name = (TextView) findViewById(R.id.name);
		address = (TextView) findViewById(R.id.address);
		phonenumber = (TextView) findViewById(R.id.phonenumber);
		dishname = (TextView) findViewById(R.id.dishname);
		info = (TextView) findViewById(R.id.info);
		num = (TextView) findViewById(R.id.num);

		total = (TextView) findViewById(R.id.total);
		// ������ʾ����

		total.setText("��" + String.valueOf(Integer.parseInt(number) * Integer.parseInt(pricetext)));
		num.setText(number);

		if (mOpenHelper.queryphonenumber() != null)
			phonenumber.setText(mOpenHelper.queryphonenumber());

		queren.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	// ��װ����
	public List<NameValuePair> getData() {
		orderdata = new ArrayList<NameValuePair>();
		orderdata.add(new BasicNameValuePair("order.order_user_id", name.getText().toString()));
		orderdata.add(new BasicNameValuePair("order.order_shangjia_id", "ʳ��"));
		orderdata.add(new BasicNameValuePair("order.order_dish_id", dishname.getText().toString()));
		orderdata.add(new BasicNameValuePair("order.order_address", address.getText().toString()));
		// orderdata.add(new
		// BasicNameValuePair("user.user_phonenumber",phonenumber.getText().toString()));
		orderdata.add(new BasicNameValuePair("order.order_price", pricetext.toString()));
		orderdata.add(new BasicNameValuePair("order.order_message", info.getText().toString()));
		// orderdata.add(new BasicNameValuePair("num",number));
		return orderdata;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.queren:
			Intent intentshow = new Intent(TijiaodingdaoActivity.this, JingduActivity.class);
			intentshow.putExtra("tishitext", "�����ѷ��ͣ����Ժ�......");
			new HttpAsyncTask(intentshow).execute();
			break;
		case R.id.back:
			Intent intent = new Intent(TijiaodingdaoActivity.this, Main.class);
			intent.putExtra("state", 1);
			startActivity(intent);
			finish();
		}
	}

	public void showDialog() {
		new AlertDialog.Builder(this).setTitle("��ܰ��ʾ").setMessage("�������ύ,�ȴ��̼�ȷ�ϣ�����").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				startActivity(new Intent(TijiaodingdaoActivity.this, Main.class));
			}
		}).show();
	}

	// ����һ�������ύ���ݵ�������
	public class HttpAsyncTask extends AsyncTask<String, Integer, String> {
		Intent intent;

		public HttpAsyncTask(Intent intent) {
			this.intent = intent;
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			NetworkConnect connpost = new NetworkConnect();
			String result = connpost.postConnect("KBD/User/postOrder", getData());
			Log.v(result, "====4");
			return result;
		}

		protected void onPostExecute(String result) {
			JSONObject jsonObject;
			try {
				// Toast.makeText(getApplicationContext(), "�޷�����222������",
				// Toast.LENGTH_LONG).show();
				JingduActivity.ActivityA.finish();
				jsonObject = new JSONObject(result);
				String message = jsonObject.getString("status");
				if (message.equals("20017")) {
					showDialog();
					Log.v(message, "====2");
				}
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "�޷����ӷ�����", Toast.LENGTH_LONG).show();
			}
		}

		protected void onPreExecute() {
			// �����ȴ�����
			startActivity(intent);
		}
	}
}
