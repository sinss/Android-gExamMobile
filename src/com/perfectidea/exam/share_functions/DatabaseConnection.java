package com.perfectidea.exam.share_functions;

import java.io.IOException;

import android.database.sqlite.SQLiteDatabase;

import com.perfectidea.exam.Application;
import com.perfectidea.exam.app_config;
import com.perfectidea.exam.helper.DatabaseHelper;

public class DatabaseConnection {
	/**
	 * Create a Singleton instance
	 * */
	private static DatabaseHelper controlHelper;
	private static DatabaseHelper dataHelper;
	private static DatabaseHelper fin00;
	private static DatabaseHelper ins01;
	private static DatabaseHelper ins02;
	private static DatabaseHelper ins03;
	private static DatabaseHelper ins04;
	private static DatabaseHelper bank01;
	private static DatabaseHelper bank02;
	// private static DatabaseHelper bank03;
	// private static DatabaseHelper bank04;
	private static DatabaseHelper bank05;
	private static DatabaseHelper bank06;
	private static DatabaseHelper sec01;
	private static DatabaseHelper sec02;
	private static DatabaseHelper sec03;
	private static DatabaseHelper sec04;
	private static DatabaseHelper sec05;
	private static DatabaseHelper sec06;
	private static DatabaseHelper sec07;
	private static DatabaseHelper sec08;
	private static DatabaseConnection instance = null;

	public static DatabaseConnection getInstance() throws IOException {
		if (instance == null) {
			synchronized (DatabaseConnection.class) {
				if (instance == null) {
					instance = new DatabaseConnection();
					initialized();
				}
			}
		}
		return instance;
	}

	private static void initialized() throws IOException {
		controlHelper = new DatabaseHelper(Application.getInstance(),
				"control.db", null, app_config.controlDB);
		dataHelper = new DatabaseHelper(Application.getInstance(), "data.sqlite",
				null, app_config.dataDB);
		fin00 = new DatabaseHelper(Application.getInstance(), "tb_img1",
				null, app_config.fin00);
		ins01 = new DatabaseHelper(Application.getInstance(), "tb_img2",
				null, app_config.ins01);
		ins02 = new DatabaseHelper(Application.getInstance(), "tb_img3",
				null, app_config.ins02);
		ins03 = new DatabaseHelper(Application.getInstance(), "tb_img4",
				null, app_config.ins03);
		ins04 = new DatabaseHelper(Application.getInstance(), "tb_img5",
				null, app_config.ins04);
		bank01 = new DatabaseHelper(Application.getInstance(), "bk_img1",
				null, app_config.bank01);
		bank02 = new DatabaseHelper(Application.getInstance(), "bk_img2",
				null, app_config.bank02);
		// bank03 = new DatabaseHelper(Application.getInstance(), "bg_img3.db",
		// null, app_config.bank03);
		// bank04 = new DatabaseHelper(Application.getInstance(), "bk_img4.db",
		// null, app_config.bank04);
		bank05 = new DatabaseHelper(Application.getInstance(), "bk_img5",
				null, app_config.bank05);
		bank06 = new DatabaseHelper(Application.getInstance(), "bk_img6",
				null, app_config.bank06);
		sec01 = new DatabaseHelper(Application.getInstance(), "sec_img1",
				null, app_config.sec01);
		sec02 = new DatabaseHelper(Application.getInstance(), "sec_img2",
				null, app_config.sec02);
		sec03 = new DatabaseHelper(Application.getInstance(), "sec_img3",
				null, app_config.sec03);
		sec04 = new DatabaseHelper(Application.getInstance(), "sec_img4",
				null, app_config.sec04);
		sec05 = new DatabaseHelper(Application.getInstance(), "sec_img5",
				null, app_config.sec05);
		sec06 = new DatabaseHelper(Application.getInstance(), "sec_img6",
				null, app_config.sec06);
		sec07 = new DatabaseHelper(Application.getInstance(), "sec_img7",
				null, app_config.sec07);
		sec08 = new DatabaseHelper(Application.getInstance(), "sec_img8",
				null, app_config.sec08);
	}

	/**
	 * 
	 * control.db
	 * */
	public SQLiteDatabase GetLicenseDB() {
		return controlHelper.getReadableDatabase();
	}

	public void closeLicenseDB() {
		controlHelper.close();
	}

	/**
	 * 
	 * control.db
	 * */
	public SQLiteDatabase GetDataDB() {
		return dataHelper.getWritableDatabase();
	}

	public void closeDataDB() {
		dataHelper.close();
	}

	/* ************************************************************************
	 * 共同科目
	 * **********************************************************************
	 */
	/**
	 * 
	 * */
	public SQLiteDatabase GetFin00() {
		return fin00.getReadableDatabase();
	}

	public void closeFin00() {
		fin00.close();
	}

	/* ************************************************************************
	 * 人身壽險
	 * **********************************************************************
	 */
	/**
	 * 
	 * */
	public SQLiteDatabase GetIns01() {
		return ins01.getReadableDatabase();
	}

	public void closeIns01() {
		ins01.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetIns02() {
		return ins02.getReadableDatabase();
	}

	public void closeIns02() {
		ins02.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetIns03() {
		return ins03.getReadableDatabase();
	}

	public void closeIns03() {
		ins03.close();
	}

	/**
	 * �]���O�I�~�ȭ�
	 * */
	public SQLiteDatabase GetIns04() {
		return ins04.getReadableDatabase();
	}

	public void closeIns04() {
		ins04.close();
	}

	/* ************************************************************************
	 * 銀行證照
	 * **********************************************************************
	 */
	/**
	 * 
	 * */
	public SQLiteDatabase GetBank01() {
		return bank01.getReadableDatabase();
	}

	public void closeBank01() {
		bank01.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetBank02() {
		return bank02.getReadableDatabase();
	}

	public void closeBank02() {
		bank02.close();
	}

	/**
	 * 
	 * sec03
	 * */
	/**
	 * 
	 * sec04
	 * */

	/**
	 * �춥�«H�H��
	 * */
	public SQLiteDatabase GetBank05() {
		return bank05.getReadableDatabase();
	}

	public void closeBank05() {
		bank05.close();
	}

	/**
	 * ���c���ӫ~�P��H��
	 * */
	public SQLiteDatabase GetBank06() {
		return bank06.getReadableDatabase();
	}

	public void closeBank06() {
		bank06.close();
	}

	/**
	 * 
	 * sec07
	 * */
	/* ************************************************************************
	 * 證券證照
	 * **********************************************************************
	 */
	/**
	 * 
	 * */
	public SQLiteDatabase GetSec01() {
		return sec01.getReadableDatabase();
	}

	public void closeSec01() {
		sec01.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec02() {
		return sec02.getReadableDatabase();
	}

	public void closeSec02() {
		sec02.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec03() {
		return sec03.getReadableDatabase();
	}

	public void closeSec03() {
		sec03.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec04() {
		return sec04.getReadableDatabase();
	}

	public void closeSec04() {
		sec04.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec05() {
		return sec05.getReadableDatabase();
	}

	public void closeSec05() {
		sec05.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec06() {
		return sec06.getReadableDatabase();
	}

	public void closeSec06() {
		sec06.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec07() {
		return sec07.getReadableDatabase();
	}

	public void closeSec07() {
		sec07.close();
	}

	/**
	 * 
	 * */
	public SQLiteDatabase GetSec08() {
		return sec08.getReadableDatabase();
	}

	public void closeSec08() {
		sec08.close();
	}
	
	public SQLiteDatabase GetQuestionDatabase(String licenseId) {
		if (licenseId.equals(app_config.licenseId1)) {
			return fin00.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseId2)) {
			return ins01.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseId3)) {
			return ins02.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseId4)) {
			return ins03.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseId5)) {
			return ins04.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseBank01)) {
			return bank01.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseBank02)) {
			return bank02.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseBank05)) {
			return bank05.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseBank06)) {
			return bank06.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec01)) {
			return sec01.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec02)) {
			return sec02.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec03)) {
			return sec03.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec04)) {
			return sec04.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec05)) {
			return sec05.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec06)) {
			return sec06.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec07)) {
			return sec07.getReadableDatabase();
		}
		else if (licenseId.equals(app_config.licenseSec08)) {
			return sec08.getReadableDatabase();
		}
		return controlHelper.getWritableDatabase();
	}
}
