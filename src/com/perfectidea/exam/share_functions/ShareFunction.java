package com.perfectidea.exam.share_functions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

import com.perfectidea.exam.Application;
import com.perfectidea.exam.app_config;
import com.perfectidea.exam.enumeration.FavoriteCategory;

import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.util.Base64;

public class ShareFunction {

	/**
	 * Create a Singleton instance
	 * */
	private static ShareFunction instance = null;

	public static ShareFunction getInstance() {
		if (instance == null) {
			synchronized (ShareFunction.class) {
				if (instance == null) {
					instance = new ShareFunction();
				}
			}
		}
		return instance;
	}

	public boolean licenseBuyingStatus(String licenseId) {
		boolean status = false;
		SharedPreferences pref = Application.getInstance().getSharedPref();

		status = pref.getBoolean(licenseId, false);

		return status;
	}

	public String GetExamOption(String key) {
		if (key.equals(app_config.licenseTag)) {
			return "證照";
		} else if (key.equals(app_config.subjectTag)) {
			return "科目";
		} else if (key.equals(app_config.sectionTag)) {
			return "單元";
		} else if (key.equals(app_config.categoryTag)) {
			return "類別";
		}
		return "";
	}

	public String GetCategoryName(FavoriteCategory key) {
		switch (key) {
		case all:
			return "全部";
		case favorite:
			return "自選";
		case error:
			return "錯誤";
		default:
			return "";
		}
	}

	/**
	 * 
	 * */
	public ArrayList<Integer> GetAges() {
		ArrayList<Integer> ages = new ArrayList<Integer>();
		for (int i = 75; i >= 0; i--) {
			ages.add(i);
		}
		return ages;
	}

	/**
	 * 
	 * */
	public ArrayList<Integer> GetOccus() {
		ArrayList<Integer> occus = new ArrayList<Integer>();
		for (int i = 1; i <= 7; i++) {
			occus.add(i);
		}
		return occus;
	}
	
	public String GetDeviceId() {
		String deviceId = Secure.getString(Application.getInstance().getContentResolver(),
                Secure.ANDROID_ID);
		return deviceId;
	}

	/**
	 * 取得亂數字串
	 * 
	 * @param length
	 *            : 字串長度
	 * @return string : 亂數字串
	 * */
	public String GetRandomStringWithLength(Integer len) {
		final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public String DecryptString(String str) throws UnsupportedEncodingException {
		String res = "";
		if (str.length() < 6) {
			return res;
		}
		/*
		 * remove the extended string
		 */
		str = str.substring(0, str.length() - 6);
		/*
		 * decode the base64
		 */
		byte[] data = Base64.decode(str, Base64.DEFAULT);
		res = new String(data, "UTF-8");

		return res;
	}

}
