package com.BeanClass;

import java.util.Date;

public class Batch {
	private int batchid;
	private int courseid;
	private int facultyid;
	private int noOfStudent;
	private String batchStartDate;
	private String duration;
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int batchid, int courseid, int facultyid, int noOfStudent, String batchStartDate, String duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.facultyid = facultyid;
		this.noOfStudent = noOfStudent;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getFacultyid() {
		return facultyid;
	}
	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	public String getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Batch [batchid=" + batchid + ", courseid=" + courseid + ", facultyid=" + facultyid + ", noOfStudent="
				+ noOfStudent + ", batchStartDate=" + batchStartDate + ", duration=" + duration + "]";
	}
	
	
}
