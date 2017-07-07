package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	GridView grid;
	ImageView imageView;
	int[] imageIds = new int[]
			{
				R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
				, R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
				, R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
				, R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
			};
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ����һ��List����List�����Ԫ����Map
		List<Map<String, Object>> listItems = 
				new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imageIds.length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}
		// ��ȡ��ʾͼƬ��Image1
		imageView = (ImageView) findViewById(R.id.imageView);
		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				listItems
				// ʹ��/layout/cell.xml�ļ���Ϊ���沼��
				, R.layout.activity_main, new String[] { "image" },
				new int[] { R.id.image1 });
		grid = (GridView) findViewById(R.id.grid01);
		// ΪGridView����Adapter
		grid.setAdapter(simpleAdapter);
		// �����б��ѡ�еļ�����
		grid.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				// ��ʾ��ǰ��ѡ�е�ͼƬ
				imageView.setImageResource(imageIds[position]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});
		// �����б�������ļ�����
		grid.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				// ��ʾ��������ͼƬ��ͼƬ
				imageView.setImageResource(imageIds[position]);
			}
		});
	}
    
}