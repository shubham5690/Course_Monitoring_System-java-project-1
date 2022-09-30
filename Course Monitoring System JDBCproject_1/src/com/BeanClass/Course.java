package com.BeanClass;

public class Course {
	private int courseid ;
	private String coursename;
	private int fee ;
	private String coursedescription;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseid, String coursename, int fee, String coursedescription) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fee = fee;
		this.coursedescription = coursedescription;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getCoursedescription() {
		return coursedescription;
	}
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", fee=" + fee + ", coursedescription="
				+ coursedescription + "]";
	}
	
	
}
