package com.aren.moveplane.view;

import com.aren.moveplane.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DialogView extends FrameLayout {

	public DialogView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		init(context);
	}

	public DialogView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
		init(context);
	}

	public DialogView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		init(context);
	}
	
	private void init(Context context) 
	{
		LayoutInflater.from(context).inflate(R.layout.main, this);
		
		TextView show = (TextView)this.findViewById(R.id.show);
		
		show.setText("DialogView");
	}
	
}
