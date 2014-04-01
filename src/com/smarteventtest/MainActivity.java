package com.smarteventtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView text;
	private ImageView img;
	GestureDetector gestureDetector;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (TextView) findViewById(R.id.text);
		Button button = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		img = (ImageView) findViewById(R.id.imageView1);

		gestureDetector = new GestureDetector(new OnGestureListener() {

			@Override
			public boolean onDown(MotionEvent event) {
				// TODO Auto-generated method stub
				text.setText("mouse down" + " " + event.getX() + ","
						+ event.getY());
				return false;
			}

			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2,
					float velocityX, float velocityY) {
				// TODO Auto-generated method stub
				text.setText("onFling");
				return false;
			}

			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				text.setText("onLongPress");

			}

			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2,
					float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				text.setText("onScroll");
				return false;
			}

			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				text.setText("onShowPress");

			}

			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				text.setText("onSingleTapUp");
				return false;
			}

		});

		button.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				MotionEvent e = MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN,
						240, 290, 0);
				onTouchEvent(e);
				MotionEvent e2 = MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE,
						240, 290, 0);
				onTouchEvent(e2);
				MotionEvent e3 = MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 240,
						290, 0);
				onTouchEvent(e3);
			}
		});
		img.setFocusable(true);
		// img.setFilterTouchesWhenObscured(true);
		// img.setFocusableInTouchMode(true);
		img.setOnTouchListener(new touchListen());
		img.setOnKeyListener(new ImageView.OnKeyListener(){

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event){
				// TODO Auto-generated method stub
				 if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
						Toast.makeText(MainActivity.this, "KEYCODE_DPAD_CENTER被触发",
								Toast.LENGTH_SHORT).show();
				 }
				return false;
			}
			
		});
		button.setOnKeyListener(new keyListen(MainActivity.this));

		button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "button2被触发",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	public class keyListen implements OnKeyListener {

		Context context;

		public keyListen(Context context) {
			this.context = context;
		}

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == KeyEvent.ACTION_DOWN) {
				switch (keyCode) {
				case KeyEvent.KEYCODE_DPAD_CENTER:
					Toast.makeText(context, "按下:中键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_UP:
					Toast.makeText(context, "按下:上键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					Toast.makeText(context, "按下:下键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_LEFT:
					Toast.makeText(context, "按下:左键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_RIGHT:
					Toast.makeText(context, "按下:右键", Toast.LENGTH_SHORT).show();
					break;
				}

			}

			if (event.getAction() == KeyEvent.ACTION_UP) {
				switch (keyCode) {
				case KeyEvent.KEYCODE_DPAD_CENTER:
					Toast.makeText(context, "抬起:中键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_UP:
					Toast.makeText(context, "抬起:上键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_DOWN:
					Toast.makeText(context, "抬起:下键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_LEFT:
					Toast.makeText(context, "抬起:左键", Toast.LENGTH_SHORT).show();
					break;
				case KeyEvent.KEYCODE_DPAD_RIGHT:
					Toast.makeText(context, "抬起:右键", Toast.LENGTH_SHORT).show();
					break;
				}
			}
			return true;
		}

	}

	@Override
	// 按键按下出发事件
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			Toast.makeText(this, "按下:中键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			Toast.makeText(this, "按下:上键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			Toast.makeText(this, "按下:下键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			Toast.makeText(this, "按下:左键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			Toast.makeText(this, "按下:右键", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	// 按键抬起触发事件
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_CENTER:
			Toast.makeText(this, "抬起:中键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			Toast.makeText(this, "抬起:上键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			Toast.makeText(this, "抬起:下键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			Toast.makeText(this, "抬起:左键", Toast.LENGTH_SHORT).show();
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			Toast.makeText(this, "抬起:右键", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	public class touchListen implements OnTouchListener {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			// int iAction = event.getAction();

			text.setText("坐标:" + img.getWidth() + "," + img.getHeight());
			if (event.getAction() == MotionEvent.ACTION_MOVE) {
				// if(event.getAction() != MotionEvent.ACTION_OUTSIDE){
				text.setText("坐标:" + (int) event.getX() + ","
						+ (int) event.getY());
				// }
				//return true;
			}
			return false;

//			if (gestureDetector.onTouchEvent(event)) {
//				return true;
//			} else {
//
//			}
//			return false;

			// if(event.getAction()== MotionEvent.ACTION_DOWN){
			// //if(event.getAction() != MotionEvent.ACTION_OUTSIDE){
			// text.setText("ACTION_DOWN)");
			// // }
			//
			// }
			//
			//
			// if(event.getAction()== MotionEvent.ACTION_UP){
			// //if(event.getAction() != MotionEvent.ACTION_OUTSIDE){
			// text.setText("ACTION_UP)");
			// // }
			//
			// }
			//return super.onTouch(v,event);

		}

	}

	// 触笔事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int iAction = event.getAction();
		// 触笔点击事件
		// if (iAction == MotionEvent.ACTION_CANCEL
		// || iAction == MotionEvent.ACTION_DOWN
		// || iAction == MotionEvent.ACTION_MOVE) {
		// return false;
		// }
		// int x = (int) event.getX();
		// int y = (int) event.getY();
		// Toast.makeText(this, "触笔点击坐标"+x+","+y,Toast.LENGTH_SHORT).show();

		// if(gestureDetector.onTouchEvent(event)){
		// return true;
		// }
		// else{
		//
		// }
		// return false;

		// 触笔移动坐标监听
		 if(iAction == MotionEvent.ACTION_MOVE){
		 //text.setText("坐标:"+(int)event.getX()+","+(int)event.getY());
		 }else{
		 return false;
		 }
		return super.onTouchEvent(event);
	}

}
