package com.example.kuai;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.entity.Constant;
import com.example.tool.CustomDialog;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DishDetail extends Activity implements OnClickListener {
	private ImageView collectionImageView;
	private TextView lookmorepic, jiarucanche, lijigoumai;
	private TextView dishPriceTextView, shopNameTextView;
	private TextView commentCountTextView, hasSaledCountTextView;
	private TextView hasCommentCountTextView;
	private String pricetext;
	private HashMap<String, Object> dish;
	private boolean collectionImageViewChoosed = false;

	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		super.onCreate(savedInstanceState);

		// TODO ��ȡ��һ�����洫�ݹ���������
		dish = (HashMap<String, Object>) getIntent().getSerializableExtra("dish");
		Log.v("��ȡ��һ�����洫�ݹ����Ĳ�Ʒ�� ", (String) dish.get(Constant.KEY_DISHNAME));

		setContentView(R.layout.dish_detail);
		initView();
		showDishDetail();
		addEventListener();
	}

	public void initView() {
		lookmorepic = (TextView) findViewById(R.id.lookmorepic);
		jiarucanche = (TextView) findViewById(R.id.jiarucanche);
		lijigoumai = (TextView) findViewById(R.id.lijigoumai);
		commentCountTextView = (TextView) findViewById(R.id.commentCountTextView);
		shopNameTextView = (TextView) findViewById(R.id.shopNameTextView);
		dishPriceTextView = (TextView) findViewById(R.id.dishPriceTextView);
		collectionImageView = (ImageView) findViewById(R.id.collectionImageView);
		hasSaledCountTextView = (TextView) findViewById(R.id.hasSaledCountTextView);
		hasCommentCountTextView = (TextView) findViewById(R.id.hasCommentCountTextView);
	}

	public void showDishDetail() {
		dishPriceTextView.setText((String) dish.get(Constant.KEY_DISH_PRICE));
		shopNameTextView.setText((String) dish.get(Constant.KEY_BUSINESSNAME));
		commentCountTextView.setText((String) dish.get(Constant.KEY_HAOPING));
		hasSaledCountTextView.setText("����" + (String) dish.get(Constant.KEY_FENSHU));
		hasCommentCountTextView.setText("���������ݶ�");
	}

	public void addEventListener() {
		lookmorepic.setOnClickListener(this);
		jiarucanche.setOnClickListener(this);
		lijigoumai.setOnClickListener(this);
		collectionImageView.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lookmorepic:
			new AlertDialog.Builder(this).setTitle("��ܰ��ʾ").setMessage("�̼Һ�����ֻ����һ��ͼƬ").setPositiveButton("ȷ��", null).show();
			break;
		case R.id.jiarucanche:
			CustomDialog.Builder builder = new CustomDialog.Builder(this);
			builder.setMessage("�ò�Ʒ�����Ϊ�𱬣������ڶ���ĵ�1λ����ȴ��ղ�ʱ��ԼΪ10���ӣ��Ƿ������");
			builder.setTitle("��ܰ��ʾ");
			builder.setPositiveButton("����ͳ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "�ò�Ʒ�Ѽ���ͳ�", Toast.LENGTH_SHORT).show();
					dialog.dismiss();
				}
			});
			builder.setNegativeButton("����", new android.content.DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});

			builder.create().show();
			break;

		case R.id.lijigoumai:
			CustomDialog.Builder build = new CustomDialog.Builder(this);
			build.setMessage("�ò�Ʒ�����Ϊ�𱬣������ڶ���ĵ�12λ����ȴ��ղ�ʱ��ԼΪ20���ӣ��Ƿ������");
			build.setTitle("��ܰ��ʾ");
			build.setPositiveButton("��������", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(DishDetail.this, MyExamActivity.class);
					intent.putExtra("price", pricetext);
					startActivity(intent);
					dialog.dismiss();
				}
			});
			build.setNegativeButton("����", new android.content.DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			build.create().show();
			break;

		case R.id.collectionImageView:
			if (collectionImageViewChoosed) {
				collectionImageViewChoosed = false;
				collectionImageView.setBackgroundResource(R.drawable.whitestar);
				Toast.makeText(getApplicationContext(), "��ȡ���ղ�", Toast.LENGTH_LONG).show();
			}
			else {
				collectionImageViewChoosed = true;
				collectionImageView.setBackgroundResource(R.drawable.redstarshoucang);
				Toast.makeText(getApplicationContext(), "�ղسɹ�", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}
}
