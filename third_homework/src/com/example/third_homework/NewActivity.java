package com.example.third_homework;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;

public class NewActivity extends Activity
{
	MyDatabaseHelper dbHelper;
	private Button insert;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newer);
		// 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可，
		// 数据库文件自动会保存在程序的数据文件夹的databases目录下。
		dbHelper = new MyDatabaseHelper(this, "message.db3", 1);
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
				// 插入生词记录
				/*ContentValues values = new ContentValues();
				values.put(stu_number, stu_name);
				values.put(stu_name, stu_name);
				values.put(stu_classname, stu_classname);
				values.put(stu_grade, stu_grade);*/
				insertData(dbHelper.getReadableDatabase(),stu_number,stu_name,stu_classname,stu_grade);
				// 显示提示信息
				Toast.makeText(NewActivity.this, "添加生词成功！", 8000).show();
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
		db.execSQL("insert into dict values(null , ? , ? , ? , ?)"
			, new String[] {number, name , classname, grade });
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		// 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
		if (dbHelper != null)
		{
			dbHelper.close();
		}
	}
}