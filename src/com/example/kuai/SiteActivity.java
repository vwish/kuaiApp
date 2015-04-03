package com.example.kuai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.entity.Constant;
import com.example.kuai.ProfileActivity.HttpAsyncTask1;
import com.example.listviewimage.LazyAdapter;
import com.example.localdata.DishData;
import com.example.net.NetworkConnect;
import com.example.tool.BaseActivity;
import com.example.tool.Common;
import com.example.tool.MyApplication;
import com.image.indicator.layout.SlideImageLayout;
import com.image.indicator.parser.NewsXmlParser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SiteActivity extends BaseActivity implements OnClickListener {
	// 滑动图片的集合
	private ArrayList<View> imagePageViews = null;
	private ViewGroup main = null;
	private ViewPager viewPager = null;
	// 当前ViewPager索引
	private int pageIndex = 0;
	// 包含圆点图片的View
	private ViewGroup imageCircleView = null;
	private ImageView[] imageCircleViews = null;
	private SlideImageLayout slideLayout = null;
	private NewsXmlParser parser = null;
	private ListView list;
	private LazyAdapter adapter;
	private Button searchButton, updateAddressButton, dishMenuButton, businessButton, userButton, salesButton;
	private ProgressDialog loading;
	private ArrayList<HashMap<String, Object>> dishes;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.site_show);
		MyApplication.instance().addActivity(this);
		initView();
		addEventListener();
	}

	public void addEventListener() {
		salesButton.setOnClickListener(this);
		userButton.setOnClickListener(this);
		businessButton.setOnClickListener(this);
		dishMenuButton.setOnClickListener(this);
		searchButton.setOnClickListener(this);
		updateAddressButton.setOnClickListener(this);

		list.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				dishes.get(position).get(Constant.KEY_DISHNAME);
				Intent intent = new Intent(SiteActivity.this, DishDetail.class);
				// Log.v("输出将要传递过去的数据： ", dishes.get(position));
				intent.putExtra("dish", dishes.get(position));
				startActivity(intent);
			}
		});
	}

	public void initView() {
		initeViews();

		HttpAsyncTask1 httptask = new HttpAsyncTask1();
		httptask.execute("KBD/User/getDish");

		list = (ListView) findViewById(R.id.list);

		View headerView = (View) findViewById(R.id.head);
		searchButton = (Button) headerView.findViewById(R.id.searchButton);
		dishMenuButton = (Button) findViewById(R.id.dishMenuButton);
		businessButton = (Button) findViewById(R.id.businessButton);
		userButton = (Button) findViewById(R.id.userButton);
		salesButton = (Button) findViewById(R.id.salesButton);
		updateAddressButton = (Button) headerView.findViewById(R.id.updateAddressButton);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.businessButton:
			startActivity(new Intent(SiteActivity.this, MainShangjiaActivity.class));
			break;

		case R.id.userButton:
			startActivity(new Intent(SiteActivity.this, MainyonghuActivity.class));
			break;

		case R.id.salesButton:
			startActivity(new Intent(SiteActivity.this, MaincuxiaoActivity.class));
			break;

		case R.id.dishMenuButton:
			startActivity(new Intent(SiteActivity.this, Allcaiping.class));
			break;

		case R.id.search:
			startActivity(new Intent(SiteActivity.this, Search.class));
			break;

		case R.id.address:
			startActivity(new Intent(SiteActivity.this, DialogActivity.class));
			break;
		}
	}

	private void initeViews() {
		// 滑动图片区域
		imagePageViews = new ArrayList<View>();
		LayoutInflater inflater = getLayoutInflater();
		main = (ViewGroup) inflater.inflate(R.layout.site_show, null);
		viewPager = (ViewPager) main.findViewById(R.id.image_slide_page);

		// 圆点图片区域
		parser = new NewsXmlParser();
		int length = parser.getSlideImages().length;
		imageCircleViews = new ImageView[length];
		imageCircleView = (ViewGroup) main.findViewById(R.id.layout_circle_images);
		slideLayout = new SlideImageLayout(SiteActivity.this);
		slideLayout.setCircleImageLayout(length);

		for (int i = 0; i < length; i++) {
			imagePageViews.add(slideLayout.getSlideImageLayout(parser.getSlideImages()[i]));
			imageCircleViews[i] = slideLayout.getCircleImageLayout(i);
			imageCircleView.addView(slideLayout.getLinearLayout(imageCircleViews[i], 10, 10));
		}
		setContentView(main);
		// 设置ViewPager
		viewPager.setAdapter(new SlideImageAdapter());
		viewPager.setOnPageChangeListener(new ImagePageChangeListener());
	}

	// 滑动图片数据适配器
	private class SlideImageAdapter extends PagerAdapter {
		public int getCount() {
			return imagePageViews.size();
		}

		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		public int getItemPosition(Object object) {
			return super.getItemPosition(object);
		}

		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(imagePageViews.get(arg1));
		}

		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(imagePageViews.get(arg1));

			return imagePageViews.get(arg1);
		}

		public void restoreState(Parcelable arg0, ClassLoader arg1) {

		}

		public Parcelable saveState() {
			return null;
		}

		public void startUpdate(View arg0) {
		}

		public void finishUpdate(View arg0) {

		}
	}

	// 滑动页面更改事件监听器
	private class ImagePageChangeListener implements OnPageChangeListener {
		public void onPageScrollStateChanged(int arg0) {
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		public void onPageSelected(int index) {
			pageIndex = index;
			slideLayout.setPageIndex(index);

			for (int i = 0; i < imageCircleViews.length; i++) {
				imageCircleViews[index].setBackgroundResource(R.drawable.now);
				if (index != i) {
					imageCircleViews[i].setBackgroundResource(R.drawable.no);
				}
			}
		}
	}

	public List<Map<String, Object>> getData(String strResult) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;

		try {
			JSONObject json = new JSONObject(strResult);
			JSONArray jsonArray = json.getJSONArray("userInfoList");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);

				map = new HashMap<String, Object>();
				int id = jsonObj.getInt("userId");
				String name = jsonObj.getString("userName");
				String password = jsonObj.getString("password");
				map.put("id", id);
				map.put("name", name);
				map.put("password", password);
				list.add(map);
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> getDishes(JSONArray dishes) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;

		for (int i = 0; i < dishes.length(); i++) {
			JSONObject dish = null;
			try {
				map = new HashMap<String, Object>();
				dish = new JSONObject(dishes.getString(i));
				map.put(Constant.KEY_DISHNAME, dish.getString("dish_name"));
				map.put(Constant.KEY_BUSINESSNAME, dish.getString("business_name"));
				map.put(Constant.KEY_DISH_PRICE, "¥" + dish.getString("dish_price"));
				map.put(Constant.KEY_HAOPING, dish.getString("good") + "%");
				map.put(Constant.KEY_FENSHU, "已售" + dish.getString("hasSold") + "份");
				// map.put(Constant.KEY_IMAGE_URL, R.drawable.yuxiaoyousi);
				// http://img4.imgtn.bdimg.com/it/u=113128261,163613967&fm=23&gp=0.jpg
				// TODO 暂时显示的是百度的图片
				map.put(Constant.KEY_IMAGE_URL, "http://img4.imgtn.bdimg.com/it/u=113128261,163613967&fm=23&gp=0.jpg");
				list.add(map);
			}
			catch (JSONException e) {
			}
		}

		return list;
	}

	public class HttpAsyncTask1 extends AsyncTask<String, Integer, String> {

		protected String doInBackground(String... params) {
			NetworkConnect connpost = new NetworkConnect();
			return connpost.getConnect(params[0]);
		}

		protected void onPostExecute(String result) {
			try {
				Log.v("获取的数据为： ", result);
				JSONObject jsonObject = new JSONObject(result);

				String status = jsonObject.getString("status");
				if ("20009".equals(status)) {
					if (jsonObject.has("dishes")) {
						JSONArray dishArray = jsonObject.getJSONArray("dishes");
						dishes = getDishes(dishArray);
						adapter = new LazyAdapter(SiteActivity.this, dishes);
						list.setAdapter(adapter);
					}
				}
			}
			catch (JSONException e) {
			}
			finally {
			}
		}

		protected void onPreExecute() {
			// TODO 此处需要增加一个loading
		}
	}
}
