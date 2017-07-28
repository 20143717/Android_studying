package com.example.cal_demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.PublicKey;
import java.util.StringTokenizer;

import org.apache.http.util.EncodingUtils;

import com.example.cal_demo.MainActivity;
import com.example.cal_demo.Rank0Activity;

import android.R.integer;
import android.R.string;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    int rank=0;
    String x;
    boolean y=false;
    private int maxn=0;
    Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
    private SharedPreferences sp;
    TextView rankTextView;
	TextView stepTextView;
	TextView targetTextView;
	TextView answerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1=(Button) findViewById(R.id.one);
		button2=(Button) findViewById(R.id.two);
		button3=(Button) findViewById(R.id.three);
		button4=(Button) findViewById(R.id.four);
		button5=(Button) findViewById(R.id.five);
		button6=(Button) findViewById(R.id.six);
		button7=(Button) findViewById(R.id.seven);
		button8=(Button) findViewById(R.id.eight);
		button9=(Button) findViewById(R.id.nine);
		
        rankTextView=(TextView) findViewById(R.id.rank);
		stepTextView=(TextView) findViewById(R.id.step);
		targetTextView=(TextView) findViewById(R.id.target);
		answerTextView=(TextView) findViewById(R.id.answer);
		read();
		
        set();
        
        button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(y==false){
					x=Integer.toString(rank);
					Bundle bundle=new Bundle();
					bundle.putString("num",x);
				switch (rank) {
					case 0:
						Intent intent = new Intent(MainActivity.this, Rank0Activity.class);
						intent.putExtras(bundle);
						startActivityForResult(intent, 1);
						break;
					case 1:
						Intent intent1 = new Intent(MainActivity.this, Rank1Activity.class);
						intent1.putExtras(bundle);
						startActivityForResult(intent1,1);
						break;
					case 2:
						Intent intent2 = new Intent(MainActivity.this, Rank2Activity.class);
						intent2.putExtras(bundle);
						startActivityForResult(intent2,1);
						break;
					case 3:
						Intent intent3 = new Intent(MainActivity.this, Rank3Activity.class);
						intent3.putExtras(bundle);
						startActivityForResult(intent3,1);
						break;
					case 4:
						Intent intent4 = new Intent(MainActivity.this, Rank4Activity.class);
						intent4.putExtras(bundle);
						startActivityForResult(intent4,1);
						break;
					case 998:
						Intent intent998 = new Intent(MainActivity.this, Rank998Activity.class);
						intent998.putExtras(bundle);
						startActivityForResult(intent998,1);
						break;
					case 5:
						Intent intent5 = new Intent(MainActivity.this, Rank5Activity.class);
						intent5.putExtras(bundle);
						startActivityForResult(intent5,1);
						break;
					case 6:
						Intent intent6 = new Intent(MainActivity.this, Rank6Activity.class);
						intent6.putExtras(bundle);
						startActivityForResult(intent6,1);
						break;
					case 7:
						Intent intent7 = new Intent(MainActivity.this, Rank7Activity.class);
						intent7.putExtras(bundle);
						startActivityForResult(intent7,1);
						break;
					case 8:
						Intent intent8 = new Intent(MainActivity.this, Rank8Activity.class);
						intent8.putExtras(bundle);
						startActivityForResult(intent8,1);
						break;
					case 997:
						Intent intent997 = new Intent(MainActivity.this, Rank997Activity.class);
						intent997.putExtras(bundle);
						startActivityForResult(intent997,1);
						break;
					case 9:
						Intent intent9 = new Intent(MainActivity.this, Rank9Activity.class);
						intent9.putExtras(bundle);
						startActivityForResult(intent9,1);
						break;
					case 10:
						Intent intent10 = new Intent(MainActivity.this, Rank10Activity.class);
						intent10.putExtras(bundle);
						startActivityForResult(intent10,1);
						break;
					case 11:
						Intent intent11 = new Intent(MainActivity.this, Rank11Activity.class);
						intent11.putExtras(bundle);
						startActivityForResult(intent11,1);
						break;
					case 12:
						Intent intent12 = new Intent(MainActivity.this, Rank12Activity.class);
						intent12.putExtras(bundle);
						startActivityForResult(intent12,1);
						break;
					case 996:
						Intent intent996 = new Intent(MainActivity.this, Rank996Activity.class);
						intent996.putExtras(bundle);
						startActivityForResult(intent996,1);
						break;
					case 13:
						Intent intent13 = new Intent(MainActivity.this, Rank13Activity.class);
						intent13.putExtras(bundle);
						startActivityForResult(intent13,1);
						break;
					case 14:
						Intent intent14 = new Intent(MainActivity.this, Rank14Activity.class);
						intent14.putExtras(bundle);
						startActivityForResult(intent14,1);
						break;
					case 15:
						Intent intent15 = new Intent(MainActivity.this, Rank15Activity.class);
						intent15.putExtras(bundle);
						startActivityForResult(intent15,1);
						break;
					case 16:
						Intent intent16 = new Intent(MainActivity.this, Rank16Activity.class);
						intent16.putExtras(bundle);
						startActivityForResult(intent16,1);
						break;
					case 17:
						Intent intent17 = new Intent(MainActivity.this, Rank17Activity.class);
						intent17.putExtras(bundle);
						startActivityForResult(intent17,1);
						break;
					case 18:
						Intent intent18 = new Intent(MainActivity.this, Rank18Activity.class);
						intent18.putExtras(bundle);
						startActivityForResult(intent18,1);
						break;
					case 995:
						Intent intent995 = new Intent(MainActivity.this, Rank995Activity.class);
						intent995.putExtras(bundle);
						startActivityForResult(intent995,1);
						break;
					case 19:
						Intent intent19 = new Intent(MainActivity.this, Rank19Activity.class);
						intent19.putExtras(bundle);
						startActivityForResult(intent19,1);
						break;
					case 20:
						Intent intent20 = new Intent(MainActivity.this, Rank20Activity.class);
						intent20.putExtras(bundle);
						startActivityForResult(intent20,1);
						break;
					case 21:
						Intent intent21 = new Intent(MainActivity.this, Rank21Activity.class);
						intent21.putExtras(bundle);
						startActivityForResult(intent21,1);
						break;
					case 22:
						Intent intent22 = new Intent(MainActivity.this, Rank22Activity.class);
						intent22.putExtras(bundle);
						startActivityForResult(intent22,1);
						break;
					case 23:
						Intent intent23 = new Intent(MainActivity.this, Rank23Activity.class);
						intent23.putExtras(bundle);
						startActivityForResult(intent23,1);
						break;
					case 24:
						Intent intent24 = new Intent(MainActivity.this, Rank24Activity.class);
						intent24.putExtras(bundle);
						startActivityForResult(intent24,1);
						break;
					case 25:
						Intent intent25 = new Intent(MainActivity.this, Rank25Activity.class);
						intent25.putExtras(bundle);
						startActivityForResult(intent25,1);
						break;
					case 26:
						Intent intent26= new Intent(MainActivity.this, Rank26Activity.class);
						intent26.putExtras(bundle);
						startActivityForResult(intent26,1);
						break;
					default:
						break;
				}
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
			y=bundle.getBoolean("setting");
			rank = Integer.parseInt(x);
			if(y){
				setting(x);
			}
			else{
				if(rank<=100){
					if(rank>maxn) maxn=rank;
				}
				set();
				load(rank,maxn);
			}
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
		x=Integer.toString(rank);
		String nn=Integer.toString(rank-1);
		targetTextView.setText("");
        stepTextView.setText("");
        rankTextView.setText("等级:"+nn);
        answerTextView.setText("不错哟~\n第"+x+"关来啦");
        answerTextView.setTextSize(40);
        button5.setText("继续游戏");
		switch (rank) {
		case 0:
			button5.setText("欢迎!");
			targetTextView.setText("幸福");
	        stepTextView.setText("0");
	        rankTextView.setText(">_<");
	        answerTextView.setText("幸福就是\n猫吃鱼狗吃肉\n而你在我身侧");
	        answerTextView.setTextSize(27);
			break;
		case 2:
	        answerTextView.setText("不错!\n第二关来啦");
	        break;
		case 999:
			button5.setText("哇!\n心态崩了!\n再来一遍!");
			button5.setTextSize(30);
			rank=0;
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
		case 13:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:12");
	        answerTextView.setText("试试新按钮\n第13关!");
	        answerTextView.setTextSize(40);
	        button5.setText("好的");
	        break;	
		case 996:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("游戏指南");
	        answerTextView.setText("等等……");
	        answerTextView.setTextSize(60);
	        button5.setText("怎么啦?!");
	        button5.setTextColor(co);
			break;
		case 995:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("游戏指南");
	        answerTextView.setText("哇偶!\n意想不到的发现");
	        answerTextView.setTextSize(40);
	        button5.setText("???");
	        button5.setTextColor(co);
			break;
		case 19:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:18");
	        answerTextView.setText("尝试新按钮\n第19关来啦");
	        answerTextView.setTextSize(40);
	        button5.setText("继续游戏");
			break;
		case 27:
			targetTextView.setText("");
	        stepTextView.setText("");
	        rankTextView.setText("等级:26");
	        answerTextView.setText("恭喜你通关啦!\n完结~~撒花~~~");
	        answerTextView.setTextSize(40);
	        button5.setText("Thanks!");
	        break;
		default:
			break;
		}
        //button5.setGravity(Gravity.TOP);
		if(rank!=997||rank!=998||rank!=1000||rank!=999||rank!=996||rank!=995){
	        int c=getResources().getColor(R.color.black);
			button5.setTextSize(20);
			button5.setTextColor(c);
			button5.setBackground(getResources().getDrawable(R.drawable.greenbutton));
		}
	}
	public void load(int a,int b){
		String rankString=Integer.toString(a);
		String maxnString=Integer.toString(b);
		sp.edit()
			.putString("RANK",rankString)
			.putString("MAXN",maxnString)
			.commit();
	}
	public void read() {
		sp = getSharedPreferences("data", MODE_PRIVATE);
		rank = Integer.parseInt(sp.getString("RANK", "0"));
		maxn = Integer.parseInt(sp.getString("MAXN", "0"));
	}
	public void setting(String k){
		int co=getResources().getColor(R.color.white);
		targetTextView.setText("");
        stepTextView.setText("");
        rankTextView.setText("设置");
        rankTextView.setTextColor(co);
        answerTextView.setText("暂停");
        answerTextView.setGravity(Gravity.CENTER);
        answerTextView.setTextSize(80);
        button7.setBackground(getResources().getDrawable(R.drawable.shadow));
        button4.setBackground(getResources().getDrawable(R.drawable.shadow));
        button6.setBackground(getResources().getDrawable(R.drawable.shadow));
        button8.setBackground(getResources().getDrawable(R.drawable.shadow));
        button5.setText("等级\n"+k);
        button5.setGravity(Gravity.CENTER);
        button5.setTextColor(co);
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
    	String mm=Integer.toString(maxn);
		Bundle bundle=new Bundle();
		bundle.putString("num",x);
		bundle.putString("maxn",mm);
		intent.putExtras(bundle);
		startActivityForResult(intent, 1);
	}
}
