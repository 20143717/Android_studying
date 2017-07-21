package com.example.third_homework;

import com.example.third_homework.search_2;
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


@SuppressLint("NewApi") public class search_2 extends Activity{

	SQLiteDatabase db;
	Button searchButton;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_2);
		searchButton= (Button) findViewById(R.id.search_2);
		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+ "/stu.db3", null);
		listView = (ListView) findViewById(R.id.show);
		searchButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 获取用户输入
				String key = ((EditText) findViewById(R.id.stu_number)).getText().toString();
				String key2= ((EditText) findViewById(R.id.stu_classname)).getText().toString();
				// 执行查询
				Cursor cursor = db.rawQuery(
					"select * from stu_inf where stu_number = ?  and stu_classname = ? ",
					new String[] { key , key2});
				inflateList(cursor);
			}
		});
	}
	private void inflateList(Cursor cursor)
	{
		// 填充SimpleCursorAdapter
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
			search_2.this,
			R.layout.line, cursor,
			new String[] {"stu_name", "stu_classname","stu_grade"}
			, new int[] {R.id.stu_name, R.id.stu_classname,R.id.stu_grade },
			CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER); //③
		// 显示数据
		listView.setAdapter(adapter); 
		
	}
}
 