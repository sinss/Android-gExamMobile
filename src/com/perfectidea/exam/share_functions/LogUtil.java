package com.perfectidea.exam.share_functions;

import com.perfectidea.exam.Application;

import android.util.Log;

public class LogUtil {
	private static final String LogTag = Application.getInstance().getPackageName();
	
	protected static boolean DEBUG_LOGGING = true;

	public static final void i(String message){
		Log.i(LogTag, message);
	}

	public static final void w(String message){
		Log.w(LogTag, message);
	}

	public static final void d(String message){
		if(DEBUG_LOGGING){
			Log.d(LogTag, message);
		}
	}

	public static final void e(String message){
		Log.e(LogTag, message);
	}
}
