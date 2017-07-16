package com.neu.userinfo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	
	private EditText sexEdit;
	private EditText ageEdit;
	
	private Button sexBtn;
	
	public final static int SEX_CODE = 1001;
	public final static int AGE_CODE = 1002;
	
	public final static String SEX_KEY = "sex";
	public final static String AGE_KEY = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.sexEdit = (EditText)this.findViewById(R.id.sexEdit);
        this.ageEdit = (EditText)this.findViewById(R.id.ageEdit);
        
        this.sexBtn = (Button)this.findViewById(R.id.sex_btn);
        
        this.sexBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SexActivity.class);
				startActivityForResult(intent, SEX_CODE);
			}
        	
        });
    }
    
    public void inputAge(View view)
    {
    	Intent intent = new Intent(this, AgeActivity.class);
		startActivityForResult(intent, AGE_CODE);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
    	if(intent == null) {
    		return;
    	}
    	
    	Bundle bundle = intent.getExtras();
    	if(requestCode == SEX_CODE) {
    		if(bundle.containsKey(SEX_KEY)) {
    			String sex = intent.getExtras().getString(SEX_KEY);
    			this.sexEdit.setText(sex);
    		}
    	} else if(requestCode == AGE_CODE) {
    		if(bundle.containsKey(AGE_KEY)) {
    			String age = intent.getExtras().getString(AGE_KEY);
    			this.ageEdit.setText(age);
    		}
    	}
    }
    
}
