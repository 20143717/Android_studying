package com.example.second_homework;

import java.util.ArrayList;
import java.util.HashMap;

import org.crazyit.io.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;   
  

public class SelectFileActivity extends Activity {
	
	private String[] filenames ;
	private ListView listview;
	private Button writeButton; 
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		filenames=fileList();
        listview=(ListView)findViewById(R.id.listview);   
        writeButton=(Button)findViewById(R.id.write); 
        ArrayList<HashMap<String,String>> myArrayList=new ArrayList<HashMap<String,String>>();  
        for(int i=0;i<filenames.length;i++){   
            HashMap<String, String> map = new HashMap<String, String>();   
            map.put("Title", filenames[i]);   
            myArrayList.add(map);   
        }   
        SimpleAdapter mySimpleAdapter=new SimpleAdapter(this,myArrayList,R.layout.list_item,
                new String[]{"Title"},new int[]{R.id.Title}
        );      
        listview.setAdapter(mySimpleAdapter);   
        listview.setOnItemClickListener(new OnItemClickListener(){   
            @Override   
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {   
                HashMap<String,String> map=(HashMap<String,String>)listview.getItemAtPosition(arg2);   
                String title=map.get("Title");   
                Intent intent = new Intent(SelectFileActivity.this,FileActivity.class);
				intent.putExtra("filename", title);
				startActivityForResult(intent, 0);
            }         
        });   
        writeButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				Intent intent = new Intent(SelectFileActivity.this,FileTest.class);
				startActivityForResult(intent, 0);
				finish();
			}
		});
    }   
}
