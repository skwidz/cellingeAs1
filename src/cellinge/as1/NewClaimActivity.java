package cellinge.as1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class NewClaimActivity extends Activity {
	
	private EditText claimName;
	private EditText claimStartDate;
	private EditText claimEndDate;
	private EditText claimDescription;
	private ListView expensesList; 
	
	
	private ArrayList<Expense> expenses; 
	private ArrayAdapter<Expense> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
		// Show the Up button in the action bar.
		setupActionBar();
		
		claimName = (EditText) findViewById(R.id.claimName);
		claimStartDate = (EditText) findViewById(R.id.claimStartDate);
		claimName = (EditText) findViewById(R.id.claimEndDate);
		claimDescription = (EditText) findViewById(R.id.claimDescription);
		expensesList = (ListView) findViewById(R.id.expenceList);
		Button newExpense = (Button) findViewById(R.id.addNewExpense);
		
		
	
	}
	
	protected void onStart(){
		super.onStart();
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_claim, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
