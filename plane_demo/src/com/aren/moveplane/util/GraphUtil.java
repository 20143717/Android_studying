package com.aren.moveplane.util;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;

public class GraphUtil {

	public static float getTextWidth(String str, Paint paint)
	{
		if(str == null || str.length() < 1 || paint == null){
			return 0;
		}
		
		float[] widths = new float[str.length() + 2];
		
		int count = paint.getTextWidths(str, widths);
		
		float tWidth = 0;
		
		for(int i = 0; i< count; i++) {
			tWidth += widths[i];
		}
		
		return tWidth;
	}
	
	// number: 0-100
	public static Bitmap getTransparentBitmap(Bitmap src, int number)
	{
		int width=src.getWidth();
		int height=src.getHeight();
		
		int[] argb = new int[width * height];
		
		src.getPixels(argb, 0, width, 0, 0, width, height);
		
		number = number * 255/100;
		
		for(int i= 0; i<argb.length; i++) {
			argb[i] = (number << 24 |(argb[i] & 0x00FFFFFF)); 
		}
		
		Bitmap transparentMap = Bitmap.createBitmap(argb, width, height,Config.ARGB_8888);
		
		return transparentMap;
	}
		
}
