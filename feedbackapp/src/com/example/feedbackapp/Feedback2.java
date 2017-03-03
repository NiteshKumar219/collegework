/*package com.example.feedbackapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

@SuppressWarnings("unused")
public class Feedback2 extends Activity implements OnClickListener {

	Spinner s1,s2,s3,s4; 
	Button b1;
	Bundle b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback2);
		Intent i = getIntent();
		b = i.getExtras();
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
		s1=(Spinner)findViewById(R.id.spinner1);
		List<String>categories1 = new ArrayList<String>();
		categories1.add("Very satisfied");
		categories1.add("Satisfied");
		categories1.add("Dissatisfied");
		categories1.add("Very dissatisfied");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories1);
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(dataAdapter1);
		
		s2=(Spinner)findViewById(R.id.spinner2);
		List<String>categories2 = new ArrayList<String>();
		categories2.add("Very satisfied");
		categories2.add("Satisfied");
		categories2.add("Dissatisfied");
		categories2.add("Very dissatisfied");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories2);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(dataAdapter2);
		
		s3=(Spinner)findViewById(R.id.spinner3);
		List<String>categories3 = new ArrayList<String>();
		categories3.add("Very satisfied");
		categories3.add("Satisfied");
		categories3.add("Dissatisfied");
		categories3.add("Very dissatisfied");
		ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories3);
		dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s3.setAdapter(dataAdapter3);
		
		s4=(Spinner)findViewById(R.id.spinner4);
		List<String>categories4 = new ArrayList<String>();
		categories4.add("Very satisfied");
		categories4.add("Satisfied");
		categories4.add("Dissatisfied");
		categories4.add("Very dissatisfied");
		ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories4);
		dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s4.setAdapter(dataAdapter4);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback2, menu);
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
		Intent j=new Intent(this,Feedback3.class);
		b.putString(Feedbackprovider.CNT_USE, (String)s1.getSelectedItem());
		b.putString(Feedbackprovider.SPKR_SKILL, (String)s2.getSelectedItem());
		b.putString(Feedbackprovider.DEMO_EFF, (String)s3.getSelectedItem());
		b.putString(Feedbackprovider.OVR_PPT_RAT, (String)s4.getSelectedItem());
		j.putExtras(b);
		startActivity(j);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	
}
*/