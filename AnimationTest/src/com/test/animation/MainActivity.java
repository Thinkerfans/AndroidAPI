package com.test.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView) findViewById(R.id.imageView1);		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btAlpha:
//			alphaAnimationTest(image);
			xmlAnimationTest(image, R.anim.myalpha);
			break;
		case R.id.btScale:
//			scaleAnimationTest(image);
			xmlAnimationTest(image, R.anim.myscale);
			break;
		case R.id.btRotate:
			rotateAnimationTest(image);
//			xmlAnimationTest(image, R.anim.myrotate);
			break;
		case R.id.btTranslate:
//			translateAnimationTest(image);
			xmlAnimationTest(image, R.anim.mytranslate);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void alphaAnimationTest(View v) {
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
		javaAnimationTest(v, alphaAnimation);
	}
	

	
	private void scaleAnimationTest(View v) {
		ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, 0.5f, 0.5f);
		javaAnimationTest(v, scaleAnimation);
	}
	

	private void rotateAnimationTest(View v) {
		RotateAnimation rotateAnimation = new RotateAnimation(0, 360,50f,50f);
		javaAnimationTest(v, rotateAnimation);
	}

	private void translateAnimationTest(View v) {
		TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
		javaAnimationTest(v, translateAnimation);
	}
	
	private void javaAnimationTest(View v,Animation anim){
		anim.setDuration(3000);
		anim.setInterpolator(this, android.R.interpolator.accelerate_decelerate);
//		anim.setInterpolator(this,android.R.anim.accelerate_decelerate_interpolator);
		v.startAnimation(anim);
	}

	private void xmlAnimationTest(View v ,int animId) {
		Animation au = AnimationUtils.loadAnimation(this, animId);
		v.startAnimation(au);
	}
	
}
