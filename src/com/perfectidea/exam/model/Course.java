package com.perfectidea.exam.model;

public class Course {
	private String license;
	private String subject;
	private String section;
	private Integer subjectAmount;
	private Integer sectionAmount;
	private Integer examTime;
	private Integer totalGrade;
	private Integer passGrade;
	private String licenseId;
	private Integer subjectId;
	private Integer sectionId;
	private Number grades;
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Integer getSubjectAmount() {
		return subjectAmount;
	}
	public void setSubjectAmount(Integer subjectAmount) {
		this.subjectAmount = subjectAmount;
	}
	public Integer getSectionAmount() {
		return sectionAmount;
	}
	public void setSectionAmount(Integer sectionAmount) {
		this.sectionAmount = sectionAmount;
	}
	public Integer getExamTime() {
		return examTime;
	}
	public void setExamTime(Integer examTime) {
		this.examTime = examTime;
	}
	public Integer getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(Integer totalGrade) {
		this.totalGrade = totalGrade;
	}
	public Integer getPassGrade() {
		return passGrade;
	}
	public void setPassGrade(Integer passGrade) {
		this.passGrade = passGrade;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public Number getGrades() {
		return grades;
	}
	public void setGrades(Number grades) {
		this.grades = grades;
	}
}
