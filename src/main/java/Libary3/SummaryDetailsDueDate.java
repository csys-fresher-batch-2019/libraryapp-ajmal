package Libary3;

import java.sql.Date;

public class SummaryDetailsDueDate {
public int bookId;
public int studentId;
public String studentName;
public String studentDept;
public String bookName;
public long mobileNumber;
public Date issueDate;
public Date dueDate;
@Override
public String toString() {
	return "SummaryDetailsDueDate [bookId=" + bookId + ", studentId=" + studentId + ", studentName=" + studentName
			+ ", studentDept=" + studentDept + ", bookName=" + bookName + ", mobileNumber=" + mobileNumber
			+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
}


}
