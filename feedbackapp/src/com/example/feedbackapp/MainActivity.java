package com.example.feedbackapp;

import java.util.ArrayList;
import java.util.List;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
	

public class MainActivity extends Activity implements OnClickListener {
	
	TextView eventname,date,venue,dpt;
	Button b;
	Spinner sp;
	
	//Intializing Objects
	public void init(){
		eventname=(TextView)findViewById(R.id.textView3);
		date=(TextView)findViewById(R.id.textView5);
		dpt=(TextView)findViewById(R.id.textView7);
		venue=(TextView)findViewById(R.id.textView9);
		b=(Button)findViewById(R.id.button1);
		sp=(Spinner)findViewById(R.id.sp1);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		Intent i = getIntent();
		Bundle bdl = i.getExtras();
		eventname.setText(bdl.getString("eventname"));
		date.setText(bdl.getString("eventdate"));
		dpt.setText(bdl.getString("dpt"));
		venue.setText(bdl.getString("venue"));		
		b.setOnClickListener(this);
		List<String>categories4 = new ArrayList<String>();
		categories4.add("Student");
		categories4.add("Faculty");
		categories4.add("Visitor");
		ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories4);
		dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(dataAdapter4);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1){
			Intent i1 = new Intent(MainActivity.this,P1Activity.class);
			Bundle b = new Bundle();
			b.putString(Feedbackprovider.PERSON_ID, (String)sp.getSelectedItem());
			i1.putExtras(b);
			startActivity(i1);
			overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
	}
	
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onResume(){
		super.onResume();
		Intent i = getIntent();
		if(i.getBooleanExtra("EXIT", false)){
			finishAndRemoveTask();
			finish();
		}
	}
}
