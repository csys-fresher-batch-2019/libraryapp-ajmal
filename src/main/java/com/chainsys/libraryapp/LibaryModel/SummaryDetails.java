package com.chainsys.libraryapp.LibaryModel;

import java.sql.Date;

import lombok.Data;
@Data
public class SummaryDetails {
	private int bookCount;
	private int bookId;
	private int studentId;
	private Date issueDate;
	private Date dueDate;
	private Date returnedDate;
	private int fineAmount;
	private int activeStatus;
}
 