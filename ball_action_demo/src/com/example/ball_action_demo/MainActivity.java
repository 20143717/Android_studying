package com.example.ball_action_demo;

import java.util.ArrayList;

import com.example.ball_action_demo.ShapeHolder;

import android.animation.*;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

	static final float ball_size=50F;
	static final float full_time=1000;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(new MyAnimationView(this));
    }
    public class MyAnimationView extends View implements AnimatorUpdateListener 
    {
    	public final ArrayList<ShapeHolder> balls 
		= new ArrayList<ShapeHolder>();
    	public MyAnimationView(Context context)
    	{
    		super(context);
    		setBackgroundColor(Color.WHITE);
    	}
		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
			if (event.getAction() != MotionEvent.ACTION_DOWN
				&& event.getAction() != MotionEvent.ACTION_MOVE)
			{
				return false;
			}
			ShapeHolder newBall = addBall(event.getX(), event.getY());
			float startY = newBall.getY();
			float endY = getHeight() - ball_size;
			float h = (float) getHeight();
			float eventY = event.getY();
			int duration = (int) (full_time * ((h - eventY) / h));
			ValueAnimator fallAnim = ObjectAnimator.ofFloat(
				newBall, "y", startY, endY);
			fallAnim.setDuration(duration);
			fallAnim.setInterpolator(new AccelerateInterpolator());
			fallAnim.addUpdateListener(this);
			ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f);
			fadeAnim.setDuration(250);
			fadeAnim.addListener(new AnimatorListenerAdapter()
			{
				@Override
				public void onAnimationEnd(Animator animation)
				{
					balls.remove(((ObjectAnimator) animation).getTarget());
				}
			});
			fadeAnim.addUpdateListener(this);		
			AnimatorSet animatorSet = new AnimatorSet();
			animatorSet.play(fallAnim).before(fadeAnim);
			animatorSet.start();
			return true;
	    }
		private ShapeHolder addBall(float x, float y)
		{
			OvalShape circle = new OvalShape();
			circle.resize(ball_size, ball_size);
			ShapeDrawable drawable = new ShapeDrawable(circle);
			ShapeHolder shapeHolder = new ShapeHolder(drawable);
			shapeHolder.setX(x - ball_size / 2);
			shapeHolder.setY(y - ball_size / 2);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			int color = 0xff000000 + red << 16 | green << 8 | blue;
			Paint paint = drawable.getPaint();
			int darkColor = 0xff000000 | red / 4 << 16 
				| green / 4 << 8 | blue / 4;
			RadialGradient gradient = new RadialGradient(
				37.5f, 12.5f, ball_size, color, darkColor
				, Shader.TileMode.CLAMP);
			paint.setShader(gradient);
			shapeHolder.setPaint(paint);
			balls.add(shapeHolder);
			return shapeHolder;
		}
		@Override
		protected void onDraw(Canvas canvas)
		{
			for (ShapeHolder shapeHolder : balls)
			{
				canvas.save();
				canvas.translate(shapeHolder.getX()
					, shapeHolder.getY());
				shapeHolder.getShape().draw(canvas);
				canvas.restore();
			}
		}
		@Override
		public void onAnimationUpdate(ValueAnimator animation)
		{
			this.invalidate(); //¢Ù
		}
    }
}
