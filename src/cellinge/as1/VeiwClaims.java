package cellinge.as1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VeiwClaims extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_veiw_claims);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.veiw_claims, menu);
		return true;
	}

}
