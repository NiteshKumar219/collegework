package com.example.feedbackapp;

import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class F3Activity extends Activity {

	RatingBar r1,r2;
	Button b;
	Bundle bdl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_f3);
		Intent i = getIntent();
		bdl = i.getExtras();
		r1 = (RatingBar)findViewById(R.id.ratingBar1);
		r2 = (RatingBar)findViewById(R.id.ratingBar2);
		b = (Button)findViewById(R.id.button1);
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
	
	public void DBClick(View v){
		float rt1 = r1.getRating();
		float rt2 = r2.getRating();
		if(!isNetworkAvailable()){			
	    	Toast.makeText(getBaseContext(), "Please Connect to the Internet and then click Submit", Toast.LENGTH_LONG).show();
		}
		else{
			bdl.putString(Feedbackprovider.EVENT_DATE, LoginActivity.edate);
			bdl.putString(Feedbackprovider.EVENT_NAME, LoginActivity.ename);
			bdl.putFloat(Feedbackprovider.SPKR_RAT, rt1);
			bdl.putFloat(Feedbackprovider.OVERALL_RAT, rt2);
			HashMap<String,Object> data = new HashMap<String,Object>();
			for(String x : bdl.keySet()){
				data.put(x, bdl.get(x));
			}
			
			new MySQLUpdater().updateMysQL(data);
			Toast.makeText(getApplicationContext(), "Thanks for Your Feedback", Toast.LENGTH_LONG).show();		
			feedbackDone(getApplicationContext());
		}		
	}
	
	public void feedbackDone(Context c){
		Intent intent = new Intent(c, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("EXIT", true);
		//if(LoginActivity.cancelAlarm())
		//	Toast.makeText(c, "Alarm Cancelled", Toast.LENGTH_LONG).show();
		startActivity(intent);
	}
}
