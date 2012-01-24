package io.pen.bluepixel.elegantriddles;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class ElegantRiddlesActivity extends Activity implements OnGestureListener, ViewFactory{

	private static final int[] LOOKUP_TITLES = new int[] {R.string.play,R.string.random,R.string.credits};
	private static final int[] LOOKUP_SUBTITLES = new int[] {R.string.tableOfContents,R.string.random_sub,R.string.credits_sub};

	private GestureDetector gestureScanner;
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;

	public static final String PREFS_NAME = "EEPrefsFile";

	private int menuPosition = 1;
	private TextSwitcher mSwitcher;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gestureScanner = new GestureDetector(this);	 

		//Text Switcher
		mSwitcher = (TextSwitcher) findViewById(R.id.switcher);
		mSwitcher.setFactory(this);
		Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
		mSwitcher.setInAnimation(in);
		mSwitcher.setOutAnimation(out);
		mSwitcher.setText(getResources().getString(LOOKUP_SUBTITLES[menuPosition-1]));

		//Set listeners
		final ImageButton forwardButton = (ImageButton) findViewById(R.id.mainButtonForward);
		forwardButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				getNextMenuElement();
			}});
		final ImageButton backButton = (ImageButton) findViewById(R.id.mainButtonBack);
		backButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				getPrevMenuElement();
			}
		});
	}

	@Override
	public void onBackPressed() {
		confirmQuit();
	}

	private void confirmQuit(){
		new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(R.string.quit).setMessage(R.string.really_quit).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();    
			}
		})
		.setNegativeButton(android.R.string.no, null).show();
	}

	private void getNextMenuElement() {
		if (menuPosition<LOOKUP_TITLES.length)
			menuPosition++;
		else
			menuPosition = 1;
		((Button)findViewById(R.id.mainButtonCentral)).setText(LOOKUP_TITLES[menuPosition-1]);
		mSwitcher.setText(getResources().getString(LOOKUP_SUBTITLES[menuPosition-1]));
		//((TextView)llMain.findViewById(R.id.mainSubSub)).setText(LOOKUP_SUBTITLES[menuPosition-1]);
	}

	private void getPrevMenuElement() {
		if (menuPosition>1)
			menuPosition--;
		else
			menuPosition = LOOKUP_TITLES.length;
		//((ViewFlipper)llMain.findViewById(R.id.viewFlipper1)).showPrevious();
		((Button)findViewById(R.id.mainButtonCentral)).setText(LOOKUP_TITLES[menuPosition-1]);
		mSwitcher.setText(getResources().getString(LOOKUP_SUBTITLES[menuPosition-1]));
		//((TextView)llMain.findViewById(R.id.mainSubSub)).setText(LOOKUP_SUBTITLES[menuPosition-1]);
	}

	private void goToLvl(int lvl){
		Intent i = new Intent(ElegantRiddlesActivity.this, Riddle.class);
		i.putExtra(Toc.LEVEL_TAG, lvl);
		startActivityForResult(i, 1);
	}

	/*
	 * Listeners
	 */
	public void mainClickListener(View v){
		switch(menuPosition){
		case 1:
			//ToC
			Intent i = new Intent(ElegantRiddlesActivity.this, Toc.class);
			startActivityForResult(i, 1);
			break;
		case 2:
			//Random
			Random rdmGen = new Random();
			goToLvl(rdmGen.nextInt(Riddle.LOOKUP_TITLES.length));
			break;
		case 3:
			//Credits
			Intent ii = new Intent(ElegantRiddlesActivity.this, Credits.class);
			startActivityForResult(ii, 1);
			break;
		}
	}

	public void buildMain(View v){
		//Fade in animation
		Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.splash);
		findViewById(R.id.mainLayout).startAnimation(fadeIn);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		try {
			if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
				return false;
			// right to left swipe
			if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				getNextMenuElement();
			}
			// left to right swipe
			else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
				getPrevMenuElement();
			}
		} catch (Exception e) {
		}

		return true;
	}

	/*
	 * Options menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.opt_menu_home, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.opt_rate:
			Intent ii = new Intent(Intent.ACTION_VIEW, Uri.parse(Riddle.PREMIUM_MARKET_URL));
			startActivity(ii);
			return true;
		case R.id.opt_quit:
			confirmQuit();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	

	@Override
	public void onLongPress(MotionEvent e) {
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent me)
	{
		return gestureScanner.onTouchEvent(me);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		buildMain(null);
	}

	@Override
	public View makeView() {
		TextView t = new TextView(this);
		t.setGravity(Gravity.CENTER);
		t.setTextAppearance(getApplicationContext(), R.style.FontStyle);
		return t;
	}
	@Override
	protected void onResume() {
		super.onResume();
		buildMain(null);
	}
}