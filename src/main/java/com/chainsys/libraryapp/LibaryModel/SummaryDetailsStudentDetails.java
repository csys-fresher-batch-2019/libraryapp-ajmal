package com.chainsys.libraryapp.LibaryModel;

import java.sql.Date;

import lombok.Data;
@Data
public class SummaryDetailsStudentDetails {
	private String studentName;
	private int bookId;
	private String bookName;
	private Date issueDate;
	private Date duedate;
	@Override
	public String toString() {
		return "SummaryDetailsStudentDetails [studentName=" + studentName + ", bookId=" + bookId + ", bookName="
				+ bookName + ", issueDate=" + issueDate + ", duedate=" + duedate + "]";
	}

}
