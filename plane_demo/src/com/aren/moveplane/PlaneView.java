package com.aren.moveplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.aren.moveplane.holder.BulletBallHolder;
import com.aren.moveplane.holder.BulletHolder;
import com.aren.moveplane.holder.BulletMapHolder;
import com.aren.moveplane.holder.PlaneHolder;
import com.aren.moveplane.holder.ScreenInfoHolder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
* Description:
* <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
* <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
* <br/>This program is protected by copyright laws.
* <br/>Program Name:
* <br/>Date:
* @author  Yeeku.H.Lee kongyeeku@163.com
* @version  1.0
*/
public class PlaneView extends View
{	
	private boolean isLose;
	
	// 记录背景位图的实际高度
	private int BACK_HEIGHT;
	private int BACK_WIDTH;
	
	private int screenW;
	private int screenH;
	
	// 背景图片的开始位置
	private int viewW;
	private int viewH;
	
	private int generateBullet = 0;
	
	private float scale;
	
	private int startY;
	private int backSpeed = 5;
	
	private Bitmap back;
	private Matrix martrix;
	private Paint textPaint;
	
	private PlaneHolder planeHolder;
	private ScreenInfoHolder screenHolder;
	
	private List<BulletHolder> bullets;
	
	
	private Paint bmpPaint;
	private Bitmap cacheBitmap;
	private Canvas cacheCanvas;
	
	final Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if (msg.what == 0x123)
			{
				// 重新开始移动
				if (startY <= 0)
				{
					startY = BACK_HEIGHT - viewH;
				}
				else
				{
					if(startY > backSpeed) {
						startY -= backSpeed;
					} else {
						startY = 0;
					}
				}
				
				if(generateBullet % 6 == 0) {
					
					BulletHolder bullet = null;
					
					if(generateBullet >= 12) {
						bullet = addMapBulletFromPlane();
						generateBullet = 0;
					} else {
						bullet = addBallBulletFromPlane();
					}
					
					bullets.add(bullet);
				}
				
				generateBullet++;
			}
			
			PlaneView.this.invalidate();
		}
	};
	
	public PlaneView(Context context)
	{
		super(context);
		
		textPaint = new Paint();
		
		generateBullet = 0;
		
		back = BitmapFactory.decodeResource(context.getResources(),R.drawable.back_img);
		
		planeHolder = new PlaneHolder(context);
		
		BACK_WIDTH = back.getWidth();
		BACK_HEIGHT = back.getHeight();
		
		PlaneApp.log("back("+BACK_WIDTH+","+BACK_HEIGHT+")");
		
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		
		screenW = metrics.widthPixels;
		screenH = metrics.heightPixels;
		
		float density = metrics.density;
				
		backSpeed = (int)(backSpeed * density);
		scale = (float)(screenW*1.0/BACK_WIDTH);
		
		viewW = BACK_WIDTH;
		viewH = (int)(screenH/scale);
		startY = BACK_HEIGHT - viewH;
		
		PlaneApp.log("view("+viewW+","+viewH+"),scale"+scale);
		
		martrix = new Matrix();
		martrix.setScale(scale, scale);
		
		bullets = new ArrayList<BulletHolder>();
		
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				handler.sendEmptyMessage(0x123);
			}

		}, 0, 100);
		
		setFocusable(true);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(planeHolder.onKeyDown(keyCode, event)) {
			invalidate();
			return true;
		}
		
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		// TODO Auto-generated method stub
		
		if(planeHolder.onTouchEvent(event)) {
			invalidate();
			return true;
		}
		
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		resetCacheCanvas();
		
		drawBackGround(cacheCanvas);
		
		drawSize(cacheCanvas);
		
		planeHolder.drawPane(cacheCanvas);
		drawBullet(cacheCanvas);
		
		drawGameOver(cacheCanvas);
		
		canvas.drawBitmap(this.cacheBitmap, 0, 0, this.bmpPaint);
	}
	
	private void resetCacheCanvas()
	{
		if(bmpPaint == null) {
			this.bmpPaint = new Paint();
			this.cacheCanvas = new Canvas();
		}
		
		this.cacheBitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Config.ARGB_8888);
		this.cacheCanvas.setBitmap(cacheBitmap);
	}
	
	private void drawBackGround(Canvas canvas)
	{
		Bitmap bitmap = Bitmap.createBitmap(back, 0, startY, viewW, viewH, martrix,true);
		canvas.drawBitmap(bitmap, 0, 0, null);
	}
	
	private void drawSize(Canvas canvas)
	{
		if(this.screenHolder == null) {
			this.screenHolder = new ScreenInfoHolder(this);
		}
		
		this.screenHolder.drawScreenSize(canvas);
	}
	
	private void drawBullet(Canvas canvas)
	{
		List<BulletHolder> outbullets = new ArrayList<BulletHolder>();
		
		for (BulletHolder bulletHolder : bullets)
		{
			if(bulletHolder.isOut()) {
				outbullets.add(bulletHolder);
				continue;
			}
			
			bulletHolder.drawBullet(canvas);
			
			bulletHolder.move();
		}
		
		if(outbullets.size()>0) {
			bullets.removeAll(outbullets);
		}
	}
	
	private void drawGameOver(Canvas canvas)
	{
		// 如果游戏已经结束
		if (isLose)
		{
			textPaint.setColor(Color.RED);
			textPaint.setTextSize(40);
			canvas.drawText("游戏已结束", 50, 200, textPaint);
		}
	}
	
	
	private BulletHolder addBallBulletFromPlane()
	{
		float x = this.planeHolder.getPlaneCenterX();
		float y = this.planeHolder.getPlaneY() - BulletBallHolder.SIZE;
		
		return addBallBullet(x,y);
	}
	
	private BulletHolder addMapBulletFromPlane()
	{
		float x = this.planeHolder.getPlaneCenterX();
		float y = this.planeHolder.getPlaneY() - BulletMapHolder.SIZE;
		
		return addMapBullet(x,y);
	}
	
	private BulletBallHolder addBallBullet(float x, float y)
	{
		BulletBallHolder bulletHolder = new BulletBallHolder(x,y);
		return bulletHolder; 
	}
	
	private BulletMapHolder addMapBullet(float x, float y)
	{
		BulletMapHolder bulletHolder = new BulletMapHolder(this.getContext(), x, y);
		return bulletHolder; 
	}
}


