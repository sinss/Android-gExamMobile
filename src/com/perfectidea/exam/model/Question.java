package com.perfectidea.exam.model;

public class Question {
	private boolean errorInd;
	private String Id;
	private String license;
	private String subject;
	private String section;
	private String period;
	private String answer;
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String comment;
	private Integer chooseOption;
	public boolean isErrorInd() {
		return errorInd;
	}
	public void setErrorInd(boolean errorInd) {
		this.errorInd = errorInd;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getChooseOption() {
		return chooseOption;
	}
	public void setChooseOption(Integer chooseOption) {
		this.chooseOption = chooseOption;
	}

}
