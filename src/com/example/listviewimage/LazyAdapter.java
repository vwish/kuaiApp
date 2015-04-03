package com.example.listviewimage;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.kuai.R;
import com.example.entity.Constant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LazyAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<HashMap<String, Object>> data;
	private LayoutInflater inflater = null;
	public ImageLoader imageLoader; // 用来下载图片的类，后面有介绍

	public LazyAdapter(Context a, ArrayList<HashMap<String, Object>> d) {
		context = a;
		data = d;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(context.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView dish_name = (TextView) vi.findViewById(R.id.dish_name); // 菜品名称
		TextView business_name = (TextView) vi.findViewById(R.id.business_name); // 餐馆名称
		TextView dish_price = (TextView) vi.findViewById(R.id.dish_price); // 菜品价格
		TextView haoping = (TextView) vi.findViewById(R.id.haoping); // 好评率
		TextView dish_hasnum = (TextView) vi.findViewById(R.id.dish_hasnum); // 已售份数
		ImageView dish_pic = (ImageView) vi.findViewById(R.id.dish_pic); // 缩略图

		HashMap<String, Object> list = new HashMap<String, Object>();
		list = data.get(position);

		// 设置ListView的相关值
		dish_name.setText((String) list.get(Constant.KEY_DISHNAME));
		business_name.setText((String) list.get(Constant.KEY_BUSINESSNAME));
		dish_price.setText((String) list.get(Constant.KEY_DISH_PRICE));
		haoping.setText((String) list.get(Constant.KEY_HAOPING));
		dish_hasnum.setText((String) list.get(Constant.KEY_FENSHU));

		// Integer url = (Integer)list.get(Constant.KEY_IMAGE_URL);
		// 加载本地资源
		// dish_pic.setBackgroundResource(url);

		// 加载网络资源
		imageLoader = new ImageLoader(context);
		imageLoader.DisplayImage((String) list.get(Constant.KEY_IMAGE_URL), dish_pic);

		return vi;
	}

}
