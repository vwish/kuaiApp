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
	public ImageLoader imageLoader; // ��������ͼƬ���࣬�����н���

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

		TextView dish_name = (TextView) vi.findViewById(R.id.dish_name); // ��Ʒ����
		TextView business_name = (TextView) vi.findViewById(R.id.business_name); // �͹�����
		TextView dish_price = (TextView) vi.findViewById(R.id.dish_price); // ��Ʒ�۸�
		TextView haoping = (TextView) vi.findViewById(R.id.haoping); // ������
		TextView dish_hasnum = (TextView) vi.findViewById(R.id.dish_hasnum); // ���۷���
		ImageView dish_pic = (ImageView) vi.findViewById(R.id.dish_pic); // ����ͼ

		HashMap<String, Object> list = new HashMap<String, Object>();
		list = data.get(position);

		// ����ListView�����ֵ
		dish_name.setText((String) list.get(Constant.KEY_DISHNAME));
		business_name.setText((String) list.get(Constant.KEY_BUSINESSNAME));
		dish_price.setText((String) list.get(Constant.KEY_DISH_PRICE));
		haoping.setText((String) list.get(Constant.KEY_HAOPING));
		dish_hasnum.setText((String) list.get(Constant.KEY_FENSHU));

		// Integer url = (Integer)list.get(Constant.KEY_IMAGE_URL);
		// ���ر�����Դ
		// dish_pic.setBackgroundResource(url);

		// ����������Դ
		imageLoader = new ImageLoader(context);
		imageLoader.DisplayImage((String) list.get(Constant.KEY_IMAGE_URL), dish_pic);

		return vi;
	}

}
