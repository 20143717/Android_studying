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

public class RankzeroActivity extends Activity {

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
				case 5:
					setfive();break;
				case 6:
					setsix();break;
				case 7:
					setseven();break;
				case 8:
					seteight();break;
				case 9:
					setnine();break;
				default:
					setend();break;
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(flag==9){
					rank_num=999;
					Intent intent = new Intent();
					x=Integer.toString(rank_num);
					intent.putExtra("num",x);
					setResult(resultCode,intent);
					finish();
				}
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
		rankTextView.setText("��Ϸָ��");
		
		stepTextView.setText("0");
		targetTextView.setText("0");
		answerTextView.setText("��~");
		
		button5.setText("��~");
		button5.setTextSize(20);
		button5.setTextColor(co);
		
		button5.setBackground(getResources().getDrawable(R.drawable.greenbutton));
	}
	public void settwo(){
		answerTextView.setText("�ҵ����ֽ�\nYCH~~~");
		answerTextView.setTextSize(40);
		button5.setText("���  YCH!");
	}
	public void setthree(){
		answerTextView.setText("������Ϸ��");
		answerTextView.setTextSize(45);
		button5.setText("��Ȼ");
	}
	public void setfour(){
		answerTextView.setText("��ѽ~~~����\n�����������");
		answerTextView.setTextSize(40);
		button5.setText("�ǵ�");
	}
	public void setfive(){
		answerTextView.setText("�����\n��ϷĿ��!");
		answerTextView.setTextSize(40);
		button5.setText("����");
	}
	public void setsix(){
		answerTextView.setText("�������\n��������\n(�R���Q)");
		answerTextView.setTextSize(40);
		button5.setText("����");
	}
	public void setseven(){
		answerTextView.setText("���������ʹ�õ��ƶ�����");
		answerTextView.setTextSize(40);
		button5.setText("��������~~~");
	}
	public void seteight(){
		answerTextView.setText("����ť������\n����Ŀ�꼴��ʤ");
		answerTextView.setTextSize(40);
		button5.setText("OK");
	}
	public void setnine(){
		answerTextView.setText("�����ˣ�����\n(�R���Q)");
		answerTextView.setTextSize(40);
		button5.setText("�ǵ�");
		button2.setText("������");
		int co=getResources().getColor(R.color.white);
		button2.setTextColor(co);
		button2.setBackground(getResources().getDrawable(R.drawable.red2));
	}
	public void setend(){
		rank_num++;
		Intent intent = new Intent();
		x=Integer.toString(rank_num);
		intent.putExtra("num",x);
		setResult(resultCode,intent);
		finish();
	}
}
