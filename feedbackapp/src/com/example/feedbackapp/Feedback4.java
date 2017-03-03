/*package com.example.feedbackapp;

import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Feedback4 extends Activity implements OnClickListener{
	 private RadioGroup radioGroup;
	   private Button btnDisplay;
	   private Bundle bundle; 
	   public void init(){
		   radioGroup =(RadioGroup)findViewById(R.id.radioperformance);
		   btnDisplay=(Button)findViewById(R.id.button1);
	   }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback4);
		Intent pt = getIntent();
		bundle = pt.getExtras();
		init();
		btnDisplay.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback4, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	//To Check Internet Connection
		private boolean isNetworkAvailable() {
		    ConnectivityManager connectivityManager 
		          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		    if(!(activeNetworkInfo != null && activeNetworkInfo.isConnected())){
		    	Log.e("Internet", "No Internet");
		    	return false;
		    }
		    return true;
		}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(!isNetworkAvailable()){			
	    	Toast.makeText(getBaseContext(), "Please Connect to the Internet and then click Submit", Toast.LENGTH_LONG).show();
		}
		else{
			RadioButton rb = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
			bundle.putString(Feedbackprovider.OVERALL_RAT, rb.getText().toString());
			ContentValues cv = new ContentValues();
			Set<String> set = bundle.keySet();
			for(String x: set){
				cv.put(x, bundle.getString(x));
			}
			getContentResolver().insert(Feedbackprovider.CONTENT_URI, cv);
			HashMap<String,String> data = new HashMap<String, String>();
			for(String x : cv.keySet()){
				data.put(x, cv.getAsString(x));
			}
			Log.i("Transmitting to Internet", "");
			new MySQLUpdater().updateMysQL(data);
			Toast.makeText(getApplicationContext(), "Thank You for the Feedback", Toast.LENGTH_LONG).show();		
			feedbackDone(getApplicationContext());
		}		
	}
	
	public void feedbackDone(Context c){
		Intent intent = new Intent(c, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("EXIT", true);
		if(LoginActivity.cancelAlarm())
			Toast.makeText(c, "Alarm Cancelled", Toast.LENGTH_LONG).show();
		startActivity(intent);
	}
}
*/