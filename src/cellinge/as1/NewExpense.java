package cellinge.as1;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class NewExpense extends Activity {
	private EditText expenseDate;
	private EditText expenseDescription;
	private Spinner category;
	private EditText expenseAmount; 
	private Spinner currency; 
		
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_expense);
		// Show the Up button in the action bar.
		setupActionBar();
		
		expenseAmount = (EditText) findViewById(R.id.expenseAmount);
		expenseDescription = (EditText) findViewById(R.id.expenseDescription);
		expenseDate = (EditText) findViewById(R.id.expenseDate);
		//category spinner
		category = (Spinner) findViewById(R.id.expenseCategory);
		ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
				R.array.expenseCategories, android.R.layout.simple_spinner_dropdown_item);
		categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		category.setAdapter(categoryAdapter);
		//currency spinner		
		currency = (Spinner) findViewById(R.id.expenseCurrency);
		ArrayAdapter<CharSequence> currencyAdapter = ArrayAdapter.createFromResource(this,
				R.array.currency, android.R.layout.simple_spinner_dropdown_item);
		currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		currency.setAdapter(currencyAdapter);
		
		Button saveButton = (Button) findViewById(R.id.saveButton);
		
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				saveExpense(v);
				
			}
		});
	}
	
	public void saveExpense(View view){
		Intent intent = new Intent(this, NewClaimActivity.class);
		
		intent.putExtra("amount", expenseAmount.getText().toString());
		intent.putExtra("description", expenseDescription.getText().toString());
		intent.putExtra("category", category.getSelectedItem().toString());
		intent.putExtra("date", expenseDate.getText().toString());
		intent.putExtra("currency", currency.getSelectedItem().toString());
		startActivity(intent);
		
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
		getMenuInflater().inflate(R.menu.new_expence, menu);
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
