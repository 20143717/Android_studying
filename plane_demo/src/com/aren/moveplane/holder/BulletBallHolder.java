package com.aren.moveplane.holder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

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
public class BulletBallHolder extends BulletHolder
{
	private int color;
	private float alpha = 1f;
	private Paint paint;
	private ShapeDrawable shape;
	private RadialGradient gradient;
	
	private int speed = 10;
	public final static int SIZE = 10;

	public BulletBallHolder(float x, float y)
	{
		OvalShape circle = new OvalShape();
		circle.resize(SIZE, SIZE);
		ShapeDrawable drawable = new ShapeDrawable(circle);
		
//		this.x = (float)( x - SIZE / 2.0);
//		this.y = (float)(y - SIZE / 2.0);
		
		this.centerX = x;
		this.centerY = y;
		
		shape = drawable;
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		
		this.color = 0xff000000 + red << 16 | green << 8 | blue;
		
		this.paint = drawable.getPaint();
		int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue / 4;
		
		this.gradient = new RadialGradient(37.5f, 12.5f, SIZE, color, darkColor, Shader.TileMode.CLAMP);
		
		this.paint.setShader(gradient);
	}

	public ShapeDrawable getShape()
	{
		return shape;
	}

	public int getColor()
	{
		return color;
	}

	public RadialGradient getGradient()
	{
		return gradient;
	}

	public float getAlpha()
	{
		return alpha;
	}
	
	@Override
	public int size()
	{
		return SIZE;
	}
	
	@Override
	public void drawBullet(Canvas canvas)
	{
		paint.setStyle(Paint.Style.FILL);
		paint.setAntiAlias(true);
		
		paint.setColor(Color.rgb(240, 240, 80));
		canvas.drawCircle(centerX, centerY, SIZE, paint);
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
