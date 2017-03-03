package com.example.feedbackapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cz.msebera.android.httpclient.Header;

public class LoginActivity extends Activity implements OnClickListener{

	/*static final int TYPE = AlarmManager.RTC_WAKEUP;
	static PendingIntent pi1;
	static PendingIntent pi2;
	static AlarmManager alarm1;
	static AlarmManager alarm2;
	
	BroadcastReceiver br1 = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context c, Intent arg1) {
			new Feedback4().feedbackDone(c);				
		}
	};
	BroadcastReceiver br2 = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context c, Intent arg1) {
			setNotify(c);				
		}
	};*/
	static String edate,ename;
	EditText ltext;
	Button lbtn;
	Bundle bdl;
	String code;
	Calendar evt_date;
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_login);
	    /*AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
	    alertDialog.setTitle("Note");
	    alertDialog.setMessage("Please do not press back button after Login");
	    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
	        new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                dialog.dismiss();
	            }
	        });
	    alertDialog.show();*/
	    NoteDialogFragment alert = new NoteDialogFragment();
	    alert.show(getFragmentManager(),"");
	    ltext = (EditText)findViewById(R.id.codeText);
	    lbtn = (Button)findViewById(R.id.loginbutton);
	    evt_date = Calendar.getInstance();
	    lbtn.setOnClickListener(this);
	    bdl = new Bundle();
	    if(!isNetworkAvailable()){			
	    	Toast.makeText(getBaseContext(), "Please Connect to the Internet and then Start this Application", Toast.LENGTH_LONG).show();		
	    	new CountDownTimer(500,500) {
				
				@Override
				public void onTick(long millisUntilFinished) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onFinish() {
					// TODO Auto-generated method stub
					finish();
				}
			}.start();	    	
		}
		else{
			AsyncHttpClient client = new AsyncHttpClient();
			RequestParams params = new RequestParams();
			
			// Make Http call to getusers.php
	        client.post("http://www.scholarcouncil.com/www/mysqlsqlitesync/getformdata.php",params,new JsonHttpResponseHandler(){
	        	@Override
	        	public void onSuccess(int status, Header[] h, JSONObject obj){
	        		try {
	        			Log.e("Data Recvd1", obj+"");
	        			bdl.putString("eventname",obj.getString("EventName"));
	        			bdl.putString("eventdate",obj.getString("EventDate"));
	        			bdl.putString("venue",obj.getString("Venue"));
	        			bdl.putString("dpt",obj.getString("EventDept"));
	        			code = obj.getString("Code");
	        			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        			edate = obj.getString("EventDate");
	        			evt_date.setTime(sdf.parse(edate));	        			
	        			ename = obj.getString("EventName");
	        		} catch (JSONException e) {
	        			// TODO Auto-generated catch block
	        			bdl.putString("eventname","");
	        			bdl.putString("eventdate","");
	        			bdl.putString("venue","");
	        			bdl.putString("dpt","");
	        			code="NULL";
	        			e.printStackTrace();
	        		}
	        		catch(ParseException pe){
	        			Log.e("Date Problem", "Unable to convert Date");
	        		}
	        	}
	        		
	        	@Override
	        	public void onFailure(int status, Header[] h, String res, Throwable t){
	        		t.printStackTrace();
	        	}
	        });
		}
	    //alarm1 = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
	    //alarm2 = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	@Override
	public void onClick(View v) {
		
		Intent i;
		if(code.equals(ltext.getText().toString())){
			Calendar ct = Calendar.getInstance();
			if((ct.get(Calendar.DAY_OF_MONTH)==evt_date.get(Calendar.DAY_OF_MONTH)||ct.get(Calendar.DAY_OF_MONTH)==(evt_date.get(Calendar.DAY_OF_MONTH)+1))&&(ct.get(Calendar.MONTH)==evt_date.get(Calendar.MONTH)&&(ct.get(Calendar.YEAR)==evt_date.get(Calendar.YEAR)))){
				Log.e("Date Limit","OK");
				i = new Intent(this,MainActivity.class);
				i.putExtras(bdl);
				startActivity(i);
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			}
			else{
				Toast.makeText(getApplicationContext(), "FeedBack Time is Over.", Toast.LENGTH_LONG).show();
				Log.e("Date Limit","Exceeded");
				/*i= new Intent(v.getContext(), LogoActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.putExtra("EXIT", true);*/
				finishAndRemoveTask();
			}
			
			//if(setAlarm(getApplicationContext()))
			//	Toast.makeText(getApplicationContext(), "Alarm Set", Toast.LENGTH_LONG).show();
			
		}
		else{
			//i = new Intent(this,LogoActivity.class);
			Log.e("Incorrect Code", ltext.getText().toString());
			Toast.makeText(getApplicationContext(), "Incorrect Code", Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), "Please check the Code and Try Again!", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	/*public boolean setAlarm(Context c){
		
		long currentTime = System.currentTimeMillis();
		
		registerReceiver(br1, new IntentFilter("CLOSE"));
		registerReceiver(br2, new IntentFilter("NOTIFY"));
		Calendar curDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		
		Intent i = new Intent("NOTIFY");
		pi1 = PendingIntent.getBroadcast(c, 0, i, 0);
		alarm1.set(TYPE, TIME_TO_NOTIFY, pi1);
		i = new Intent("CLOSE");
		pi2 = PendingIntent.getBroadcast(c, 0, i, 0);
		alarm2.set(TYPE, TIME_TO_CLOSE, pi2);
		return true;
	}	
	public void setNotify(Context c){
		Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		Intent ri = new Intent(this, LogoActivity.class);		
		PendingIntent rpi = PendingIntent.getActivity(c,0,ri,0);
		
		Notification nf = new Notification.Builder(c)
		        .setSmallIcon(R.drawable.notify_icon)
		        .setContentTitle("MGR UNIV Event Feedback")
		        .setContentText("Only 5 mins. left to submit your Feedback! Hurry!!")
		        .setContentIntent(rpi)
		        .setSound(soundUri).build();
		
		NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		nf.flags = Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(0, nf);
		Log.e("Notification Set", "Success");
	}
	public static boolean cancelAlarm(){
		alarm1.cancel(pi1);
		alarm2.cancel(pi2);		
		return true;
	}
	@Override
	public void onDestroy(){
		try{
			if(br1!=null)
				unregisterReceiver(br1);
			if(br2!=null)
				unregisterReceiver(br2);
		}
		catch(Exception e){
			Log.e("BroadCastReciever Error", e+"");
		}
		super.onDestroy();
	}*/
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
class NoteDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do not press \"Back Button\" after Login")
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       dismiss();
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}