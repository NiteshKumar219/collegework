package com.example.feedbackapp;

import java.util.HashMap;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.util.Log;
import cz.msebera.android.httpclient.Header;




public class MySQLUpdater {

	AsyncHttpClient client;
	RequestParams params;
	
	Gson gson;
	
	public MySQLUpdater(){
		gson = new Gson();
		client = new AsyncHttpClient();
		params = new RequestParams();
	}
	
	public void updateMysQL(HashMap<String,Object> data){
		String dt = gson.toJson(data);
		Log.e("Sending Data", dt);
		params.add("feeddata", dt);
		client.post("http://www.scholarcouncil.com/www/mysqlsqlitesync/storeFeedback.php", params, new AsyncHttpResponseHandler(){

			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				System.out.println("Error");
			}

			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				System.out.println("Success");
			}
			
		});
		System.out.println("Done Synching");
		Log.e("Done Update", "");
	}
}
