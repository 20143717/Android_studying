package com.example.third_homework;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewActivity extends Activity
{
	SQLiteDatabase db;
	private Button insert;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newer);
		// 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可，
		// 数据库文件自动会保存在程序的数据文件夹的databases目录下。
		db = SQLiteDatabase.openOrCreateDatabase(
				this.getFilesDir().toString()
				+ "/stu.db3", null);
		insert = (Button) findViewById(R.id.insert);
		insert.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 获取用户输入
				String stu_number = ((EditText) findViewById(R.id.stu_number))
					.getText().toString();
				String stu_name = ((EditText) findViewById(R.id.stu_name))
						.getText().toString();
				String stu_classname = ((EditText) findViewById(R.id.stu_classname))
						.getText().toString();
				String stu_grade = ((EditText) findViewById(R.id.stu_grade))
					.getText().toString();
				try
				{
					insertData(db, stu_number, stu_name ,stu_classname, stu_grade);
				}
				catch (SQLiteException se)
				{
					db.execSQL("create table stu_inf(_id integer"
						+ " primary key autoincrement,"
						+ "stu_number varchar(255),"
						+ "stu_name varchar(255),"
						+ "stu_classname varchar(255),"
						+ "stu_grade varchar(255))");
					// 执行insert语句插入数据
					insertData(db, stu_number, stu_name ,stu_classname, stu_grade);
				}
				// 显示提示信息
				Toast.makeText(NewActivity.this, "添加成功！", 8000).show();
				final EditText stu_numberEditText=(EditText) findViewById(R.id.stu_number);
				final EditText stu_nameEditText = (EditText) findViewById(R.id.stu_name);
				final EditText stu_classnameEditText =(EditText) findViewById(R.id.stu_classname);
				final EditText stu_gradEditText = (EditText) findViewById(R.id.stu_grade);
				stu_classnameEditText.setText("");
				stu_gradEditText.setText("");
				stu_nameEditText.setText("");
				stu_numberEditText.setText("");
			}
		});
	}
	private void insertData(SQLiteDatabase db,String number, String name,String classname,String grade)
	{
		// 执行插入语句
		db.execSQL("insert into stu_inf values(null , ? , ? , ? , ?)"
			, new String[] {number, name , classname, grade });
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (db != null&& db.isOpen())
		{
			db.close();
		}
	}
}