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
import android.widget.LinearLayout;
import android.widget.TextView;

public class Rank995Activity extends Activity {

	int rank_num;
	String x;
	int terget;
	int step;
	int flag=1;
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
		setContentView(R.layout.activity_main);

		rankTextView=(TextView) findViewById(R.id.rank);
		stepTextView=(TextView) findViewById(R.id.step);
		targetTextView=(TextView) findViewById(R.id.target);
		answerTextView=(TextView) findViewById(R.id.answer);
		int co=getResources().getColor(R.color.white);
		rankTextView.setTextColor(co);
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
		setone();

		button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				flag++;
				switch (flag) {
				case 2:
					settwo();break;
				case 3:
					setthree();break;
				case 4:
					setfour();break;
				default:
					setend();break;
				}
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void setone(){
		rankTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
		rankTextView.setText("游戏指南");
		int co=getResources().getColor(R.color.white);
		stepTextView.setText("");
		targetTextView.setText("");
		answerTextView.setText("我们得到了\n一个新按钮!");
		answerTextView.setTextSize(40);
		button5.setText("是的!");
		button5.setTextSize(20);
		button5.setTextColor(co);
		button5.setBackground(getResources().getDrawable(R.drawable.greenbutton));
		button2.setBackground(getResources().getDrawable(R.drawable.orangebutton));
		button2.setTextColor(co);
		button2.setText("+/-");
		button2.setTextSize(40);
	}
	public void settwo(){
		answerTextView.setText("我们可以将正负数相互转换!");
		answerTextView.setTextSize(40);
		button5.setText("好的!");
		
	}
	public void setthree(){	
		answerTextView.setText("我们先控制\n这些数字……");
		answerTextView.setTextSize(40);
		button5.setText("……");
	}
	public void setfour(){
		answerTextView.setText("然后控制\n世界!!!");
		answerTextView.setTextSize(40);
		button5.setText("哈哈!好!");
	}
	public void setend(){
		rank_num=19;
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		setResult(resultCode,intent);
		finish();
	}
}
