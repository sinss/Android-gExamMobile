package com.perfectidea.exam.share_functions;

import java.io.IOException;
import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {
	/**
	 * Create a Singleton instance
	 * */
	private static DatabaseAccess instance = null;

	public static DatabaseAccess getInstance() {
		if (instance == null) {
			synchronized (DatabaseAccess.class) {
				if (instance == null) {
					instance = new DatabaseAccess();
				}
			}
		}
		return instance;
	}
	
	public ArrayList<String> GetLicenseGroups() throws IOException {
		ArrayList<String> array = new ArrayList<String>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = db.rawQuery("select distinct class from license order by seq", null);
		while (cur.moveToNext()) {
			array.add(cur.getString(0));
		}
		return array;
	}
	
}
