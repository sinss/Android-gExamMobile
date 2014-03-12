package com.perfectidea.exam.share_functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.perfectidea.exam.Application;
import com.perfectidea.exam.app_config;
import com.perfectidea.exam.enumeration.FavoriteCategory;
import com.perfectidea.exam.model.Course;
import com.perfectidea.exam.model.DataGroupObject;
import com.perfectidea.exam.model.ExamLog;
import com.perfectidea.exam.model.License;
import com.perfectidea.exam.model.Question;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
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

	/*
	 * License
	 * */
	public ArrayList<String> GetLicenseGroups() throws IOException {
		ArrayList<String> array = new ArrayList<String>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = db.rawQuery(
				"select distinct class from license order by seq", null);
		while (cur.moveToNext()) {
			array.add(cur.getString(0));
		}
		return array;
	}

	public ArrayList<License> GetLicenses() throws IOException {
		ArrayList<License> array = new ArrayList<License>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();

		Cursor cur = db.rawQuery(
				"select * from license where status <> '9' order by seq", null);
		while (cur.moveToNext()) {
			License item = new License();
			String licenseId = cur.getString(cur.getColumnIndex("class"));
			boolean buyStatus = ShareFunction.getInstance()
					.licenseBuyingStatus(licenseId);
			item.setClassName(licenseId);
			item.setStatus(cur.getInt(cur.getColumnIndex("status")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("license_id")));
			item.setLicenseName(cur.getString(cur
					.getColumnIndex("license_name")));
			item.setComment(cur.getString(cur.getColumnIndex("common")));

			item.setBuyInd(buyStatus);
			array.add(item);
		}

		return array;
	}

	public ArrayList<License> GetLicensesInPurchased() throws IOException {
		ArrayList<License> array = new ArrayList<License>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = db.rawQuery(
				"select * from license where status <> '9' order by seq", null);
		while (cur.moveToNext()) {
			License item = new License();
			String licenseId = cur.getString(cur.getColumnIndex("class"));
			boolean buyStatus = ShareFunction.getInstance()
					.licenseBuyingStatus(licenseId);
			if (buyStatus) {
				continue;
			}
			item.setClassName(licenseId);
			item.setStatus(cur.getInt(cur.getColumnIndex("status")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("license_id")));
			item.setLicenseName(cur.getString(cur
					.getColumnIndex("license_name")));
			item.setComment(cur.getString(cur.getColumnIndex("common")));
			array.add(item);
		}
		return array;
	}

	/*
	 * Courses
	 * */
	public ArrayList<Course> GetAllSubjectsInLicense(String licenseId)
			throws IOException {
		ArrayList<Course> array = new ArrayList<Course>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = db
				.rawQuery(
						"select * from course where license_id = ? group by subject_id",
						new String[] { licenseId });
		while (cur.moveToNext()) {
			Course item = new Course();
			item.setLicenseId(cur.getString(cur.getColumnIndex("license")));
			item.setSubject(cur.getString(cur.getColumnIndex("subject")));
			item.setSection(cur.getString(cur.getColumnIndex("section")));
			item.setSubjectAmount(cur.getInt(cur
					.getColumnIndex("subject_amount")));
			item.setSectionAmount(cur.getInt(cur
					.getColumnIndex("section_amount")));
			item.setExamTime(cur.getInt(cur.getColumnIndex("exam_time")));
			item.setTotalGrade(cur.getInt(cur.getColumnIndex("total_grade")));
			item.setPassGrade(cur.getInt(cur.getColumnIndex("pass_grade")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("subject_id")));
			item.setSubjectId(cur.getInt(cur.getColumnIndex("subject_id")));
			item.setSectionId(cur.getInt(cur.getColumnIndex("section_id")));
			array.add(item);
		}
		return array;
	}

	public ArrayList<Course> GetCourses(String licenseId, Integer subjectId)
			throws IOException {
		ArrayList<Course> array = new ArrayList<Course>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = null;
		if (licenseId.startsWith("sec") || licenseId.startsWith("bak")) {
			cur = db.rawQuery(
					"select * from course where license_id = ? and subject_id = ? order by subject_id, section_id desc",
					new String[] { licenseId, String.valueOf(subjectId) });
		} else {
			cur = db.rawQuery(
					"select * from course where license_id = ? and subject_id = ? order by subject_id, section_id desc",
					new String[] { licenseId, String.valueOf(subjectId) });
		}

		while (cur.moveToNext()) {
			Course item = new Course();
			item.setLicenseId(cur.getString(cur.getColumnIndex("license")));
			item.setSubject(cur.getString(cur.getColumnIndex("subject")));
			item.setSection(cur.getString(cur.getColumnIndex("section")));
			item.setSubjectAmount(cur.getInt(cur
					.getColumnIndex("subject_amount")));
			item.setSectionAmount(cur.getInt(cur
					.getColumnIndex("section_amount")));
			item.setExamTime(cur.getInt(cur.getColumnIndex("exam_time")));
			item.setTotalGrade(cur.getInt(cur.getColumnIndex("total_grade")));
			item.setPassGrade(cur.getInt(cur.getColumnIndex("pass_grade")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("subject_id")));
			item.setSubjectId(cur.getInt(cur.getColumnIndex("subject_id")));
			item.setSectionId(cur.getInt(cur.getColumnIndex("section_id")));
			array.add(item);
		}
		return array;
	}

	public Course GetCourse(String licenseId, Integer subjectId,
			Integer sectionId) throws IOException {
		Course item = new Course();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetLicenseDB();
		Cursor cur = db
				.rawQuery(
						"select * from course where license_id = ? and subject_id = ? and section_id = ?",
						new String[] { licenseId, String.valueOf(subjectId),
								String.valueOf(sectionId) });
		if (cur.moveToFirst()) {
			item.setLicenseId(cur.getString(cur.getColumnIndex("license")));
			item.setSubject(cur.getString(cur.getColumnIndex("subject")));
			item.setSection(cur.getString(cur.getColumnIndex("section")));
			item.setSubjectAmount(cur.getInt(cur
					.getColumnIndex("subject_amount")));
			item.setSectionAmount(cur.getInt(cur
					.getColumnIndex("section_amount")));
			item.setExamTime(cur.getInt(cur.getColumnIndex("exam_time")));
			item.setTotalGrade(cur.getInt(cur.getColumnIndex("total_grade")));
			item.setPassGrade(cur.getInt(cur.getColumnIndex("pass_grade")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("subject_id")));
			item.setSubjectId(cur.getInt(cur.getColumnIndex("subject_id")));
			item.setSectionId(cur.getInt(cur.getColumnIndex("section_id")));
		}
		return item;
	}

	/*
	 * Questions
	 * */
	public ArrayList<Question> GetRandomQuestions(ArrayList<Course> courses)
			throws IOException {
		ArrayList<Question> array = new ArrayList<Question>();
		for (Course course : courses) {
			SQLiteDatabase db = DatabaseConnection.getInstance()
					.GetQuestionDatabase(course.getLicenseId());
			Cursor cur = null;
			String qid = String.format("%s%d%02d", course.getLicenseId(),
					course.getSubjectId(), course.getSectionId());
			if (course.getSubjectAmount() == -1) {
				if (courses.size() == 1) {
					cur = db.rawQuery(
							"select * from questions where q_id like '%?%' order by Random() limite 30",
							new String[] { qid });
				} else {
					cur = db.rawQuery(
							"select * from questions where q_id like '%?%' order by Random() limite ?",
							new String[] { qid,
									String.valueOf(course.getSectionAmount()) });
				}
			} else {
				cur = db.rawQuery(
						"select * from questions where q_id like '%?%' order by Random()",
						new String[] { qid });
			}
			while (cur.moveToNext()) {
				Question item = new Question();
				String content = cur.getString(cur.getColumnIndex("q_content"));
				String option1 = cur.getString(cur.getColumnIndex("q_optoin1"));
				String option2 = cur.getString(cur.getColumnIndex("q_optoin2"));
				String option3 = cur.getString(cur.getColumnIndex("q_optoin3"));
				String option4 = cur.getString(cur.getColumnIndex("q_optoin4"));
				item.setLicense(cur.getString(cur.getColumnIndex("q_name")));
				item.setSubject(cur.getString(cur.getColumnIndex("q_subject")));
				item.setSection(cur.getString(cur.getColumnIndex("q_section")));
				item.setId(cur.getString(cur.getColumnIndex("q_id")));
				item.setAnswer(cur.getString(cur.getColumnIndex("q_answer")));
				item.setContent(ShareFunction.getInstance().DecryptString(
						content));
				item.setOption1(ShareFunction.getInstance().DecryptString(
						option1));
				item.setOption2(ShareFunction.getInstance().DecryptString(
						option2));
				item.setOption3(ShareFunction.getInstance().DecryptString(
						option3));
				item.setOption4(ShareFunction.getInstance().DecryptString(
						option4));
				item.setComment(cur.getString(cur.getColumnIndex("q_comment")));
				array.add(item);
			}
		}
		return array;
	}

	public ArrayList<Question> GetQuestionsInCourses(ArrayList<Course> courses)
			throws IOException {
		ArrayList<Question> array = new ArrayList<Question>();
		for (Course course : courses) {
			SQLiteDatabase db = DatabaseConnection.getInstance()
					.GetQuestionDatabase(course.getLicenseId());
			Cursor cur = null;
			String qid = String.format("%s%d%02d", course.getLicenseId(),
					course.getSubjectId(), course.getSectionId());
			cur = db.rawQuery(
					"select * from questions where q_id like '%?%' order by qid",
					new String[] { qid,
							String.valueOf(course.getSectionAmount()) });
			while (cur.moveToNext()) {
				Question item = new Question();
				String content = cur.getString(cur.getColumnIndex("q_content"));
				String option1 = cur.getString(cur.getColumnIndex("q_optoin1"));
				String option2 = cur.getString(cur.getColumnIndex("q_optoin2"));
				String option3 = cur.getString(cur.getColumnIndex("q_optoin3"));
				String option4 = cur.getString(cur.getColumnIndex("q_optoin4"));
				item.setLicense(cur.getString(cur.getColumnIndex("q_name")));
				item.setSubject(cur.getString(cur.getColumnIndex("q_subject")));
				item.setSection(cur.getString(cur.getColumnIndex("q_section")));
				item.setId(cur.getString(cur.getColumnIndex("q_id")));
				item.setAnswer(cur.getString(cur.getColumnIndex("q_answer")));
				item.setContent(ShareFunction.getInstance().DecryptString(
						content));
				item.setOption1(ShareFunction.getInstance().DecryptString(
						option1));
				item.setOption2(ShareFunction.getInstance().DecryptString(
						option2));
				item.setOption3(ShareFunction.getInstance().DecryptString(
						option3));
				item.setOption4(ShareFunction.getInstance().DecryptString(
						option4));
				item.setComment(cur.getString(cur.getColumnIndex("q_comment")));
				array.add(item);
			}
		}
		return array;
	}

	/*
	 * ExamLog
	 * */
	public Integer GetMaxSaveIdInExamLog() throws IOException {
		Integer count = 0;
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		Cursor cur = db.rawQuery("select max(save_id) from examLog", null);
		if (cur.moveToFirst()) {
			count = cur.getInt(0);
		}
		return count;
	}

	public boolean SaveExamResult(String licenseId, Integer subjectId,
			Integer sectionId, Integer grade, Integer spendTimes,
			Integer totalGrades) throws IOException {
		int maxSaveId = GetMaxSaveIdInExamLog() + 1;
		String today = DateFunctions.getInstance().dateToString(new Date());
		ContentValues value = new ContentValues();
		value.put("subject_amount", 0);
		value.put("section_amount", 0);
		value.put("exam_time", spendTimes);
		value.put("total_grade", totalGrades);
		value.put("pass_grade", grade);
		value.put("license_id", licenseId);
		value.put("subject_id", subjectId);
		value.put("section_id", sectionId);
		value.put("exam_date", today);
		value.put("save_id", maxSaveId);

		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		long rowId = db.insert("examLog", null, value);
		if (rowId == -1) {
			return false;
		}
		return true;
	}

	public boolean DeleteExamLog(ExamLog log) throws IOException {
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		db.delete("examLog", "save_id = ?",
				new String[] { String.valueOf(log.getSaveId()) });
		return true;
	}

	public ArrayList<DataGroupObject> GetExamLogLicenseGroup()
			throws IOException {
		ArrayList<DataGroupObject> array = new ArrayList<DataGroupObject>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		Cursor cur = db
				.rawQuery(
						"select distinct examLog.license_id ,license.license_name from examLog,license where examLog.license_id = license.license_id order by examLog.license_id",
						null);
		while (cur.moveToNext()) {
			DataGroupObject item = new DataGroupObject();
			item.setLicenseId(cur.getString(cur.getColumnIndex("license_id")));
			item.setLicenseName(cur.getString(cur
					.getColumnIndex("license_name")));
			array.add(item);
		}
		return array;
	}

	public ArrayList<ExamLog> GetExamLog() throws IOException {
		ArrayList<ExamLog> array = new ArrayList<ExamLog>();
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		Cursor cur = db
				.rawQuery("select * from examLog order by save_id", null);
		while (cur.moveToNext()) {
			ExamLog item = new ExamLog();
			item.setSubjectAmount(cur.getInt(cur
					.getColumnIndex("subject_amount")));
			item.setSectionAmount(cur.getInt(cur
					.getColumnIndex("section_amount")));
			item.setExamTime(cur.getInt(cur.getColumnIndex("exam_time")));
			item.setTotalGrade(cur.getInt(cur.getColumnIndex("total_grade")));
			item.setPassGrade(cur.getInt(cur.getColumnIndex("pass_grade")));
			item.setLicenseId(cur.getString(cur.getColumnIndex("license_id")));
			item.setSubjectId(cur.getInt(cur.getColumnIndex("subject_id")));
			item.setSectionId(cur.getInt(cur.getColumnIndex("section_id")));
			item.setExamDate(cur.getString(cur.getColumnIndex("exam_date")));
			item.setSaveId(cur.getInt(cur.getColumnIndex("save_id")));

			array.add(item);
		}
		return array;
	}
	/*
	 * Favorite 
	 * */
	public boolean ExistInFavorite(String qid) throws IOException {
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		Integer count = 0;
		Cursor cur = db.rawQuery(
				"select count(*) from favorite where q_id = ?",
				new String[] { String.valueOf(qid) });
		if (cur.moveToFirst()) {
			count = cur.getInt(0);
		}
		if (count > 0)
			return true;
		return false;
	}

	public boolean SaveFavorite(Question q, FavoriteCategory category)
			throws IOException {
		boolean exist = ExistInFavorite(q.getId());
		if (exist) {
			LogUtil.e("favorite exist : " + q.getId());
			return false;
		}
		SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
		ContentValues value = new ContentValues();
		value.put("q_name", q.getLicense());
		value.put("q_subject", q.getSubject());
		value.put("q_section", q.getSection());
		value.put("q_id", q.getId());
		value.put("q_answer", q.getAnswer());
		value.put("q_content", q.getContent());
		value.put("q_option1", q.getOption1());
		value.put("q_option2", q.getOption2());
		value.put("q_option3", q.getOption3());
		value.put("q_option4", q.getOption4());
		value.put("q_comment", category.toInt());
		long rowId = db.insert("favorite", null, value);
		if (rowId == -1) {
			LogUtil.e("favorite save error");
			return false;
		}
		return true;
	}
	
	public Integer NumberOfQuestionsInFavorite(String licenseId, Integer subjectId, Integer sectionId, FavoriteCategory category) throws IOException {
		ArrayList<Course> array = new ArrayList<Course> ();
		if (sectionId != 0) {
			Course course = GetCourse(licenseId, subjectId, sectionId);
			array.add(course);
		}
		else {
			array = GetCourses(licenseId, subjectId);
		}
		
		ArrayList<Question> questions = this.GetFavorites(array, category);
		
		return questions.size();
	}
	
	public ArrayList<Question> GetFavorites(ArrayList<Course> courses, FavoriteCategory category) throws IOException {
		ArrayList<Question> array = new ArrayList<Question>();
		for (Course course : courses) {
			Cursor cur = null;
			SQLiteDatabase db = DatabaseConnection.getInstance().GetDataDB();
			String qid = String.format("%s%d%02d", course.getLicenseId(),
					course.getSubjectId(), course.getSectionId());
			if (category.equals(FavoriteCategory.all)) {
				cur = db.rawQuery("select * from favorite where q_id like '%?%'", new String[] { qid });
			}
			else if (category.equals(FavoriteCategory.favorite)) {
				cur = db.rawQuery("select * from favorite where q_id like '%?%' and category = ?", new String[] { qid , String.valueOf(category.toInt())});
			}
			else if (category.equals(FavoriteCategory.error)) {
				cur = db.rawQuery("select * from favorite where q_id like '%?%' and category = ?", new String[] { qid , String.valueOf(category.toInt())});
			}
			while (cur.moveToNext()) {
				Question item = new Question();
				String content = cur.getString(cur.getColumnIndex("q_content"));
				String option1 = cur.getString(cur.getColumnIndex("q_optoin1"));
				String option2 = cur.getString(cur.getColumnIndex("q_optoin2"));
				String option3 = cur.getString(cur.getColumnIndex("q_optoin3"));
				String option4 = cur.getString(cur.getColumnIndex("q_optoin4"));
				item.setLicense(cur.getString(cur.getColumnIndex("q_name")));
				item.setSubject(cur.getString(cur.getColumnIndex("q_subject")));
				item.setSection(cur.getString(cur.getColumnIndex("q_section")));
				item.setId(cur.getString(cur.getColumnIndex("q_id")));
				item.setAnswer(cur.getString(cur.getColumnIndex("q_answer")));
				item.setContent(content);
				item.setOption1(option1);
				item.setOption2(option2);
				item.setOption3(option3);
				item.setOption4(option4);
				item.setComment(cur.getString(cur.getColumnIndex("q_comment")));
				array.add(item);
			}
		}
		return array;
	}
}
