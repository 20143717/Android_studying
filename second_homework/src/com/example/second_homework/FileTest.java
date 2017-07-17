package com.example.second_homework;

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
import android.widget.TableLayout;
import android.widget.Toast;

public class FileTest extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final EditText edit1 = (EditText) findViewById(R.id.edit1);
		Button filelist = (Button) findViewById(R.id.filelist);
		Button write = (Button) findViewById(R.id.write);
		write.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				customView(edit1.getText().toString());
			}
		});

		filelist.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(FileTest.this,SelectFileActivity.class);
				startActivityForResult(intent, 0);
				finish();
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
	
	public void customView(final String content)
	{
		final TableLayout titleForm = (TableLayout)getLayoutInflater().inflate( R.layout.title, null);		
		new AlertDialog.Builder(this)
		.setTitle("请输入文件名称")
		.setView(titleForm)
		.setPositiveButton("创建" , new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				EditText text = (EditText)titleForm.findViewById(R.id.title);  
				String title=text.getText().toString();
				write(title, content);
				
				final EditText edit1 = (EditText) findViewById(R.id.edit1);
				edit1.setText("");
				Toast toast = Toast.makeText(FileTest.this, "文件保存成功", Toast.LENGTH_SHORT);
				toast.show();
			}
		})
		.setNegativeButton("取消", new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(FileTest.this
					, "取消保存！", Toast.LENGTH_SHORT);
				toast.show();
			}
		})
		.create()
		.show();
	}
}