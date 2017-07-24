package com.example.third_homework;

import com.example.third_homework.search_1;

import com.example.third_homework.R;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


@SuppressLint("NewApi") public class search_1 extends Activity{

	SQLiteDatabase db;
	Button searchButton;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_1);
		searchButton= (Button) findViewById(R.id.search_1);
		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+ "/stu.db3", null);
		listView = (ListView) findViewById(R.id.show);
		searchButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// ��ȡ�û�����
				String key = ((EditText) findViewById(R.id.stu_number)).getText()
					.toString();
				// ִ�в�ѯ
				Cursor cursor = db.rawQuery(
					"select * from stu_inf where stu_number = ? ",
					new String[] { key });
				inflateList(cursor);
			}
		});
	}
	private void inflateList(Cursor cursor)
	{
		// ���SimpleCursorAdapter
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
			search_1.this,
			R.layout.line, cursor,
			new String[] {"stu_name", "stu_classname","stu_grade"}
			, new int[] {R.id.stu_name, R.id.stu_classname,R.id.stu_grade },
			CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER); //��
		// ��ʾ����
		listView.setAdapter(adapter);
	}
}
 