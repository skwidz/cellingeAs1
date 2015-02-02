package cellinge.as1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


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
	
	
	private static final String FILENAME = "saveData.sav";
	private EditText claimName;
	private EditText claimStartDate;
	private EditText claimEndDate;
	private EditText claimDescription;
	private ListView expensesList; 
	private Claim newClaim; 
	private String name;
	private String startDate;
	private String endDate; 
	private String description; 
	//expense variables
	private String expenseDate;
	private String expenseCategory;
	private String expenseAmount;
	private String expenseCurrency;
	
	private ArrayList<Expense> expenses; 
	private ArrayAdapter<Expense> adapter;
	protected ArrayList<Claim> claims; 
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
		//Receiving data from the expense activity
		Intent intent= getIntent();
		if (newClaim == null){
			newClaim = new Claim("In Progress");
		}
		try{
			expenseDate = intent.getExtras().getString("date");
			expenseCategory = intent.getExtras().getString("category");
			expenseAmount = intent.getExtras().getString("amount");
			expenseCurrency = intent.getExtras().getString("currency");
			Expense newExpense = new Expense();
			newExpense.setDate(expenseDate);
			newExpense.setCategory(expenseCategory);
			newExpense.setCurrency(expenseCurrency);
			newExpense.setAmount(expenseAmount);
			newClaim.addExpense(newExpense);
			
			
		}catch(Exception e){
			e.printStackTrace();			
		}
		expenses = newClaim.getExpences();
		if(expenses == null){
			expenses = new ArrayList<Expense>();
		}
		adapter = new ArrayAdapter<Expense>(this, R.layout.list_item, expenses);
		//expensesList.setAdapter(adapter);
		//adapter.notifyDataSetChanged();
		// Show the Up button in the action bar.
		setupActionBar();
		
		claimName = (EditText) findViewById(R.id.claimName);
		claimStartDate = (EditText) findViewById(R.id.claimStartDate);
		claimEndDate = (EditText) findViewById(R.id.claimEndDate);
		claimDescription = (EditText) findViewById(R.id.claimDescription);
		expensesList = (ListView) findViewById(R.id.expenceList);
		Button newExpense = (Button) findViewById(R.id.addNewExpense);
		Button submit = (Button) findViewById(R.id.submitClaim);
		newExpense.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				setResult(RESULT_OK);
				newExpense(v);
				
;			}
		});
		
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				claims.add(newClaim);
				saveInFile(claims);
				
				
			}
		});
		
		
	
	}
	
	private void gotoMain(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	protected void onStart(){
		super.onStart();
		
		
		claims = loadfromfile();
		if (claims == null){
			claims = new ArrayList<Claim>();
		}
		
		
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

	public void newExpense(View veiw){
		Intent intent = new Intent(this, NewExpense.class);
		//save the current values to a class and add that class to the list in gson.
		if (newClaim == null){
			newClaim = new Claim("In Progress");
		}
		name = claimName.getText().toString();
		description = claimDescription.getText().toString();
		newClaim.setName(name);
		newClaim.setDescription(description);
		claims.add(newClaim);
		saveInFile(claims);
		
		//need to pass the class through to the expence class. 
		
		startActivity(intent);
				
	}
	
	
	
	private void saveInFile(ArrayList<Claim> claims) {
		Gson gson = new Gson();
		try{
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claims, osw);
			osw.flush();
			fos.close(); 
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Claim> loadfromfile(){
		Gson gson = new Gson();
		ArrayList<Claim> claims = new ArrayList<Claim>();
		try{
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);
			Type typeOfT = new TypeToken<ArrayList<Claim>>(){}.getType();
			claims = gson.fromJson(in, typeOfT);
			fis.close();
				
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return claims; 
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
