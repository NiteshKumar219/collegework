package com.example.feedbackapp;

import java.io.File;

/*import org.mgr.eventapp.HomeActivity;
import org.mgr.eventapp.LoginActivity;*/

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.SwitchPreference;
import android.provider.Contacts.Intents;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

@SuppressWarnings({ "unused", "deprecation" })
public class FirstActivity extends Activity implements OnClickListener {
public Button OpenPDF,m2;
RelativeLayout r1,r2;
WebView w;
int score;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		score=0;
		OpenPDF=(Button) findViewById(R.id.button1);
		m2=(Button)findViewById(R.id.button2);
		r1 = (RelativeLayout)findViewById(R.id.r1);
		r2 = (RelativeLayout)findViewById(R.id.r2);
		w = (WebView)findViewById(R.id.webView1);
		r1.setVisibility(View.VISIBLE);
		r2.setVisibility(View.GONE);
		OpenPDF.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*File pdfFile = new File("http://drmgrdu.ac.in/Univ_Event/Eve_pre_details/Eve_IC.htm"); 
		        if(pdfFile.exists()) 
		        {
		            Uri path = Uri.fromFile(pdfFile); 
		            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
		            pdfIntent.setDataAndType(path, "application/pdf");
		            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		            try
		            {
		                startActivity(pdfIntent);
		            }
		            catch(ActivityNotFoundException e)
		            {
		                Toast.makeText( FirstActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show(); 
		            }
		        }*/
				r2.setVisibility(View.VISIBLE);
				r1.setVisibility(View.GONE);
				w.getSettings().setUseWideViewPort(true);
			    w.getSettings().setLoadWithOverviewMode(true);
			    w.getSettings().setBuiltInZoomControls(true);
			    w.getSettings().setDisplayZoomControls(false);
				w.loadUrl("https://www.drmgrdu.ac.in/Univ_Event/Eve_pre_details/Eve_OA.htm");
			}
		});
		m2.setOnClickListener(this);		
	}
	
	@Override
	
	public void onClick(View v){
		score +=1;
		Intent i = new Intent(FirstActivity.this,LoginActivity.class);
		startActivity(i);
	}
	/*@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.button2:
			score +=1;
			Intent i = new Intent(FirstActivity.this,LoginActivity.class);
			startActivity(i);
			break;
			
	case R.id.button1:
	{		
				File pdfFile = new File("http://drmgrdu.ac.in/Univ_Event/Eve_pre_details/Eve_IC.htm"); 
	            if(pdfFile.exists()) 
	            {
	                Uri path = Uri.fromFile(pdfFile); 
	                Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
	                pdfIntent.setDataAndType(path, "application/pdf");
	                pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

	                try
	                {
	                    startActivity(pdfIntent);
	                }
	                catch(ActivityNotFoundException e)
	                {
	                    Toast.makeText( FirstActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show(); 
	                }
	            }
	            }
	}}*/
		
	
}
			
		/*case R.id.button1:
			Intent j = new Intent(FirstActivity.this,ActivityB.class);
			startActivity(j);
			Toast aamir = Toast.makeText(ActivityA.this,"your score is" +score,Toast.LENGTH_LONG);
			aamir.setGravity(Gravity.TOP|Gravity.TOP, 50, 50);
			aamir.show();
		}
		 
	}
      @Override
    	public void onConfigurationChanged(Configuration newConfig) {
    		super.onConfigurationChanged(newConfig);
    		
    		if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
    		{
    		Toast sohail = Toast.makeText(ActivityA.this,"potrait mode",Toast.LENGTH_LONG);
    		sohail.show();
    		}
    		else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
    		{
    		Toast make = Toast.makeText(ActivityA.this,"landscape mode",Toast.LENGTH_LONG);
    		make.show();
    		
    		}
    	}
}
}


	
}*/
	/*@Override

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}


	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
}}*/
