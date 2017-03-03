package com.example.feedbackapp;

import java.util.ArrayList;
import java.util.List;

import com.example.feedbackapp.R.string;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressWarnings("unused")
public class P1Activity extends Activity {

	Bundle b;
	Spinner s1,s2,s3,s4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p1);
		Intent prev = getIntent();
		b = prev.getExtras();
		s1=(Spinner)findViewById(R.id.spinner1);
		List<String>categories1 = new ArrayList<String>();
		categories1.add("Circular");
		categories1.add("Website");
		categories1.add("Social Media");
		categories1.add("Brochure");
		categories1.add("Through Collegue");
		categories1.add("Through friend");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories1);
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(dataAdapter1);
		
		s2=(Spinner)findViewById(R.id.spinner2);
		List<String>categories2 = new ArrayList<String>();
		categories2.add("Yes");
		categories2.add("No");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories2);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(dataAdapter2);
		
		s3=(Spinner)findViewById(R.id.spinner3);
		List<String>categories3 = new ArrayList<String>();
		categories3.add("Yes");
		categories3.add("No");
		ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories3);
		dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s3.setAdapter(dataAdapter3);
		
		s4=(Spinner)findViewById(R.id.spinner4);
		List<String>categories4 = new ArrayList<String>();
		categories4.add("Yes");
		categories4.add("No");
		ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories4);
		dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s4.setAdapter(dataAdapter4);
		
	}
	
	public void nextpage(View v){
		Intent i=new Intent(this,Feedback3.class);
		b.putString(Feedbackprovider.HOW_KNOW_EVENT, (String)s1.getSelectedItem());
		b.putString(Feedbackprovider.EVENT_STARTED_ONTIME, (String)s2.getSelectedItem());
		b.putString(Feedbackprovider.EVENTVENUE_HOSPITALITY, (String)s3.getSelectedItem());
		b.putString(Feedbackprovider.OVERALL_EVEORG_SAT, (String)s4.getSelectedItem());
		i.putExtras(b);
		startActivity(i);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.p1, menu);
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
}
