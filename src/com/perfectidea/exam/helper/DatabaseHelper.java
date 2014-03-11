package com.perfectidea.exam.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.perfectidea.exam.share_functions.LogUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

@SuppressLint("SdCardPath")
public class DatabaseHelper extends SQLiteOpenHelper  {
	private final Context context;
	private final String assetPath;
	private final String dbPath;
	private final Integer db_version;
	
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) throws IOException {
		super(context, name, factory, version);
		this.context = context;
		this.assetPath = name;
		this.db_version = version;
		this.dbPath = "/data/data/"
				+ context.getApplicationContext().getPackageName()
				+ "/databases/" + name;

		checkExists();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion == oldVersion) {
			LogUtil.e("insurance.db doesn't need change");
		}
		else if (oldVersion > newVersion) {
			LogUtil.e("insurance.db XX");
		}
		else if (oldVersion < newVersion) {
			LogUtil.e("insurance.db need upgrade");
		}
		
		try {
			LogUtil.e( "Insurance.db version : " + db_version);
			upgradeDatabase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		LogUtil.e("SQLiteHelper on Open!");
		super.onOpen(db);
	}

	/**
	 * Checks if the database asset needs to be copied and if so copies it to
	 * the default location.
	 * 
	 * @throws IOException
	 */
	private void checkExists() throws IOException {
		LogUtil.e("checkExists()");

		File dbFile = new File(dbPath);

		if (!dbFile.exists()) {

			LogUtil.e("creating database..");

			if (!dbFile.getParentFile().exists()) {
				dbFile.getParentFile().mkdirs();				
			}
			
			copyStream(context.getAssets().open(assetPath),
					new FileOutputStream(dbFile));

			LogUtil.e(assetPath + " has been copied to "
							+ dbFile.getAbsolutePath());
		}

	}
	
	private void upgradeDatabase() throws IOException {
		File dbFile = new File(dbPath);

		LogUtil.e("upgrading database..");

		if (dbFile.exists()) {
			dbFile.delete();
		}
		
		copyStream(context.getAssets().open(assetPath),
				new FileOutputStream(dbFile));

		LogUtil.e(assetPath + " has been copied to "
						+ dbFile.getAbsolutePath());
	}

	private void copyStream(InputStream is, OutputStream os) throws IOException {
		byte buf[] = new byte[1024];
		int c = 0;
		while (true) {
			c = is.read(buf);
			if (c == -1)
				break;
			os.write(buf, 0, c);
		}
		is.close();
		os.close();
	}
}
