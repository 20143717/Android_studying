package com.aren.moveplane.holder;

import android.graphics.Canvas;

public abstract class BulletHolder 
{
	protected boolean isOut = false;
	
	protected float centerX = 0;
	protected float centerY = 0;
	
	public float getX()
	{
		return centerX;
	}

	public float getY()
	{
		return centerY;
	}

	
	public boolean isOut() {
		return isOut;
	}
	
	abstract public int size();
	abstract public void drawBullet(Canvas canvas);
	abstract public void move();

}
