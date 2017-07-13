package com.aren.moveplane.util;


import java.io.FileDescriptor;
import java.io.IOException;

import com.aren.moveplane.PlaneApp;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnCompletionListener;


public class MusicPlayer 
{	
	private int volume = 50;
	
	private MediaPlayer mediaPlayer=null;
	private Activity activity;
	private int resid;
	
	public MusicPlayer(Activity activity, int resid)
	{
		this.activity=activity;
		
		setMusicResource(resid);
	}
	
	private void reset()
	{
		stopMusic();
		
		if(mediaPlayer!=null) {
			
			mediaPlayer.reset();
			
			try {
				AssetFileDescriptor afd = activity.getResources().openRawResourceFd(resid);
	            
				if (afd == null) {
	            	return;
	            }
	            
	            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
	            afd.close();
				mediaPlayer.prepare();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			MediaListener listener=new MediaListener();
		
			mediaPlayer.setOnPreparedListener(listener);
			mediaPlayer.setOnCompletionListener(listener);
		}
	}
	
	public void setMusicResource(int resid)
	{
		if(mediaPlayer == null) {
			this.resid = resid;
			mediaPlayer = MediaPlayer.create(activity, resid);
		} else {
			if(this.resid != resid) {
				this.resid = resid;
				reset();	
			}
		}
	}
	
	public boolean setMusicFromSDcard(String path)
	{
		boolean isSet=true;
		
		if(mediaPlayer == null) {
			mediaPlayer = new MediaPlayer();
		}
		
		reset();
		
		try  {
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
		}  catch (IllegalArgumentException e)  {
			PlaneApp.log("Exception: " + e.toString());
			isSet=false;
		} catch (IllegalStateException e)  {
			PlaneApp.log("Exception: " + e.toString());
			isSet=false;
		} catch (IOException e)  {
			PlaneApp.log("Exception: " + e.toString());
			isSet=false;
		}
		
		if(!isSet) {
			destory();
		}
		
		return isSet;
	}
	
	public boolean setMusicAsset(String fileName) 
	{	
		AssetManager assetManager = this.activity.getAssets();
		
		FileDescriptor descriptor = null;
		
		try {
			AssetFileDescriptor assetfiledescriptor = assetManager.openFd(fileName);
			descriptor = assetfiledescriptor.getFileDescriptor();
		} catch (IOException e) {
			PlaneApp.log("Exception: " + e.toString());
			descriptor = null;
		}
		
		if(descriptor != null) {
			return setMusicFileDescriptor(descriptor);
		}
		
		destory();
		
		return false;
	}
	
	public boolean setMusicFileDescriptor(FileDescriptor descriptor)
	{
		boolean isSet=true;
		
		if(mediaPlayer == null) {
			mediaPlayer = new MediaPlayer();
		} else {
			this.stopMusic();
			mediaPlayer.reset();
		}
		
		try {
			mediaPlayer.setDataSource(descriptor);
			mediaPlayer.prepare();
		} catch (IllegalArgumentException e) {
			PlaneApp.log("Exception: " + e.toString());
			isSet = false;
		} catch (IllegalStateException e) {
			PlaneApp.log("Exception: " + e.toString());
			isSet = false;
		} catch (IOException e) {
			PlaneApp.log("Exception: " + e.toString());
			isSet = false;
		}
		
		if(!isSet) {
			destory();
		}
		
		return isSet;
	}
	
	public void addVolume()
	{
		if(volume<100){
			volume+=10;
		}
		
		updateVolume();
	}
	
	public void subVolume()
	{
		if(volume>=10) {
			volume-=10;
		}
		
		updateVolume();
	}
	
	public void updateVolume()
	{
		if(mediaPlayer!=null) {
			mediaPlayer.setVolume(volume, volume);
		}
	}
	
	public void startMusic() 
	{
		if(mediaPlayer!=null)
		{
			updateVolume();
			mediaPlayer.setLooping(true);
			mediaPlayer.start();
		}
	}
	
	public void stopMusic() 
	{
		if(mediaPlayer!=null)
		{
			if(mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
			}
		}
	}
	
	public void destory()
	{
		stopMusic();
		
		if(mediaPlayer!=null) {
			mediaPlayer.reset();
			mediaPlayer.release();
			
			mediaPlayer=null;
		}
	}
	
	private final class MediaListener implements OnPreparedListener,OnCompletionListener 
	{
		@Override
		public void onPrepared(MediaPlayer mp) 
		{
			mediaPlayer.start();
		}

		@Override
		public void onCompletion(MediaPlayer mp) 
		{
			mediaPlayer.start();
		};
	}
}
