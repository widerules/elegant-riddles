package io.pen.bluepixel.elegantriddles;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Toc extends ListActivity {
	
	public static final String LEVEL_TAG = "LEVEL";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toc); 
		
		//ToC Elements
		setListAdapter(new ArrayAdapter<String>(this, R.layout.chapter, getResources().getStringArray(R.array.chaptersArray)));
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				goToLvl(position);
			}
		});
	}
	
	private void goToLvl(int lvl){
		Intent i = new Intent(Toc.this, Riddle.class);
		i.putExtra(LEVEL_TAG, lvl);
		Toc.this.startActivity(i);
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
		case R.id.opt_back:
			finish();
			return true;
		case R.id.opt_rate:
			Intent ii = new Intent(Intent.ACTION_VIEW, Uri.parse(Riddle.PREMIUM_MARKET_URL));
			startActivity(ii);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}	
}
