package com.perfectidea.exam;

import android.content.Context;
import android.content.SharedPreferences;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class Application extends android.app.Application {
	
	private SharedPreferences sharedPref = null;
	
	private static Application instance;

	public static Application getInstance() {
		if (instance == null)
			throw new IllegalStateException();
		return instance;
	}
	
	public SharedPreferences getSharedPref() {
		return sharedPref;
	}
	
	public Application() {
		instance = this;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		sharedPref = getSharedPreferences(app_config.sharedPrefTag, Context.MODE_PRIVATE);
		/*
		 * save installation information to parse server
		 * */
		Parse.initialize(this, app_config.getParseAppId(), app_config.getParseClientKey());

		ParseUser.enableAutomaticUser();
		
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);

		PushService.setDefaultPushCallback(this, ExamSimulationActivity.class);
		
		ParseInstallation.getCurrentInstallation().saveInBackground();
	}

}
