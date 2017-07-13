package com.aren.moveplane;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;

public class PlaneApp extends Application 
{
	private static boolean saveCacheOnScard=true;	//true将缓存保存在内存卡上，false将缓存保存在手机卡上
	
	public static Context context;
	public static Resources resource;
	
	public final static String TAG = "MovePlane";

	@Override
	
	public void onCreate() 
	{
		super.onCreate();
		
		context = getApplicationContext();
		resource = context.getResources();
		
		log("PlaneApp Create");
	}
	
	public static void log(String msg)
	{
		Log.i(TAG, msg);
	}
	
	public static void startBackService(String action)
	{
		/*
		 * this need to config in Manifest.xml, else [ new Intent(context, BackService.class); ] instead 
		 * */
		
		if(context!=null) {
			Intent intent=new Intent(action);
			context.startService(intent);
		}
	}
	
	public static void exitApp()
	{
		
	}
	
	public static void setSaveOption(boolean onSdcard)
	{
		saveCacheOnScard=onSdcard;
		
		if(saveCacheOnScard)
		{
			//clear data on phone;
		}
		else
		{
			//clear data on sdcard;;
		}
	}
	
	public static boolean saveOnSdcard(boolean onPhone)
	{
		return saveCacheOnScard;
	}
	
	public static void altertNetError(final Context context)
	{		
		AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
		
		dialogBuilder.setTitle("网络错误");
		dialogBuilder.setMessage("设置网络，或关闭窗口");
		
		dialogBuilder.setPositiveButton("设置网络",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
				
				//Action Net Setting
				context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
			}
		});
		
		dialogBuilder.setNegativeButton("退出",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
				PlaneApp.exitApp();
			}
		});
		
		dialogBuilder.create().show();
	}
	
	public static void promptExit(final Context con)
	{
		AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(con);
		dialogBuilder.setMessage("确定要退出吗？");	//set the view for the dilog, something like setMessage() 
		
		dialogBuilder.setPositiveButton("是",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
				PlaneApp.exitApp();
			}
		});
		
		dialogBuilder.setNegativeButton("否",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
			}
		});
		
		dialogBuilder.create().show();
	}
	
	public static void showDialog(final Context context, String msg)
	{
		showDialog(context, msg, null);
	}
	
	public static void showDialog(final Context ctx, String msg, final OnClickListener listener)
	{
		new AlertDialog.Builder(ctx)
			.setMessage(msg)
			.setCancelable(false)
			.setPositiveButton("确定", listener)
			.create()
			.show();
	}
	
	public static void showDialog(Context context, View view)
	{
		showDialog(context, view, null);
	}
	
	public static void showDialog(Context ctx, View view, final OnClickListener listener)
	{
		new AlertDialog.Builder(ctx)
			.setView(view).setCancelable(false)
			.setPositiveButton("确定", listener)
			.create()
			.show();
	}
}
