package com.neu.userinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class SexActivity extends Activity {
	
	private EditText sexEdit;
	private Button confirmBtn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sex);
        this.sexEdit = (EditText)this.findViewById(R.id.sexEdit);
        
        confirmBtn = (Button)this.findViewById(R.id.sex_btn);
        
        confirmBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = SexActivity.this.getIntent();
		    	intent.putExtra(MainActivity.SEX_KEY, SexActivity.this.sexEdit.getText().toString());
				setResult(MainActivity.SEX_CODE, intent);
				
				SexActivity.this.finish();
			}
        	;
        });
    }
}
