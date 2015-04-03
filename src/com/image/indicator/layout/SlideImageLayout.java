package com.image.indicator.layout;

import java.util.ArrayList;
import com.image.indicator.parser.NewsXmlParser;
import com.example.kuai.R;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

/**
 * ���ɻ���ͼƬ���򲼾�
 * @Description: ���ɻ���ͼƬ���򲼾�
 */
public class SlideImageLayout {
	// ����ͼƬ��ArrayList
	private ArrayList<ImageView> imageList = null;
	private Activity activity = null;
	// Բ��ͼƬ����
	private ImageView[] imageViews = null; 
	private ImageView imageView = null;
	private NewsXmlParser parser = null;
	// ��ʾ��ǰ����ͼƬ������
	private int pageIndex = 0;
	
	public SlideImageLayout(Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
		imageList = new ArrayList<ImageView>();
		parser = new NewsXmlParser();
	}
	
	/**
	 * ���ɻ���ͼƬ���򲼾�
	 * @param index
	 * @return
	 */
	public View getSlideImageLayout(int index){
		// ����TextView��LinearLayout
		LinearLayout imageLinerLayout = new LinearLayout(activity);
		LinearLayout.LayoutParams imageLinerLayoutParames = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, 
				LinearLayout.LayoutParams.WRAP_CONTENT,
				1);
		
		ImageView iv = new ImageView(activity);
		iv.setBackgroundResource(index);
		iv.setOnClickListener(new ImageOnClickListener());
		imageLinerLayout.addView(iv,imageLinerLayoutParames);
		imageList.add(iv);
		
		return imageLinerLayout;
	}
	
	/**
	 * ��ȡLinearLayout
	 * @param view
	 * @param width
	 * @param height
	 * @return
	 */
	public View getLinearLayout(View view,int width,int height){
		LinearLayout linerLayout = new LinearLayout(activity);
		LinearLayout.LayoutParams linerLayoutParames = new LinearLayout.LayoutParams(
				width, 
				height,
				1);
		// �������Ҳ�Զ������ã�����Ȥ���Լ����á�
		linerLayout.setPadding(5, 0, 5, 0);
		linerLayout.addView(view, linerLayoutParames);
		
		return linerLayout;
	}
	
	/**
	 * ����Բ�����
	 * @param size
	 */
	public void setCircleImageLayout(int size){
		imageViews = new ImageView[size];
	}
	
	/**
	 * ����Բ��ͼƬ���򲼾ֶ���
	 * @param index
	 * @return
	 */
	public ImageView getCircleImageLayout(int index){
		imageView = new ImageView(activity);  
		imageView.setLayoutParams(new LayoutParams(5,5));
        imageView.setScaleType(ScaleType.FIT_XY);
        
        imageViews[index] = imageView;
         
        if (index == 0) {  
            //Ĭ��ѡ�е�һ��ͼƬ
            imageViews[index].setBackgroundResource(R.drawable.now);  
        } else {  
            imageViews[index].setBackgroundResource(R.drawable.no);  
        }  
         
        return imageViews[index];
	}
	
	/**
	 * ���õ�ǰ����ͼƬ������
	 * @param index
	 */
	public void setPageIndex(int index){
		pageIndex = index;
	}
	
	// ����ҳ�����¼�������
    private class ImageOnClickListener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		Toast.makeText(activity, "�޷����ӷ�����", Toast.LENGTH_LONG).show();
    	}
    }
}
