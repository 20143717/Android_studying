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
		// ����MyDatabaseHelper����ָ�����ݿ�汾Ϊ1���˴�ʹ�����·�����ɣ�
		// ���ݿ��ļ��Զ��ᱣ���ڳ���������ļ��е�databasesĿ¼�¡�
		dbHelper = new MyDatabaseHelper(this, "message.db3", 1);
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
				// �������ʼ�¼
				/*ContentValues values = new ContentValues();
				values.put(stu_number, stu_name);
				values.put(stu_name, stu_name);
				values.put(stu_classname, stu_classname);
				values.put(stu_grade, stu_grade);*/
				insertData(dbHelper.getReadableDatabase(),stu_number,stu_name,stu_classname,stu_grade);
				// ��ʾ��ʾ��Ϣ
				Toast.makeText(NewActivity.this, "������ʳɹ���", 8000).show();
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
		db.execSQL("insert into dict values(null , ? , ? , ? , ?)"
			, new String[] {number, name , classname, grade });
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		// �˳�����ʱ�ر�MyDatabaseHelper���SQLiteDatabase
		if (dbHelper != null)
		{
			dbHelper.close();
		}
	}
}