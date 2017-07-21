package com.example.third_homework;

import com.example.third_homework.NewActivity;
import com.example.third_homework.R;
import com.example.third_homework.search_1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


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
				// 获取用户输入
				Intent intent = new Intent(MainActivity.this, search_1.class);
//				intent.setClass(MainActivity.this, NewActivity.class);
				startActivityForResult(intent, 0);
			}
		});
        seltwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, search_2.class);
//				intent.setClass(MainActivity.this, NewActivity.class);
				startActivityForResult(intent, 0);
			}
		});
    }

    
}
