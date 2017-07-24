package com.example.cal_demo;


import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RankoneActivity extends Activity {

	int rank_num;
	int terget;
	int step;
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
		rank_num=bundle.getInt("num");
		String x=Integer.toString(rank_num);
		
		setone();
		
		button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				String x=Integer.toString(rank_num);
				intent.putExtra("num",x);
				setResult(resultCode , intent);
				finish();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rankone, menu);
		return true;
	}
	
	public void setone(){
		int co=getResources().getColor(R.color.white);
		rankTextView.setTextColor(co);
		rankTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
		rankTextView.setText("”Œœ∑÷∏ƒœ");
		
		stepTextView.setText("0");
		targetTextView.setText("0");
		answerTextView.setText("‡À~");
		
		button5.setText("‡À~");
		button5.setTextSize(20);
		
		button5.setBackground(getResources().getDrawable(R.drawable.green));
	}
}
