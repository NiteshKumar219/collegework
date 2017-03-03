package com.example.feedbackapp;

import java.text.DateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("unused")
public class Feedback3 extends Activity implements OnClickListener {
	
	EditText EditText1,EditText2,EditText3,EditText4;
	Button b;
	Bundle bdl;
	public void init(){
		EditText1=(EditText)findViewById(R.id.editText1);
		EditText2=(EditText)findViewById(R.id.editText2);
		EditText3=(EditText)findViewById(R.id.editText3);
		EditText4=(EditText)findViewById(R.id.editText4);
		b=(Button)findViewById(R.id.button1);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback3);
		Intent u = getIntent();
		bdl = u.getExtras();
		init();
		b.setOnClickListener(this);
		EditText1.setText("");
		EditText2.setText("");
		EditText3.setText("");
		EditText4.setText("");
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback3, menu);
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
		Intent k=new Intent(this,F3Activity.class);
		bdl.putString(Feedbackprovider.EVNT_STRNTH, EditText1.getText().toString());
		bdl.putString(Feedbackprovider.KEY_MSGS, EditText2.getText().toString());
		bdl.putString(Feedbackprovider.OTHR_INFO, EditText3.getText().toString());
		bdl.putString(Feedbackprovider.INTRSTD_EVES, EditText4.getText().toString());
		k.putExtras(bdl);
		startActivity(k);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	}
}
