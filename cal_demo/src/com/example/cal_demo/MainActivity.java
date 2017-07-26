package com.example.cal_demo;

import com.example.cal_demo.MainActivity;
import com.example.cal_demo.RankzeroActivity;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    int rank=0;
    String x;
    private int maxn;
    private Button button5;
    TextView rankTextView;
	TextView stepTextView;
	TextView targetTextView;
	TextView answerTextView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button5 = (Button) findViewById(R.id.five);
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
						Intent intent0 = new Intent(MainActivity.this, RankzeroActivity.class);
						Bundle bundle0=new Bundle();
						x=Integer.toString(rank);
						bundle0.putString("num",x);
						intent0.putExtras(bundle0);
						startActivityForResult(intent0, 1);
						break;
					case 1:
						Intent intent1 = new Intent(MainActivity.this, RankoneActivity.class);
						Bundle bundle1=new Bundle();
						x=Integer.toString(rank);
						bundle1.putString("num",x);
						intent1.putExtras(bundle1);
						startActivityForResult(intent1,1);
						break;
					case 2:
						Intent intent2 = new Intent(MainActivity.this, RanktwoActivity.class);
						Bundle bundle2=new Bundle();
						x=Integer.toString(rank);
						bundle2.putString("num",x);
						intent2.putExtras(bundle2);
						startActivityForResult(intent2,1);
						break;
					case 3:
						Intent intent3 = new Intent(MainActivity.this, RankthreeActivity.class);
						Bundle bundle3=new Bundle();
						x=Integer.toString(rank);
						bundle3.putString("num",x);
						intent3.putExtras(bundle3);
						startActivityForResult(intent3,1);
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
			button5.setText("哇!心态崩了!\n再教你一遍~~~");
			button5.setTextSize(30);
			rank=0;
			break;
		default:
			button5.setText("继续游戏");
			break;
		}
        //button5.setGravity(Gravity.TOP);
        int co=getResources().getColor(R.color.black);
		button5.setTextSize(20);
		button5.setTextColor(co);
		button5.setBackground(getResources().getDrawable(R.drawable.greenbutton));
        
        
        
	}
    
}
