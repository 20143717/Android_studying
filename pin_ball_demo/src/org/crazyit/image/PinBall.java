package org.crazyit.image;

import java.security.PrivateKey;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.PrivateCredentialPermission;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class PinBall extends Activity
{
	// ����Ŀ��
	private int tableWidth;
	// ����ĸ߶�
	private int tableHeight;
	// ���ĵĴ�ֱλ��
	private int racketY;
	// ���涨�����ĵĸ߶ȺͿ��
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 70;
	// С��Ĵ�С
	private final int BALL_SIZE = 12;
	// С������������ٶ�
	private int ySpeed = 10*2;
	Random rand = new Random();
	// ����һ��-0.5~0.5�ı��ʣ����ڿ���С������з���
	private double xyRate = rand.nextDouble() - 0.5;
	// С�����������ٶ�
	private int xSpeed = (int) (ySpeed * xyRate * 2);
	
	// ballX��ballY����С�������
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;
	// racketX�������ĵ�ˮƽλ��
	private int racketX = rand.nextInt(200);
	// ��Ϸ�Ƿ���������
	private boolean isLose = false;
	
	private GameView gameView;

	final Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if (msg.what == 0x123)
			{
				gameView.invalidate();
			}
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// ȥ�����ڱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ȫ����ʾ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// ����GameView���
		this.gameView = new GameView(this);
		
		setContentView(gameView);
		// ��ȡ���ڹ�����
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		// �����Ļ��͸�
		tableWidth = metrics.widthPixels;
		tableHeight = metrics.heightPixels;
		racketY = tableHeight - 50;

		gameView.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_DOWN) {
					if(isLose){
						reStartGame();
						return true;
					}
					float dx= (event.getX() - racketX - RACKET_WIDTH/2);
					float dy= (event.getY() - racketY - RACKET_HEIGHT/2);
					if(dx>0){
						boolean top=true;
						if(dy<0) {dy*=-1;top=false;}
						if(dy/dx<=1){
							if(racketX < tableWidth - RACKET_WIDTH) racketX+=20;
						}
						else{
							if(top){
								if(racketY < tableHeight - RACKET_HEIGHT) racketY +=20;
							}
							else{
								if(racketY > 0) racketY -= 20;
							}
						}
					} 
					else{
						dx*=-1;
						boolean top=true;
						if(dy<0) {dy*=-1;top=false;}
						if(dy/dx<=1){
							if(racketX > 0) racketX -= 20;
						}
						else{
							if(top){
								if(racketY < tableHeight - RACKET_HEIGHT) racketY +=20;
							}
							else{
								if(racketY > 0) racketY -= 20;
							}
						}
					}
					gameView.invalidate();
					
					// TODO Auto-generated method stub
					return true;
				}
				
				return false;
			}
			
		});
		
		startGame();
	}
	
	public void reStartGame()
	{
		// ballX��ballY����С�������
		ballX = rand.nextInt(200) + 20;
		ballY = rand.nextInt(10) + 20;
		// racketX�������ĵ�ˮƽλ��
		racketX = rand.nextInt(200);
		// ��Ϸ�Ƿ���������
		isLose = false;
		
		startGame();
	}
	
	public void startGame()
	{

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() // ��
		{

			@Override
			public void run()
			{
				// ���С��������߱߿�
				if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE)
				{
					xSpeed = -xSpeed;
				}
				// ���С��߶ȳ���������λ�ã��Һ��������ķ�Χ֮�ڣ���Ϸ������
				if (ballY >= racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH))
				{
					timer.cancel();
					// ������Ϸ�Ƿ���������Ϊtrue��
					isLose = true;
				}
				// ���С��λ������֮�ڣ��ҵ�������λ�ã�С�򷴵�
				else if (ballY <= 0 || (ballY >= racketY - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH))
				{
					ySpeed = -ySpeed;
				}
				// С����������
				ballY += ySpeed;
				ballX += xSpeed;
				// ������Ϣ��֪ͨϵͳ�ػ����
				handler.sendEmptyMessage(0x123);
			}
		}, 0, 100);
	}

	class GameView extends View
	{
		Paint paint = new Paint();

		public GameView(Context context)
		{
			super(context);
			setFocusable(true);
		}

		// ��дView��onDraw������ʵ�ֻ滭
		public void onDraw(Canvas canvas)
		{
			paint.setStyle(Paint.Style.FILL);
			// ����ȥ���
			paint.setAntiAlias(true);
			// �����Ϸ�Ѿ�����
			if (isLose)
			{
				paint.setColor(Color.RED);
				paint.setTextSize(30);
				canvas.drawText("��Ϸ�ѽ������������¿�ʼ", 50, 200, paint);
			}
			// �����Ϸ��δ����
			else
			{
				// ������ɫ��������С��
				paint.setColor(Color.rgb(240, 240, 80));
				canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
				// ������ɫ������������
				paint.setColor(Color.rgb(80, 80, 200));
				canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH, racketY + RACKET_HEIGHT, paint);
			}
		}
	}
}