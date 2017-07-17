package com.example.second_homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.crazyit.io.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileActivity extends Activity{
	private EditText filecontent;
	private Button saveButton;
	private Button gobackButton;
	private String filename;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);  
        setContentView(R.layout.file);  
        Intent intent=getIntent();  
        Bundle bundle=intent.getExtras();  
        filename=bundle.getString("filename");
        String content=read(filename);
        saveButton = (Button) findViewById(R.id.save);
        gobackButton=(Button) findViewById(R.id.goback);
        filecontent=(EditText)findViewById(R.id.filecontent);  
        filecontent.setText(content);   
        gobackButton.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
            	Intent intent = new Intent(FileActivity.this,SelectFileActivity.class);
				startActivityForResult(intent, 0);
				finish();
            }  
        });
        saveButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				filecontent=(EditText)findViewById(R.id.filecontent);  
				String content=filecontent.getText().toString();
				deleteFile(filename);
				write(filename, content);
				Intent intent = new Intent(FileActivity.this,SelectFileActivity.class);
				startActivityForResult(intent, 0);
				finish(); 
				Toast toast = Toast.makeText(FileActivity.this, "文件保存成功", Toast.LENGTH_SHORT);
				toast.show();
			}
        });
	}
	public void write(String filename, String content)
	{
		try
		{
			FileOutputStream fos = openFileOutput(filename, MODE_APPEND);
			PrintStream ps = new PrintStream(fos);
			ps.println(content);
			ps.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String read(String FILE_NAME)
	{
		try
		{
			FileInputStream fis = openFileInput(FILE_NAME);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder("");
			while ((hasRead = fis.read(buff)) > 0)
			{
				sb.append(new String(buff, 0, hasRead));
			}
			fis.close();
			return sb.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
