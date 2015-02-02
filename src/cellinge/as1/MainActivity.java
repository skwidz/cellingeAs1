package cellinge.as1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button newClaimButton = (Button) findViewById(R.id.newClaim);
        Button viewClaimButton = (Button) findViewById(R.id.viewClaim);
        
        
    }
    //move to the new claim activity when the new claim button is hit
    public void newClaim(View veiw){
    	Intent intent = new Intent(this, NewClaimActivity.class);
    	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void viewClaims(View view){
    	Intent intent = new Intent(this, ViewClaims.class);
    	startActivity(intent);
    }
}
