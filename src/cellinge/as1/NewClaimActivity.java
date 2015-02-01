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
		
	
	private ArrayList<Expense> expenses; 
	private ArrayAdapter<Expense> adapter;
	protected ArrayList<Claim> claims; 
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
		// Show the Up button in the action bar.
		setupActionBar();
		
		claimName = (EditText) findViewById(R.id.claimName);
		claimStartDate = (EditText) findViewById(R.id.claimStartDate);
		claimEndDate = (EditText) findViewById(R.id.claimEndDate);
		claimDescription = (EditText) findViewById(R.id.claimDescription);
		expensesList = (ListView) findViewById(R.id.expenceList);
		Button newExpense = (Button) findViewById(R.id.addNewExpense);
		
		newExpense.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				setResult(RESULT_OK);
				name = claimName.getText().toString();
				startDate = claimStartDate.getText().toString();
				description = claimDescription.getText().toString();
				endDate = claimEndDate.getText().toString(); 
				newExpense(v);
				
;			}
		});
	
	}
	
	protected void onStart(){
		super.onStart();
		
		Claim newClaim = new Claim("In Progress");
		claims = loadfromfile();
		if (claims == null){
			claims = new ArrayList<Claim>();
		}
		newClaim.expenseList = new ArrayList<Expense>();
		
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
		// need to save any inputed data before activity is changed
		
		startActivity(intent);
				
	}
	
	private void saveInFile(Claim claim) {
		Gson gson = new Gson();
		try{
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claim, osw);
			osw.flush();
			fos.close(); 
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<Claim> loadfromfile(){
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
