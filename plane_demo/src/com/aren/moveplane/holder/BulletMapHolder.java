package com.aren.moveplane.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.aren.moveplane.R;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class BulletMapHolder  extends BulletHolder
{
	private int speed = 10;
	public final static int SIZE = 20;
	
	private static Bitmap bullerMap = null;
	
	private Context context;
	
	private static Bitmap getBulletMap(Resources res)
	{
		if(bullerMap == null) {
			Drawable tile=res.getDrawable(R.drawable.redstar);
			
			Bitmap map=Bitmap.createBitmap(SIZE, SIZE, Bitmap.Config.ARGB_8888);
			
			Canvas canvas=new Canvas(map);	
			tile.setBounds(0, 0, SIZE, SIZE);
			tile.draw(canvas);
			
			bullerMap = map;
		}
		
		return bullerMap;
	}
	
	public BulletMapHolder(Context context, float x, float y)
	{
		this.context = context;
		
		this.centerX = x;
		this.centerY = y;		
	}
	
	@Override
	public int size()
	{
		return SIZE;
	}

	@Override
	public void drawBullet(Canvas canvas)
	{
		float x = (float)(centerX - SIZE/2.0);
		float y = (float)(centerY - SIZE/2.0);
		
		Bitmap map = getBulletMap(this.context.getResources());
		
		canvas.drawBitmap(map, x, y, null);
	}
	
	@Override
	public void move()
	{
		this.centerY = this.centerY - this.speed;
		
		if(this.centerY + SIZE < 0) {
			isOut = true;
		}
	}
	
}
