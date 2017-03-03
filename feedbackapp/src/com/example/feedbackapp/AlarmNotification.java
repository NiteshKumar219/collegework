/*package com.example.feedbackapp;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;

public class AlarmNotification{
	
	static final long TIME_TO_CLOSE = 60000;	//720
	static final long TIME_TO_NOTIFY = 30000;	//670
	static final int TYPE = AlarmManager.RTC_WAKEUP;
	static LoginActivity x;
	static PendingIntent pi1;
	static PendingIntent pi2;
	static AlarmManager alarm1 = (AlarmManager)x.getSystemService(Context.ALARM_SERVICE);
	static AlarmManager alarm2 = (AlarmManager)x.getSystemService(Context.ALARM_SERVICE);

	public static boolean setAlarm(LoginActivity x){
				
		long currentTime = System.currentTimeMillis();
		
		BroadcastReceiver br = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				new Feedback4().feedbackDone();				
			}
		};
		x.registerReceiver(br, new IntentFilter("CLOSE"));
		Intent i = new Intent("NOTIFY");
		pi1 = PendingIntent.getBroadcast(x.getApplicationContext(), 0, i, 0);
		alarm1.set(TYPE, currentTime+TIME_TO_NOTIFY, pi1);
		i = new Intent("CLOSE");
		pi2 = PendingIntent.getBroadcast(x.getApplicationContext(), 0, i, 0);
		alarm2.set(TYPE, currentTime+TIME_TO_CLOSE, pi2);
		return true;
	}	
	public static void setNotify(){
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(x)
		        .setSmallIcon(R.drawable.notify_icon)
		        .setContentTitle("MGR UNIV Event Feedback")
		        .setContentText("Only 5 mins. left to submit your Feedback! Hurry!!")
				.setAutoCancel(true);
		Intent resultIntent = new Intent(x, LogoActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(x);
		stackBuilder.addParentStack(LogoActivity.class);
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager)x.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());
	}
	public static boolean cancelAlarm(){
		alarm1.cancel(pi1);
		alarm2.cancel(pi2);
		return true;
	}
	
}
*/