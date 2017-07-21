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
		// ����MyDatabaseHelper����ָ�����ݿ�汾Ϊ1���˴�ʹ�����·�����ɣ�
		// ���ݿ��ļ��Զ��ᱣ���ڳ���������ļ��е�databasesĿ¼�¡�
		db = SQLiteDatabase.openOrCreateDatabase(
				this.getFilesDir().toString()
				+ "/stu.db3", null);
		insert = (Button) findViewById(R.id.insert);
		insert.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ��ȡ�û�����
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
					// ִ��insert����������
					insertData(db, stu_number, stu_name ,stu_classname, stu_grade);
				}
				// ��ʾ��ʾ��Ϣ
				Toast.makeText(NewActivity.this, "��ӳɹ���", 8000).show();
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
		// ִ�в������
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