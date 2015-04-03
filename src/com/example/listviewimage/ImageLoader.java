package com.example.listviewimage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageLoader {

	MemoryCache memoryCache = new MemoryCache();
	FileCache fileCache;
	private Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap<ImageView, String>());
	ExecutorService executorService;
	public Bitmap bitmapnew=null;
	public ImageView imageView;
	public ImageLoader(Context context) {
		fileCache = new FileCache(context);
		executorService = Executors.newFixedThreadPool(5);
	}
	//将url对应的资源显示到imageView中
	public void DisplayImage(String url, ImageView imageView) {
		this.imageView=imageView;
		imageViews.put(imageView, url);
		Bitmap bitmap = memoryCache.get(url);
		
		if (bitmap != null)
			imageView.setImageBitmap(bitmap);
		else {
			asyncImageLoad(url);
		}
	}

	private Bitmap getBitmap(String url) {
		File f = fileCache.getFile(url);
		// 从sd卡
		Bitmap b = decodeFile(f);
		if (b != null)
			return b;
		// 从网络
		try {
			Bitmap bitmap = null;
			URL imageUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(true);
			InputStream is = conn.getInputStream();
			OutputStream os = new FileOutputStream(f);
			Utils.CopyStream(is, os);
			os.close();
			is.close();
			bitmap = decodeFile(f);
			return bitmap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//使用异步任务类来处理显示图片的问题
   private void asyncImageLoad(String path) {
    	AsyncImageTask asyncImageTask = new AsyncImageTask();
    	asyncImageTask.execute(path);
    }    
    private final class AsyncImageTask extends AsyncTask<String, Integer, Bitmap>{
		protected Bitmap doInBackground(String... params) {//子线程中执行的
			try {
				return getBitmap(params[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		protected void onPostExecute(Bitmap result) {
			imageView.setImageBitmap(result);
		}
    }
    
	// 解码图像用来减少内存消耗
	private Bitmap decodeFile(File f) {
		try {
			// 解码图像大小
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);

			// 找到正确的刻度值，它应该是2的幂。
			final int REQUIRED_SIZE = 70;
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp / 2 < REQUIRED_SIZE
						|| height_tmp / 2 < REQUIRED_SIZE)
					break;
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
		}
		return null;
	}
}
