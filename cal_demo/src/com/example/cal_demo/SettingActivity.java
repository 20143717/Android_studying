package com.example.cal_demo;

import android.os.Bundle;
import android.os.Vibrator;
import android.R.integer;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity {
	
	int rank_num;
	int maxn;
	String x;
	String mm;
	int target=9;
	int step=4;
	int begin=0;
	String targetString;
	String stepString;
	String beginString;
	TextView rankTextView;
	TextView stepTextView;
	TextView targetTextView;
	TextView answerTextView;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	private Vibrator mVibrator;
	private int resultCode=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rankTextView=(TextView) findViewById(R.id.rank);
		stepTextView=(TextView) findViewById(R.id.step);
		targetTextView=(TextView) findViewById(R.id.target);
		answerTextView=(TextView) findViewById(R.id.answer);
		
		button1=(Button) findViewById(R.id.one);
		button2=(Button) findViewById(R.id.two);
		button3=(Button) findViewById(R.id.three);
		button4=(Button) findViewById(R.id.four);
		button5=(Button) findViewById(R.id.five);
		button6=(Button) findViewById(R.id.six);
		button7=(Button) findViewById(R.id.seven);
		button8=(Button) findViewById(R.id.eight);
		button9=(Button) findViewById(R.id.nine);
		
		Bundle bundle=this.getIntent().getExtras();
		x=bundle.getString("num");
		mm=bundle.getString("maxn");
		maxn=Integer.parseInt(mm);
		rank_num=Integer.parseInt(x);
		
		set();

		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(rank_num>0){
					rank_num--;
					String k=Integer.toString(rank_num);
					button5.setText("等级\n"+k);
				}
				else{
					Toast.makeText(getApplicationContext(), "已经是第0关--游戏指南啦",Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(rank_num<maxn){
					rank_num++;
					String k=Integer.toString(rank_num);
					button5.setText("等级\n"+k);
				}
				else{
					Toast.makeText(getApplicationContext(), "已经是您见过的最高关卡啦",Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setend();
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void set(){
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		setResult(resultCode , intent);
		int co=getResources().getColor(R.color.white);
		rankTextView.setTextColor(co);
		targetTextView.setText("");
        stepTextView.setText("");
        rankTextView.setText("设置");
        answerTextView.setText("暂停");
        answerTextView.setGravity(Gravity.CENTER);
        answerTextView.setTextSize(80);
        button7.setBackground(getResources().getDrawable(R.drawable.yellowbutton));
        button4.setBackground(getResources().getDrawable(R.drawable.subbutton));
        button5.setBackground(getResources().getDrawable(R.drawable.rank));
        button6.setBackground(getResources().getDrawable(R.drawable.plusbutton));
        button8.setBackground(getResources().getDrawable(R.drawable.bluebutton));
        button5.setText("等级\n"+x);
        button5.setGravity(Gravity.CENTER);
        button5.setTextColor(co);
	}
	public void setend(){
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("setting",false);
		intent.putExtra("num",x);
		setResult(resultCode , intent);
		finish();
	}
}
