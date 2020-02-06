package Libary3;

import java.sql.Date;

public class SummaryDetailsStudentDetails {
	public String studentName;
	public int bookId;
	public String bookName;
	public Date issueDate;
	public Date duedate;
	@Override
	public String toString() {
		return "SummaryDetailsStudentDetails [studentName=" + studentName + ", bookId=" + bookId + ", bookName="
				+ bookName + ", issueDate=" + issueDate + ", duedate=" + duedate + "]";
	}

}
