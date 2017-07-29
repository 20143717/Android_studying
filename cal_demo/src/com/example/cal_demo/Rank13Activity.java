package com.example.cal_demo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Vibrator;
import android.R.integer;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Rank13Activity extends Activity {
	
	int rank_num;
	String x;
	int target=93;
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
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				actionAlertDialog();
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					begin=begin*7;
					step--;
					update(step, target, begin);
					if(step==0){
						if(begin==target) win();
						else lose();
					}
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "已经过关啦，请点击OK",Toast.LENGTH_SHORT).show();
					else lose();
				}
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(step>0){
					begin+=6;
					step--;
					update(step, target, begin);
					if(step==0){
						if(begin==target) win();
						else lose();
					}
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "已经过关啦，请点击OK",Toast.LENGTH_SHORT).show();
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
					if(find("6", "9")){
						update(step, target, begin);
						if(step==0){
							if(begin==target) win();
							else lose();
						}
					}
					else
						Toast.makeText(getApplicationContext(), "找不到这个数字",Toast.LENGTH_SHORT).show();
				}
				else{
					if(begin==target)
						Toast.makeText(getApplicationContext(), "已经过关啦，请点击OK",Toast.LENGTH_SHORT).show();
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
				else update(4, 93, 0);
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
		rankTextView.setText("等级:"+x);
		
		update(step, target, begin);
		button2.setText("×7");
		button2.setTextSize(40);
		button2.setTextColor(co);
		button5.setText("+6");
		button5.setTextSize(40);
		button5.setTextColor(co);
		button6.setText("6=>9");
		button6.setTextSize(40);
		button6.setTextColor(co);

		button2.setBackground(getResources().getDrawable(R.drawable.purplebutton));
		button5.setBackground(getResources().getDrawable(R.drawable.greybutton));
		button6.setBackground(getResources().getDrawable(R.drawable.orangebutton));

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
	public void lose(){
		mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		mVibrator.vibrate(1000);
		Toast.makeText(getApplicationContext(), "请重新开始，点击CLR",Toast.LENGTH_SHORT).show();
	}
	public void win(){
		Toast.makeText(getApplicationContext(), "你好厉害呀~~~",Toast.LENGTH_SHORT).show();
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
							answerTextView.setText("赢得");
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
	protected void actionAlertDialog(){
        ArrayList<buyaction> list = initData();
        AlertDialog.Builder builder;
        AlertDialog alertDialog;
        Context context = Rank13Activity.this;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.myview, (ViewGroup)findViewById(R.id.layout_myview));
        CornerListView myListView = (CornerListView) layout.findViewById(R.id.mylistview);
        MyAdapter adapter = new MyAdapter(context, list);
        myListView.setAdapter(adapter);
        builder = new AlertDialog.Builder(context);
        builder.setView(layout);
        alertDialog = builder.create();
        alertDialog.show();
        
    }
    protected ArrayList<buyaction> initData(){
        ArrayList<buyaction> list = new ArrayList<buyaction>();
        buyaction p;
        p = new buyaction();
        p.name = "套餐"+1+" :";
        p.num = 1;
        p.val = 0.99;
        list.add(p);
        p = new buyaction();
        p.name = "套餐"+2+" :";
        p.num = 3;
        p.val = 2.88;
        list.add(p);
        p = new buyaction();
        p.name = "套餐"+3+" :";
        p.num = 5;
        p.val = 4.55;
        list.add(p);
        p = new buyaction();
        p.name = "套餐"+4+" :";
        p.num = 10;
        p.val = 8.88;
        list.add(p);
        p = new buyaction();
        p.name = "套餐"+5+" :";
        p.num = 100;
        p.val = 77.7;
        list.add(p);
        return list;
    }
}
