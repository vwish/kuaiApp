package com.example.kuai;

import com.example.tool.MyApplication;
import com.example.view.LoadingView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class WelcomeActivity extends Activity {
	private LoadingView main_imageview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.welcome);
		main_imageview = (LoadingView) findViewById(R.id.main_imageview);
		initLoadingImages();

		new Thread() {
			@Override
			public void run() {
				main_imageview.startAnim();
			}
		}.start();
		Handler x = new Handler();
		x.postDelayed(new splashhandler(), 3000);
	}

	private void initLoadingImages() {
		int[] imageIds = new int[8];
		imageIds[0] = R.drawable.b;
		imageIds[1] = R.drawable.b;
		imageIds[2] = R.drawable.c;
		imageIds[3] = R.drawable.d;
		imageIds[4] = R.drawable.e;
		imageIds[5] = R.drawable.f;
		imageIds[6] = R.drawable.g;
		imageIds[7] = R.drawable.h;
		// imageIds[5] = R.drawable.loader_frame_6;

		main_imageview.setImageIds(imageIds);
	}

	class splashhandler implements Runnable {

		public void run() {
			startActivity(new Intent(getApplication(), Main.class));
			WelcomeActivity.this.finish();
		}

	}
}
