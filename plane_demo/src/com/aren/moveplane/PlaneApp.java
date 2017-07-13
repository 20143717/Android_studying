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
	private static boolean saveCacheOnScard=true;	//true�����汣�����ڴ濨�ϣ�false�����汣�����ֻ�����
	
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
		
		dialogBuilder.setTitle("�������");
		dialogBuilder.setMessage("�������磬��رմ���");
		
		dialogBuilder.setPositiveButton("��������",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
				
				//Action Net Setting
				context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
			}
		});
		
		dialogBuilder.setNegativeButton("�˳�",new OnClickListener()
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
		dialogBuilder.setMessage("ȷ��Ҫ�˳���");	//set the view for the dilog, something like setMessage() 
		
		dialogBuilder.setPositiveButton("��",new OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				dialog.cancel();
				PlaneApp.exitApp();
			}
		});
		
		dialogBuilder.setNegativeButton("��",new OnClickListener()
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
			.setPositiveButton("ȷ��", listener)
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
			.setPositiveButton("ȷ��", listener)
			.create()
			.show();
	}
}
