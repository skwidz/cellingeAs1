package cellinge.as1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewClaims extends Activity {
	private ListView claimsList;
	private ArrayList<Claim> claims;
	private ArrayAdapter<Claim> adapter; 
	private static final String FILENAME = "saveData.sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_veiw_claims);
		
		claimsList = (ListView) findViewById(R.id.claimsList);
		
	}

	protected void onStart(){
		super.onStart();
		claims = loadfromfile();
		if (claims == null){
			claims = new ArrayList<Claim>();
		}
		adapter = new ArrayAdapter<Claim>(this,R.layout.list_item, claims);
		claimsList.setAdapter(adapter);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.veiw_claims, menu);
		return true;
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
}