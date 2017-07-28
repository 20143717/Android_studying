package com.example.cal_demo;

import java.util.Timer;
import java.util.TimerTask;

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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Rank18Activity extends Activity {
	
	int rank_num;
	String x;
	int target=414;
	int step=4;
	int begin=1234;
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
	private int col=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rank);

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
					step--;
					if(find("23", "41")){
						update(step, target, begin);
						if(step==0){
							if(begin==target) win();
							else lose();
						}
					}
					else
						Toast.makeText(getApplicationContext(), "�Ҳ����������",Toast.LENGTH_SHORT).show();
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "�Ѿ�������������OK",Toast.LENGTH_SHORT).show();
					else lose();
				}
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					step--;
					if(find("24", "14")){
						update(step, target, begin);
						if(step==0){
							if(begin==target) win();
							else lose();
						}
					}
					else
						Toast.makeText(getApplicationContext(), "�Ҳ����������",Toast.LENGTH_SHORT).show();
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "�Ѿ�������������OK",Toast.LENGTH_SHORT).show();
					else lose();
				}
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					step--;
					if(find("12", "24")){
						update(step, target, begin);
						if(step==0){
							if(begin==target) win();
							else lose();
						}
					}
					else
						Toast.makeText(getApplicationContext(), "�Ҳ����������",Toast.LENGTH_SHORT).show();
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "�Ѿ�������������OK",Toast.LENGTH_SHORT).show();
					else lose();
				}
			}
		});
		
		button9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					step--;
					if(find("14", "2")){
						update(step, target, begin);
						if(step==0){
							if(begin==target) win();
							else lose();
						}
					}
					else
						Toast.makeText(getApplicationContext(), "�Ҳ����������",Toast.LENGTH_SHORT).show();
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "�Ѿ�������������OK",Toast.LENGTH_SHORT).show();
					else lose();
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
				else update(4, 414, 1234);
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(begin!=target) settings();
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
		rankTextView.setText("�ȼ�:"+x);
		
		update(step, target, begin);
		button2.setText("23=>41");
		button2.setTextSize(27);
		button2.setTextColor(co);
		button5.setText("24=>14");
		button5.setTextSize(27);
		button5.setTextColor(co);
		button6.setText("12=>24");
		button6.setTextSize(27);
		button6.setTextColor(co);
		button9.setText("14=>2");
		button9.setTextSize(27);
		button9.setTextColor(co);
		
		button2.setBackground(getResources().getDrawable(R.drawable.orangebutton));
		button5.setBackground(getResources().getDrawable(R.drawable.orangebutton));
		button6.setBackground(getResources().getDrawable(R.drawable.orangebutton));
		button9.setBackground(getResources().getDrawable(R.drawable.orangebutton));
		
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
		rank_num=995;
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		setResult(resultCode , intent);
		finish();
	}
	public void lose(){
		mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		mVibrator.vibrate(1000);
		Toast.makeText(getApplicationContext(), "�����¿�ʼ�����CLR",Toast.LENGTH_SHORT).show();
	}
	public void win(){
		Toast.makeText(getApplicationContext(), "�������ѽ~~~",Toast.LENGTH_SHORT).show();
		button3.setBackground(getResources().getDrawable(R.drawable.okbutton));
		button1.setBackground(getResources().getDrawable(R.drawable.shadow));
		button7.setBackground(getResources().getDrawable(R.drawable.shadow));
		spark();
	}
	public void spark(){
		Timer timer=new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(col==0){
							answerTextView.setText("Ӯ��");
							col=1;
						}
						else if(col==1){
							answerTextView.setText(targetString);
							col=0;
						}
					}
				});
			}
		};
		timer.schedule(task, 1 , 1000);
	}
	public void settings(){
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		intent.putExtra("setting", true);
		setResult(resultCode , intent);
		finish();
	}
	public boolean find(String p,String q){
		String numString=Integer.toString(begin);
		boolean ok=false;
		if(numString.contains(p))
			ok=true;
		numString=numString.replaceAll(p, q);
		begin=Integer.parseInt(numString);
		return ok;
	}
}