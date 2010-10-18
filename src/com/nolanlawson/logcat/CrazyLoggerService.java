package com.nolanlawson.logcat;

import java.util.Date;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * just writes a bunch of logs.  to be used during debugging and testing.
 * @author nolan
 *
 */
public class CrazyLoggerService extends IntentService {
	
	private boolean kill = false;

	public CrazyLoggerService() {
		super("CrazyLoggerService");
	}

	protected void onHandleIntent(Intent intent) {
	
		Log.d("CrazyLoggerService", "onHandleIntent()");
		
		while (!kill) {
		
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				Log.e("CrazyLoggerService", "error", e);
			}
			Date date = new Date();
			Log.i("CrazyLoggerService", "Log message " + date + " " + (date.getTime() % 1000));
		
		}
	
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		kill = true;
	}
	
}