package com.aren.moveplane;

import com.aren.moveplane.util.MusicPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

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
public class MovePlane extends Activity
{
	private static int screenH;
	private static int screenW;
	
	private static DisplayMetrics metrics;
	
	private MusicPlayer player;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Display display = MovePlane.this.getWindowManager().getDefaultDisplay();
		metrics = new DisplayMetrics(); 
		display.getMetrics(metrics);
		
		screenW = metrics.widthPixels;
		screenH = metrics.heightPixels;			
		PlaneApp.log("screen("+screenW+","+screenH+")");
		
		setContentView(new PlaneView(this));
		
		this.player = new MusicPlayer(this, R.raw.beautiful);
	}
	

	@Override
	protected void onResume() {
		super.onResume();
		
		player.startMusic();
	}



	public static int getScreenH() {
		return screenH;
	}

	public static int getScreenW() {
		return screenW;
	}

	public static DisplayMetrics getMetrics() {
		return metrics;
	}
}

