package io.pen.bluepixel.elegantriddlesfreefull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Splash extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		final int welcomeScreenDisplay = 2800;

		Thread welcomeThread = new Thread() {
			int wait = 0;
			@Override
			public void run() {
				try {
					super.run();
					while (wait < welcomeScreenDisplay) {
						sleep(100);
						wait += 100;
					}
				} catch (Exception e) {
					startActivity(new Intent(Splash.this, ElegantRiddlesActivity.class));
					finish();
				} finally {
					startActivity(new Intent(Splash.this, ElegantRiddlesActivity.class));
					finish();
				}
			}
		};
		welcomeThread.start();

	LinearLayout llSplash = (LinearLayout)findViewById(R.id.mainSplash);
	Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.unsplash);
	llSplash.startAnimation(fadeOut);
}

}
