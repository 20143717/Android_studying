package com.example.cal_demo;


import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RankoneActivity extends Activity {

	int rank_num;
	String x;
	int target=2;
	int step=2;
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
	private VibratorUtil mVibrator;
	private int resultCode=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rankone);

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
		rank_num=Integer.parseInt(x);
		set();

		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					begin++;
					step--;
					update(step, target, begin);
					if(step==0&&begin==target){
						Toast.makeText(getApplicationContext(), "你好厉害呀~~~",Toast.LENGTH_SHORT).show();
						button3.setBackground(getResources().getDrawable(R.drawable.okbutton));
					}
				}
				else{
					//mVibrator = (VibratorUtil) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
					Toast.makeText(getApplicationContext(), "请重新开始，点击CLR",Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step==0&&begin==target){
					setend();
				}
				else update(2, 2, 0);
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rankone, menu);
		return true;
	}
	
	
	public void set(){
		int co=getResources().getColor(R.color.white);
		rankTextView.setTextColor(co);
		rankTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
		rankTextView.setText("等级:1");
		
		stepTextView.setText("2");
		targetTextView.setText("2");
		answerTextView.setText("0");
		button2.setText("+1");
		button2.setTextSize(40);
		button2.setTextColor(co);
		button2.setBackground(getResources().getDrawable(R.drawable.greybutton));
		button3.setBackground(getResources().getDrawable(R.drawable.redbutton));
		button7.setBackground(getResources().getDrawable(R.drawable.yellowbutton));
		button1.setBackground(getResources().getDrawable(R.drawable.bluebutton));
	}
	public void update(int a,int b,int c){
		step=a;
		target=b;
		begin=c;
		stepString=Integer.toString(step);
		targetString=Integer.toString(target);
		beginString=Integer.toString(begin);
		stepTextView.setText(stepString);
		targetTextView.setText(targetString);
		answerTextView.setText(beginString);
	}
	public void setend(){
		rank_num++;
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		setResult(resultCode , intent);
		finish();
	}
}
