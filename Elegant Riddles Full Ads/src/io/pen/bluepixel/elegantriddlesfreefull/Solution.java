package io.pen.bluepixel.elegantriddlesfreefull;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Solution extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.solution);
	final int lvl=getIntent().getExtras().getInt(Toc.LEVEL_TAG);

	TextView solution=(TextView) findViewById(R.id.solutionText);
	solution.setText(getResources().getString(Riddle.LOOKUP_ANSWERS[lvl]));

	String notesFromIntent=getIntent().getExtras().getCharSequence(Riddle.NOTES_TAG).toString();
	if ( ! notesFromIntent.equals("")) {
	    TextView notes=(TextView) findViewById(R.id.solutionNotepad);
	    notes.setText(notesFromIntent);
	    ((LinearLayout) findViewById(R.id.solutionNotesBlock)).setVisibility(View.VISIBLE);
	}
    }

    public void backToRiddle(View v) {
	finish();
    }

    /*
     * Options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	MenuInflater inflater=getMenuInflater();
	inflater.inflate(R.menu.opt_menu_gen, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	    case R.id.opt_back:
		finish();
		return true;
	    case R.id.opt_buy:
		Intent ii=new Intent(Intent.ACTION_VIEW, Uri.parse(Riddle.PREMIUM_MARKET_URL));
		startActivity(ii);
		return true;
	    default:
		return super.onOptionsItemSelected(item);
	}
    }
}
