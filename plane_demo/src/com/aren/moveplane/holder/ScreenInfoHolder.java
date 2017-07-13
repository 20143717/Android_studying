package com.aren.moveplane.holder;

import com.aren.moveplane.util.GraphUtil;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.Log;
import android.view.View;

public class ScreenInfoHolder {
	
	
	private int height;
	private int width;
	private int texth;
	
	private float scaledDensity;
	private boolean isInit = false;
	
	private Paint paint;	
	private View ownerView;
	
	public ScreenInfoHolder(View view)
	{
		this.ownerView = view; 
	}
	
	private void init()
	{	
		if(isInit) {
			return;
		}
		
		isInit = true;
		
		height=this.ownerView.getHeight();
		width=this.ownerView.getWidth();
		
		scaledDensity  = this.ownerView.getContext().getResources().getDisplayMetrics().scaledDensity;
		
		Log.i("SnakeActivity","BackView size:( "+width+" x "+height+" )");
		
		this.paint=new Paint();
		this.paint.setAntiAlias(true);
		this.paint.setColor(Color.parseColor("#ff8888ff"));
		this.paint.setTextSize(24 * scaledDensity);
		
		FontMetrics fm = this.paint.getFontMetrics();
		texth=(int) Math.ceil(fm.descent-fm.ascent);
	}
	
	public void drawScreenSize(Canvas canvas) 
	{	
		if(!isInit) {
			this.init();
		}
		
		drawScreenInfo(canvas);
	}
	
	private void drawScreenInfo(Canvas canvas)
	{
		int y = (height-texth*2)/2;
		
		String str= width + " x " + height;
		String center= "center";		
		
		int x1 = startXInCenterHorizonal(str);
		int x2 = startXInCenterHorizonal(center);
		
		canvas.drawText(str, x1, y, this.paint);
		canvas.drawText(center, x2, y+texth, this.paint);
	}
	
	private int startXInCenterHorizonal(String str) {
		
		float tWidth = GraphUtil.getTextWidth(str, this.paint);
		
		int x = (int)((width - tWidth )/2);
		
		return x;
	}

}
