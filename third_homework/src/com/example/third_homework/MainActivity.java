package com.example.third_homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * @author 10375
 *
 */
public class MainActivity extends Activity {
	
	private Button newButton;
	private Button seloneButton;
	private Button seltwoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Intent intent=getIntent();         
//        Bundle bundle=intent.getExtras(); 
        
        newButton = (Button) findViewById(R.id.newer);
        seloneButton = (Button) findViewById(R.id.search_1);
        seltwoButton = (Button) findViewById(R.id.search_2);
        
        newButton.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, NewActivity.class);
//				intent.setClass(MainActivity.this, NewActivity.class);
				startActivityForResult(intent, 0);
			}
		});
        seloneButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        seltwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    
}
