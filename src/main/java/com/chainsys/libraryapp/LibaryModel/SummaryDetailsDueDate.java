package com.chainsys.libraryapp.LibaryModel;

import java.sql.Date;

import lombok.Data;
@Data
public class SummaryDetailsDueDate {
	private int bookId;
	private int studentId;
	private String studentName;
	private String studentDept;
	private String bookName;
	private long mobileNumber;
	private Date issueDate;
	private Date dueDate;
@Override
public String toString() {
	return "SummaryDetailsDueDate [bookId=" + bookId + ", studentId=" + studentId + ", studentName=" + studentName
			+ ", studentDept=" + studentDept + ", bookName=" + bookName + ", mobileNumber=" + mobileNumber
			+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
}


}
