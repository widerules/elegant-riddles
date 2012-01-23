package io.pen.bluepixel.elegantriddles;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Riddle extends Activity{
	
	public static final String PREMIUM_MARKET_URL = "market://details?id=io.pen.bluepixel.elegantriddles";

	public static final int[] LOOKUP_TITLES = new int[] {	
		R.string.T01,R.string.T02,R.string.T03,R.string.T04,R.string.T05,
		R.string.T06,R.string.T07,R.string.T08, R.string.T09, R.string.T10, 
		R.string.T11, R.string.T12, R.string.T13, R.string.T14, R.string.T15, 
		R.string.T16, R.string.T17, R.string.T18, R.string.T19, R.string.T20, 
		R.string.T21, R.string.T22, R.string.T23, R.string.T24, R.string.T25, 
		R.string.T26, R.string.T27, R.string.T28, R.string.T29, R.string.T30, 
		R.string.T31, R.string.T32, R.string.T33, R.string.T34, R.string.T35, 
		R.string.T36, R.string.T37, R.string.T38, R.string.T39, R.string.T40, 
		R.string.T41, R.string.T42, R.string.T43, R.string.T44, R.string.T45, 
		R.string.T46, R.string.T47, R.string.T48, R.string.T49, R.string.T50, 
		R.string.T51, R.string.T52, R.string.T53, R.string.T54, R.string.T55, 
		R.string.T56, R.string.T57, R.string.T58, R.string.T59, R.string.T60, 
		R.string.T61, R.string.T62, R.string.T63, R.string.T64, R.string.T65, 
		R.string.T66, R.string.T67, R.string.T68, R.string.T69, R.string.T70, 
		R.string.T71, R.string.T72, R.string.T73, R.string.T74, R.string.T75, 
		R.string.T76, R.string.T77, R.string.T78, R.string.T79, R.string.T80, 
		R.string.T81, R.string.T82, R.string.T83, R.string.T84, R.string.T85, 
		R.string.T86, R.string.T87, R.string.T88, R.string.T89, R.string.T90, 
		R.string.T91, R.string.T92, R.string.T93, R.string.T94, R.string.T95, 
		R.string.T96, R.string.T97, R.string.T98, R.string.T99, R.string.T100, 
		R.string.T101 
	};
	private static final int[] LOOKUP_QUESTIONS = new int[] {
		R.string.Q01,R.string.Q02,R.string.Q03,R.string.Q04,R.string.Q05,
		R.string.Q06,R.string.Q07,R.string.Q08, R.string.Q09, R.string.Q10, 
		R.string.Q11, R.string.Q12, R.string.Q13, R.string.Q14, R.string.Q15, 
		R.string.Q16, R.string.Q17, R.string.Q18, R.string.Q19, R.string.Q20, 
		R.string.Q21, R.string.Q22, R.string.Q23, R.string.Q24, R.string.Q25, 
		R.string.Q26, R.string.Q27, R.string.Q28, R.string.Q29, R.string.Q30, 
		R.string.Q31, R.string.Q32, R.string.Q33, R.string.Q34, R.string.Q35, 
		R.string.Q36, R.string.Q37, R.string.Q38, R.string.Q39, R.string.Q40, 
		R.string.Q41, R.string.Q42, R.string.Q43, R.string.Q44, R.string.Q45, 
		R.string.Q46, R.string.Q47, R.string.Q48, R.string.Q49, R.string.Q50, 
		R.string.Q51, R.string.Q52, R.string.Q53, R.string.Q54, R.string.Q55, 
		R.string.Q56, R.string.Q57, R.string.Q58, R.string.Q59, R.string.Q60, 
		R.string.Q61, R.string.Q62, R.string.Q63, R.string.Q64, R.string.Q65, 
		R.string.Q66, R.string.Q67, R.string.Q68, R.string.Q69, R.string.Q70, 
		R.string.Q71, R.string.Q72, R.string.Q73, R.string.Q74, R.string.Q75, 
		R.string.Q76, R.string.Q77, R.string.Q78, R.string.Q79, R.string.Q80, 
		R.string.Q81, R.string.Q82, R.string.Q83, R.string.Q84, R.string.Q85, 
		R.string.Q86, R.string.Q87, R.string.Q88, R.string.Q89, R.string.Q90, 
		R.string.Q91, R.string.Q92, R.string.Q93, R.string.Q94, R.string.Q95, 
		R.string.Q96, R.string.Q97, R.string.Q98, R.string.Q99, R.string.Q100, 
		R.string.Q101 
	};
	public static final int[] LOOKUP_ANSWERS = new int[] {
		R.string.A01,R.string.A02,R.string.A03,R.string.A04,R.string.A05,
		R.string.A06,R.string.A07,R.string.A08, R.string.A09, R.string.A10, 
		R.string.A11, R.string.A12, R.string.A13, R.string.A14, R.string.A15, 
		R.string.A16, R.string.A17, R.string.A18, R.string.A19, R.string.A20, 
		R.string.A21, R.string.A22, R.string.A23, R.string.A24, R.string.A25, 
		R.string.A26, R.string.A27, R.string.A28, R.string.A29, R.string.A30, 
		R.string.A31, R.string.A32, R.string.A33, R.string.A34, R.string.A35, 
		R.string.A36, R.string.A37, R.string.A38, R.string.A39, R.string.A40, 
		R.string.A41, R.string.A42, R.string.A43, R.string.A44, R.string.A45, 
		R.string.A46, R.string.A47, R.string.A48, R.string.A49, R.string.A50, 
		R.string.A51, R.string.A52, R.string.A53, R.string.A54, R.string.A55, 
		R.string.A56, R.string.A57, R.string.A58, R.string.A59, R.string.A60, 
		R.string.A61, R.string.A62, R.string.A63, R.string.A64, R.string.A65, 
		R.string.A66, R.string.A67, R.string.A68, R.string.A69, R.string.A70, 
		R.string.A71, R.string.A72, R.string.A73, R.string.A74, R.string.A75, 
		R.string.A76, R.string.A77, R.string.A78, R.string.A79, R.string.A80, 
		R.string.A81, R.string.A82, R.string.A83, R.string.A84, R.string.A85, 
		R.string.A86, R.string.A87, R.string.A88, R.string.A89, R.string.A90, 
		R.string.A91, R.string.A92, R.string.A93, R.string.A94, R.string.A95, 
		R.string.A96, R.string.A97, R.string.A98, R.string.A99, R.string.A100, 
		R.string.A101 
	};

	private static final int[] LOOKUP_PIC = new int[] {
		R.drawable.picture01, R.drawable.picture02, R.drawable.picture03, R.drawable.picture04, R.drawable.picture05,
		R.drawable.picture06,R.drawable.picture07,R.drawable.picture08, R.drawable.picture09, R.drawable.picture10,
		R.drawable.picture11, R.drawable.picture12, R.drawable.picture13, R.drawable.picture14, R.drawable.picture15, 
		R.drawable.picture16, R.drawable.picture17, R.drawable.picture18, R.drawable.picture19, R.drawable.picture20, 
		R.drawable.picture21, R.drawable.picture22, R.drawable.picture23, R.drawable.picture24, R.drawable.picture25, 
		R.drawable.picture26, R.drawable.picture27, R.drawable.picture28, R.drawable.picture29, R.drawable.picture30, 
		R.drawable.picture31, R.drawable.picture32, R.drawable.picture33, R.drawable.picture34, R.drawable.picture11, 
		R.drawable.picture36, R.drawable.picture37, R.drawable.picture15, R.drawable.picture21, R.drawable.picture40,
		R.drawable.picture41, R.drawable.picture42, R.drawable.picture43, R.drawable.picture24, R.drawable.picture45,
		R.drawable.picture18, R.drawable.picture04, R.drawable.picture11, R.drawable.picture05, R.drawable.picture20,
		R.drawable.picture51, R.drawable.picture15, R.drawable.picture53, R.drawable.picture14, R.drawable.picture55,
		R.drawable.picture53, R.drawable.picture12, R.drawable.picture58, R.drawable.picture20, R.drawable.picture60,
		R.drawable.picture15, R.drawable.picture62, R.drawable.picture05, R.drawable.picture01, R.drawable.picture23,
		R.drawable.picture15, R.drawable.picture33, R.drawable.picture62, R.drawable.picture69, R.drawable.picture34,
		R.drawable.picture11, R.drawable.picture05, R.drawable.picture23, R.drawable.picture74, R.drawable.picture75,
		R.drawable.picture17, R.drawable.picture14, R.drawable.picture22, R.drawable.picture15, R.drawable.picture55,
		R.drawable.picture10, R.drawable.picture82, R.drawable.picture41, R.drawable.picture22, R.drawable.picture37,
		R.drawable.picture13, R.drawable.picture53, R.drawable.picture27, R.drawable.picture27, R.drawable.picture18,
		R.drawable.picture11, R.drawable.picture92, R.drawable.picture93, R.drawable.picture32, R.drawable.picture55,
		R.drawable.picture96, R.drawable.picture22, R.drawable.picture24, R.drawable.picture82, R.drawable.picture100,
		R.drawable.picture29
	}; 

	private LinearLayout ll;
	private Vibrator myVib;
	private int lvl = 0;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.riddle);
		lvl = getIntent().getExtras().getInt(Toc.LEVEL_TAG);
		fillPage();
		manageButtons();
	}
	
	private void manageButtons() {
		//Set listeners
		final Button solButton = (Button) ll.findViewById(R.id.riddlehints_btn);
		solButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showSolution(lvl);
			}
		});
		final Button nextButton = (Button) ll.findViewById(R.id.nextriddle_btn);
		nextButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				lvl++;
				getIntent().putExtra(Toc.LEVEL_TAG, lvl);
				setContentView(R.layout.riddle);
				fillPage();
			}
		});
		final Button prevButton = (Button) ll.findViewById(R.id.previousriddle_btn);
		prevButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				myVib.vibrate(50);
				lvl--;
				getIntent().putExtra(Toc.LEVEL_TAG, lvl);
				setContentView(R.layout.riddle);
				fillPage();
			}
		});
		final Button rdmButton = (Button) ll.findViewById(R.id.rdmriddle_btn);
		rdmButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				myVib.vibrate(50);
				Random rdmGen = new Random();
				lvl = rdmGen.nextInt(LOOKUP_TITLES.length);
				getIntent().putExtra(Toc.LEVEL_TAG, lvl);
				setContentView(R.layout.riddle);
				fillPage();
			}
		});

		//Hide buttons if needed
		if(lvl == LOOKUP_TITLES.length-1)
			nextButton.setVisibility(View.INVISIBLE);
		if(lvl == 0)
			prevButton.setVisibility(View.INVISIBLE);
		
	}

	public void showSolution(int lvl) {
		Intent i = new Intent(Riddle.this, Solution.class);
		i.putExtra(Toc.LEVEL_TAG, lvl);
		Riddle.this.startActivity(i);
	}

	private void fillPage(){
		//Fill the riddle page (NOTE: for first level lvl=0)
		String title="Error loading title";
		String text="Error loading text";
		int src;

		title = getResources().getString(LOOKUP_TITLES[lvl]);
		text = getResources().getString(LOOKUP_QUESTIONS[lvl]);
		src = LOOKUP_PIC[lvl];
		
		ll = ((LinearLayout)((ScrollView)findViewById(R.id.riddleScrollView1)).getChildAt(0));
		ImageView imgView = (ImageView)ll.findViewById(R.id.riddleimageView1);
		TextView titleView = (TextView)ll.findViewById(R.id.riddleTitle);
		TextView questionView = (TextView)ll.findViewById(R.id.riddleText);
		titleView.setText(title);
		questionView.setText(text);
		imgView.setImageResource(src);	
		manageButtons();
	}

	public void backToToc(View v){
		myVib.vibrate(50);
		finish();
	}

	/*
	 * Options menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.opt_menu_riddle, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.opt_rate:
			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(PREMIUM_MARKET_URL));
			startActivity(i);
			return true;
		case R.id.opt_solution:
			showSolution(lvl);
			return true;
		case R.id.opt_back:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
