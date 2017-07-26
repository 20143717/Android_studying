package com.example.cal_demo;

import com.example.cal_demo.MainActivity;
import com.example.cal_demo.Rank0Activity;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    int rank=0;
    String x;
    private int maxn;
    private Button button5;
    private Button button2;
    TextView rankTextView;
	TextView stepTextView;
	TextView targetTextView;
	TextView answerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button5 = (Button) findViewById(R.id.five);
        button2 = (Button) findViewById(R.id.two);
        rankTextView=(TextView) findViewById(R.id.rank);
		stepTextView=(TextView) findViewById(R.id.step);
		targetTextView=(TextView) findViewById(R.id.target);
		answerTextView=(TextView) findViewById(R.id.answer);
        set();
        
        button5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switch (rank) {
					case 0:
						Intent intent0 = new Intent(MainActivity.this, Rank0Activity.class);
						Bundle bundle0=new Bundle();
						x=Integer.toString(rank);
						bundle0.putString("num",x);
						intent0.putExtras(bundle0);
						startActivityForResult(intent0, 1);
						break;
					case 1:
						Intent intent1 = new Intent(MainActivity.this, Rank1Activity.class);
						Bundle bundle1=new Bundle();
						x=Integer.toString(rank);
						bundle1.putString("num",x);
						intent1.putExtras(bundle1);
						startActivityForResult(intent1,1);
						break;
					case 2:
						Intent intent2 = new Intent(MainActivity.this, Rank2Activity.class);
						Bundle bundle2=new Bundle();
						x=Integer.toString(rank);
						bundle2.putString("num",x);
						intent2.putExtras(bundle2);
						startActivityForResult(intent2,1);
						break;
					case 3:
						Intent intent3 = new Intent(MainActivity.this, Rank3Activity.class);
						Bundle bundle3=new Bundle();
						x=Integer.toString(rank);
						bundle3.putString("num",x);
						intent3.putExtras(bundle3);
						startActivityForResult(intent3,1);
						break;
					case 4:
						Intent intent4 = new Intent(MainActivity.this, Rank4Activity.class);
						Bundle bundle4=new Bundle();
						x=Integer.toString(rank);
						bundle4.putString("num",x);
						intent4.putExtras(bundle4);
						startActivityForResult(intent4,1);
						break;
					case 998:
						Intent intent998 = new Intent(MainActivity.this, Rank998Activity.class);
						Bundle bundle998 = new Bundle();
						x=Integer.toString(rank);
						bundle998.putString("num",x);
						intent998.putExtras(bundle998);
						startActivityForResult(intent998,1);
						break;
					case 5:
						Intent intent5 = new Intent(MainActivity.this, Rank5Activity.class);
						Bundle bundle5=new Bundle();
						x=Integer.toString(rank);
						bundle5.putString("num",x);
						intent5.putExtras(bundle5);
						startActivityForResult(intent5,1);
						break;
					case 6:
						Intent intent6 = new Intent(MainActivity.this, Rank6Activity.class);
						Bundle bundle6=new Bundle();
						x=Integer.toString(rank);
						bundle6.putString("num",x);
						intent6.putExtras(bundle6);
						startActivityForResult(intent6,1);
						break;
					case 7:
						Intent intent7 = new Intent(MainActivity.this, Rank7Activity.class);
						Bundle bundle7=new Bundle();
						x=Integer.toString(rank);
						bundle7.putString("num",x);
						intent7.putExtras(bundle7);
						startActivityForResult(intent7,1);
						break;
					case 8:
						Intent intent8 = new Intent(MainActivity.this, Rank8Activity.class);
						Bundle bundle8=new Bundle();
						x=Integer.toString(rank);
						bundle8.putString("num",x);
						intent8.putExtras(bundle8);
						startActivityForResult(intent8,1);
						break;
					case 997:
						Intent intent997 = new Intent(MainActivity.this, Rank997Activity.class);
						Bundle bundle997=new Bundle();
						x=Integer.toString(rank);
						bundle997.putString("num",x);
						intent997.putExtras(bundle997);
						startActivityForResult(intent997,1);
						break;
					case 9:
						Intent intent9 = new Intent(MainActivity.this, Rank9Activity.class);
						Bundle bundle9=new Bundle();
						x=Integer.toString(rank);
						bundle9.putString("num",x);
						intent9.putExtras(bundle9);
						startActivityForResult(intent9,1);
						break;
					case 10:
						Intent intent10 = new Intent(MainActivity.this, Rank10Activity.class);
						Bundle bundle10=new Bundle();
						x=Integer.toString(rank);
						bundle10.putString("num",x);
						intent10.putExtras(bundle10);
						startActivityForResult(intent10,1);
						break;
					case 11:
						Intent intent11 = new Intent(MainActivity.this, Rank11Activity.class);
						Bundle bundle11=new Bundle();
						x=Integer.toString(rank);
						bundle11.putString("num",x);
						intent11.putExtras(bundle11);
						startActivityForResult(intent11,1);
						break;
					case 12:
						Intent intent12 = new Intent(MainActivity.this, Rank12Activity.class);
						Bundle bundle12=new Bundle();
						x=Integer.toString(rank);
						bundle12.putString("num",x);
						intent12.putExtras(bundle12);
						startActivityForResult(intent12,1);
						break;
					default:
						break;
				}
			}
		});
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
    	if(requestCode==resultCode){
    		Bundle bundle = data.getExtras();
			x=bundle.getString("num");
			rank = Integer.parseInt(x);
			set();
    	}
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void set(){
		int co=getResources().getColor(R.color.white);
		switch (rank) {
		case 0:
			button5.setText("欢迎!");
			targetTextView.setText("幸福");
	        stepTextView.setText("0");
	        rankTextView.setText(">_<");
	        answerTextView.setText("幸福就是\n猫吃鱼狗吃肉\n而你在我身侧");
	        answerTextView.setTextSize(27);
			break;
		case 1:
			button5.setText("Come on!");
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:0");
	        answerTextView.setText("第一关来啦");
	        answerTextView.setTextSize(40);
			break;
		case 2:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:1");
	        answerTextView.setText("不错!\n第二关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
	        break;
		case 999:
			button5.setText("哇!\n心态崩了!\n再来一遍!");
			button5.setTextSize(30);
			rank=0;
			break;
		case 3:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:2");
	        answerTextView.setText("不错!\n第3关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
	        break;
		case 4:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:3");
	        answerTextView.setText("不错!\n第4关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
	        break;
		case 998:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("游戏指南");
	        answerTextView.setText("稍等......");
	        answerTextView.setTextSize(80);
	        button5.setText("?");
	        button5.setTextColor(co);
	        break;
		case 5:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:4");
	        answerTextView.setText("尝试新的按钮!\n第5关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 6:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:5");
	        answerTextView.setText("小试身手!\n第6关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 7:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:6");
	        answerTextView.setText("加大难度!\n第7关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 8:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:7");
	        answerTextView.setText("更难的来喽\n第8关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 997:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("游戏指南");
	        answerTextView.setText("又发生了!");
	        answerTextView.setTextSize(60);
	        button5.setText("什么?!");
	        button5.setTextColor(co);
			break;
		case 9:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:8");
	        answerTextView.setText("小试牛刀\n第9关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 10:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:9");
	        answerTextView.setText("难度增加~\n第10关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 11:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:10");
	        answerTextView.setText("试试这个!\n第11关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 12:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:11");
	        answerTextView.setText("继续努力!\n第12关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 13:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:12");
	        answerTextView.setText("恭喜你通关啦!\n完结~~撒花~~~");
	        answerTextView.setTextSize(40);
	        button5.setText("Thanks!");
	        break;
		default:
			answerTextView.setText("暂停!");
			button5.setText("继续游戏");
			break;
		}
        //button5.setGravity(Gravity.TOP);
		if(rank!=997||rank!=998){
	        int c=getResources().getColor(R.color.black);
			button5.setTextSize(20);
			button5.setTextColor(c);
			button5.setBackground(getResources().getDrawable(R.drawable.greenbutton));
		}
	}
    
}
