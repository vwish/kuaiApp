package com.example.listviewimage;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.entity.Constant;
import com.example.kuai.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * �̳�BaseAdapter �����������
 * @author lenovo
 *
 */
public class AllUserAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<HashMap<String, Object>> data;
    private LayoutInflater inflater=null;
    public ImageLoader imageLoader; //��������ͼƬ���࣬�����н���
    public AllUserAdapter(Context a, ArrayList<HashMap<String, Object>> d) {
    	context = a;
        data=d;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(context.getApplicationContext());
    }
    @Override
	public int getCount() {
		// TODO Auto-generated method stub
    	return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row_user, null);
        /**
         * �˴�Ϊͨ��findViewById�ҵ�ÿһ���ؼ�
         */
        TextView user_name = (TextView)vi.findViewById(R.id.user_name); // �û�����
        TextView jifen = (TextView)vi.findViewById(R.id.jifen); // ��ʾ�û�����
        TextView paiming = (TextView)vi.findViewById(R.id.paiming); // ��ʾ�û�����
        TextView hasnumber = (TextView)vi.findViewById(R.id.hasnumber); // ��ʾ�Ѿ�����ķ���
        ImageView user_pic=(ImageView)vi.findViewById(R.id.user_pic); // ����ͼ
        
        HashMap<String, Object> list = new HashMap<String, Object>();
        list = data.get(position);
        
        // ����ListView�����ֵ
        user_name.setText((String)list.get(Constant.KEY_USERNAME));
        jifen.setText((String)list.get(Constant.KEY_USERJIFEN));
        paiming.setText((String)list.get(Constant.KEY_USERPAIMING));
        hasnumber.setText((String)list.get(Constant.KEY_HASNUMBER));
        Integer url = (Integer)list.get(Constant.KEY_IMAGE_URL);
        //���ر�����Դ
        user_pic.setBackgroundResource(url);
       
        //����������Դ
       /* imageLoader=new ImageLoader(context);
        imageLoader.DisplayImage(url, dish_pic);*/
       
        return vi;
	}

}
