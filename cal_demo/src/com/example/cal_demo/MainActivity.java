package com.example.cal_demo;

import com.example.cal_demo.MainActivity;
import com.example.cal_demo.RankoneActivity;

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
    int rank=1;
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
					case 1:
						Intent intent = new Intent(MainActivity.this, RankoneActivity.class);
						Bundle bundle=new Bundle();
						bundle.putInt("num", rank);
						intent.putExtras(bundle);
						startActivityForResult(intent, 1);
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
			String x=bundle.getString("num");
			maxn= Integer.parseInt(x);
    	}
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	public void set(){
		
        if(rank==1)
        	button5.setText("欢迎!");
        else button5.setText("\n继续\n下一关");
        button5.setGravity(Gravity.CENTER);
        button5.setTextSize(20);
        int co=getResources().getColor(R.color.black);
        button5.setTextColor(co);
        button5.setBackground(getResources().getDrawable(R.drawable.green));
        
        targetTextView.setText("幸福");
        stepTextView.setText("0");
        rankTextView.setText(">_<");
        answerTextView.setText("幸福就是\n猫吃鱼狗吃肉\n而你在我身侧");
        answerTextView.setTextSize(27);
        
	}
    
}
