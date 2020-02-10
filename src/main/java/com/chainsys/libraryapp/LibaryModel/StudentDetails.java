package com.chainsys.libraryapp.LibaryModel;

import java.sql.Date;

import lombok.Data;
@Data
public class StudentDetails {
	private int studentId;
	private String studentName;
	private String studentDepatment;
	private Date dateOfBirth;
	private String studentMailId;
	private long mobileNumber;
	private int yearOfJoin;
@Override
public String toString() {
	return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", studentDepatment="
			+ studentDepatment + ", dateOfBirth=" + dateOfBirth + ", studentMailId=" + studentMailId + ", mobileNumber="
			+ mobileNumber + ", yearOfJoin=" + yearOfJoin + "]";
}





}
