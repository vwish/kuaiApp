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

		// TODO 获取上一个界面传递过来的数据
		dish = (HashMap<String, Object>) getIntent().getSerializableExtra("dish");
		Log.v("获取上一个界面传递过来的菜品： ", (String) dish.get(Constant.KEY_DISHNAME));

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
		hasSaledCountTextView.setText("已售" + (String) dish.get(Constant.KEY_FENSHU));
		hasCommentCountTextView.setText("评价人数暂定");
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
			new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("商家很懒，只传了一张图片").setPositiveButton("确定", null).show();
			break;
		case R.id.jiarucanche:
			CustomDialog.Builder builder = new CustomDialog.Builder(this);
			builder.setMessage("该菜品购买较为火爆，您处于队伍的第1位，最长等待烧菜时间约为10分钟，是否继续？");
			builder.setTitle("温馨提示");
			builder.setPositiveButton("加入餐车", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "该菜品已加入餐车", Toast.LENGTH_SHORT).show();
					dialog.dismiss();
				}
			});
			builder.setNegativeButton("放弃", new android.content.DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});

			builder.create().show();
			break;

		case R.id.lijigoumai:
			CustomDialog.Builder build = new CustomDialog.Builder(this);
			build.setMessage("该菜品购买较为火爆，您处于队伍的第12位，最长等待烧菜时间约为20分钟，是否继续？");
			build.setTitle("温馨提示");
			build.setPositiveButton("立即购买", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(DishDetail.this, MyExamActivity.class);
					intent.putExtra("price", pricetext);
					startActivity(intent);
					dialog.dismiss();
				}
			});
			build.setNegativeButton("放弃", new android.content.DialogInterface.OnClickListener() {
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
				Toast.makeText(getApplicationContext(), "已取消收藏", Toast.LENGTH_LONG).show();
			}
			else {
				collectionImageViewChoosed = true;
				collectionImageView.setBackgroundResource(R.drawable.redstarshoucang);
				Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}
}
