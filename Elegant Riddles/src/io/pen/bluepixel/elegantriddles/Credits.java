package io.pen.bluepixel.elegantriddles;
 
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Credits extends Activity{
	
	private static final String MAIL_ADDRESS = "a.s.hereb@gmail.com";
	private static final String MAIL_SUBJ = "Contact from Elegant Riddles";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credits);
		
		//Set listeners
		final Button mailButton = (Button) findViewById(R.id.credits_btn_mail);
		mailButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{MAIL_ADDRESS});
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, MAIL_SUBJ);
				startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.credits_mail)));
			}
		});

	}
	public void backToMain(View v){
		finish();
	}


	/*
	 * Options menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.opt_menu_gen, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.opt_rate:
			Intent ii = new Intent(Intent.ACTION_VIEW, Uri.parse(Riddle.PREMIUM_MARKET_URL));
			startActivity(ii);
			return true;
		case R.id.opt_back:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	
	
}
