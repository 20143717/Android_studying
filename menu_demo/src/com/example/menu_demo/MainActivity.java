package com.example.menu_demo;

import android.R.integer;
import android.R.menu;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView;
	private ActionBar actionBar;
	private final static int GROUP_ID=1;
	
	private final static int ITEM_ID_1=1;
	private final static int ITEM_ID_2=1;
	private final static int ITEM_ID_3=1;
	private final static int ITEM_ID_4=1;
	
	private final static int HIDE_ACTION_BAR=1;
	private final static int SHOW_ACTION_BAR=2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView=(TextView)this.findViewById(R.id.textView);
        this.registerForContextMenu(textView);
        
        actionBar = this.getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0, SHOW_ACTION_BAR, 0, "show action bar");
        menu.add(0, HIDE_ACTION_BAR, 0, "hide action bar");
        return true;
    }
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	int id=item.getItemId();
    	
    	if(id==R.id.action_settings){
    		return true;
    	}
    	else if(id == SHOW_ACTION_BAR){
    		actionBar.show();
    		Toast.makeText(this, "show action bar", Toast.LENGTH_SHORT).show();
    		return true;
    	}
    	else if(id == HIDE_ACTION_BAR){
    		actionBar.hide();
    		Toast.makeText(this, "hide action bar", Toast.LENGTH_SHORT).show();
    		return true;
    	}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
    	menu.add(GROUP_ID, ITEM_ID_1, 0, "Java");
    	menu.add(GROUP_ID, ITEM_ID_2, 0, "C/C++");
    	menu.add(GROUP_ID, ITEM_ID_3, 0, "Python");
    	menu.add(GROUP_ID, ITEM_ID_4, 0, "Ruty");
    	
    	menu.setHeaderIcon(R.drawable.ic_launcher);
    	menu.setHeaderTitle("choose your language:");
    	
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		if(id==ITEM_ID_1){
			textView.setText("your program with Java");
			return true;
		}
		else if(id==ITEM_ID_2){
			textView.setText("your program with C/C++");
			return true;
		}
		else if(id==ITEM_ID_3){
			textView.setText("your program with Python");
			return true;
		}
		else if(id==ITEM_ID_4){
			textView.setText("your program with Ruty");
			return true;
		}
		return super.onContextItemSelected(item);
	}
	
	
}
