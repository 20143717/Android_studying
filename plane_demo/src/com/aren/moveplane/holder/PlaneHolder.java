package com.aren.moveplane.holder;

import android.content.Context;
import com.aren.moveplane.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class PlaneHolder {

	private float planeX;
	private float planeY;
	
	private float lastEventX;
	private float lastEventY;
	
	private int planeWidth;
	private int planeHeight;
	
	private int planeSpeed = 10;

	private int screenW;
	private int screenH;
	
	private Bitmap plane;
	
	public PlaneHolder(Context context) 
	{
		plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
		
		this.planeWidth = plane.getWidth();
		this.planeHeight = plane.getHeight();
		
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		
		screenW = metrics.widthPixels;
		screenH = metrics.heightPixels;
		
		planeX = (screenW - planeWidth)/2;
		planeY = (screenH - planeHeight)/2;
		
		planeSpeed = (int)(planeSpeed *metrics.density * 1.5);
	}
	
	public float getPlaneX() {
		return planeX;
	}
	
	public float getPlaneY() {
		return planeY;
	}

	public int getPlaneWidth() {
		return planeWidth;
	}

	public int getPlaneHeight() {
		return planeHeight;
	}

	public float getPlaneCenterX() {
		return this.planeX + this.planeWidth/2;
	}

	public float getPlaneCenterY() {
		return this.planeY + this.planeHeight/2;
	}

	public void drawPane(Canvas canvas)
	{
		canvas.drawBitmap(plane, planeX, planeY, null);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		keyCode = event.getKeyCode();
		
		if( keyCode == KeyEvent.KEYCODE_S || keyCode == KeyEvent.KEYCODE_DPAD_DOWN || 
			keyCode == KeyEvent.KEYCODE_W || keyCode == KeyEvent.KEYCODE_DPAD_UP ||
			keyCode == KeyEvent.KEYCODE_A || keyCode == KeyEvent.KEYCODE_DPAD_LEFT || 
			keyCode == KeyEvent.KEYCODE_D || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT ) {
			
			switch (event.getKeyCode())
			{
				// 控制飞机下移
				case KeyEvent.KEYCODE_S:
					turnDown();
					break;
				// 控制飞机上移
				case KeyEvent.KEYCODE_W:
					turnUp();
					break;
				// 控制飞机左移
				case KeyEvent.KEYCODE_A:
					turnLeft();
					break;
				// 控制飞机右移
				case KeyEvent.KEYCODE_D:
					turnRight();
					break;
			}
			
			
			return true;
		}
		
		return false;
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		
		float eventX = event.getX();
		float eventY = event.getY();
		
		float planeCenterX = this.planeX + this.planeWidth/2;
		float planeCenterY = this.planeY + this.planeHeight/2;
		
		float x = eventX - planeCenterX;
		float y = eventY - planeCenterY;
		
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
						
			if (x == 0 && y == 0) {
				return true;
			}

			if (x == 0) {
				if (y > 0)
					turnDown(); // 向下
				if (y < 0)
					turnUp(); // 向上
			}

			if (y == 0) {
				if (x > 0)
					turnRight(); // 向右
				if (x < 0)
					turnLeft(); // 向左
			}

			if (y < 0 && (x > 0 && x + y < 0) || (x < 0 && x > y)) {
				turnUp();
			}

			if (y > 0 && (x > 0 && x < y) || (x < 0 && x + y > 0)) {
				turnDown();
			}

			if (x > 0) {
				turnRight();
			} else {
				turnLeft();
			}
			
			return true;
		} else if(event.getAction() == MotionEvent.ACTION_MOVE) {
			
			if(this.lastEventX > 0) {
				
				x = eventX - this.lastEventX;
				y = eventY - this.lastEventY;
			
				if (x >= this.planeSpeed) {
					turnRight();
				} else if (x <= -this.planeSpeed){
					turnLeft();
				}
				
				if (y >= this.planeSpeed) {
					turnDown(); 
				} else if (y <= -this.planeSpeed) {
					turnUp();
				}
			}
			
			this.lastEventX = eventX;
			this.lastEventY = eventY;
			
			return true;
			
		} else if(event.getAction() == MotionEvent.ACTION_UP){
			this.lastEventX = -1;
			this.lastEventY = -1;
			return false;
		}
		
		return false;
	}
	
	private void turnUp() {
		
		if(this.planeY > planeSpeed) {
			this.planeY -= planeSpeed;
		} else {
			this.planeY -= 0;
		}
	}
	
	private void turnDown() {
		
		if(this.planeY + planeHeight < screenH - planeSpeed) {
			this.planeY += planeSpeed;
		} else {
			this.planeY = screenH - planeSpeed;
		}
	}
	
	private void turnLeft() {
		
		if(this.planeX > planeSpeed) {
			this.planeX -= planeSpeed;
		} else {
			this.planeX -= 0;
		}
	}
	
	private void turnRight() {
		
		if(this.planeX + planeWidth < screenW - planeSpeed) {
			this.planeX += planeSpeed;
		} else {
			this.planeX = screenW - planeSpeed;
		}
	}
}
