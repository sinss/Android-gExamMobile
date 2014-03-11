package com.perfectidea.exam;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class Application extends android.app.Application {
	
	private static Application instance;

	public static Application getInstance() {
		if (instance == null)
			throw new IllegalStateException();
		return instance;
	}
	
	public Application() {
		instance = this;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
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
