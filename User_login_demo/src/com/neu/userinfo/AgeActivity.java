package com.neu.userinfo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AgeActivity extends Activity {
	
	private EditText ageEdit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);
        
        this.ageEdit = (EditText)this.findViewById(R.id.ageEdit);
    }
    
    public void backHome(View view) {
    	
    	Intent intent = this.getIntent();
    	
    	intent.putExtra(MainActivity.AGE_KEY, this.ageEdit.getText().toString());
		setResult(MainActivity.AGE_CODE, intent);
		finish();
    }
}
