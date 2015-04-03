package com.example.kuai;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.example.model.Locationmodel;
import com.example.tool.BaseActivity;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DinnerPositionActivity extends BaseActivity {

	/**
	 * MapView 是地图主控件
	 */
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	private Marker mMarkerA;
	private Locationmodel locationmodel;
	private InfoWindow mInfoWindow;
	private Button first;
	private TextView xiayigedingdan;

	// 初始化全局 bitmap 信息，不用时及时 recycle
	BitmapDescriptor bdA = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
	BitmapDescriptor bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.setting);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(16.0f);
		mBaiduMap.setMapStatus(msu);
		init();
		
		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			public boolean onMarkerClick(final Marker marker) {
				Button button = new Button(getApplicationContext());
				button.setBackgroundResource(R.drawable.popup);
				
				final LatLng ll = marker.getPosition();
				Point p = mBaiduMap.getProjection().toScreenLocation(ll);
				p.y -= 47;
				LatLng llInfo = mBaiduMap.getProjection().fromScreenLocation(p);
				OnInfoWindowClickListener listener = null;
				 
				mInfoWindow = new InfoWindow(button, llInfo, listener);
				mBaiduMap.showInfoWindow(mInfoWindow);
				return true;
			}
		});
	}

	public void init(){
		
		/*new HttpAsyncTask1().execute("getlocation.action");*/
		first=(Button)findViewById(R.id.first);
		xiayigedingdan=(TextView)findViewById(R.id.xiayigedingdan);
		first.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(DinnerPositionActivity.this, Main.class));
				finish();
				
			}});
		xiayigedingdan.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(DinnerPositionActivity.this)
				.setTitle("操作提示")
				.setMessage("只有一个订单！")
				.setPositiveButton("确定",null)
				.show();
			}});
		
		locationmodel=new Locationmodel();
		locationmodel.setX("112.93");
		locationmodel.setY("28.23");
		initOverlay(locationmodel);
	}
	
	
	public void initOverlay(Locationmodel locationmodel) {
		// add marker overlay
		LatLng llA = new LatLng(Double.parseDouble(locationmodel.getY()),Double.parseDouble(locationmodel.getX()));

		OverlayOptions ooA = new MarkerOptions().position(llA).icon(bdA).zIndex(9);
		mMarkerA = (Marker) (mBaiduMap.addOverlay(ooA));
		// add ground overlay
		/*LatLng southwest = new LatLng(39.92235, 116.380338);
		LatLng northeast = new LatLng(39.947246, 116.414977);*/
		LatLng southwest = new LatLng(Double.parseDouble(locationmodel.getY()),Double.parseDouble(locationmodel.getX()));
		LatLng northeast = new LatLng(Double.parseDouble(locationmodel.getY())+0.00002,Double.parseDouble(locationmodel.getX())+0.00002);
		LatLngBounds bounds = new LatLngBounds.Builder().include(northeast)
				.include(southwest).build();

		MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(bounds.getCenter());
		mBaiduMap.setMapStatus(u);
	}


	@Override
	protected void onPause() {
		// MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
		mMapView.onDestroy();
		super.onDestroy();
		// 回收 bitmap 资源
		bdA.recycle();
		bd.recycle();
	}
	/*
	 * 网络异步任务程序
	public class HttpAsyncTask1 extends AsyncTask<String, Integer, String> {
		@Override
		protected String doInBackground(String... params) {
			//采用post方式提交数据
			List<NameValuePair> param = new ArrayList<NameValuePair>(); 
		     param.add(new BasicNameValuePair("username","123")); 
			ConnPost connpost=new ConnPost();
			String result=null;
			result=connpost.conn(params[0],param);
			return result;
		}
		@Override
		protected void onPostExecute(String result) {
			try {
				JSONObject jsonObject = new JSONObject(result.toString()).getJSONObject("locationmodel");
				String X = jsonObject.getString("x");
				String Y = jsonObject.getString("y");
				locationmodel=new Locationmodel();
				locationmodel.setX(X);
				locationmodel.setY(Y);
				initOverlay(locationmodel);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}*/
}
