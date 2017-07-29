package com.example.cal_demo;

import java.io.IOException;
import java.util.ArrayList;

import android.media.AudioManager;
import android.media.MediaPlayer;
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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity {
	
	int rank_num;
	int maxn;
	String x;
	String mm;
	String nn;
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
	private MediaPlayer mp;
	private AudioManager am;
	private int max;
	private int current;
	private int stepvolume;
	
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
		current=bundle.getInt("music");
		maxn=Integer.parseInt(mm);
		rank_num=Integer.parseInt(x);
		nn=Integer.toString(current);
		
		mp=new MediaPlayer();
		try {
			mp.setDataSource("rain.mp3");
			mp.prepare();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		am=(AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		max=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		stepvolume=max/10;
		set();
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				current=am.getStreamVolume(AudioManager.STREAM_MUSIC);
				int tempvolume=current-stepvolume;
				current=tempvolume>0?tempvolume:0;
				am.setStreamVolume(AudioManager.STREAM_MUSIC, current, AudioManager.FLAG_PLAY_SOUND);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				current=am.getStreamVolume(AudioManager.STREAM_MUSIC);
				int tempvolume=current+stepvolume;
				current=tempvolume<max?tempvolume:max;
				am.setStreamVolume(AudioManager.STREAM_MUSIC, current, AudioManager.FLAG_PLAY_SOUND);
			}
		});

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
				actionAlertDialog();
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
		intent.putExtra("music", current);
		setResult(resultCode , intent);
		int co=getResources().getColor(R.color.white);
		rankTextView.setTextColor(co);
		targetTextView.setText("");
        stepTextView.setText("");
        rankTextView.setText("设置");
        answerTextView.setText("暂停");
        answerTextView.setGravity(Gravity.CENTER);
        answerTextView.setTextSize(80);
        
        button1.setBackground(getResources().getDrawable(R.drawable.subbutton));
        button2.setBackground(getResources().getDrawable(R.drawable.music));
        button3.setBackground(getResources().getDrawable(R.drawable.plusbutton));
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
		intent.putExtra("music", current);
		setResult(resultCode , intent);
		finish();
	}
	protected void actionAlertDialog(){
        ArrayList<buyaction> list = initData();
        AlertDialog.Builder builder;
        AlertDialog alertDialog;
        Context context = SettingActivity.this;
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
