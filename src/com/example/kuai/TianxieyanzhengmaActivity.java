package com.example.kuai;

import com.example.kuai.R.color;
import com.example.tool.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TianxieyanzhengmaActivity extends Activity implements
		OnClickListener {
	private Button next, back, again;
	private TimeCount time;
	private String yanzhengma;
	private String shoujihao;
	private EditText yanzhengmaput;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication.instance().addActivity(this);
		setContentView(R.layout.tianxieyanzhengma);
		time = new TimeCount(60000, 1000);//����CountDownTimer����
		
		Intent intent1 = this.getIntent();
		shoujihao = intent1.getStringExtra("phone");
		yanzhengma = intent1.getStringExtra("yanzhengma");

		init();
	}

	public void init() {
		next = (Button) findViewById(R.id.next);
		back = (Button) findViewById(R.id.back);
		again = (Button) findViewById(R.id.again);
		
		yanzhengmaput=(EditText)findViewById(R.id.yanzhengma);
		time.start();//��ʼ��ʱ
		
		back.setOnClickListener(this);
		next.setOnClickListener(this);
		again.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back:
			startActivity(new Intent(TianxieyanzhengmaActivity.this,
					TianxieshoujihaoActivity.class));
			finish();
			break;
		case R.id.next:
			if(!(yanzhengma.equals(yanzhengmaput.getText().toString())))
				Toast.makeText(getApplicationContext(), "��֤�����벻��ȷ", Toast.LENGTH_LONG).show();
			else{
			Intent intent = new Intent(TianxieyanzhengmaActivity.this,
					ZhuceActivity.class);
			intent.putExtra("shouji", shoujihao);
			startActivity(intent);
			}
			break;
		case R.id.again:
			
			time.start();//��ʼ��ʱ
			break;
		}
	}

	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// ��������Ϊ��ʱ��,�ͼ�ʱ��ʱ����
		}

		@Override
		public void onFinish() {// ��ʱ���ʱ����
			//again.setBackgroundColor(color.red);
			again.setBackgroundResource(R.drawable.loginbg);
			again.setText("������֤");
			again.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// ��ʱ������ʾ
			again.setBackgroundColor(color.bg_gray);
			again.setClickable(false);
			again.setText(millisUntilFinished / 1000 + "��");
		}
	}
}
